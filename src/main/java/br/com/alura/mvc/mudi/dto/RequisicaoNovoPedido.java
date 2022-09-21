package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class RequisicaoNovoPedido {

    @NotBlank(message = "Nome do Produto não pode ser vazio.")
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String urlImagem;
    private String descricaoProduto;

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setDescricao(descricaoProduto);
        return pedido;
    }
}
