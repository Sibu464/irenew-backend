package com.teama.irenew.controllers;

import com.teama.irenew.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        cartService.addToCart(username, productId, quantity);
        return ResponseEntity.ok("Item added to cart");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestParam Long productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        cartService.removeFromCart(username, productId);
        return ResponseEntity.ok("Item removed from cart");
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateCart(@RequestParam Long productId, @RequestParam int quantity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        cartService.updateCart(username, productId, quantity);
        return ResponseEntity.ok("Cart updated");
    }

    @GetMapping("/details")
    public ResponseEntity<List<CartItem>> getCartDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<CartItem> cartItems = cartService.getCartItems(username);
        return ResponseEntity.ok(cartItems);
    }
}
