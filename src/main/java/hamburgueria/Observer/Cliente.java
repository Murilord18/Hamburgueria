package hamburgueria.Observer;

public class Cliente {

    private final String nome;
    private String ultimaNotificacao;
    public Cliente(String nome) { this.nome = nome; }


    public String getNome() {
        return nome;
    }
}
