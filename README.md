# Teste Prático de Programação em Java

Este repositório contém a solução para o teste prático de programação em Java proposto. O objetivo do teste era criar um sistema para gerenciar informações de funcionários, incluindo suas informações pessoais, salários e funções, e realizar diversas operações sobre esses dados.

## Requisitos

O teste prático consistia em implementar as seguintes funcionalidades:

1.  **Classes `Pessoa` e `Funcionario`:**
    *   `Pessoa`: Classe base com atributos `nome` (String) e `dataNascimento` (LocalDate).
    *   `Funcionario`: Classe que herda de `Pessoa` com atributos `salario` (BigDecimal) e `funcao` (String).

2.  **Classe `Principal`:**
    *   Inserir funcionários na lista.
    *   Remover um funcionário específico (ex: "João").
    *   Imprimir informações dos funcionários formatadas (data no formato dd/mm/aaaa e valores numéricos com separador de milhar e decimal).
    *   Aplicar aumento de 10% nos salários dos funcionários.
    *   Agrupar funcionários por função em um `Map`.
    *   Imprimir funcionários agrupados por função.
    *   Imprimir funcionários que fazem aniversário em meses específicos (ex: Outubro e Dezembro).
    *   Imprimir o funcionário com a maior idade.
    *   Imprimir lista de funcionários em ordem alfabética.
    *   Imprimir o total dos salários dos funcionários.
    *   Imprimir quantos salários mínimos cada funcionário ganha (considerando um salário mínimo de R$1212.00).

## Solução

A solução foi implementada utilizando Java 17 e as seguintes classes:

*   `Pessoa.java`: Contém a definição da classe `Pessoa`.
*   `Funcionario.java`: Contém a definição da classe `Funcionario`.
*   `Principal.java`: Contém o método `main` e a lógica para executar as operações solicitadas no teste.

## Como executar

1.  **Pré-requisitos:**
    *   JDK (Java Development Kit) 17 ou superior instalado.
    *   VS Code (ou outra IDE de sua preferência) instalado.
    *   Extensões Java instaladas no VS Code.

2.  **Abrir o projeto no VS Code:**

    *   Abra o VS Code e clique em "File" > "Open Folder..." e selecione a pasta do projeto.

3.  **Compilar o código:**

    *   Abra o terminal integrado do VS Code (View > Terminal).
    *   Navegue até a pasta raiz do projeto no terminal.
    *   Execute o comando `javac *.java` para compilar todos os arquivos Java.

4.  **Executar o código:**

    *   No mesmo terminal, execute o comando `java Principal`.
    *   O resultado da execução será exibido no terminal.
