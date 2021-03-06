package tech4me.com.produtos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech4me.com.produtos.clienteHTPP.VendasFeignClient;
import tech4me.com.produtos.model.Produto;
import tech4me.com.produtos.repository.ProdutoRepository;
import tech4me.com.produtos.shared.ProdutoDTO;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository repositorio;

    @Autowired
    private VendasFeignClient vendasMsClient;

    @Override
    public Optional<ProdutoDTO> obterPorId(String id) {
       Optional<Produto> produto = repositorio.findById(id);

        
       if(produto.isPresent()) {
           ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
           dto.setVenda(vendasMsClient.obterVendas(id));
           return Optional.of(dto);
       }

       return Optional.empty();
    }

    @Override
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produto = repositorio.findAll();
        return produto.stream()
        .map(p -> new ModelMapper()
        .map(p, ProdutoDTO.class))
        .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO cadastrarProduto(ProdutoDTO produto){
        ModelMapper mapper = new ModelMapper();
        Produto salvarProduto = mapper.map(produto, Produto.class);
        salvarProduto = repositorio.save(salvarProduto);
        return mapper.map(salvarProduto, ProdutoDTO.class);
    }

    @Override
    public void excluirProduto(String id) {
        repositorio.deleteById(id);
    }

    @Override
    public Optional<ProdutoDTO> atualizarProdutoPorId(String id, ProdutoDTO produto) {
        ModelMapper mapper = new ModelMapper();
        Optional<Produto> p = repositorio.findById(id);
        Produto salvarProduto = mapper.map(produto, Produto.class);

        if (p.isPresent()){
            salvarProduto.setId(id);
            salvarProduto = repositorio.save(salvarProduto);
            return Optional.of(mapper.map(salvarProduto, ProdutoDTO.class));
        }
        return Optional.empty();
    }
}

