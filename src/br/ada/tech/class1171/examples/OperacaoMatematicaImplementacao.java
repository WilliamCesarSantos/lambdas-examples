package br.ada.tech.class1171.examples;

import java.math.BigDecimal;

public class OperacaoMatematicaImplementacao implements OperacaoMatematica {
    @Override
    public BigDecimal somar(BigDecimal one, BigDecimal two) {
        return one.add(two);
    }

    @Override
    public BigDecimal subtracao(BigDecimal one, BigDecimal two) {
        return one.subtract(two);
    }

}
