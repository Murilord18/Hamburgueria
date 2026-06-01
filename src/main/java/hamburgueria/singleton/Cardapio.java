package hamburgueria.singleton;


import hamburgueria.model.Lanche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cardapio {


    private static final Cardapio instancia = new Cardapio();
    private final List<Lanche> lanches = new ArrayList<>();
    
    private Cardapio() {
        lanches.add(new Lanche("X-Burguer", 18.90));
        lanches.add(new Lanche("X-Bacon", 24.90));
        lanches.add(new Lanche("X-Salada", 22.00));
    }
    public static Cardapio getInstancia() {
        return instancia;
    }
    public List<Lanche> getLanches() {
        return Collections.unmodifiableList(lanches); }

    public void adicionarLanche(Lanche lanche) { lanches.add(lanche); }
}