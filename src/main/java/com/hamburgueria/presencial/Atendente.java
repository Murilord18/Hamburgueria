package com.hamburgueria.presencial;

import com.hamburgueria.compartilhado.mediator.MediadorHamburgueria;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class Atendente {

    private final String nome;
    private final MediadorHamburgueria mediador;

    public Atendente(String nome, MediadorHamburgueria mediador) {
        this.nome = Objects.requireNonNull(nome, "nome");
        this.mediador = Objects.requireNonNull(mediador, "mediador");
    }

    public String getNome() {
        return nome;
    }


    public List<String> atenderPedido(Pedido pedido) {
        List<String> entregasDiretas = new ArrayList<>();
        boolean temComida = false;
        for (ItemPedido item : pedido) {
            if (item.getComestivel().exigePreparo()) {
                temComida = true;
            } else {
                entregasDiretas.add(nome + " entregou " + item.getComestivel().descricao());
            }
        }
        if (temComida) {
            mediador.registrarPedido(pedido);
        }
        return entregasDiretas;
    }
}
