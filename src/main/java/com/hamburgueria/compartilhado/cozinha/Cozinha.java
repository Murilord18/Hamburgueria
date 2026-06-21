package com.hamburgueria.compartilhado.cozinha;

import com.hamburgueria.compartilhado.lanche.Comestivel;
import com.hamburgueria.compartilhado.pedido.ItemPedido;
import com.hamburgueria.compartilhado.pedido.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Singleton - Iterator - Template Method
public final class Cozinha {

    private static final Cozinha INSTANCIA = new Cozinha();

    private final List<Pedido> fila = new ArrayList<>();
    private final Map<String, List<String>> etapasPorPedido = new HashMap<>();

    private Cozinha() {
    }

    public static Cozinha obterInstancia() {
        return INSTANCIA;
    }

    public void receberPedido(Pedido pedido) {
        fila.add(pedido);
    }

    public int tamanhoFila() {
        return fila.size();
    }

    public List<Pedido> getFila() {
        return Collections.unmodifiableList(fila);
    }


    public List<String> prepararComidas(Pedido pedido) {
        List<String> etapas = new ArrayList<>();
        for (ItemPedido item : pedido) {
            Comestivel comestivel = item.getComestivel();
            if (comestivel.exigePreparo()) {
                comestivel.preparo().ifPresent(receita -> etapas.addAll(receita.preparar()));
            }
        }
        etapasPorPedido.put(pedido.getId(), etapas);
        return etapas;
    }

    public List<String> etapasPreparo(String idPedido) {
        return Collections.unmodifiableList(etapasPorPedido.getOrDefault(idPedido, new ArrayList<>()));
    }

    public void removerPreparo(String idPedido) {
        etapasPorPedido.remove(idPedido);
    }

    public void limparFila() {
        fila.clear();
        etapasPorPedido.clear();
    }
}
