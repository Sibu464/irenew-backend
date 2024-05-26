package com.teama.irenew.controllers;
import com.teama.irenew.models.CartEntity;
import com.teama.irenew.models.Product;
import com.teama.irenew.services.cartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/cart")
public class CartController {
    @Autowired
    private cartService cartServices;

    @PostMapping
    public void addProduct(@RequestBody CartEntity product){
        cartServices.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public  void removeProduct(@PathVariable Long productId){
        cartServices.removeProduct(productId);
    }

    @GetMapping
    public List<CartEntity> getCartItems(){
        return cartServices.getCartItems();
    }

    @DeleteMapping("/all")
    public void clearCart(){
        cartServices.clearCart();
    }
}
