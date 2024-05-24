package com.teama.irenew.models;

import com.teama.irenew.customer.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Data
@Entity
@Table(name = "cart")
public class CartEntity {

//    This entity will represent a shopping cart, contains multiple items that user intends to purchase.
//    Cart: Represents the shopping cart itself.
//    CartItem: Represents an item within the cart.
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "condition")
    private String condition;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "image")
    private String image;

    @Column(name = "")
    private String specs;

//  Specifies that the role should be persisted as a string in the database.
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public String getCondition() {
        return condition;
    }

}
