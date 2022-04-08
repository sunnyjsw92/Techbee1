package com.sj.SunnyRestaurant1.repositories;

import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//jpa is used to track/record orders and also hibernate access the ordermenu table
@Repository
public interface RestaurantOrdersJpa extends JpaRepository<RestaurantOrders, String> {

}
