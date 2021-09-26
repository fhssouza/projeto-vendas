package tech4me.com.venda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech4me.com.venda.service.VendaService;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    
}
