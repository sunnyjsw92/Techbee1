package com.sj.SunnyRestaurant1.vos;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReducedRestaurantOrders {

    public String orderStatus;

    public List<ReducedOrderMenuItems> orderList;

    public LocalDateTime time;

    public String user;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<ReducedOrderMenuItems> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<ReducedOrderMenuItems> orderList) {
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


    public ReducedRestaurantOrders(String orderStatus,
            List<ReducedOrderMenuItems> orderList, LocalDateTime time, String user) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
        this.time = time;
        this.user = user;
    }

    public ReducedRestaurantOrders() {
    }
}
