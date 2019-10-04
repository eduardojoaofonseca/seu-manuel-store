package com.seumanuel.store.service;

import com.seumanuel.store.model.Product;
import com.seumanuel.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){

        this.repository = repository;
    }

    public Product update(String id, Product product) {

        product.setId(id);
        return repository.save(product);
    }

    public void deleteProduct (String id){

        repository.deleteById(id);
    }

    public Product findById(String id) {

        return repository.findById(id).orElse(null);
    }

    public List<Product> findAllByProcessorContaining(String name) {

        return repository.findAllByNameContaining(name);
    }

//    public  List<Product> findAllByPriceBetween(BigDecimal min, BigDecimal max){
//
//        return (repository >= min && repository<= max);
//
//       // repository >= min && repository <= max

        /*
        *
        * price.compareTo( BigDecimal.valueOf( 500 ) > 0
     && price.compareTo( BigDecimal.valueOf( 1000 ) < 0 ) {
    // price is larger than 500 and less than 1000
        *
        *
        *
        * */
    }

}