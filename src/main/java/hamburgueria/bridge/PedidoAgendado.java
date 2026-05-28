package hamburgueria.bridge;

public class PedidoAgendado extends PedidoEntrega {

    private final String horario;

    public PedidoAgendado(Entrega entrega, String endereco, String horario) {
        super(entrega, endereco);
        this.horario = horario;
    }

    @Override
    public String enviar() {
        return "[AGENDADO " + horario + "] " + entrega.realizarEntrega(endereco);
    }
}
