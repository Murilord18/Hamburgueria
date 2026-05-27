package hamburgueria.factory;

import hamburgueria.model.Lanche;

public class ComboTradicionalFactory implements LancheFactory {
    public Lanche criarLanche() {
        return new Lanche("X-Burguer", 18.90); }

    public Lanche criarAcompanhamento() {
        return new Lanche("Batata Frita P", 8.00); }
}
