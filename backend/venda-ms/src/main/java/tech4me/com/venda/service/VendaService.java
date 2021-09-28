package tech4me.com.venda.service;

import java.util.List;
import java.util.Optional;

import tech4me.com.venda.shared.VendaDTO;

public interface VendaService {
    VendaDTO cadastrarVenda(VendaDTO venda);
    List<VendaDTO> obtertodos();
    Optional<VendaDTO> obterPorId(String id);
    List<VendaDTO> obterPorProduto(String produto);
    Optional<VendaDTO> atualizarVendaPorId(String id, VendaDTO venda);
    void excluirVenda(String id);
}
