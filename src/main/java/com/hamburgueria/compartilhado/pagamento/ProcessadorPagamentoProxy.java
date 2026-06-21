package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;
import java.util.Objects;

//Proxy
public final class ProcessadorPagamentoProxy implements ProcessadorPagamento {

    private final ProcessadorPagamento real;
    private final BigDecimal limite;

    public ProcessadorPagamentoProxy(ProcessadorPagamento real, BigDecimal limite) {
        this.real = Objects.requireNonNull(real, "real");
        this.limite = Objects.requireNonNull(limite, "limite");
    }

    @Override
    public ResultadoPagamento processar(BigDecimal valor) {
        if (valor.compareTo(limite) > 0) {
            return new ResultadoPagamento(false, valor, "recusado-acima-do-limite");
        }
        return real.processar(valor);
    }
}
