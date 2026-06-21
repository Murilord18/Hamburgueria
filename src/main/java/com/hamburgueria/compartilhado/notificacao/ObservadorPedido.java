package com.hamburgueria.compartilhado.notificacao;

import com.hamburgueria.compartilhado.pedido.Pedido;


public interface ObservadorPedido {
    void atualizar(Pedido pedido);
}
