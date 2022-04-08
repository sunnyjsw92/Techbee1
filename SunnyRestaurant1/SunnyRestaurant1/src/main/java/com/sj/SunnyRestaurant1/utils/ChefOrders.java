package com.sj.SunnyRestaurant1.utils;

import com.sj.SunnyRestaurant1.repositories.RestaurantOrdersJpa;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChefOrders {

    @Autowired
    RestaurantOrdersJpa restaurantOrdersJpa;

//    simply gets all the orders for the chef
    public List<RestaurantOrders> getChefOrders() {
        return restaurantOrdersJpa.findAll();
    }

//    allows chef to update status
    public String updateOrderByChef (String user, String status) {
        RestaurantOrders order = restaurantOrdersJpa.findById(user).orElseThrow();
        order.setOrderStatus(status);
        restaurantOrdersJpa.save(order);
        return " order for "+user+ " is - "+ status;
    }
}