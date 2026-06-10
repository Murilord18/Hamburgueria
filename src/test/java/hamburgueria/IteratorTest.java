package hamburgueria;

import hamburgueria.Iterator.CardapioIterator;
import hamburgueria.Iterator.FiltroCardapioOnline;
import hamburgueria.Iterator.ItemCardapioOnline;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class IteratorTest {

    // ---------------------------------------------------------------
    //  Cardápio reutilizado nos testes unitários
    //
    //  X-Bacon       LANCHE         R$24,90  | 320 pedidos  ← mais pedido / mais caro
    //  X-Burguer     LANCHE         R$18,90  | 280 pedidos
    //  Batata Frita  ACOMPANHAMENTO R$ 8,00  |  95 pedidos
    //  + Queijo      ADICIONAL      R$ 2,50  |  60 pedidos  ← mais barato
    //  Onion Rings   ACOMPANHAMENTO R$10,00  | 110 pedidos
    // ---------------------------------------------------------------

    private CardapioIterator cardapioPadrao() {
        return new CardapioIterator(
                new ItemCardapioOnline("X-Bacon",      24.90, "LANCHE",          320),
                new ItemCardapioOnline("X-Burguer",    18.90, "LANCHE",          280),
                new ItemCardapioOnline("Batata Frita",  8.00, "ACOMPANHAMENTO",   95),
                new ItemCardapioOnline("+ Queijo",      2.50, "ADICIONAL",        60),
                new ItemCardapioOnline("Onion Rings",  10.00, "ACOMPANHAMENTO",  110)
        );
    }

    // ---------------------------------------------------------------
    //  buscarMaisPedido — for-each
    // ---------------------------------------------------------------

    @Test
    public void deveBuscarMaisPedidoSimples() {
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMaisPedido(cardapioPadrao());
        assertNotNull(resultado);
        assertEquals("X-Bacon", resultado.getNome());
        assertEquals(320, resultado.getTotalPedidos());
    }

    @Test
    public void deveBuscarMaisPedidoComUmUnicoItem() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("X-Especial", 29.90, "LANCHE", 500)
        );
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMaisPedido(cardapio);
        assertNotNull(resultado);
        assertEquals("X-Especial", resultado.getNome());
    }

    @Test
    public void deveBuscarMaisPedidoRetornaNullParaCardapioVazio() {
        CardapioIterator vazio = new CardapioIterator();
        assertNull(FiltroCardapioOnline.buscarMaisPedido(vazio));
    }

    // ---------------------------------------------------------------
    //  buscarMaiorPreco — for-each
    // ---------------------------------------------------------------

    @Test
    public void deveBuscarMaiorPrecoSimples() {
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMaiorPreco(cardapioPadrao());
        assertNotNull(resultado);
        assertEquals("X-Bacon", resultado.getNome());
        assertEquals(24.90, resultado.getPreco(), 0.01);
    }

    @Test
    public void deveBuscarMaiorPrecoComUmUnicoItem() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("X-Especial", 39.90, "LANCHE", 50)
        );
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMaiorPreco(cardapio);
        assertNotNull(resultado);
        assertEquals(39.90, resultado.getPreco(), 0.01);
    }

    @Test
    public void deveBuscarMaiorPrecoRetornaNullParaCardapioVazio() {
        CardapioIterator vazio = new CardapioIterator();
        assertNull(FiltroCardapioOnline.buscarMaiorPreco(vazio));
    }

    @Test
    public void deveBuscarMaiorPrecoComTodosIguais() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("Item A", 10.00, "LANCHE",          30),
                new ItemCardapioOnline("Item B", 10.00, "ACOMPANHAMENTO",  20),
                new ItemCardapioOnline("Item C", 10.00, "ADICIONAL",       10)
        );
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMaiorPreco(cardapio);
        assertEquals("Item A", resultado.getNome());
    }

    // ---------------------------------------------------------------
    //  buscarMenorPreco — iterator explícito
    // ---------------------------------------------------------------

    @Test
    public void deveBuscarMenorPrecoSimples() {
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMenorPreco(cardapioPadrao());
        assertNotNull(resultado);
        assertEquals("+ Queijo", resultado.getNome());
        assertEquals(2.50, resultado.getPreco(), 0.01);
    }

    @Test
    public void deveBuscarMenorPrecoComUmUnicoItem() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("+ Molho", 1.50, "ADICIONAL", 40)
        );
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMenorPreco(cardapio);
        assertNotNull(resultado);
        assertEquals(1.50, resultado.getPreco(), 0.01);
    }

    @Test
    public void deveBuscarMenorPrecoRetornaNullParaCardapioVazio() {
        CardapioIterator vazio = new CardapioIterator();
        assertNull(FiltroCardapioOnline.buscarMenorPreco(vazio));
    }

    @Test
    public void deveBuscarMenorPrecoComTodosIguais() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("Item A", 5.00, "ADICIONAL",       15),
                new ItemCardapioOnline("Item B", 5.00, "ACOMPANHAMENTO",  10),
                new ItemCardapioOnline("Item C", 5.00, "LANCHE",           5)
        );
        ItemCardapioOnline resultado = FiltroCardapioOnline.buscarMenorPreco(cardapio);
        assertEquals("Item A", resultado.getNome());
    }

    // ---------------------------------------------------------------
    //  Combinação dos três filtros no mesmo cardápio
    // ---------------------------------------------------------------

    @Test
    public void deveTerResultadosDiferentesParaCadaFiltro() {
        CardapioIterator cardapio = new CardapioIterator(
                new ItemCardapioOnline("X-Especial", 49.90, "LANCHE",    600),
                new ItemCardapioOnline("X-Burguer",  18.90, "LANCHE",    200),
                new ItemCardapioOnline("+ Molho",     1.00, "ADICIONAL",  30)
        );

        assertEquals("X-Especial", FiltroCardapioOnline.buscarMaisPedido(cardapio).getNome());
        assertEquals("X-Especial", FiltroCardapioOnline.buscarMaiorPreco(cardapio).getNome());
        assertEquals("+ Molho",    FiltroCardapioOnline.buscarMenorPreco(cardapio).getNome());
    }
}
