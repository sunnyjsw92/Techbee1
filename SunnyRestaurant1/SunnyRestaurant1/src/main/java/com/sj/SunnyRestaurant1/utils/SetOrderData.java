package com.sj.SunnyRestaurant1.utils;

import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;

import java.time.LocalDateTime;
import java.util.List;

public class SetOrderData {

//    used to set complete order so that for m=one to many and many to one the relationship is established.
//    Used a smaller method instead of dumping this in the controller

    public static RestaurantOrders setOrderDataForDb(RestaurantOrders order) {
        order.setOrderStatus("open");
        order.setTime(LocalDateTime.now());
        List<OrderMenuItems> list = order.getOrderList();
        for (OrderMenuItems l1 : list) {
            l1.setRestaurantOrders(order);
        }
        return order;
    }
}
