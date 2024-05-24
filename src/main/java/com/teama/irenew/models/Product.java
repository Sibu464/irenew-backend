package com.teama.irenew.models;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "description")
    private  String description;

    @Column(name = "price")
    private double price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "specs")
    private String[] specs;
}
