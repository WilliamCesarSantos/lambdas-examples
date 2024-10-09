package br.ada.tech.class1171.examples;

import java.util.Comparator;

public class MainComparador {

    public static void main(String[] args) {
        Comparator<Integer> comparaIdade = (first, second) -> {
            System.out.println("Comparando idades");
            return first.compareTo(second);
        };
        Integer idadeWilliam = 35;
        Integer idadeDiogo = 22;
        if (comparaIdade.compare(idadeWilliam, idadeDiogo) < 0) {
            System.out.println("William é mais novo que Diogo");
        } else if(comparaIdade.compare(idadeWilliam, idadeDiogo) > 0) {
            System.out.println("William é mais velho que Diogo");
        } else {
            System.out.println("William e Diogo tem a mesma idade");
        }
    }
}
