package com.sj.SunnyRestaurant1.repositories;

import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

//order menu JPA is established but not directly used
@Repository
public interface OrderMenuJpa extends JpaRepository<OrderMenuItems, Integer> {
    /*@Query(value = "SELECT * FROM todos t WHERE " +
            "LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%'))",
            nativeQuery = true
    )
    List<Todo> findBySearchTermNative(@Param("searchTerm") String searchTerm);*/

}
