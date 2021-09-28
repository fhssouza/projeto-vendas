package tech4me.com.produtos.clienteHTPP;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tech4me.com.produtos.shared.Venda;

@FeignClient(name="venda-ms")
public interface VendasFeignClient {
    @GetMapping(path = "/api/vendas/{produto}/lista")
    List<Venda> obterVendas(@PathVariable String produto);
}
