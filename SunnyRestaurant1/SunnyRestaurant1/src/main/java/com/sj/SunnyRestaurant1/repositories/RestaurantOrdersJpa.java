package com.sj.SunnyRestaurant1.repositories;

import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantOrdersJpa extends JpaRepository<RestaurantOrders, String> {

}
