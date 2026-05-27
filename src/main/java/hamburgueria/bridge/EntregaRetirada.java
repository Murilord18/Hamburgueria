package hamburgueria.bridge;

public class EntregaRetirada implements Entrega {
    public String realizarEntrega(String endereco) {

        return "Pedido disponivel para retirada em: " + endereco;
    }
}
