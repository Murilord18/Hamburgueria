package com.hamburgueria.compartilhado.pedido.estado;

public final class EstadoEmPreparo implements EstadoPedido {

    @Override
    public String nome() {
        return "EM_PREPARO";
    }

    @Override
    public EstadoPedido avancar() {
        return new EstadoPronto();
    }

    @Override
    public boolean podeCancelar() {
        return true;
    }
}
