package com.hamburgueria.compartilhado.pedido.estado;


public interface EstadoPedido {
    String nome();
    EstadoPedido avancar();
    boolean podeCancelar();
}
