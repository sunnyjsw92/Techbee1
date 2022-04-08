package com.sj.SunnyRestaurant1.vos;

import javax.persistence.*;

//items on the menu that can be ordered. using id as auto generated, dishname, price, spice level and qty
@Entity
@Table(name = "OrderMenuItems")
public class OrderMenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OrderMenu_Id")
    public int orderMenuId;

    @Column(name = "dish")
    public String dishName;

    @Column(name = "SPICE")
    public String spiceLevel;

    @Column(name = "Price")
    public float price;

    @Column(name = "QTY")
    public int qty;

    @ManyToOne
    @JoinColumn(name = "customer")
    public RestaurantOrders restaurantOrders;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
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

    public RestaurantOrders getRestaurantOrders() {
        return restaurantOrders;
    }

    public void setRestaurantOrders(RestaurantOrders restaurantOrders) {
        this.restaurantOrders = restaurantOrders;
    }

    public OrderMenuItems() {
    }
}
