package com.hamburgueria.compartilhado.facade;

import java.math.BigDecimal;
import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.fabrica.canal.FabricaPresencial;
import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.pagamento.PagamentoAVista;
import com.hamburgueria.compartilhado.pagamento.ProcessadorDinheiro;
import com.hamburgueria.compartilhado.pedido.Pedido;
import com.hamburgueria.compartilhado.validacao.ManipuladorPedido;
import com.hamburgueria.compartilhado.validacao.ValidaItensNaoVazio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HamburgueriaFacadeTest {

    private HamburgueriaFacade facade;

    @Before
    public void preparar() {
        Cozinha.obterInstancia().limparFila();
        facade = new HamburgueriaFacade(
                new FabricaPresencial(), new FabricaIngredientes(), Cozinha.obterInstancia());
    }

    @Test
    public void abrirPedidoEnviaACozinha() {
        facade.abrirPedido("P1");
        assertEquals(1, Cozinha.obterInstancia().tamanhoFila());
    }

    @Test
    public void abrirPedidoCriaItem() {
        Pedido p = facade.abrirPedido("P1");
        assertEquals(1, p.quantidadeItens());
    }

    @Test
    public void avancarEDesfazerPreparo() {
        Pedido p = facade.abrirPedido("P1");
        facade.avancarPreparo(p);
        facade.desfazerUltimoPreparo();
        assertEquals("RECEBIDO", p.getEstado().nome());
    }

    @Test
    public void validacaoAprovaPedidoComItem() {
        Pedido p = facade.abrirPedido("P1");
        ManipuladorPedido cadeia = new ValidaItensNaoVazio();
        assertTrue(facade.validar(p, cadeia).isValido());
    }

    @Test
    public void pagamentoCobraTotalDoPedido() {
        Pedido p = facade.abrirPedido("P1");
        BigDecimal esperado = p.total();
        assertEquals(esperado,
                facade.pagar(p, new PagamentoAVista(new ProcessadorDinheiro())).getValorCobrado());
    }
}
