package hamburgueria.chain;

public class AprovarPedido {

    private final String descricao;
    private final TipoPedido tipo;

    public AprovarPedido(String descricao, TipoPedido tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

}
