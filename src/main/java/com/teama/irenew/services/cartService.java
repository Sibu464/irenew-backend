package com.teama.irenew.services;
import com.teama.irenew.models.CartEntity;
import com.teama.irenew.models.Product;
import com.teama.irenew.repository.cartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartService {
    @Autowired
    private cartRepo cartRepo;

    public void addProduct(CartEntity cartEntity){
        cartRepo.save(cartEntity);
    }
    public void removeProduct(Long productID){
        cartRepo.deleteById(productID);
    }
    public List<CartEntity> getCartItems(){
        return  cartRepo.findAll();
    }
    public  void clearCart(){
        cartRepo.deleteAll();
    }
}
