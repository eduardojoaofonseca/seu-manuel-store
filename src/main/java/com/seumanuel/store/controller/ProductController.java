package com.seumanuel.store.controller;

import com.seumanuel.store.model.Order;
import com.seumanuel.store.model.Product;
import com.seumanuel.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
        public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public Product update(@RequestBody String id,@RequestBody Product product) {
        return productService.update(id,product);
    }

    @GetMapping
    public void subtractStock(@RequestBody Product product,@RequestBody BigDecimal number){
        productService.subtractStock(product,number);
    }

    @GetMapping
    public void addStock(@RequestBody Product product,@RequestBody BigDecimal number){
        productService.addStock(product,number);
    }

    @GetMapping
    public void deleteProduct (@RequestBody String id){
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<Product> findAllByNameContaining(@RequestBody String name) {
        return productService.findAllByNameContaining(name);
    }

    @GetMapping
    public  List<Product> findAllByPriceBetween(@RequestBody BigDecimal min,@RequestBody BigDecimal max){
        return productService.findAllByPriceBetween(min,max);
    }
}

