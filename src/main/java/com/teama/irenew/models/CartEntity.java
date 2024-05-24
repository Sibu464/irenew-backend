package com.teama.irenew.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {

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



}
