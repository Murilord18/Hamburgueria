package com.hamburgueria.compartilhado.pagamento;


public final class GatewayExternoLegado {

    private static final double VALOR_MINIMO_REAIS = 0.0d;

    public boolean efetuarCobranca(double valorReais) {
        return valorReais > VALOR_MINIMO_REAIS;
    }
}
