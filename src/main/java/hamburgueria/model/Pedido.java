package hamburgueria.model;



public class Pedido {

    public enum Status {
        PEDIDO_FEITO("Pedido feito"),
        PREPARANDO("Preparando pedido"),
        PEDIDO_CONCLUIDO("Pedido concluido"),
        PEDIDO_A_CAMINHO("Pedido a caminho");

        private final String descricao;
        Status(String descricao) { this.descricao = descricao; }
        public String getDescricao() { return descricao; }
    }

    private final int id;
    private final String lanche;
    private Status status;


    public Pedido(int id, String lanche) {
        this.id = id;
        this.lanche = lanche;
        this.status = Status.PEDIDO_FEITO;
    }
}
