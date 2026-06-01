package hamburgueria.factory;

import hamburgueria.model.Lanche;

public class ComboPremiumFactory implements LancheFactory {
    public Lanche criarLanche() {
        return new Lanche("X-Burguer", 18.90); }

    public Lanche criarAcompanhamento() {
        return new Lanche("Batata Frita P + Onion Rings", 18.00); }
}
