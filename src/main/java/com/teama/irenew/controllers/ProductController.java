package com.teama.irenew.controllers;

import com.teama.irenew.models.Product;
import com.teama.irenew.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.getAllProducts();
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.saveProducts(product);
    }

    @GetMapping("/{id}")
    public Product findOne(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Product product) {
        this.productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.deleteProduct(id);
    }

}
