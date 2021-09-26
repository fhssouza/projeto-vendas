package tech4me.com.venda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech4me.com.venda.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, String>{
    
}
