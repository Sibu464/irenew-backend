package com.teama.irenew.models;

import com.teama.irenew.customer.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="cartItems")
public class CartItem {
    // getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id") // This column references the user
    private User user;

    @ManyToOne
    private Product product;
    private int quantity;

}
