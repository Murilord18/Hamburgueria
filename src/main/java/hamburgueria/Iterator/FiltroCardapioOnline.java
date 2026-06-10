package hamburgueria.Iterator;

import java.util.Iterator;

public class FiltroCardapioOnline {


    public static ItemCardapioOnline buscarMaisPedido(CardapioIterator cardapio) {
        ItemCardapioOnline maisPedido = null;
        for (ItemCardapioOnline item : cardapio) {
            if (maisPedido == null || item.getTotalPedidos() > maisPedido.getTotalPedidos()) {
                maisPedido = item;
            }
        }
        return maisPedido;
    }


    public static ItemCardapioOnline buscarMaiorPreco(CardapioIterator cardapio) {
        ItemCardapioOnline maisCaro = null;
        for (ItemCardapioOnline item : cardapio) {
            if (maisCaro == null || item.getPreco() > maisCaro.getPreco()) {
                maisCaro = item;
            }
        }
        return maisCaro;
    }



    public static ItemCardapioOnline buscarMenorPreco(CardapioIterator cardapio) {
        ItemCardapioOnline maisBarato = null;
        for (Iterator<ItemCardapioOnline> it = cardapio.iterator(); it.hasNext(); ) {
            ItemCardapioOnline item = it.next();
            if (maisBarato == null || item.getPreco() < maisBarato.getPreco()) {
                maisBarato = item;
            }
        }
        return maisBarato;
    }
}
