package com.hamburgueria.online.pagamento;

import com.hamburgueria.compartilhado.pagamento.Pagamento;
import com.hamburgueria.compartilhado.pagamento.PagamentoAVista;
import com.hamburgueria.compartilhado.pagamento.ProcessadorPagamento;
import com.hamburgueria.compartilhado.pagamento.ProcessadorPagamentoProxy;
import com.hamburgueria.compartilhado.pagamento.ProcessadorPix;
import com.hamburgueria.compartilhado.pagamento.ResultadoPagamento;

import java.math.BigDecimal;

//Bridge e Proxy
public final class SistemaPagamentoOnline {

    private static final BigDecimal LIMITE_PADRAO = new BigDecimal("500.00");

    private final Pagamento pagamento;

    public SistemaPagamentoOnline() {
        this(LIMITE_PADRAO);
    }

    public SistemaPagamentoOnline(BigDecimal limite) {
        ProcessadorPagamento real = new ProcessadorPix();
        ProcessadorPagamento protegido = new ProcessadorPagamentoProxy(real, limite);
        this.pagamento = new PagamentoAVista(protegido);
    }

    public ResultadoPagamento cobrar(BigDecimal valor) {
        return pagamento.pagar(valor);
    }
}
