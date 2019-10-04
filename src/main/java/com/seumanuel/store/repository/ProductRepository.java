package com.seumanuel.store.repository;

import com.seumanuel.store.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{

    List<Product> findAllByPriceBetween(BigDecimal min, BigDecimal max);
    List<Product> findAllByNameContaining(String name);
}
