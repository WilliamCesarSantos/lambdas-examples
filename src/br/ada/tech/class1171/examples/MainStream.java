package br.ada.tech.class1171.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args) {
        List<Nadador> nadadores = List.of(
                new Peixe(),
                new Polvo(),
                new Humano(),
                new Peixe(),
                new Peixe()
        );

        nadadores.stream()
                .filter(nadador -> {
                    System.out.println("Executando filtro para " + nadador);
                    return nadador.tipo().equalsIgnoreCase("Peixe");
                }).map(nadador -> {
                    System.out.println("Executando map para " + nadador);
                    return new LatinhaDeSardinha(nadador);
                }).forEach(latinha -> {
                    System.out.println("Executando o sout");
                    System.out.println(latinha);
                });


//        List<LatinhaDeSardinha> latinhas = new ArrayList<>();
//        for (Nadador nadador : nadadores) {
//            if (nadador.tipo().equalsIgnoreCase("Peixe")) {
//                latinhas.add(new LatinhaDeSardinha(nadador));
//            }
//        }
//        for (LatinhaDeSardinha latinha : latinhas) {
//            System.out.println(latinha);
//        }
    }

}
