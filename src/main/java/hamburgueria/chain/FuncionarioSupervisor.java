package hamburgueria.chain;

public class FuncionarioSupervisor extends Funcionario {

    @Override
    public boolean podeProcessar(TipoPedido tipo) {
        return tipo instanceof TipoPedidoPersonalizado;
    }

    @Override
    public String processar(AprovarPedido pedido) {
        if (podeProcessar(pedido.getTipo())) {
            return "Supervisor preparou: " + pedido.getDescricao()
                    + " [" + pedido.getTipo().getTipo() + "]";
        }
        return super.processar(pedido);
    }

    @Override
    public String getNome() {
        return "Supervisor";
    }
}
