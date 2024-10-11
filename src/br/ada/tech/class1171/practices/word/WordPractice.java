package br.ada.tech.class1171.practices.word;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordPractice {

    private static final String[] WORDS = {"Arroz", "Feijão", "Ovo", "Frito", "Radar", "Osso"};

    public List<String> wordsLessThan5Characters() {
        //Filtre apenas palavras que possuem menos de 5 caracteres
        return Arrays.stream(WORDS)
                .filter(word -> word.length() < 5)
                .collect(Collectors.toList());
    }

    public List<String> words5Characters() {
        // Filtre apenas palavras que possuem 5 caracteres
        return Arrays.stream(WORDS)
                .filter(word -> word.length() == 5)
                .collect(Collectors.toList());
    }

    public List<String> wordsGreaterThan5Characters() {
        // Filtre apenas palavras que possuem mais de 5 caracteres
        return Arrays.stream(WORDS)
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());
    }

    public List<String> wordsArePalindromes() {
        // Identifique e retorne as palavras que sejam palíndromos(são iguais de trás para frente, exemplo: Radar)
        return Arrays.stream(WORDS)
                .filter(word -> {
                    var reserved = reverse(word);
                    return word.equalsIgnoreCase(reserved);
                }).collect(Collectors.toList());
    }

    private String reverse(String value) {
        return new StringBuilder(value).reverse().toString();
    }

    public Map<String, Integer> countLetterEachWord() {
        //Calcule quantos caracteres cada palavra têm, o retorno deve ser a palavra -> quantidade de carateres. Exemplo: Osso -> 4
        return Arrays.stream(WORDS)
                .collect(
                        Collectors.toMap(
                                word -> word,
                                word -> word.length()
                        )
                );
    }


    public Integer countLettersAllWordHave() {
        // Calcule quantos caracteres tem todas as palavras têm juntas.
//        Arrays.stream(WORDS)
//                .mapToInt(String::length)
//                .sum();
//
//        Arrays.stream(WORDS)
//                .collect(Collectors.joining())
//                .length();

        return Arrays.stream(WORDS)
                .map(String::length)
                .reduce((first, second) -> first + second)
                .orElse(0);
    }

}
