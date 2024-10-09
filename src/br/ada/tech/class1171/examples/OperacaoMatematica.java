package br.ada.tech.class1171.examples;

import java.math.BigDecimal;

// Esse interface não é funcional. Tem mais de um método abstrato
public interface OperacaoMatematica {

    BigDecimal somar(BigDecimal one, BigDecimal two);

    BigDecimal subtracao(BigDecimal one, BigDecimal two);

}
