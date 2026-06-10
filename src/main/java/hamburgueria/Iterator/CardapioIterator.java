package hamburgueria.Iterator;

import hamburgueria.singleton.Cardapio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CardapioIterator implements Iterable<ItemCardapioOnline> {

    private List<ItemCardapioOnline> itens = new ArrayList<>();

    public CardapioIterator(ItemCardapioOnline... itens) {
        this.itens = Arrays.asList(itens);
    }

    @Override
    public Iterator<ItemCardapioOnline> iterator() {
        return itens.iterator();
    }

    public static CardapioIterator cardapioCompleto() {
        Cardapio c = Cardapio.getInstancia();
        List<ItemCardapioOnline> todos = new ArrayList<>();

        c.getLanches().forEach(l ->
                todos.add(new ItemCardapioOnline(l.getNome(), l.getPreco(), "LANCHE", 0)));
        c.getAcompanhamentos().forEach(a ->
                todos.add(new ItemCardapioOnline(a.getNome(), a.getPreco(), "ACOMPANHAMENTO", 0)));
        c.getAdicionais().forEach(ad ->
                todos.add(new ItemCardapioOnline(ad.getNome(), ad.getPreco(), "ADICIONAL", 0)));

        return new CardapioIterator(todos.toArray(new ItemCardapioOnline[0]));
    }
}
