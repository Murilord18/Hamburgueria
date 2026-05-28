package hamburgueria.state;

public abstract class PedidoState {

    public void confirmar(PedidoContext ctx) {
        System.out.println("Acao nao permitida no estado: " + getClass().getSimpleName());
    }

    public void preparar(PedidoContext ctx) {
        System.out.println("Acao nao permitida no estado: " + getClass().getSimpleName());
    }

    public void concluir(PedidoContext ctx) {
        System.out.println("Acao nao permitida no estado: " + getClass().getSimpleName());
    }

    public void enviar(PedidoContext ctx) {
        System.out.println("Acao nao permitida no estado: " + getClass().getSimpleName());
    }

    public void cancelar(PedidoContext ctx) {
        System.out.println("Acao nao permitida no estado: " + getClass().getSimpleName());
    }

    public abstract String getNome();
}