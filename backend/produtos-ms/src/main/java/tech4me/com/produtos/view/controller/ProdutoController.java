package tech4me.com.produtos.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech4me.com.produtos.model.Produto;
import tech4me.com.produtos.service.ProdutoService;
import tech4me.com.produtos.shared.ProdutoDTO;
import tech4me.com.produtos.view.model.ProdutoModeloRequest;
import tech4me.com.produtos.view.model.ProdutoModeloResponse;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService servico;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta){
        return String.format("Serviço ativo e executado na porta %s", porta);
    }

   @PostMapping
    public ResponseEntity<ProdutoModeloResponse> criarPessoa(@RequestBody @Valid ProdutoModeloRequest produto) {
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(produto, ProdutoDTO.class);
        dto = servico.cadastrarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos() {
        List<ProdutoDTO> dtos = servico.listarProdutos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<ProdutoModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, ProdutoModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> obterPorId(@PathVariable String id) {
        Optional<ProdutoDTO> produto = servico.obterPorId(id);

        if(produto.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(produto.get(), ProdutoModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id){
        servico.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProdutoPorId(@PathVariable String id, @RequestBody Produto produto){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(produto, ProdutoDTO.class);
        Optional<ProdutoDTO> p = servico.atualizarProdutoPorId(id, dto);
        
        if (p.isPresent()) {
            return new ResponseEntity<>(p.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    
        
}



