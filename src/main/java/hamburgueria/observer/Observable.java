package hamburgueria.observer;

public interface Observable {
    void adicionarObserver(PedidoObserver observer);

    void removerObserver(PedidoObserver observer);

    void notificarObservers();
}

