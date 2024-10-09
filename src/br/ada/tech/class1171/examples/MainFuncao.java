package br.ada.tech.class1171.examples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MainFuncao {

    public static void main(String[] args) {
        // () declaração de variável. Deve respeitar a definição do método abstrato
        // -> definição do código executável == código do método
        // {} utilizado quando o código é maior que uma instrução - Código de execução

        // operacaoSoma é uma lambda
        System.out.println("Criando operacao de soma");
        OperacaoMatematicaFunional operacaoSoma = (primeiro, segundo) -> {
            System.out.println("executando operacao de soma");
            return primeiro.add(segundo);
        };
        operacao(operacaoSoma);

        // operacaoSubtracao é outra lambda
        System.out.println("Criando operacao de subtracao");
        OperacaoMatematicaFunional operacaoSubtracao = (primeiro, segundo) -> {
            System.out.println("executando operacao de subtracao");
            return primeiro.subtract(segundo);
        };
        operacao(operacaoSubtracao);

        //Desafio: Criar operação de divisão, usando lambda
        System.out.println("Criando operacao de divisao");
        OperacaoMatematicaFunional operacaoDivisao = (primeiro, segundo) -> {
            System.out.println("executando operacao de divisão");
            return primeiro.divide(segundo, 10, RoundingMode.HALF_DOWN);
        };
        operacao(operacaoDivisao);

        // Mesma declaração de lambda que as acima, porém não é necessário uma verbosidade maior
        operacao(BigDecimal::multiply);
    }

    public static void operacao(OperacaoMatematicaFunional operacao) {
        System.out.println("Executando operacao");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um valor");
        var primeiro = new BigDecimal(scanner.nextLine());

        System.out.println("Informe um segundo valor");
        var segundo = new BigDecimal(scanner.nextLine());

        // Aqui chama a execução do código da lambda
        var result = operacao.executar(primeiro, segundo);
        System.out.println("O valor da operação é: " + result);
    }

}
