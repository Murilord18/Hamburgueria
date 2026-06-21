package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PagamentoParcelado extends Pagamento {

    private static final int CASAS_REAIS = 2;
    private static final BigDecimal PERCENTUAL_JUROS_POR_PARCELA = new BigDecimal("2");
    private static final BigDecimal BASE_PERCENTUAL = new BigDecimal("100");
    private static final int PARCELA_MINIMA = 1;

    private final int parcelas;

    public PagamentoParcelado(ProcessadorPagamento processador, int parcelas) {
        super(processador);
        this.parcelas = Math.max(PARCELA_MINIMA, parcelas);
    }

    @Override
    public ResultadoPagamento pagar(BigDecimal valor) {
        BigDecimal percentualJuros = PERCENTUAL_JUROS_POR_PARCELA.multiply(BigDecimal.valueOf(parcelas));
        BigDecimal juros = valor.multiply(percentualJuros)
                .divide(BASE_PERCENTUAL, CASAS_REAIS, RoundingMode.HALF_UP);
        return processador.processar(valor.add(juros));
    }

    public int getParcelas() {
        return parcelas;
    }
}
