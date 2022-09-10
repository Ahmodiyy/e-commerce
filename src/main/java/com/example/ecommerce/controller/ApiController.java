package com.example.ecommerce.controller;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ProductDao productDao;
    @Autowired
    UserDao userDao;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }
    @GetMapping("/product/{id}")
    public Product getAllProduct(@PathVariable long id){
        return productDao.findById(id).get();
    }
    @PostMapping("/register")
    public long register(@RequestBody User user){
        if(!Objects.equals(user.getEmail(), "") && !Objects.equals(user.getPassword(), "")){
            return userDao.save(user).getId();
        }
        return 0;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession httpSession){
        if (userDao.existsByEmailAndPassword(user.getEmail(), user.getPassword())){
            httpSession.setAttribute("login",
                    userDao.findByEmailAndPassword(user.getEmail(), user.getPassword()).get());
            return "successful";
        }
        return "null";

    }
}
