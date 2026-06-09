package hamburgueria.builder;

import java.util.List;

public class PedidoPersonalizado {

    // --- Campos obrigatórios ---
    private final String nomeLanche;
    private final String nomeCliente;

    // --- Campos opcionais ---
    private final List<String> ingredientesExtras;
    private final String tipoEntrega;
    private final String enderecoEntrega;
    private final double descontoAplicado;
    private final String observacoes;



    public String getNomeLanche() {
        return nomeLanche;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public List<String> getIngredientesExtras() {
        return ingredientesExtras;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public String getEnderecoEntrega() {
         return enderecoEntrega;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    @Override
    public String toString() {
        return "PedidoPersonalizado{" +
                "nomeLanche='"        + nomeLanche         + '\'' +
                ", nomeCliente='"     + nomeCliente        + '\'' +
                ", ingredientesExtras=" + ingredientesExtras +
                ", tipoEntrega='"     + tipoEntrega        + '\'' +
                ", enderecoEntrega='" + enderecoEntrega    + '\'' +
                ", descontoAplicado=" + descontoAplicado   +
                ", observacoes='"     + observacoes        + '\'' +
                '}';
    }
}

