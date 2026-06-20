package com.hamburgueria.presencial;

import com.hamburgueria.compartilhado.cardapio.CategoriaCardapio;
import com.hamburgueria.compartilhado.cardapio.visitor.ContadorProdutosVisitor;
import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardapioPresencialTest {

    private CategoriaCardapio raiz;

    @Before
    public void preparar() {
        raiz = new CardapioPresencial(new FabricaIngredientes()).montar();
    }

    @Test
    public void raizTemDuasSecoes() {
        assertEquals(2, raiz.quantidadeFilhos());
    }

    @Test
    public void totalDeProdutosSomaLanchesEBebidas() {
        ContadorProdutosVisitor contador = new ContadorProdutosVisitor();
        raiz.aceitar(contador);
        assertEquals(8, contador.getQuantidade());
    }

    @Test
    public void raizTemNome() {
        assertEquals("Cardapio Presencial", raiz.nome());
    }
}
