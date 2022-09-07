package com.example.ecommerce.controller;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ProductDao productDao;
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }
    @GetMapping("/product/{id}")
    public Product getAllProduct(@PathVariable long id){
        return productDao.findById(id).get();
    }
}
