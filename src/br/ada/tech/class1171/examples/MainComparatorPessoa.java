package br.ada.tech.class1171.examples;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainComparatorPessoa {

    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("William", "111111", LocalDate.of(1989, 06, 02)),
                new Pessoa("Cesar", "22222", LocalDate.of(1989, 02, 06)),
                new Pessoa("William", "111111", LocalDate.of(1999, 06, 02))
        );

        pessoas.sort(Comparator.comparing(
                Pessoa::getNome, String::compareTo
        ).thenComparing(
                pessoa -> pessoa.getDataNascimento(), Comparator.reverseOrder()
        ).thenComparing(
                Pessoa::getCpf, String::compareTo
        ));
        /*
         pessoas.sort(Comparator.comparing(
                pessoa -> pessoa.getNome(), //Lambda para extrar o nome da pessoa e utilizar na comparação
                (first, second) -> first.compareTo(second) // Lambda para definir como comparar
            ).thenComparing(
                pessoa -> pessoa.getCpf(), //Lambda para extrar o cpf da pessoa e utilizar na comparação
                (first, second) -> first.compareTo(second) // Lambda para definir como comparar
            ));
         */

        System.out.println(pessoas);
    }
}
