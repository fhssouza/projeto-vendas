package tech4me.com.venda.view.controller;

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

import tech4me.com.venda.model.Venda;
import tech4me.com.venda.service.VendaService;
import tech4me.com.venda.shared.VendaDTO;
import tech4me.com.venda.view.model.VendaModeloInclusao;
import tech4me.com.venda.view.model.VendaModeloResponse;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    } 

    @PostMapping
    public ResponseEntity<VendaModeloResponse> cadastrarVenda(@RequestBody @Valid VendaModeloInclusao Venda) {
        ModelMapper mapper = new ModelMapper();
        VendaDTO dto = mapper.map(Venda, VendaDTO.class);
        dto = service.cadastrarVenda(dto);
        return new ResponseEntity<>(mapper.map(dto, VendaModeloResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VendaModeloResponse>> listarVendas(){
        List<VendaDTO> dtos = service.obtertodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModeloResponse> resp = dtos.stream()
            .map(dto -> mapper.map(dto, VendaModeloResponse.class))
            .collect(Collectors.toList());
        
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<VendaModeloResponse> obterPorId(@PathVariable String id) {
        Optional<VendaDTO> venda = service.obterPorId(id);

        if(venda.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(venda.get(), VendaModeloResponse.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value="/{produto}/lista")
    public ResponseEntity<List<VendaModeloResponse>> obterPorProduto(@PathVariable String produto) {
        List<VendaDTO> dtos = service.obterPorProduto(produto);

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, VendaModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @PutMapping(value="/{id}")
    public ResponseEntity<VendaDTO> atualizarVendaPorId(@PathVariable String id, @RequestBody Venda venda){
        ModelMapper mapper = new ModelMapper();
        VendaDTO dto = mapper.map(venda, VendaDTO.class);
        Optional<VendaDTO> vendas = service.atualizarVendaPorId(id, dto);

        if (vendas.isPresent()){
            return new ResponseEntity<>(vendas.get(), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> excluirVenda(@PathVariable String id){
        service.excluirVenda(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




