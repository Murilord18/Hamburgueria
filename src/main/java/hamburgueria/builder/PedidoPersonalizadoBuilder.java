package hamburgueria.builder;

import java.util.ArrayList;
import java.util.List;

public class PedidoPersonalizadoBuilder {
    String nomeLanche   = "";
    String nomeCliente  = "";
    List<String> ingredientesExtras = new ArrayList<>();
    String tipoEntrega        = "Retirada";
    String enderecoEntrega    = "";
    double descontoAplicado   = 0.0;
    String observacoes        = "";

    public PedidoPersonalizadoBuilder() {

    }

    public PedidoPersonalizado build() {
        if (nomeLanche == null || nomeLanche.isBlank()) {
            throw new IllegalArgumentException("Nome do lanche inválido");
        }
        if (nomeCliente == null || nomeCliente.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente inválido");
        }
        return new PedidoPersonalizado(this);
    }



    public PedidoPersonalizadoBuilder setNomeLanche(String nomeLanche) {
        this.nomeLanche = nomeLanche;
        return this;
    }

    public PedidoPersonalizadoBuilder setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        return this;
    }


    public PedidoPersonalizadoBuilder adicionarIngredienteExtra(String ingrediente) {
        this.ingredientesExtras.add(ingrediente);
        return this;
    }

    public PedidoPersonalizadoBuilder setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
        return this;
    }

    public PedidoPersonalizadoBuilder setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
        return this;
    }

    public PedidoPersonalizadoBuilder setDescontoAplicado(double descontoAplicado) {
        this.descontoAplicado = descontoAplicado;
        return this;
    }

    public PedidoPersonalizadoBuilder setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }



}
