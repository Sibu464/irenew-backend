package com.teama.irenew.services;

import com.teama.irenew.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

//    public Product getProductById(Long id) {
//        return  productRepo.findById(id);
//    }

    public Product getProductById(Long id) { //Return type of todo is expected
        Optional<Product> optional = productRepo.findById(id);
        Product product;
        if(optional.isPresent()) {
            product = optional.get();
        }
        else {
            throw new RuntimeException("Todo for the id " + id + " is not found");
        }

        return product;
    }

    public void updateProduct(Long id, Product product) {
    }

    public void deleteProduct(Long productID) {
        productRepo.deleteById(productID);
    }
}
