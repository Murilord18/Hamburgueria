package hamburgueria.chain;

public class FuncionarioAtendente extends Funcionario {

    @Override
    public boolean podeProcessar(TipoPedido tipo) {
        return tipo instanceof TipoPedidoSimples;
    }

    @Override
    public String processar(AprovarPedido pedido) {
        if (podeProcessar(pedido.getTipo())) {
            return "Atendente registrou: " + pedido.getDescricao()
                    + " [" + pedido.getTipo().getTipo() + "]";
        }
        return super.processar(pedido);
    }

    @Override
    public String getNome() {
        return "Atendente";
    }
}
