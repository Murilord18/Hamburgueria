package com.hamburgueria.compartilhado.cardapio;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoriaCardapioTest {

    private CategoriaCardapio raiz;

    @Before
    public void preparar() {
        raiz = new CategoriaCardapio("Cardapio");
        CategoriaCardapio lanches = new CategoriaCardapio("Lanches");
        lanches.adicionar(new ProdutoCardapio("A",
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir()));
        lanches.adicionar(new ProdutoCardapio("B",
                new LancheBuilder().comPrecoBase(new BigDecimal("20.00")).construir()));
        raiz.adicionar(lanches);
    }

    @Test
    public void precoSomaRecursivo() {
        assertEquals(new BigDecimal("30.00"), raiz.preco());
    }

    @Test
    public void contaFilhosDiretos() {
        assertEquals(1, raiz.quantidadeFilhos());
    }

    @Test
    public void produtoFolhaTemPrecoProprio() {
        ProdutoCardapio p = new ProdutoCardapio("C",
                new LancheBuilder().comPrecoBase(new BigDecimal("15.00")).construir());
        assertEquals(new BigDecimal("15.00"), p.preco());
    }

    @Test
    public void iteraSobreFilhos() {
        int contador = 0;
        for (ItemCardapio ignorado : raiz) {
            contador++;
        }
        assertEquals(1, contador);
    }
}
