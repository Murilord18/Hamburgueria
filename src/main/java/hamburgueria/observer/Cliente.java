package hamburgueria.observer;

public class Cliente implements PedidoObserver {

    private final String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome; }

    @Override
    public void notificar(String status) {
        this.ultimaNotificacao = status;
        System.out.println("Cliente " + nome + " notificado: " + status);
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao; }

    public String getNome() {
        return nome; }
}