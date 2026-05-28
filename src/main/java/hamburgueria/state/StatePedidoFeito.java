package hamburgueria.state;

public class StatePedidoFeito extends PedidoState {

    @Override
    public void preparar(PedidoContext ctx) {
        System.out.println("Iniciando preparo do pedido.");
        ctx.setEstado(new StatePreparando());
    }

    @Override
    public void cancelar(PedidoContext ctx) {
        System.out.println("Pedido cancelado.");
        ctx.setEstado(new StateCancelado());
    }

    @Override
    public String getNome() { return "Pedido Feito"; }
}
