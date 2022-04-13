package vos;

import java.time.LocalDateTime;
import java.util.List;

public class RestaurantOrder {

    public String orderStatus;
    public List<OrderMenuItem> orderList;
    public LocalDateTime time;
    public String user;

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderMenuItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderMenuItem> orderList) {
        this.orderList = orderList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public RestaurantOrder() {
    }

    public RestaurantOrder(String orderStatus, List<OrderMenuItem> orderList, LocalDateTime time,
            String user) {
        this.orderStatus = orderStatus;
        this.orderList = orderList;
        this.time = time;
        this.user = user;
    }
}
