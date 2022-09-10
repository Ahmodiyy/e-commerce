package com.example.ecommerce.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne()
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;
    @OneToOne()
    @JoinColumn(name = "productId", referencedColumnName ="id")
    private Product product;
    private int quantity;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
