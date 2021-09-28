package tech4me.com.venda.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class VendaModeloInclusao {
    private String data;
    @NotBlank(message = "O Produto pode estar em branco")
    @NotEmpty(message = "O Produto é obrigátorio")
    private String produto;
    private Integer quantidade;
    private Double valor;
    
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
