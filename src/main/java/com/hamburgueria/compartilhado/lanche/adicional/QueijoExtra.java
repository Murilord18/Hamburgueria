package com.hamburgueria.compartilhado.lanche.adicional;

import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;

public final class QueijoExtra extends AdicionalDecorator {

    private static final BigDecimal PRECO = new BigDecimal("3.00");

    public QueijoExtra(Comestivel base) {
        super(base);
    }

    @Override
    protected String rotuloAdicional() {
        return "fatia de queijo";
    }

    @Override
    protected BigDecimal precoAdicional() {
        return PRECO;
    }
}
