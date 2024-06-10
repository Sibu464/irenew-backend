package com.teama.irenew.services;

import com.teama.irenew.customer.User;
import com.teama.irenew.models.CartItem;
import com.teama.irenew.models.Product;
import com.teama.irenew.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/cart")
public class CartService {
    private CartRepository cartRepository;

    public void addToCart(User user, Product product, int quantity) {
        CartItem cartItem = cartRepository.findByUserAndProduct(user, product);
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setUser(user.getId());
            cartItem.setProduct(product);
        }
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartRepository.save(cartItem);
    }

    public void removeFromCart(User user, Product product) {
        CartItem cartItem = cartRepository.findByUserAndProduct(user, product);
        if (cartItem != null) {
            cartRepository.delete(cartItem);
        }
    }

    public void updateCart(User user, Product product, int quantity) {
        CartItem cartItem = cartRepository.findByUserAndProduct(user, product);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartRepository.save(cartItem);
        }
    }

    public List<CartItem> getCartItemsForUser(User user) {
        return cartRepository.findByUser(user);
    }

}
