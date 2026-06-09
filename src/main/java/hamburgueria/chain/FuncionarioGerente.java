package hamburgueria.chain;

public class FuncionarioGerente extends Funcionario {

    @Override
    public boolean podeProcessar(TipoPedido tipo) {
        return tipo instanceof TipoPedidoEvento;
    }

    @Override
    public String processar(AprovarPedido pedido) {
        if (podeProcessar(pedido.getTipo())) {
            return "Gerente autorizou: " + pedido.getDescricao()
                    + " [" + pedido.getTipo().getTipo() + "]";
        }
        return super.processar(pedido);
    }

    @Override
    public String getNome() {
        return "Gerente";
    }
}
