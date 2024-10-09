package br.ada.tech.class1171.practices;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class Reviewer {

    private String colorRed = "\u001B[31m";
    private String colorDefault = "\u001B[0m";

    public <T> void valid(String practiceName, Supplier<T> producesResult, Predicate<T> validResult) {
        try {
            var result = producesResult.get();
            System.out.println("O resultado do exercício " + practiceName + " foi: " + result);
            var areValid = validResult.test(result);
            if (areValid) {
                System.out.println("Exercício " + practiceName + " esta correto");
            } else {
                System.out.println(colorRed + "Exercício " + practiceName + " esta incorreto" + colorDefault);
            }
        } catch(Exception exception) {
            System.out.println(colorRed + "Falha na execução do exercício " + practiceName + ", verifique seu código." + colorDefault);
            exception.printStackTrace();
        }

    }

}
