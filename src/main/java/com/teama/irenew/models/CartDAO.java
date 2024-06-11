package com.teama.irenew.models;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CartDAO extends ListCrudRepository<Cart,Integer> {
    List<Cart> findByUser_Id(Integer id);
}
