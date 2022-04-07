package com.sj.SunnyRestaurant1.vos;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "RestaurantOrders")
public class RestaurantOrders {

       enum orderState {open, started, completed}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Order_No")
    public int orderNo;

    @Column(name = "Order_Status")
    public orderState orderStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "QID")
    public List<OrderMenuItems> orderList;

    @Column(name = "Time_Of_Order")
    public LocalDateTime time;

    @Version
    private int ver;

    @Column(name="customer")
    public String user;

    public RestaurantOrders(List<OrderMenuItems> orderList, LocalDateTime time, String user) {
        this.orderList = orderList;
        this.time = time;
        this.user = user;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public orderState getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(orderState orderStatus) {
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
}
