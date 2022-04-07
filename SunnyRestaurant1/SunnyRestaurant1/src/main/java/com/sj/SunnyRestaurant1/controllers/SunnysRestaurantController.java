package com.sj.SunnyRestaurant1.controllers;

import com.sj.SunnyRestaurant1.repositories.RestaurantMenuJpa;
import com.sj.SunnyRestaurant1.repositories.RestaurantOrdersJpa;
import com.sj.SunnyRestaurant1.vos.RestaurantMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("SunnysRestaurant/")
public class SunnysRestaurantController {

    @Autowired
    RestaurantMenuJpa restaurantMenuJpa;

    @Autowired
    RestaurantOrdersJpa restaurantOrdersJpa;

    //    made static so that one call to DB and it is available for all
    static List<RestaurantMenuItem> menuList;

    //    get menu - accessible to all
    @RequestMapping("menu")
    public List<RestaurantMenuItem> getMenu() {
        menuList = restaurantMenuJpa.findAll();
        System.out.println(menuList);
        return menuList;
    }

    //    owner to add to menu
    @RequestMapping("owner/addtomenu")
    public void addToMenu() {
    }

    //    owner to add to remove from menu
    @RequestMapping("owner/deletefrommenu")
    public void deleteFromMenu() {
    }

    //    owner to update menu
    @RequestMapping("owner/updatemenu")
    public void updateMenu() {
    }

    //    chef to get all open orders
    @RequestMapping("chef/getorders")
    public void getForChefOrders() {
    }

    //    chef to update orders as completed
    @RequestMapping("chef/updateorder")
    public void updateByChefOrders() {
    }

    //    user places new order
    @RequestMapping("user/placeorder")
    public void userPlaceOrder() {
    }

    //    user deletes order
    @RequestMapping("user/deleteorder")
    public void userDeleteOrder() {
    }

    //    user updates order
    @RequestMapping("user/updateorder")
    public void userUpdateOrder() {
    }

    //    user sees the order he/she placed
    @RequestMapping("user/getorder")
    public void userGetOrder() {
    }

}
