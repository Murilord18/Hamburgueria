package com.hamburgueria.compartilhado.cardapio.visitor;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.ProdutoCardapio;
import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitanteCardapioTest {

    private CategoriaCardapio raiz;

    @Before
    public void preparar() {
        raiz = new CategoriaCardapio("Cardapio");
        raiz.adicionar(new ProdutoCardapio("A",
                new LancheBuilder().comPrecoBase(new BigDecimal("10.00")).construir()));
        CategoriaCardapio bebidas = new CategoriaCardapio("Bebidas");
        bebidas.adicionar(new ProdutoCardapio("B",
                new LancheBuilder().comPrecoBase(new BigDecimal("5.00")).construir()));
        raiz.adicionar(bebidas);
    }

    @Test
    public void calculadoraSomaTudo() {
        CalculadoraPrecoVisitor v = new CalculadoraPrecoVisitor();
        raiz.aceitar(v);
        assertEquals(new BigDecimal("15.00"), v.getTotal());
    }

    @Test
    public void contadorContaProdutosFolha() {
        ContadorProdutosVisitor v = new ContadorProdutosVisitor();
        raiz.aceitar(v);
        assertEquals(2, v.getQuantidade());
    }

    @Test
    public void visitaProdutoIsolado() {
        CalculadoraPrecoVisitor v = new CalculadoraPrecoVisitor();
        new ProdutoCardapio("X", new LancheBuilder().comPrecoBase(new BigDecimal("7.00")).construir()).aceitar(v);
        assertEquals(new BigDecimal("7.00"), v.getTotal());
    }
}
