package com.sj.SunnyRestaurant1.vos;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="RestaurantMenu")
public class RestaurantMenuItem {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="dish")
    public String dishName;

    enum spiceLevel {mild, medium, hot}

    @Column(name="SPICE", columnDefinition = "enum('mild', 'medium', 'hot')")
    @Enumerated(EnumType.STRING)
    public spiceLevel spiceLevel;

    @Column(name="Price")
    public float price;

    @Version
    private int ver;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public RestaurantMenuItem.spiceLevel getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(RestaurantMenuItem.spiceLevel spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public RestaurantMenuItem(String dishName,
            RestaurantMenuItem.spiceLevel spiceLevel, float price) {
        this.dishName = dishName;
        this.spiceLevel = spiceLevel;
        this.price = price;
    }

    public RestaurantMenuItem() {
    }

    public RestaurantMenuItem(String dishName,
            RestaurantMenuItem.spiceLevel spiceLevel, float price, int ver) {
        this.dishName = dishName;
        this.spiceLevel = spiceLevel;
        this.price = price;
        this.ver = ver;
    }
}
