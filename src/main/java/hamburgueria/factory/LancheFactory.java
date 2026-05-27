package hamburgueria.factory;

import hamburgueria.model.Lanche;

public interface LancheFactory {
    Lanche criarLanche();
    Lanche criarAcompanhamento();
}
