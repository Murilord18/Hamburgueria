package com.hamburgueria.compartilhado.pagamento;

import java.math.BigDecimal;
import java.util.Objects;

//Adapter
public final class AdaptadorGatewayExterno implements ProcessadorPagamento {

    private final GatewayExternoLegado gateway;

    public AdaptadorGatewayExterno(GatewayExternoLegado gateway) {
        this.gateway = Objects.requireNonNull(gateway, "gateway");
    }

    @Override
    public ResultadoPagamento processar(BigDecimal valor) {
        boolean aceito = gateway.efetuarCobranca(valor.doubleValue());
        return new ResultadoPagamento(aceito, valor, "gateway-externo");
    }
}
