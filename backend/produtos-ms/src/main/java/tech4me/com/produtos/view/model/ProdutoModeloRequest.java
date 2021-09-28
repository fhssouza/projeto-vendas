package tech4me.com.produtos.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProdutoModeloRequest {
    @NotBlank(message = "O nome não deve possuir caracteres em brancos")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "O nome deve ter, no mínimo, 5 caracteres")
    private String nome;
    private Double valor;
    private Integer quantidadeEstoque;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    
}
