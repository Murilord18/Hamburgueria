package hamburgueria.chain;

public class FuncionarioCoordenador extends Funcionario {

    @Override
    public boolean podeProcessar(TipoPedido tipo) {
        return tipo instanceof TipoPedidoEncomenda;
    }

    @Override
    public String processar(AprovarPedido pedido) {
        if (podeProcessar(pedido.getTipo())) {
            return "Coordenador aprovou encomenda: " + pedido.getDescricao()
                    + " [" + pedido.getTipo().getTipo() + "]";
        }
        return super.processar(pedido);
    }

    @Override
    public String getNome() {
        return "Coordenador";
    }
}
