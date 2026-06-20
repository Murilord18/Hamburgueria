package com.hamburgueria.compartilhado.facade;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.cozinha.comando.AvancarPreparoComando;
import com.hamburgueria.compartilhado.cozinha.comando.FilaComandos;
import com.hamburgueria.compartilhado.fabrica.canal.FabricaCanal;
import com.hamburgueria.compartilhado.lanche.FabricaIngredientes;
import com.hamburgueria.compartilhado.lanche.Lanche;
import com.hamburgueria.compartilhado.pagamento.Pagamento;
import com.hamburgueria.compartilhado.pagamento.ResultadoPagamento;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;
import com.hamburgueria.compartilhado.validacao.ManipuladorPedido;
import com.hamburgueria.compartilhado.validacao.ResultadoValidacao;

import java.util.Objects;


public final class HamburgueriaFacade {

    private static final int UMA_UNIDADE = 1;

    private final FabricaCanal fabricaCanal;
    private final FabricaIngredientes fabricaIngredientes;
    private final Cozinha cozinha;
    private final FilaComandos filaComandos = new FilaComandos();

    public HamburgueriaFacade(FabricaCanal fabricaCanal,
                              FabricaIngredientes fabricaIngredientes,
                              Cozinha cozinha) {
        this.fabricaCanal = Objects.requireNonNull(fabricaCanal, "fabricaCanal");
        this.fabricaIngredientes = Objects.requireNonNull(fabricaIngredientes, "fabricaIngredientes");
        this.cozinha = Objects.requireNonNull(cozinha, "cozinha");
    }

    /** Monta um pedido com o lanche principal do canal e o envia a cozinha. */
    public Pedido abrirPedido(String id) {
        Lanche lanche = fabricaCanal.criadorLanchePrincipal().produzir(fabricaIngredientes);
        Pedido pedido = new Pedido(id);
        pedido.adicionarItem(new ItemPedido(lanche, UMA_UNIDADE));
        cozinha.receberPedido(pedido);
        return pedido;
    }

    public ResultadoValidacao validar(Pedido pedido, ManipuladorPedido cadeia) {
        return cadeia.validar(pedido);
    }

    /** Avanca o preparo via COMMAND (permitindo desfazer depois). */
    public void avancarPreparo(Pedido pedido) {
        filaComandos.executar(new AvancarPreparoComando(pedido, cozinha));
    }

    public void desfazerUltimoPreparo() {
        filaComandos.desfazerUltimo();
    }

    public ResultadoPagamento pagar(Pedido pedido, Pagamento pagamento) {
        return pagamento.pagar(pedido.total());
    }
}
