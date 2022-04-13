package vos;

import utilities.MakePojoFromProperties;

public class MenuItems {

    public String dishName;

    public static enum spiceLevel {mild, medium, hot}

    public static spiceLevel spiceLevel;

    public float price;

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MenuItems() {
    }

    public MenuItems.spiceLevel getSpiceLevel() {
        return spiceLevel;
    }

    public void setSpiceLevel(MenuItems.spiceLevel spiceLevel) {
        this.spiceLevel = spiceLevel;
    }

    public MenuItems(String dishName, MenuItems.spiceLevel spiceLevel, float price) {
        this.dishName = dishName;
        this.spiceLevel = spiceLevel;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItems{" +
                "dishName='" + dishName + '\'' +
                ", spiceLevel=" + spiceLevel +
                ", price=" + price +
                '}';
    }
}
