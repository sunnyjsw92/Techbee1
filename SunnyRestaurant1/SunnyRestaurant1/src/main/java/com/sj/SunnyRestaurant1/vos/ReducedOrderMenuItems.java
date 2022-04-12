package com.sj.SunnyRestaurant1.vos;

import org.springframework.stereotype.Component;

@Component
public class ReducedOrderMenuItems {

    public String dishName;

    public String spiceLevel;

    public float price;

    public int qty;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(String spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public ReducedOrderMenuItems() {
    }

}
