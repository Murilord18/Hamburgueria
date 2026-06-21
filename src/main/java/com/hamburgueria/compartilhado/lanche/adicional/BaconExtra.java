package com.hamburgueria.compartilhado.lanche.adicional;

import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;

public final class BaconExtra extends AdicionalDecorator {

    private static final BigDecimal PRECO = new BigDecimal("5.00");

    public BaconExtra(Comestivel base) {
        super(base);
    }

    @Override
    protected String rotuloAdicional() {
        return "bacon";
    }

    @Override
    protected BigDecimal precoAdicional() {
        return PRECO;
    }
}
