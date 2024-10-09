package br.ada.tech.class1171.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainComparadorLista {

    public static void main(String[] args) {
        List<Integer> numerosAleatorios = Arrays.asList(1, 5, 69, 8, 95, 16, 456, 489, 65, 13, 85, 87, 78, 4, 101);

        // 1 - Usando lambdas faça a ordenação da lista de forma crescente
        Comparator<Integer> crescente = (first, second) -> {
            System.out.println("Comparando valores [" + first + " > " + second + "]");
            return first - second;
        };
        numerosAleatorios.sort(crescente);
        System.out.println("Lista ordenada de forma crescente.");
        System.out.println(numerosAleatorios);
        /*
         * numerosAleatorios.sort((first, second) -> first.compareTo(second));
         * numerosAleatorios.sort(Integer::compareTo)
         * numerosAleatorios.sort(Comparator.comparing(numero -> numero, Integer::compareTo));
         */

        // 2 - Usando lambdas faça a ordenação da lista de forma decrescente
        numerosAleatorios = Arrays.asList(1, 5, 69, 8, 95, 16, 456, 489, 65, 13, 85, 87, 78, 4, 101);
        numerosAleatorios.sort(crescente.reversed());
        System.out.println("Lista ordenada de forma decrescente.");
        System.out.println(numerosAleatorios);
        /*
         * Comparator<Integer> comparator = Integer::compareTo;
         * numerosAleatorios.sort(comparator.reversed());
         */
    }

}
