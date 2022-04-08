package com.sj.SunnyRestaurant1.repositories;

import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//order menu JPA is established but not directly used
@Repository
public interface OrderMenuJpa extends JpaRepository<OrderMenuItems, Integer> {

}
