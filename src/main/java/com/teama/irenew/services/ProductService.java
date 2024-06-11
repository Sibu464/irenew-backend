package com.teama.irenew.services;

import com.teama.irenew.models.Product;
import com.teama.irenew.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/products")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepository.findByCategory(categoryName);
    }

    public Product updateProduct(Integer productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setTitle(updatedProduct.getTitle());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        return productRepository.save(existingProduct);
    }

    public void removeProduct(Integer productId) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(existingProduct);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Integer productId){
        return productRepository.findById(productId);
    }


    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
