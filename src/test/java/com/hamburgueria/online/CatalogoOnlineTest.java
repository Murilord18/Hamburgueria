package com.hamburgueria.online;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;
import com.hamburgueria.compartilhado.filtro.FiltroE;
import com.hamburgueria.compartilhado.filtro.FiltroPrecoMaximo;
import com.hamburgueria.compartilhado.filtro.FiltroVegetariano;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CatalogoOnlineTest {

    private CatalogoOnline catalogo;

    @Before
    public void preparar() {
        catalogo = new CatalogoOnline();
        catalogo.adicionar(item("Veg Barato", new BigDecimal("15.00"), true, 400, "alface"));
        catalogo.adicionar(item("Bacon Caro", new BigDecimal("40.00"), false, 900, "bacon"));
        catalogo.adicionar(item("Veg Caro", new BigDecimal("45.00"), true, 800, "tomate"));
    }

    private ItemCardapioOnline item(String nome, BigDecimal preco, boolean veg, int cal, String ing) {
        Set<String> ingredientes = new HashSet<>();
        ingredientes.add(ing);
        ProdutoCardapio produto = new ProdutoCardapio(nome,
                new LancheBuilder().comNome(nome).comPrecoBase(preco).construir());
        return new ItemCardapioOnline(produto, cal, veg, ingredientes);
    }

    @Test
    public void contaTodosOsItens() {
        assertEquals(3, catalogo.quantidade());
    }

    @Test
    public void filtraVegetarianos() {
        assertEquals(2, catalogo.filtrar(new FiltroVegetariano()).size());
    }

    @Test
    public void filtraVegetarianoEBarato() {
        assertEquals(1, catalogo.filtrar(
                new FiltroE(new FiltroVegetariano(), new FiltroPrecoMaximo(new BigDecimal("20.00")))).size());
    }

    @Test
    public void filtroVegBaratoRetornaItemCerto() {
        assertEquals("Veg Barato", catalogo.filtrar(
                new FiltroE(new FiltroVegetariano(), new FiltroPrecoMaximo(new BigDecimal("20.00"))))
                .get(0).nome());
    }
}
