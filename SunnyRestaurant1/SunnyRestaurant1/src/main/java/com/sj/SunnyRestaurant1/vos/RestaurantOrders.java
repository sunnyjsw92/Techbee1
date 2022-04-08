package com.sj.SunnyRestaurant1.vos;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//this is used for recording orders in the restaurant. note that user is treated as primarykey and Id
@Entity
@Table(name = "RestaurantOrders")
public class RestaurantOrders {

    @Column(name = "Order_Status")
    public String orderStatus;

//    an order list can contain many menu item
    @OneToMany(mappedBy = "restaurantOrders", cascade = CascadeType.ALL)
    public List<OrderMenuItems> orderList;

    @Column(name = "Time_Of_Order")
    public LocalDateTime time;

    @Version
    private int ver;

//    using this as primary key as this with open orders are what matters
    @Id
    @Column(name = "customer")
    public String user;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderMenuItems> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMenuItems> orderList) {
        this.orderList = orderList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public RestaurantOrders() {
    }

    public RestaurantOrders(List<OrderMenuItems> orderList, LocalDateTime time, String user) {
        this.orderList = orderList;
        this.time = time;
        this.user = user;
    }

    public RestaurantOrders(String orderStatus,
            List<OrderMenuItems> orderList, LocalDateTime time, String user) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
        this.time = time;
        this.user = user;
    }
}
