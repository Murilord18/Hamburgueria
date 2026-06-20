package com.hamburgueria.online.entrega;

import com.hamburgueria.compartilhado.pedido.Pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public final class SistemaEntrega {

    private static final int CASAS_REAIS = 2;
    private static final BigDecimal FRETE_BASE = new BigDecimal("5.00");
    private static final BigDecimal FRETE_POR_KM = new BigDecimal("1.00");
    private static final double DISTANCIA_MINIMA_KM = 0.0d;

    private final Map<String, BigDecimal> fretesCalculados = new HashMap<>();

    public BigDecimal calcularFrete(double distanciaKm) {
        double distancia = Math.max(DISTANCIA_MINIMA_KM, distanciaKm);
        return FRETE_BASE
                .add(FRETE_POR_KM.multiply(BigDecimal.valueOf(distancia)))
                .setScale(CASAS_REAIS, RoundingMode.HALF_UP);
    }

    public BigDecimal registrarEntrega(Pedido pedido, double distanciaKm) {
        Objects.requireNonNull(pedido, "pedido");
        BigDecimal frete = calcularFrete(distanciaKm);
        fretesCalculados.put(pedido.getId(), frete);
        return frete;
    }

    public boolean possuiEntrega(String idPedido) {
        return fretesCalculados.containsKey(idPedido);
    }

    public BigDecimal freteDoPedido(String idPedido) {
        return fretesCalculados.getOrDefault(idPedido, FRETE_BASE);
    }
}
