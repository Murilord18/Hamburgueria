package com.hamburgueria.compartilhado.pedido;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemPedidoTest {

    @Test
    public void subtotalMultiplicaPelaQuantidade() {
        ItemPedido item = new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 3);
        assertEquals(new BigDecimal("30.00"), item.subtotal());
    }

    @Test
    public void mantemQuantidade() {
        ItemPedido item = new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir(), 4);
        assertEquals(4, item.getQuantidade());
    }
}
