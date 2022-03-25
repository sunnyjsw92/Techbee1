package com.sj.ShopingCartHibernate.utils;

import com.sj.ShopingCartHibernate.Repositories.ProductJpa;
import com.sj.ShopingCartHibernate.VOs.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//short class for calculation of total amt in shopping cart. It is the sum of all items (unit price *quantity foe ech item)
@Component
public class AmountCalculator {
    @Autowired
    ProductJpa productJpa;

    public String amountCalculator() {
        List<Product> productList = productJpa.findAll();
        double amount = 0;
        for (Product product : productList) {
            amount = amount + (product.getQty() * product.getPrice());
        }
        amount = Math.round(amount * 100) / 100.0;
        String message = "the total amount based on price and quantity of each item is $" + amount;
        return message;
    }

}
