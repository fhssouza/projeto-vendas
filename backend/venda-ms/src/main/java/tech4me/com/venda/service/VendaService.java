package tech4me.com.venda.service;

import java.util.List;

import tech4me.com.venda.shared.VendaDTO;

public interface VendaService {
    List<VendaDTO> obtertodos();
    VendaDTO cadastrarVenda(VendaDTO venda);
}
