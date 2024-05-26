package com.teama.irenew.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @NonNull
    @Column(name = "quantity")
    private double quantity;

    @NonNull
    @Column(name = "description")
    private  String description;

    @NonNull
    @Column(name = "price")
    private double price;

    @NonNull
    @Column(name = "currency")
    private String currency;

    @NonNull
    @Column(name = "imageUrl")
    private String imageUrl;

    @NonNull
    @Column(name = "specs")
    private String[] specs;
}
