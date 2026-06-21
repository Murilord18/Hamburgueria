package com.hamburgueria.compartilhado.lanche.adicional;

import com.hamburgueria.compartilhado.lanche.Comestivel;

import java.math.BigDecimal;

public final class BlendExtra extends AdicionalDecorator {

    private static final BigDecimal PRECO = new BigDecimal("7.00");

    public BlendExtra(Comestivel base) {
        super(base);
    }

    @Override
    protected String rotuloAdicional() {
        return "blend de hamburguer";
    }

    @Override
    protected BigDecimal precoAdicional() {
        return PRECO;
    }
}
