package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;

//Bridge
public interface ProcessadorPagamento {
    ResultadoPagamento processar(BigDecimal valor);
}
