package com.teama.irenew.repository;

import com.teama.irenew.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepo extends JpaRepository<Product, Long> {
}
