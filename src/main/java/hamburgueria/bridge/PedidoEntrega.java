package hamburgueria.bridge;

public  abstract class PedidoEntrega {

    protected final Entrega entrega;
    protected final String endereco;

    public PedidoEntrega(Entrega entrega, String endereco){
        this.entrega = entrega;
        this.endereco = endereco;
    }
    public abstract String enviar();
}
