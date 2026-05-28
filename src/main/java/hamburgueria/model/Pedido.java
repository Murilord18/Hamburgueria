package hamburgueria.model;


import hamburgueria.observer.Observable;
import hamburgueria.observer.PedidoObserver;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Observable {

    public enum Status {
        PEDIDO_FEITO("Pedido feito"),
        PREPARANDO("Preparando pedido"),
        PEDIDO_CONCLUIDO("Pedido concluido"),
        PEDIDO_A_CAMINHO("Pedido a caminho"),
        PEDIDO_CENCELADO("Pedido Cancelado");

        private final String descricao;
        Status(String descricao) { this.descricao = descricao; }
        public String getDescricao() { return descricao; }
    }

    private final int id;
    private final String lanche;
    private Status status;
    private final List<PedidoObserver> observers = new ArrayList<>();

    public Pedido(int id, String lanche) {
        this.id = id;
        this.lanche = lanche;
        this.status = Status.PEDIDO_FEITO;
    }

    @Override
    public void adicionarObserver(PedidoObserver observer) { observers.add(observer); }

    @Override
    public void removerObserver(PedidoObserver observer) { observers.remove(observer); }

    @Override
    public void notificarObservers() {
        for (PedidoObserver o : observers) o.notificar(status.getDescricao());
    }

    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
        notificarObservers();
    }

    public Status getStatus() { return status; }
    public int getId() { return id; }
    public String getLanche() { return lanche; }
}
