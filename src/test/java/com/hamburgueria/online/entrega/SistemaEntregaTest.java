package com.hamburgueria.online.entrega;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SistemaEntregaTest {

    private SistemaEntrega entrega;

    @Before
    public void preparar() {
        entrega = new SistemaEntrega();
    }

    @Test
    public void freteBaseSemDistancia() {
        assertEquals(new BigDecimal("5.00"), entrega.calcularFrete(0));
    }

    @Test
    public void freteSomaPorKm() {
        assertEquals(new BigDecimal("8.00"), entrega.calcularFrete(3));
    }

    @Test
    public void distanciaNegativaUsaBase() {
        assertEquals(new BigDecimal("5.00"), entrega.calcularFrete(-5));
    }

    @Test
    public void registraEntregaDoPedido() {
        Pedido p = new Pedido("P1");
        entrega.registrarEntrega(p, 2);
        assertTrue(entrega.possuiEntrega("P1"));
    }

    @Test
    public void recuperaFreteRegistrado() {
        Pedido p = new Pedido("P1");
        entrega.registrarEntrega(p, 2);
        assertEquals(new BigDecimal("7.00"), entrega.freteDoPedido("P1"));
    }

    @Test
    public void pedidoSemEntregaNaoExiste() {
        assertFalse(entrega.possuiEntrega("DESCONHECIDO"));
    }
}
