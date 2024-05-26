package com.teama.irenew.services;
import com.teama.irenew.models.Product;
import com.teama.irenew.repository.cartRepo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class cartService {
    @Autowired
    private cartRepo cartRepo;

    public void addProduct(Product product){
        cartRepo.save(product);
    }
    public void removeProduct(Long productID){
        cartRepo.deleteById(productID);
    }
    public List<Product> getCartItems(){
        return  cartRepo.findAll();
    }
    public  void clearCart(){
        cartRepo.deleteAll();
    }
}
