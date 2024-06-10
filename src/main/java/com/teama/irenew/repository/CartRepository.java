package com.teama.irenew.repository;

import com.teama.irenew.customer.User;
import com.teama.irenew.models.CartItem;
import com.teama.irenew.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Integer> {
    List<CartItem> findByUser(User user);
    CartItem findByUserAndProduct(User user, Product product);
}
