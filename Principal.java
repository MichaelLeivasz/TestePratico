import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir funcionários
        funcionarios.add(new Funcionario("Juliana", LocalDate.of(1989, 7, 26), new BigDecimal("2500.00"), "Atendente"));
        funcionarios.add(new Funcionario("Pedro", LocalDate.of(1996, 3, 23), new BigDecimal("2000.00"), "Vendedor"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1992, 8, 12), new BigDecimal("1500.00"), "Auxiliar"));
        funcionarios.add(new Funcionario("Larissa", LocalDate.of(1998, 9, 7), new BigDecimal("1800.00"), "Atendente"));
        funcionarios.add(new Funcionario("Daniel", LocalDate.of(1994, 10, 5), new BigDecimal("1700.00"), "Operador"));
        funcionarios.add(new Funcionario("Marcelo", LocalDate.of(1991, 12, 2), new BigDecimal("2200.00"), "Gerente"));
        funcionarios.add(new Funcionario("Alan", LocalDate.of(1999, 1, 15), new BigDecimal("1900.00"), "Vendedor"));
        funcionarios.add(new Funcionario("Vivian", LocalDate.of(2000, 5, 28), new BigDecimal("2100.00"), "Auxiliar"));

        // 3.2 - Remover João
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 - Imprimir funcionários
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Lista de Funcionários:");
        funcionarios.forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimento().format(formatter) + " - R$" + f.getSalario().setScale(2, java.math.RoundingMode.HALF_UP).toString().replace(".", ",")));

        // 3.4 - Aumento de 10%
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));

        // 3.5 - Agrupar por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 - Imprimir agrupados por função
        System.out.println("\nFuncionários Agrupados por Função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println(f.getNome() + " - R$" + f.getSalario().setScale(2, java.math.RoundingMode.HALF_UP).toString().replace(".", ",")));
        });

        // 3.8 - Aniversariantes em Outubro e Dezembro
        System.out.println("\nAniversariantes em Outubro e Dezembro:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(f -> System.out.println(f.getNome() + " - " + f.getDataNascimento().format(formatter)));

        // 3.9 - Funcionário mais velho
        Funcionario maisVelho = funcionarios.stream().min(Comparator.comparing(f -> f.getDataNascimento())).orElse(null);
        if (maisVelho != null) {
            System.out.println("\nFuncionário Mais Velho:");
            System.out.println(maisVelho.getNome() + " - " + (LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear()) + " anos");
        }

        // 3.10 - Lista em ordem alfabética
        System.out.println("\nLista de Funcionários em Ordem Alfabética:");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(f -> System.out.println(f.getNome()));

        // 3.11 - Total dos salários
        BigDecimal totalSalarios = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos Salários: R$" + totalSalarios.setScale(2, java.math.RoundingMode.HALF_UP).toString().replace(".", ","));

        // 3.12 - Salários mínimos por funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nSalários Mínimos por Funcionário:");
        funcionarios.forEach(f -> System.out.println(f.getNome() + " - " + f.getSalario().divide(salarioMinimo, 2, java.math.RoundingMode.HALF_UP) + " salários mínimos"));
    }
}