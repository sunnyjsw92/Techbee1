package com.sj.SunnyRestaurant1;

import com.sj.SunnyRestaurant1.repositories.OrderMenuJpa;
import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SunnyRestaurant1ApplicationTests {

	@Autowired
	OrderMenuJpa orderMenuJpa;

	@Test
	void contextLoads() {
	}
}
