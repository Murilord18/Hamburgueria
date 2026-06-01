package hamburgueria.singleton;

import hamburgueria.model.Lanche;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cardapio {

    private static final Cardapio instancia = new Cardapio();

    private final List<Lanche> lanches          = new ArrayList<>();
    private final List<Lanche> acompanhamentos  = new ArrayList<>();
    private final List<Lanche> adicionais       = new ArrayList<>();

    private Cardapio() {

        // Lanches
        lanches.add(new Lanche("X-Burguer",     18.90));
        lanches.add(new Lanche("X-Bacon",       24.90));
        lanches.add(new Lanche("X-Salada",      22.00));
        lanches.add(new Lanche("X-Bacon Duplo", 32.90));

        // Acompanhamentos
        acompanhamentos.add(new Lanche("Batata Frita P",  8.00));
        acompanhamentos.add(new Lanche("Batata Frita G", 12.00));
        acompanhamentos.add(new Lanche("Onion Rings",    10.00));

        // Adicionais (Decorator)
        adicionais.add(new Lanche("+ Queijo",              2.50));
        adicionais.add(new Lanche("+ Bacon Extra",         4.00));
        adicionais.add(new Lanche("+ Ovo",                 2.00));
        adicionais.add(new Lanche("+ Cebola Caramelizada", 3.00));
    }

    public static Cardapio getInstancia() {
        return instancia;
    }

    public List<Lanche> getLanches() {
        return Collections.unmodifiableList(lanches);
    }

    public List<Lanche> getAcompanhamentos() {
        return Collections.unmodifiableList(acompanhamentos);
    }

    public List<Lanche> getAdicionais() {
        return Collections.unmodifiableList(adicionais);
    }

    public void exibir() {
        System.out.println("===== CARDÁPIO =====");

        System.out.println("\n-- Lanches --");
        for (Lanche l : lanches)         System.out.println("  " + l);

        System.out.println("\n-- Acompanhamentos --");
        for (Lanche a : acompanhamentos) System.out.println("  " + a);

        System.out.println("\n-- Adicionais --");
        for (Lanche ad : adicionais)     System.out.println("  " + ad);

        System.out.println("====================");
    }
}