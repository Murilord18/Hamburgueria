package hamburgueria;

import hamburgueria.builder.PedidoPersonalizado;
import hamburgueria.builder.PedidoPersonalizadoBuilder;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BuilderTest {

    //  Testes de validação (exceções esperadas)

    @Test
    public void deveRetornarExcecaoParaPedidoSemNomeLanche() {
        try {
            new PedidoPersonalizadoBuilder()
                    .setNomeCliente("João")
                    .setTipoEntrega("Motoboy")
                    .setEnderecoEntrega("Rua das Flores, 42")
                    .build();
            fail("Deveria lançar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do lanche inválido", e.getMessage());
        }
    }

    @Test
    public void deveRetornarExcecaoParaPedidoSemNomeCliente() {
        try {
            new PedidoPersonalizadoBuilder()
                    .setNomeLanche("X-Bacon")
                    .setTipoEntrega("Motoboy")
                    .setEnderecoEntrega("Rua das Flores, 42")
                    .build();
            fail("Deveria lançar IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do cliente inválido", e.getMessage());
        }
    }

    //  Testes de construção válida

    @Test
    public void deveRetornarPedidoValidoComCamposObrigatorios() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Burguer")
                .setNomeCliente("Maria")
                .build();

        assertNotNull(pedido);
        assertEquals("X-Burguer", pedido.getNomeLanche());
        assertEquals("Maria", pedido.getNomeCliente());
    }

    @Test
    public void deveRetornarPedidoCompletoComTodosOsCampos() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Bacon Duplo")
                .setNomeCliente("Carlos")
                .adicionarIngredienteExtra("Queijo Extra")
                .adicionarIngredienteExtra("Ovo")
                .setTipoEntrega("Motoboy")
                .setEnderecoEntrega("Av. Brasil, 100")
                .setDescontoAplicado(15.0)
                .setObservacoes("Sem cebola, ponto da carne bem passado")
                .build();

        assertNotNull(pedido);
        assertEquals("X-Bacon Duplo",                        pedido.getNomeLanche());
        assertEquals("Carlos",                               pedido.getNomeCliente());
        assertEquals(2,                                       pedido.getIngredientesExtras().size());
        assertEquals("Motoboy",                              pedido.getTipoEntrega());
        assertEquals("Av. Brasil, 100",                      pedido.getEnderecoEntrega());
        assertEquals(15.0,                                   pedido.getDescontoAplicado(), 0.001);
        assertEquals("Sem cebola, ponto da carne bem passado", pedido.getObservacoes());
    }

    @Test
    public void deveAcumularMultiplosIngredientesExtras() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Tudo")
                .setNomeCliente("Ana")
                .adicionarIngredienteExtra("Bacon Extra")
                .adicionarIngredienteExtra("Cebola Caramelizada")
                .adicionarIngredienteExtra("Molho Especial")
                .build();

        assertEquals(3, pedido.getIngredientesExtras().size());
        assertTrue(pedido.getIngredientesExtras().contains("Bacon Extra"));
        assertTrue(pedido.getIngredientesExtras().contains("Cebola Caramelizada"));
        assertTrue(pedido.getIngredientesExtras().contains("Molho Especial"));
    }

    @Test
    public void deveUsarDescontoPadraoZeroQuandoNaoInformado() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Salada")
                .setNomeCliente("Pedro")
                .build();

        assertEquals(0.0, pedido.getDescontoAplicado(), 0.001);
    }

    @Test
    public void deveUsarTipoEntregaRetiradaComoValorPadrao() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Frango")
                .setNomeCliente("Lucas")
                .build();

        assertEquals("Retirada", pedido.getTipoEntrega());
    }

    @Test
    public void devePermitirPedidoSemIngredientesExtras() {
        PedidoPersonalizado pedido = new PedidoPersonalizadoBuilder()
                .setNomeLanche("X-Burguer")
                .setNomeCliente("Fernanda")
                .build();

        assertNotNull(pedido.getIngredientesExtras());
        assertTrue(pedido.getIngredientesExtras().isEmpty());
    }
}
