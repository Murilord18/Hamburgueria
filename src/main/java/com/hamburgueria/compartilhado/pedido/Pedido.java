package com.hamburgueria.compartilhado.pedido;

import com.hamburgueria.compartilhado.notificacao.Assunto;
import com.hamburgueria.compartilhado.notificacao.ObservadorPedido;
import com.hamburgueria.compartilhado.pedido.estado.EstadoCancelado;
import com.hamburgueria.compartilhado.pedido.estado.EstadoPedido;
import com.hamburgueria.compartilhado.pedido.estado.EstadoRecebido;
import com.hamburgueria.compartilhado.pedido.memento.PedidoMemento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//Iterator - State - Observer - Memento
public class Pedido implements Iterable<ItemPedido>, Assunto {

    private static final BigDecimal VALOR_ZERO = new BigDecimal("0.00");

    private final String id;
    private final List<ItemPedido> itens = new ArrayList<>();
    private final List<ObservadorPedido> observadores = new ArrayList<>();
    private EstadoPedido estado = new EstadoRecebido();

    public Pedido(String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public String getId() {
        return id;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public int quantidadeItens() {
        return itens.size();
    }

    public BigDecimal total() {
        BigDecimal total = VALOR_ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.subtotal());
        }
        return total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void avancarEstado() {
        estado = estado.avancar();
        notificarObservadores();
    }

    public void cancelar() {
        if (!estado.podeCancelar()) {
            throw new IllegalStateException("Pedido nao pode ser cancelado no estado " + estado.nome());
        }
        estado = new EstadoCancelado();
        notificarObservadores();
    }

    // ----- ITERATOR -----
    @Override
    public Iterator<ItemPedido> iterator() {
        return new IteradorItensPedido(itens);
    }

    // ----- OBSERVER -----
    @Override
    public void registrar(ObservadorPedido observador) {
        observadores.add(observador);
    }

    @Override
    public void remover(ObservadorPedido observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (ObservadorPedido observador : new ArrayList<>(observadores)) {
            observador.atualizar(this);
        }
    }

    public int quantidadeObservadores() {
        return observadores.size();
    }

    // ----- MEMENTO -----
    public PedidoMemento salvar() {
        return new PedidoMemento(estado, itens);
    }

    public void restaurar(PedidoMemento memento) {
        this.estado = memento.getEstado();
        this.itens.clear();
        this.itens.addAll(memento.getItens());
    }
}
