package hamburgueria.factory;

import hamburgueria.model.Pedido;

public class PedidoCreator {
    private int contadorId = 1;
    public Pedido criarPedido(String nomeLanche) {
        return new Pedido(contadorId++, nomeLanche);
    }
}