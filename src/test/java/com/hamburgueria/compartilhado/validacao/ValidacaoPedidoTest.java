package com.hamburgueria.compartilhado.validacao;

import java.math.BigDecimal;

import com.hamburgueria.compartilhado.lanche.LancheBuilder;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidacaoPedidoTest {

    private static final BigDecimal VALOR_MINIMO = new BigDecimal("10.00");

    private Pedido comItem(BigDecimal preco) {
        Pedido p = new Pedido("P1");
        p.adicionarItem(new ItemPedido(
                new LancheBuilder().comPrecoBase(preco).construir(), 1));
        return p;
    }

    private ManipuladorPedido cadeia() {
        ManipuladorPedido inicio = new ValidaItensNaoVazio();
        inicio.encadear(new ValidaValorMinimo(VALOR_MINIMO));
        return inicio;
    }

    @Test
    public void pedidoVazioFalhaNoPrimeiroElo() {
        ResultadoValidacao r = cadeia().validar(new Pedido("P1"));
        assertEquals("pedido sem itens", r.getMotivo());
    }

    @Test
    public void pedidoAbaixoDoMinimoFalhaNoSegundoElo() {
        ResultadoValidacao r = cadeia().validar(comItem(new BigDecimal("5.00")));
        assertEquals("valor abaixo do minimo", r.getMotivo());
    }

    @Test
    public void pedidoValidoPassaTodaCadeia() {
        assertTrue(cadeia().validar(comItem(new BigDecimal("20.00"))).isValido());
    }

    @Test
    public void canceladoFalhaNaValidacaoDeCancelamento() {
        Pedido p = comItem(new BigDecimal("20.00"));
        p.avancarEstado();
        p.avancarEstado();
        assertFalse(new ValidaCancelavel().validar(p).isValido());
    }
}
