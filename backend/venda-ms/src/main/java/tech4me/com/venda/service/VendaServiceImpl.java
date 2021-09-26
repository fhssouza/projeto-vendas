package tech4me.com.venda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech4me.com.venda.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repo;
    
    
}
