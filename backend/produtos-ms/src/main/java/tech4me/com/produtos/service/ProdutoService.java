package tech4me.com.produtos.service;

import java.util.List;
import java.util.Optional;

import tech4me.com.produtos.shared.ProdutoDTO;

public interface ProdutoService {
    ProdutoDTO cadastrarProduto(ProdutoDTO produto);
    List<ProdutoDTO> listarProdutos();
    Optional<ProdutoDTO> obterPorId(String id);
    void excluirProduto(String id);
    Optional<ProdutoDTO> atualizarProdutoPorId(String id, ProdutoDTO produto);
}
