package br.ada.tech.class1171.examples;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        soma(new OperacaoMatematicaImplementacao());

        subtracao(new OperacaoMatematica() {
            @Override
            public BigDecimal somar(BigDecimal one, BigDecimal two) {
                return one.add(two);
            }

            @Override
            public BigDecimal subtracao(BigDecimal one, BigDecimal two) {
                return one.subtract(two);
            }
        });
    }

    public static void soma(OperacaoMatematica operacaoMatematica) {
        System.out.println("Executando operacao de soma");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um valor");
        var primeiro = new BigDecimal(scanner.nextLine());

        System.out.println("Informe um segundo valor");
        var segundo = new BigDecimal(scanner.nextLine());

        var result = operacaoMatematica.somar(primeiro, segundo);
        System.out.println("O valor da operação é: " + result);
    }

    public static void subtracao(OperacaoMatematica operacaoMatematica) {
        System.out.println("Executando operacao de subtracao");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um valor");
        var primeiro = new BigDecimal(scanner.nextLine());

        System.out.println("Informe um segundo valor");
        var segundo = new BigDecimal(scanner.nextLine());

        var result = operacaoMatematica.subtracao(primeiro, segundo);
        System.out.println("O valor da operação é: " + result);
    }

}
