package hamburgueria.bridge;

public class EntregaMotoboy implements Entrega {
    public String realizarEntrega(String endereco) {
        return "Motoboy a caminho para: " + endereco;
    }
}
