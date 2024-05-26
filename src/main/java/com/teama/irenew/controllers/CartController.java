package com.teama.irenew.controllers;
import com.teama.irenew.models.Product;
import com.teama.irenew.services.cartService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private cartService cartService;

    @PostMapping
    public void addProduct(@RequestBody Product product){
        cartService.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public  void removeProduct(@PathVariable Long productId){
        cartService.removeProduct(productId);
    }

    @GetMapping
    public List<Product> getCartItems(){
        return cartService.getCartItems();
    }

    @DeleteMapping("/all")
    public void clearCart(){
        cartService.clearCart();
    }
}
