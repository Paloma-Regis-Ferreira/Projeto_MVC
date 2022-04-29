package com.paloma.MVCMudi.models;

import javax.validation.constraints.NotBlank;

public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto ;

    @NotBlank
    private String  urlImagem;

    @NotBlank
    private String urlProduto;

    private String  descricao;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setDescricao(descricao);
        pedido.setNome(nomeProduto);
        pedido.setUrlDoProduto(urlProduto);
        pedido.setUrlDaImagem(urlImagem);

        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
