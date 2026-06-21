package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;
import java.util.Objects;


public abstract class Pagamento {

    protected final ProcessadorPagamento processador;

    protected Pagamento(ProcessadorPagamento processador) {
        this.processador = Objects.requireNonNull(processador, "processador");
    }

    public abstract ResultadoPagamento pagar(BigDecimal valor);
}
