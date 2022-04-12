package com.sj.SunnyRestaurant1.utils;

import com.sj.SunnyRestaurant1.repositories.RestaurantOrdersJpa;
import com.sj.SunnyRestaurant1.vos.ReducedRestaurantOrders;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChefOrders {

    @Autowired
    RestaurantOrdersJpa restaurantOrdersJpa;

    @Autowired
    ConvertOrdersToReducedOrders convertOrdersToReducedOrders;

    //    simply gets all the orders for the chef
    public List<ReducedRestaurantOrders> getChefOrders() {
        List<RestaurantOrders> orders = restaurantOrdersJpa.findAll();
        List<ReducedRestaurantOrders> rorders = new ArrayList<>();
        for(RestaurantOrders order: orders) {
            ReducedRestaurantOrders rros = convertOrdersToReducedOrders.convertRestOrders(order);
            rorders.add(rros);
        }
        return rorders;
    }

    //    allows chef to update status
    public String updateOrderByChef(String user, String status) {
        RestaurantOrders order = restaurantOrdersJpa.findById(user).orElseThrow();
        order.setOrderStatus(status);
        restaurantOrdersJpa.save(order);
        return " order for " + user + " is - " + status;
    }
}