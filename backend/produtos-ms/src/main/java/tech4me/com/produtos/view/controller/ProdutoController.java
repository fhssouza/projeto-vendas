package tech4me.com.produtos.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech4me.com.produtos.service.ProdutoService;
import tech4me.com.produtos.shared.ProdutoDTO;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService servico;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(){
        return new ResponseEntity<>(servico.listarProdutos(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produto){
        return new ResponseEntity<>(servico.cadastrarProduto(produto), HttpStatus.CREATED);
    }
    
}
