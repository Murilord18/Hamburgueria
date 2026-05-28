package hamburgueria.state;

public class StatePreparando extends PedidoState{
    @Override
    public void concluir(PedidoContext ctx) {
        System.out.println("Pedido concluido na cozinha.");
        ctx.setEstado(new StateConcluido());
    }

    @Override
    public String getNome() { return "Preparando Pedido"; }
}
