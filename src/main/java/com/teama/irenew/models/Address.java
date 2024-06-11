package com.teama.irenew.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teama.irenew.customer.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="address")
public class Address  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    /** The first line of address. */
    @Column(name = "street", nullable = false, length = 512)
    private String street;
    /** The second line of address. */
    @Column(name = "address_line_2", length = 512)
    private String addressLine2;
    /** The city of the address. */
    @Column(name = "city", nullable = false)
    private String city;
    /** The country of the address. */
    @Column(name = "country", nullable = false, length = 75)
    private String country;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /** The user the address is associated with. */




}
