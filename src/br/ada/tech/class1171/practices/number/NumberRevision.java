package br.ada.tech.class1171.practices.number;

import br.ada.tech.class1171.practices.Reviewer;

import java.util.Arrays;
import java.util.Set;

public class NumberRevision {

    public static void main(String[] args) {
        Reviewer reviewer = new Reviewer();
        NumberPractice practices = new NumberPractice();

        System.out.println("-----------------------------");
        reviewer.valid("removeRepeatNumbers", practices::removeRepeatNumbers, result ->
                Set.of(1, 2, 3, 4, 7, 8).equals(result)
        );

        System.out.println("-----------------------------");
        reviewer.valid("numbersLessThan5", practices::numbersLessThan5, result -> {
            result.sort(Integer::compareTo);
            return Arrays.asList(1, 1, 1, 2, 3, 3, 4, 4).equals(result);
        });

        System.out.println("-----------------------------");
        reviewer.valid("sumAllNumbers", practices::sumAllNumbers, result ->
                result == 34
        );

        System.out.println("-----------------------------");
        reviewer.valid("sumNumbersWithoutRepeats", practices::sumNumbersWithoutRepeats, result ->
                result == 25
        );

        System.out.println("-----------------------------");
        reviewer.valid("countRepeatedNumber", practices::countRepeatedNumber, result ->
                result.get(4) == 2
                        && result.get(1) == 3
                        && result.get(8) == 1
                        && result.get(7) == 1
                        && result.get(3) == 2
                        && result.get(2) == 1
        );
    }
}
