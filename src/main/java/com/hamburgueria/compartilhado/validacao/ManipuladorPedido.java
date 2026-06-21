package com.hamburgueria.compartilhado.validacao;

import com.hamburgueria.compartilhado.pedido.Pedido;


public abstract class ManipuladorPedido {

    private ManipuladorPedido proximo;

    public ManipuladorPedido encadear(ManipuladorPedido proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public final ResultadoValidacao validar(Pedido pedido) {
        ResultadoValidacao resultado = verificar(pedido);
        if (!resultado.isValido()) {
            return resultado;
        }
        if (proximo != null) {
            return proximo.validar(pedido);
        }
        return ResultadoValidacao.ok();
    }

    protected abstract ResultadoValidacao verificar(Pedido pedido);
}
