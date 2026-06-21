package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

public final class ProcessadorPix implements ProcessadorPagamento {

    @Override
    public ResultadoPagamento processar(BigDecimal valor) {
        return new ResultadoPagamento(true, valor, "pix");
    }
}
