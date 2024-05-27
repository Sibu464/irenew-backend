package com.teama.irenew.controllers;

import com.teama.irenew.models.Product;
import com.teama.irenew.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("irenew/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/category/{categoryName}")
    public List<Product> getProductsByCategoryName(@PathVariable String categoryName) {
        return productService.getProductsByCategoryName(categoryName);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Integer productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }
    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable Integer productId){
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable Integer productId) {
        productService.removeProduct(productId);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
