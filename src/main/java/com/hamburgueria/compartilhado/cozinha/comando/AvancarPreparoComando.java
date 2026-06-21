package com.hamburgueria.compartilhado.cozinha.comando;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.pedido.Pedido;
import com.hamburgueria.compartilhado.pedido.memento.PedidoMemento;

import java.util.Objects;


public final class AvancarPreparoComando implements ComandoCozinha {

    private static final String ESTADO_EM_PREPARO = "EM_PREPARO";

    private final Pedido pedido;
    private final Cozinha cozinha;
    private PedidoMemento snapshotAnterior;

    public AvancarPreparoComando(Pedido pedido, Cozinha cozinha) {
        this.pedido = Objects.requireNonNull(pedido, "pedido");
        this.cozinha = Objects.requireNonNull(cozinha, "cozinha");
    }

    @Override
    public void executar() {
        snapshotAnterior = pedido.salvar();
        pedido.avancarEstado();
        if (ESTADO_EM_PREPARO.equals(pedido.getEstado().nome())) {
            cozinha.prepararComidas(pedido);
        }
    }

    @Override
    public void desfazer() {
        if (snapshotAnterior != null) {
            pedido.restaurar(snapshotAnterior);
            cozinha.removerPreparo(pedido.getId());
        }
    }
}
