package hamburgueria.state;

import hamburgueria.observer.Observable;
import hamburgueria.observer.PedidoObserver;

import java.util.ArrayList;
import java.util.List;

public class PedidoContext implements Observable {

    private PedidoState estado;
    private final String nomeLanche;
    private final List<PedidoObserver> observers = new ArrayList<>();

    public PedidoContext(String nomeLanche) {
        this.nomeLanche = nomeLanche;
        this.estado = new StatePedidoFeito();
    }

    public void setEstado(PedidoState novoEstado) {
        this.estado = novoEstado;
        notificarObservers(); 
    }

    public void confirmar() { estado.confirmar(this); }
    public void preparar()  { estado.preparar(this);  }
    public void concluir()  { estado.concluir(this);  }
    public void enviar()    { estado.enviar(this);    }
    public void cancelar()  { estado.cancelar(this);  }

    public String getEstadoAtual() { return estado.getNome(); }
    public String getNomeLanche()  { return nomeLanche; }

    @Override
    public void adicionarObserver(PedidoObserver observer) { observers.add(observer); }

    @Override
    public void removerObserver(PedidoObserver observer) { observers.remove(observer); }

    @Override
    public void notificarObservers() {
        for (PedidoObserver o : observers) o.notificar(estado.getNome());
    }
}
