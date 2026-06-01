package hamburgueria.factory;

import hamburgueria.model.Lanche;

public class ComboPremiumFactory implements LancheFactory {
    public Lanche criarLanche() {
        return new Lanche("X-Bacon", 24.90); }

    public Lanche criarAcompanhamento() {
        return new Lanche("Batata Frita G + Onion Rings", 15.00); }
}
