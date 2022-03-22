package com.sj.ShopingCart.daos;

import com.sj.ShopingCart.vos.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    private List<Product> list = new ArrayList<Product>();

    public ArrayList<Product> getProductList() {
        return (ArrayList<Product>) list;
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public String deleteProduct(int id) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                flag = true;
            }
        }
        if (!flag) {
            return "item not found - trying adding it first";
        }
        else {
            list.remove(index);
            return "successfully deleted product";
        }
    }

    public String updateProduct(Product product, int id) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                flag = true;
            }
        }
        if (!flag) {
            return "item not found - trying adding it";
        }
        else {
            list.set(index, product);
            return "successfully updated product";
        }

    }

    public int totalItemsInCart() {
        return list.size();
    }

    public double totalAmountCart() {
        double total = 0;
        for (Product product : list) {
            total = product.getPrice() * product.getQty() + total;
        }
        return Math.round(total * 100.0) / 100.0;
    }

}
