package com.hamburgueria.compartilhado.fabrica.canal;

import java.math.BigDecimal;

public final class EmbalagemBandeja implements Embalagem {

    private static final BigDecimal CUSTO = new BigDecimal("0.00");

    @Override
    public String tipo() {
        return "bandeja";
    }

    @Override
    public BigDecimal custo() {
        return CUSTO;
    }
}
