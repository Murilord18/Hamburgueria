package com.hamburgueria.compartilhado.pedido.estado;

public final class EstadoCancelado implements EstadoPedido {

    @Override
    public String nome() {
        return "CANCELADO";
    }

    @Override
    public EstadoPedido avancar() {
        return this;
    }

    @Override
    public boolean podeCancelar() {
        return false;
    }
}
