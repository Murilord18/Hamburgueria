package com.hamburgueria.compartilhado.fabrica.canal;

import java.math.BigDecimal;

public final class EmbalagemDelivery implements Embalagem {

    private static final BigDecimal CUSTO = new BigDecimal("2.50");

    @Override
    public String tipo() {
        return "caixa delivery";
    }

    @Override
    public BigDecimal custo() {
        return CUSTO;
    }
}
