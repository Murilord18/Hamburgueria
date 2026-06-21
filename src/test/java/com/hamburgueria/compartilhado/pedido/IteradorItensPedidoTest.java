package com.hamburgueria.compartilhado.pedido;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IteradorItensPedidoTest {

    private Pedido pedido;

    @Before
    public void preparar() {
        FabricaIngredientes f = new FabricaIngredientes();
        pedido = new Pedido("P1");
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00"))
                        .adicionarIngrediente(f.obter("pao", new BigDecimal("2.00"))).construir(), 1));
        pedido.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(new BigDecimal("20.00")).construir(), 2));
    }

    @Test
    public void percorreTodosOsItens() {
        int contador = 0;
        for (ItemPedido ignorado : pedido) {
            contador++;
        }
        assertEquals(2, contador);
    }

    @Test
    public void hasNextFalsoNoFim() {
        Iterator<ItemPedido> it = pedido.iterator();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void hasNextVerdadeiroNoInicio() {
        assertTrue(pedido.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void nextAlemDoFimLancaExcecao() {
        Iterator<ItemPedido> it = pedido.iterator();
        it.next();
        it.next();
        it.next();
    }
}
