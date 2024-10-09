package br.ada.tech.class1171.examples;

import java.util.Arrays;
import java.util.List;

public class MainCalculoNumeroInteiros {

    public static void main(String[] args) {
        //- Dado uma lista de número inteiros, calcule a soma total dos números.
        List<Integer> numeros = Arrays.asList(1, 5, 69, 8, 95, 16, 456, 489, 65, 13, 85, 87, 78, 4, 101);

        Integer acumulador = 0;
        for (Integer numero : numeros) {
            acumulador += numero;
        }
        System.out.println("O valor total é: " + acumulador);

        numeros.stream()
                .reduce((primeiro, segundo) -> primeiro + segundo)
                .ifPresent(System.out::println);
    }

}
