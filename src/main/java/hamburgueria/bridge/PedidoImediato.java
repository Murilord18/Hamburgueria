package hamburgueria.bridge;

public class PedidoImediato extends PedidoEntrega {
    public PedidoImediato(Entrega entrega, String endereco) {
        super(entrega, endereco);
    }

    @Override
    public String enviar() {
        return "[IMEDIATO] " + entrega.realizarEntrega(endereco);
    }
}
