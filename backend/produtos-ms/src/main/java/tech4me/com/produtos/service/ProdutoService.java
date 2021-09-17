package tech4me.com.produtos.service;

import java.util.List;

import tech4me.com.produtos.shared.ProdutoDTO;

public interface ProdutoService {

    List<ProdutoDTO> listarProdutos();
    ProdutoDTO cadastrarProduto(ProdutoDTO produto);
    
    
}
