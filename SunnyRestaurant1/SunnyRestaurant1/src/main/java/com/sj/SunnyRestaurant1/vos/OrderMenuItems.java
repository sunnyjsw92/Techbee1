package com.sj.SunnyRestaurant1.vos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "OrderMenuItems")
public class OrderMenuItems {

    enum dishType {mild, medium, spicy}

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "dish")
    public String dishName;

    @Column(name = "SPICE")
    public dishType spiceLevel;

    @Column(name = "Price")
    public float price;

    @Column(name = "QTY")
    public int qty;


    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public dishType getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(dishType spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public OrderMenuItems(String dishName, dishType spiceLevel, float price, int qty) {
        this.dishName = dishName;
        this.spiceLevel = spiceLevel;
        this.price = price;
        this.qty = qty;
    }

    public OrderMenuItems() {
    }
}
