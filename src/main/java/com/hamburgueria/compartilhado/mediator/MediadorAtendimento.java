package com.hamburgueria.compartilhado.mediator;

import com.hamburgueria.compartilhado.cozinha.Cozinha;
import com.hamburgueria.compartilhado.notificacao.ObservadorPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public final class MediadorAtendimento implements MediadorHamburgueria {

    private final Cozinha cozinha;
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private final List<String> eventos = new ArrayList<>();

    public MediadorAtendimento(Cozinha cozinha) {
        this.cozinha = Objects.requireNonNull(cozinha, "cozinha");
    }

    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }

    @Override
    public void registrarPedido(Pedido pedido) {
        for (ObservadorPedido observador : observadores) {
            pedido.registrar(observador);
        }
        cozinha.receberPedido(pedido);
        eventos.add("registrado:" + pedido.getId());
    }

    @Override
    public void avancarPedido(Pedido pedido) {
        pedido.avancarEstado();
        eventos.add("avancado:" + pedido.getId() + ":" + pedido.getEstado().nome());
    }

    public List<String> getEventos() {
        return Collections.unmodifiableList(eventos);
    }
}
