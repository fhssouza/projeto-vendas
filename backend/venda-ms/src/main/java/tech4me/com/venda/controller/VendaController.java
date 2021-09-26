package tech4me.com.venda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}


