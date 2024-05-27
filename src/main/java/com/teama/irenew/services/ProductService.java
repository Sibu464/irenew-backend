
//This is my service

package com.teama.irenew.services;

import com.teama.irenew.models.Product;
import com.teama.irenew.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    public Product saveProduct(Product product){
        return productRepo.save(product);
    }
    public Optional<Product> getProductById(Long id){
        return productRepo.findById(id);
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

}
