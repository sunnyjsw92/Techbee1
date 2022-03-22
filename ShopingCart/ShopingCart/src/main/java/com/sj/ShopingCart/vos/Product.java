package com.sj.ShopingCart.vos;

import org.springframework.stereotype.Component;

@Component
public class Product {

    int id;
    String prodDesc;
    double price;
    int qty;

    public Product() {
    }

    public Product(int id, String prodDesc, double price, int qty) {
        this.id = id;
        this.prodDesc = prodDesc;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
