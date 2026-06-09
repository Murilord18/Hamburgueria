package hamburgueria.chain;

public abstract class Funcionario {

    private Funcionario proximo;

    public Funcionario setProximo(Funcionario proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public String processar(AprovarPedido pedido) {
        if (proximo != null) {
            return proximo.processar(pedido);
        }
        return "Pedido nao pode ser processado: " + pedido.getDescricao();
    }

    public abstract boolean podeProcessar(TipoPedido tipo);

    public abstract String getNome();
}
