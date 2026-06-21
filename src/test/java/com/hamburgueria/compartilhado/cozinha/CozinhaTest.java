package com.hamburgueria.compartilhado.cozinha;

import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CozinhaTest {

    @Before
    public void limpar() {
        Cozinha.obterInstancia().limparFila();
    }

    @Test
    public void mesmaInstanciaSempre() {
        assertSame(Cozinha.obterInstancia(), Cozinha.obterInstancia());
    }

    @Test
    public void filaCompartilhadaEntreReferencias() {
        Cozinha.obterInstancia().receberPedido(new Pedido("P1"));
        assertEquals(1, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void limparZeraFila() {
        Cozinha.obterInstancia().receberPedido(new Pedido("P2"));
        Cozinha.obterInstancia().limparFila();
        assertEquals(0, Cozinha.obterInstancia().tamanhoFila());
    }
}
