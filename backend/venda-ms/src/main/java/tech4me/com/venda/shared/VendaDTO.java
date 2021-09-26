package tech4me.com.venda.shared;

import java.time.LocalDate;

public class VendaDTO {
    private String id;
    private LocalDate data;
    private String produto;
    private Integer quantidade;
    private Double valor;
    
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
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
