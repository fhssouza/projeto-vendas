package tech4me.com.produtos.service;

import java.util.List;
import java.util.Optional;

import tech4me.com.produtos.shared.ProdutoDTO;

public interface ProdutoService {

    List<ProdutoDTO> listarProdutos();
    Optional<ProdutoDTO> obterPorId(String id);
    ProdutoDTO cadastrarProduto(ProdutoDTO produto);
    void excluirProduto(String id);
    Optional<ProdutoDTO> atualizarProdutoPorId(String id, ProdutoDTO produto);
}
