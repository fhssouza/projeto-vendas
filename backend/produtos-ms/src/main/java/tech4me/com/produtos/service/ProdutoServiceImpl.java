package tech4me.com.produtos.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech4me.com.produtos.model.Produto;
import tech4me.com.produtos.repository.ProdutoRepository;
import tech4me.com.produtos.shared.ProdutoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository repositorio;

    @Autowired
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produto = repositorio.findAll();
        return produto.stream()
        .map(p -> new ModelMapper()
        .map(p, ProdutoDTO.class))
        .collect(Collectors.toList());
    }
}
