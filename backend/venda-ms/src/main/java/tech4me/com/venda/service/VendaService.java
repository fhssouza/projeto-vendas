package tech4me.com.venda.service;

import java.util.List;
import java.util.Optional;

import tech4me.com.venda.shared.VendaDTO;

public interface VendaService {
    List<VendaDTO> obtertodos();
    VendaDTO cadastrarVenda(VendaDTO venda);
    Optional<VendaDTO> atualizarVendaPorId(String id, VendaDTO venda);
    void excluirVenda(String id);
    
    
}
