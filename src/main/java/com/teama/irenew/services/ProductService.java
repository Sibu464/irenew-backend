package com.teama.irenew.services;

import com.teama.irenew.models.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    private com.teama.irenew.repository.ProductRepo productRepo;

//    public void addProduct(Product product){
//        productRepo.save(product);
//    }
//    public void removeProduct(Long productID){
//        productRepo.deleteById(productID);
//    }
//    public List<Product> getCartItems(){
//        return  productRepo.findAll();
//    }
//    public  void clearCart(){
//        productRepo.deleteAll();
//    }

    public List<Product> getAllProducts() {
        return  productRepo.findAll();
    }

    public void saveProducts(Product product) {
        productRepo.save(product);
    }

    public Product getProductById(Long id) {
        return  productRepo.findById(Long id);
    }

    public void updateProduct(Long id, Product product) {
    }

    public void deleteProduct(Long productID) {
        productRepo.deleteById(productID);
    }
}
