package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

public final class PagamentoAVista extends Pagamento {

    public PagamentoAVista(ProcessadorPagamento processador) {
        super(processador);
    }

    @Override
    public ResultadoPagamento pagar(BigDecimal valor) {
        return processador.processar(valor);
    }
}
