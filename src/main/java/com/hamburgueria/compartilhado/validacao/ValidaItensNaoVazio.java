package com.hamburgueria.compartilhado.validacao;

import com.hamburgueria.compartilhado.pedido.Pedido;

public final class ValidaItensNaoVazio extends ManipuladorPedido {

    private static final int MINIMO_ITENS = 1;

    @Override
    protected ResultadoValidacao verificar(Pedido pedido) {
        if (pedido.quantidadeItens() < MINIMO_ITENS) {
            return ResultadoValidacao.falha("pedido sem itens");
        }
        return ResultadoValidacao.ok();
    }
}
