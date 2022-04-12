package com.sj.SunnyRestaurant1.controllers;

import com.sj.SunnyRestaurant1.repositories.RestaurantMenuJpa;
import com.sj.SunnyRestaurant1.repositories.RestaurantOrdersJpa;
import com.sj.SunnyRestaurant1.utils.ChefOrders;
import com.sj.SunnyRestaurant1.utils.SetOrderData;
import com.sj.SunnyRestaurant1.utils.UserOrders;
import com.sj.SunnyRestaurant1.vos.OrderMenuItems;
import com.sj.SunnyRestaurant1.vos.ReducedRestaurantOrders;
import com.sj.SunnyRestaurant1.vos.RestaurantMenuItem;
import com.sj.SunnyRestaurant1.vos.RestaurantOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("SunnysRestaurant/")
public class SunnysRestaurantController {

    @Autowired
    RestaurantMenuJpa restaurantMenuJpa;

    @Autowired
    RestaurantOrdersJpa restaurantOrdersJpa;

    @Autowired
    UserOrders userOrders;

    @Autowired
    ChefOrders chefOrders;

    //    get menu
    @RequestMapping("menu")
    public List<RestaurantMenuItem> getMenu() {
        List<RestaurantMenuItem> menuList = restaurantMenuJpa.findAll();
        return menuList;
    }

    //    owner to add to menu
    @RequestMapping("owner/addtomenu")
    public String addToMenu(@RequestBody RestaurantMenuItem restaurantMenuItem) {
        List<RestaurantMenuItem> menuList = restaurantMenuJpa.findAll();
        for (RestaurantMenuItem items : menuList) {
            if (items.getDishName().equalsIgnoreCase(restaurantMenuItem.getDishName())) {
                return "this dish already exists - try updating this";
            }
        }
        restaurantMenuJpa.save(restaurantMenuItem);
        return "added the product to the menu item " + restaurantMenuItem.toString();
    }

    //    owner to add to remove from menu
    @RequestMapping("owner/deletefrommenu")
    public String deleteFromMenu(@RequestBody String dishName) {
        List<RestaurantMenuItem> menuList = restaurantMenuJpa.findAll();
        for (RestaurantMenuItem items : menuList) {
            if (items.getDishName().equalsIgnoreCase(dishName)) {
                restaurantMenuJpa.deleteById(dishName);
                return dishName + "- successfully removed from menu";
            }
        }
        return dishName + " not found in menu, so cannot be deleted";
    }

    //    owner to update menu
    @RequestMapping("owner/updatemenu")
    public String updateMenu(@RequestBody RestaurantMenuItem restaurantMenuItem) {
        List<RestaurantMenuItem> menuList = restaurantMenuJpa.findAll();
        String dishname = restaurantMenuItem.getDishName().toLowerCase();
        for (RestaurantMenuItem items : menuList) {
            if (items.getDishName().equalsIgnoreCase(dishname)) {
                items.setDishName(restaurantMenuItem.getDishName());
                items.setPrice(restaurantMenuItem.getPrice());
                items.setSpiceLevel(restaurantMenuItem.getSpiceLevel());
                restaurantMenuJpa.save(items);
                return restaurantMenuItem.getDishName() + "- successfully updated";
            }
        }
        return restaurantMenuItem.getDishName() + " not found in menu, so cannot be updated. Try adding it";
    }

    //    chef to get all open orders
    @RequestMapping("chef/getorders")
    public List<ReducedRestaurantOrders> getForChefOrders() {
        return chefOrders.getChefOrders();
    }

    //    chef to update orders as completed
    @RequestMapping("chef/updateorder")
    public String updateByChefOrders(@RequestBody String[] updateinfo) {
        return chefOrders.updateOrderByChef(updateinfo[0], updateinfo[1]);
    }

    //    endpoint developed for testing purposes - not to be used later on
    @RequestMapping("test")
    public RestaurantOrders getPostInfo() {
        RestaurantOrders order = new RestaurantOrders();
        OrderMenuItems o1 = new OrderMenuItems();
        o1.setDishName("disha");
        o1.setSpiceLevel("hot");
        o1.setPrice((float) 12.51);
        o1.setQty(2);
        o1.setRestaurantOrders(order);
        OrderMenuItems o2 = new OrderMenuItems();
        o2.setDishName("dishb");
        o2.setSpiceLevel("mild");
        o2.setPrice((float) 6.22);
        o2.setQty(1);
        o2.setRestaurantOrders(order);
        OrderMenuItems o3 = new OrderMenuItems();
        o3.setDishName("dishc");
        o3.setSpiceLevel("medium");
        o3.setPrice((float) 7.31);
        o3.setQty(3);
        o3.setRestaurantOrders(order);
        OrderMenuItems o4 = new OrderMenuItems();
        o4.setDishName("dishf");
        o4.setSpiceLevel("hot");
        o4.setPrice((float) 12.56);
        o4.setQty(1);
        o4.setRestaurantOrders(order);
        List<OrderMenuItems> order1 = new ArrayList<OrderMenuItems>();
        order1.add(o1);
        order1.add(o2);
        order1.add(o3);
        order1.add(o4);
        order.setOrderList(order1);
        order.setOrderStatus("open");
        order.setTime(LocalDateTime.now());
        order.setUser("user1");
        restaurantOrdersJpa.save(order);
        List<RestaurantOrders> ordersList = restaurantOrdersJpa.findAll();
        return ordersList.get(0);
    }

    //    user places new order
    @RequestMapping("user/placeorder")
    public String userPlaceOrder(@RequestBody RestaurantOrders order) {
        RestaurantOrders filledOrder = SetOrderData.setOrderDataForDb(order);
        restaurantOrdersJpa.save(filledOrder);
        return userOrders.userPlaceOrder(order);
    }

    //    user deletes order
    @RequestMapping("user/deleteorder")
    public String userDeleteOrder(@RequestBody String user) {
        return userOrders.userDeleteOrder(user);
    }

    //    user updates order
    @RequestMapping("user/updateorder")
    public ResponseEntity userUpdateOrder(@RequestBody RestaurantOrders order) {
        return userOrders.userUpdateOrder(order);
    }

    //    user sees the order he/she placed
    @RequestMapping("user/getorder")
    public ResponseEntity userGetOrder(@RequestBody String user) {
        return userOrders.userGetOrder(user);
    }
}
