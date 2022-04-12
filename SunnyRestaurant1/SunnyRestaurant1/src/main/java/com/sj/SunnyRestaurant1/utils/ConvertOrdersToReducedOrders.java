package com.sj.SunnyRestaurant1.utils;

import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import com.sj.SunnyRestaurant1.vos.ReducedOrderMenuItems;
import com.sj.SunnyRestaurant1.vos.ReducedRestaurantOrders;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertOrdersToReducedOrders {

    public ReducedRestaurantOrders convertRestOrders(RestaurantOrders order) {
        ReducedRestaurantOrders rro = new ReducedRestaurantOrders();
        rro.setOrderStatus(order.getOrderStatus());
        rro.setTime(order.getTime());
        rro.setUser(order.getUser());
        List<ReducedOrderMenuItems> rrol = new ArrayList<>();
        List<OrderMenuItems> list = order.getOrderList();
        for(OrderMenuItems orm: list) {
            ReducedOrderMenuItems rormi = new ReducedOrderMenuItems();
            rormi.setDishName(orm.getDishName());
            rormi.setSpiceLevel(orm.getSpiceLevel());
            rormi.setPrice(orm.getPrice());
            rormi.setQty(orm.getQty());
            rrol.add(rormi);
        }
        rro.setOrderList(rrol);
        return rro;
    }
}
