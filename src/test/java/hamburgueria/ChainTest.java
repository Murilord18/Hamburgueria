package hamburgueria;

import hamburgueria.chain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChainTest {

    private Funcionario cadeia;

    @Before
    public void setUp() {
        FuncionarioAtendente atendente     = new FuncionarioAtendente();
        FuncionarioSupervisor supervisor   = new FuncionarioSupervisor();
        FuncionarioCoordenador coordenador          = new FuncionarioCoordenador();
        FuncionarioGerente gerente              = new FuncionarioGerente();

        // Atendente -> Supervisopr -> Coordenador -> Gerente
        atendente.setProximo(supervisor)
                .setProximo(coordenador)
                .setProximo(gerente);

        cadeia = atendente;
    }

    @Test
    public void testAtenenteProcessaPedidoSimples() {
        AprovarPedido pedido = new AprovarPedido("X-Burguer", new TipoPedidoSimples());
        assertEquals("Atendente registrou: X-Burguer [Pedido Simples]", cadeia.processar(pedido));
    }

    @Test
    public void testSupervisorProcessaPedidoPersonalizado() {
        AprovarPedido pedido = new AprovarPedido("X-Burguer sem cebola com extra bacon", new TipoPedidoPersonalizado());
        assertEquals("Supervisor preparou: X-Burguer sem cebola com extra bacon [Pedido Personalizado]", cadeia.processar(pedido));
    }

    @Test
    public void testCoordenadorProcessaEncomenda() {
        AprovarPedido pedido = new AprovarPedido("150 hamburgueres para aniversario", new TipoPedidoEncomenda());
        assertEquals("Coordenador aprovou encomenda: 150 hamburgueres para aniversario [Encomenda]", cadeia.processar(pedido));
    }

    @Test
    public void testGerenteProcessaEvento() {
        AprovarPedido pedido = new AprovarPedido("Festa de 50 pessoas", new TipoPedidoEvento());
        assertEquals("Gerente autorizou: Festa de 50 pessoas [Pedido Evento]", cadeia.processar(pedido));
    }

    @Test
    public void testPedidoNaoReconhecidoRetornaMensagem() {
        TipoPedido tipoDesconhecido = () -> "TipoDesconhecido";
        AprovarPedido pedido = new AprovarPedido("Pedido invalido", tipoDesconhecido);
        String resultado = cadeia.processar(pedido);
        assertTrue(resultado.contains("nao pode ser processado"));
    }

    @Test
    public void testNomesFuncionarios() {
        assertEquals("Atendente",   new FuncionarioAtendente().getNome());
        assertEquals("Supervisor",  new FuncionarioSupervisor().getNome());
        assertEquals("Coordenador",     new FuncionarioCoordenador().getNome());
        assertEquals("Gerente",        new FuncionarioGerente().getNome());
    }

    @Test
    public void testSupervisorNaoProcessaPedidoSimples() {
        FuncionarioSupervisor supervisor = new FuncionarioSupervisor();
        assertTrue(!supervisor.podeProcessar(new TipoPedidoSimples()));
    }

    @Test
    public void testAtenenteNaoProcessaEvento() {
        FuncionarioAtendente atendente = new FuncionarioAtendente();
        assertTrue(!atendente.podeProcessar(new TipoPedidoEvento()));
    }

    @Test
    public void testTiposPedido() {
        assertEquals("Pedido Simples",       new TipoPedidoSimples().getTipo());
        assertEquals("Pedido Personalizado", new TipoPedidoPersonalizado().getTipo());
        assertEquals("Encomenda",           new TipoPedidoEncomenda().getTipo());
        assertEquals("Pedido Evento",        new TipoPedidoEvento().getTipo());
    }
}
