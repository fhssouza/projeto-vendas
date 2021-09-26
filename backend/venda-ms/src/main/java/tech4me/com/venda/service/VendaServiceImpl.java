package tech4me.com.venda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech4me.com.venda.model.Venda;
import tech4me.com.venda.repository.VendaRepository;
import tech4me.com.venda.shared.VendaDTO;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepository repo;

    @Override
    public List<VendaDTO> obtertodos() {
        List<Venda> vendas = repo.findAll();
        
        return vendas.stream()
        .map(venda -> new ModelMapper().map(venda, VendaDTO.class))
        .collect(Collectors.toList());
    }
    
    
}
