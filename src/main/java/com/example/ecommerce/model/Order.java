package com.example.ecommerce.model;

import jakarta.persistence.*;
import jakarta.websocket.OnError;

public class Order {
    @Id
    @GeneratedValue()
    private Integer productId;
    @OneToOne
    @JoinColumn(name = "userID", referencedColumnName = "userId")
    private User user;
    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;
    @Column
    private Integer quantity;
    @Column
    private String date;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
