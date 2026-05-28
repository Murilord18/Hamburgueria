package hamburgueria.state;

public class PedidoContext {

    private PedidoState estado;
    private final String nomeLanche;

    public PedidoContext(String nomeLanche) {
        this.nomeLanche = nomeLanche;
        this.estado = new EstadoPedidoFeito();
        System.out.println("Pedido criado: " + nomeLanche + " | Estado: " + estado.getNome());
    }

    public void setEstado(PedidoState novoEstado) {
        this.estado = novoEstado;
        System.out.println("Novo estado: " + estado.getNome());
    }

    public void confirmar() { estado.confirmar(this); }
    public void preparar()  { estado.preparar(this);  }
    public void concluir()  { estado.concluir(this);  }
    public void enviar()    { estado.enviar(this);    }
    public void cancelar()  { estado.cancelar(this);  }

    public String getEstadoAtual() { return estado.getNome(); }
    public String getNomeLanche()  { return nomeLanche; }
}
