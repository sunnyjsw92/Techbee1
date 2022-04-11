package com.sj.SunnyRestaurant1.repositories;

import com.sj.SunnyRestaurant1.vos.RestaurantMenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repository for the menu items that is accessed only by the owner
@Repository
public interface RestaurantMenuJpa extends JpaRepository<RestaurantMenuItem, String> {

}
