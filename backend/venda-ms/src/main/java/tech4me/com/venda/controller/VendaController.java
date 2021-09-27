package tech4me.com.venda.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas(){
        return new ResponseEntity<>(service.obtertodos(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<VendaDTO> cadastrarVenda(@RequestBody VendaDTO venda){
        return new ResponseEntity<>(service.cadastrarVenda(venda), HttpStatus.CREATED);
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




