package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class ResultadoPagamento {

    private static final int CASAS_REAIS = 2;

    private final boolean aprovado;
    private final BigDecimal valorCobrado;
    private final String detalhe;

    public ResultadoPagamento(boolean aprovado, BigDecimal valorCobrado, String detalhe) {
        this.aprovado = aprovado;
        this.valorCobrado = Objects.requireNonNull(valorCobrado, "valorCobrado")
                .setScale(CASAS_REAIS, RoundingMode.HALF_UP);
        this.detalhe = Objects.requireNonNull(detalhe, "detalhe");
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public BigDecimal getValorCobrado() {
        return valorCobrado;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
