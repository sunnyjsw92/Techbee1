package com.sj.SunnyRestaurant1.utils;

import com.sj.SunnyRestaurant1.repositories.RestaurantOrdersJpa;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserOrders {

    @Autowired
    RestaurantOrdersJpa restaurantOrdersJpa;

    //when user places order
    public String userPlaceOrder(RestaurantOrders order) {
        List<RestaurantOrders> orders = restaurantOrdersJpa.findAll();
        for (RestaurantOrders orders1 : orders) {
            if (orders1.getUser().equalsIgnoreCase(order.getUser()) && orders1.getOrderStatus().equals(
                    "open")) {
                return "your order no is - " + orders1.getUser();
            }
        }
        return "order no not generated - please contact the manager";
    }

    //when user deletes order
    public String userDeleteOrder(String user) {
        List<RestaurantOrders> orders = restaurantOrdersJpa.findAll();
        for (RestaurantOrders orders1 : orders) {
            if (orders1.getUser().equalsIgnoreCase(user) && orders1.getOrderStatus().equals(
                    "open")) {
                restaurantOrdersJpa.deleteById(user);
                return "your order has been deleted";
            }
        }
        return "order not found - please contact the manager";
    }

    //when user wants to see the order
    public ResponseEntity userGetOrder(String user) {
        Optional<RestaurantOrders> order = restaurantOrdersJpa.findById(user);
        if (order.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user order not found - contact the "
                    + "Manager");
        }
        else {
            return new ResponseEntity(order, HttpStatus.OK);
        }
    }

    //when user wants to update order
    public ResponseEntity userUpdateOrder(RestaurantOrders order) {
        RestaurantOrders rorder = restaurantOrdersJpa.findById(order.getUser()).orElseThrow();
        if (!rorder.getOrderStatus().equalsIgnoreCase("open")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("order in progress/completed - cannot "
                    + "change now");
        }
        else {
            rorder = SetOrderData.setOrderDataForDb(order);
            restaurantOrdersJpa.save(rorder);
            return new ResponseEntity(rorder, HttpStatus.OK);
        }
    }

}
