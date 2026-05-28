package hamburgueria.state;

public class StateConcluido extends PedidoState{
    @Override
    public String getNome() {
        return "Pedido Concluido";
    }

    @Override
    public void enviar(PedidoContext ctx) {
        System.out.println("Pedido saiu para entrega.");
        ctx.setEstado(new StateACaminho());
    }
}
