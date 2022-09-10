package com.example.ecommerce.dao;

import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Boolean existsByEmailAndPassword(String email, String password);

    Optional<User> findByEmailAndPassword(String email, String password);
}
