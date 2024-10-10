package br.ada.tech.class1171.practices.number;

import java.util.*;
import java.util.stream.Collectors;

public class NumberPractice {

    private static final Integer[] NUMBERS = {4, 1, 1, 8, 1, 7, 3, 2, 3, 4};

    public List<Integer> numbersLessThan5() {
        // Filtre todos os números que são menores que 5
        return Arrays.stream(NUMBERS)
                .filter(numero -> numero < 5)
                .collect(Collectors.toList());
    }

    public Set<Integer> removeRepeatNumbers() {
        // Remova os números repetidos
        return Arrays.stream(NUMBERS)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Integer sumAllNumbers() {
        // Calcule a soma total dos números.
        return Arrays.stream(NUMBERS)
                .reduce((first, second) -> first + second)
                .orElse(0);
    }

    public Integer sumNumbersWithoutRepeats() {
        // Some todos os números, porém não utilize os repetidos
        return Arrays.stream(NUMBERS)
                .distinct()
                .reduce((first, second) -> first + second)
                .orElse(0);
    }

    public Map<Integer, Long> countRepeatedNumber() {
        // Conte quantas vezes cada número aparece na lista. Exemplo de retorno: 4 -> 2, 1 -> 3
        return Arrays.stream(NUMBERS)
                .collect(
                        Collectors.groupingBy(
                                number -> number,
                                Collectors.counting()
                        )
                );
    }

}
