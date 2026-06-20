package com.hamburgueria.online;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemCardapioOnlineTest {

    private ItemCardapioOnline item;

    @Before
    public void preparar() {
        Set<String> ingredientes = new HashSet<>();
        ingredientes.add("queijo");
        ProdutoCardapio produto = new ProdutoCardapio("X",
                new LancheBuilder().comNome("X").comPrecoBase(new BigDecimal("18.00")).construir());
        item = new ItemCardapioOnline(produto, 600, false, ingredientes);
    }

    @Test
    public void herdaPrecoDoProduto() {
        assertEquals(new BigDecimal("18.00"), item.preco());
    }

    @Test
    public void exponhaCalorias() {
        assertEquals(600, item.calorias());
    }

    @Test
    public void naoVegetariano() {
        assertFalse(item.vegetariano());
    }

    @Test
    public void contemIngredienteConhecido() {
        assertTrue(item.contemIngrediente("queijo"));
    }

    @Test
    public void naoContemIngredienteAusente() {
        assertFalse(item.contemIngrediente("bacon"));
    }
}
