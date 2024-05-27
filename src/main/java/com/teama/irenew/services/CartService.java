package com.teama.irenew.services;

import com.teama.irenew.models.Cart;
import com.teama.irenew.models.CartItem;
import com.teama.irenew.models.Product;
import com.teama.irenew.repository.CartRepository;
import com.teama.irenew.repository.CartItemRepository;
import com.teama.irenew.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepo productRepo;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart addItemToCart(Long cartId, Long productId, int quantity) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<Product> productOptional = productRepo.findById(productId);
        if (cartOptional.isPresent() && productOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Product product = productOptional.get();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);
            cart.addItem(cartItem);
            cartItemRepository.save(cartItem);
            return cartRepository.save(cart);
        }
        throw new RuntimeException("Cart or Product not found");
    }

    public Cart removeItemFromCart(Long cartId, Long cartItemId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if (cartOptional.isPresent() && cartItemOptional.isPresent()) {
            Cart cart = cartOptional.get();
            CartItem cartItem = cartItemOptional.get();
            cart.removeItem(cartItem);
            cartItemRepository.delete(cartItem);
            return cartRepository.save(cart);
        }
        throw new RuntimeException("Cart or CartItem not found");
    }

    public double calculateTotal(Long cartId) {
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isPresent()) {
            return cartOptional.get().calculateTotal();
        }
        throw new RuntimeException("Cart not found");
    }
}
