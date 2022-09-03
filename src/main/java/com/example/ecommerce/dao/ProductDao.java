package com.example.ecommerce.dao;

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}