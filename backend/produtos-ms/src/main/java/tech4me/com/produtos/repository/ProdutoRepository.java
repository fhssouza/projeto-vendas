package tech4me.com.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech4me.com.produtos.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, Integer> {
    
}
