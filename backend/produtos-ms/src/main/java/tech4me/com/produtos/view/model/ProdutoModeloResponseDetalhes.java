package tech4me.com.produtos.view.model;

import java.util.List;

import tech4me.com.produtos.shared.Venda;

public class ProdutoModeloResponseDetalhes {
    private String id;
    private String nome;
    private Double valor;
    private Integer quantidadeEstoque;
    private List<Venda> venda;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public List<Venda> getVenda() {
        return venda;
    }
    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    
}
