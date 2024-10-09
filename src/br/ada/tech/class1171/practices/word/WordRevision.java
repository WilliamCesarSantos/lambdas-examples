package br.ada.tech.class1171.practices.word;

import br.ada.tech.class1171.practices.Reviewer;

import java.util.Arrays;

public class WordRevision {

    public static void main(String[] args) {
        Reviewer reviewer = new Reviewer();
        WordPractice practices = new WordPractice();

        System.out.println("-----------------------------");
        reviewer.valid("wordsLessThan5Characters", practices::wordsLessThan5Characters, result -> {
            result.sort(String::compareTo);
            return Arrays.asList("Osso", "Ovo").equals(result);
        });

        System.out.println("-----------------------------");
        reviewer.valid("words5Characters", practices::words5Characters, result -> {
            result.sort(String::compareTo);
            return Arrays.asList("Arroz", "Frito", "Radar").equals(result);
        });

        System.out.println("-----------------------------");
        reviewer.valid("wordsGreaterThan5Characters", practices::wordsGreaterThan5Characters, result ->
                Arrays.asList("Feijão").equals(result)
        );

        System.out.println("-----------------------------");
        reviewer.valid("wordsArePalindromes", practices::wordsArePalindromes, result -> {
            result.sort(String::compareTo);
            return Arrays.asList("Osso", "Ovo", "Radar").equals(result);
        });

        System.out.println("-----------------------------");
        reviewer.valid("countLetterEachWord", practices::countLetterEachWord, result ->
                result.get("Arroz") == 5
                        && result.get("Feijão") == 6
                        && result.get("Ovo") == 3
                        && result.get("Frito") == 5
                        && result.get("Radar") == 5
                        && result.get("Osso") == 4
        );

        System.out.println("-----------------------------");
        reviewer.valid("countLettersAllWordHave", practices::countLettersAllWordHave, result ->
                result == 28
        );
    }

}
