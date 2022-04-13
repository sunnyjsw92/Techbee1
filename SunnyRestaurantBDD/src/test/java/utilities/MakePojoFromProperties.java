package utilities;

import io.cucumber.java.bs.A;
import vos.MenuItems;
import vos.OrderMenuItem;
import vos.RestaurantOrder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MakePojoFromProperties {

     public MenuItems setMenuItems () throws IOException {
          MenuItems menuItems = new MenuItems();
          Properties properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties"
                  + "/AddMenu.properties");
          menuItems.setDishName(properties.getProperty("dishName"));
          float price = Float.parseFloat(properties.getProperty("price"));
          menuItems.setPrice(price);
          MenuItems.spiceLevel spicy = MenuItems.spiceLevel.valueOf(properties.getProperty("spiceLevel"));
          menuItems.setSpiceLevel(spicy);
          return menuItems;
     }

     public MenuItems updateMenuItems () throws IOException {
          MenuItems menuItems = new MenuItems();
          Properties properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties"
                  + "/UpdateMenu.properties");
          menuItems.setDishName(properties.getProperty("dishName"));
          float price = Float.parseFloat(properties.getProperty("price"));
          menuItems.setPrice(price);
          MenuItems.spiceLevel spicy = MenuItems.spiceLevel.valueOf(properties.getProperty("spiceLevel"));
          menuItems.setSpiceLevel(spicy);
          return menuItems;
     }

     public RestaurantOrder makeOrderItem () throws IOException {
          Properties properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties"
                  + "/UserPlaceOrder.properties");
          String[] dishName = properties.getProperty("dishName").split(",");
          String[] spiceLevel = properties.getProperty("spiceLevel").split(",");
          String[] price = properties.getProperty("price").split(",");
          String[] qty = properties.getProperty("qty").split(",");
          int size = price.length;
          Float[] aprice = new Float[size];
          Integer[] aqty = new Integer[size];
          for(int i=0; i<size;i++){
               aprice[i]=Float.parseFloat(price[i]);
               aqty[i]=Integer.valueOf(qty[i]);
          }
          List<OrderMenuItem> itemList = new ArrayList<>();
          for(int j=0; j< size; j++) {
               OrderMenuItem orderMenuItem = new OrderMenuItem();
               orderMenuItem.setDishName(dishName[j]);
               orderMenuItem.setPrice(aprice[j]);
               orderMenuItem.setSpiceLevel(spiceLevel[j]);
               orderMenuItem.setQty(aqty[j]);
               itemList.add(orderMenuItem);
          }
          RestaurantOrder restaurantOrder = new RestaurantOrder();
          restaurantOrder.setOrderList(itemList);
          restaurantOrder.setOrderStatus("open");
          restaurantOrder.setUser(properties.getProperty("user"));

          return restaurantOrder;
     }

     public RestaurantOrder updateOrderItem () throws IOException {
          Properties properties = ReadPropertiesFile.readPropertiesFile("src/test/resources/Properties"
                  + "/UserUpdateOrder.properties");
          String[] dishName = properties.getProperty("dishName").split(",");
          String[] spiceLevel = properties.getProperty("spiceLevel").split(",");
          String[] price = properties.getProperty("price").split(",");
          String[] qty = properties.getProperty("qty").split(",");
          int size = price.length;
          Float[] aprice = new Float[size];
          Integer[] aqty = new Integer[size];
          for(int i=0; i<size;i++){
               aprice[i]=Float.parseFloat(price[i]);
               aqty[i]=Integer.valueOf(qty[i]);
          }
          List<OrderMenuItem> itemList = new ArrayList<>();
          for(int j=0; j< size; j++) {
               OrderMenuItem orderMenuItem = new OrderMenuItem();
               orderMenuItem.setDishName(dishName[j]);
               orderMenuItem.setPrice(aprice[j]);
               orderMenuItem.setSpiceLevel(spiceLevel[j]);
               orderMenuItem.setQty(aqty[j]);
               itemList.add(orderMenuItem);
          }
          RestaurantOrder restaurantOrder = new RestaurantOrder();
          restaurantOrder.setOrderList(itemList);
          restaurantOrder.setOrderStatus("open");
          restaurantOrder.setUser(properties.getProperty("user"));

          return restaurantOrder;
     }

}
