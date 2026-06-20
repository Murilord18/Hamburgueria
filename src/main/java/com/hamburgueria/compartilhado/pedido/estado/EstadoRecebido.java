package com.hamburgueria.compartilhado.pedido.estado;

public final class EstadoRecebido implements EstadoPedido {

    @Override
    public String nome() {
        return "RECEBIDO";
    }

    @Override
    public EstadoPedido avancar() {
        return new EstadoEmPreparo();
    }

    @Override
    public boolean podeCancelar() {
        return true;
    }
}
