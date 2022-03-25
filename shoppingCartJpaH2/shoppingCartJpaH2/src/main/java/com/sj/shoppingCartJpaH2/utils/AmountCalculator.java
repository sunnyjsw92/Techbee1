package com.sj.shoppingCartJpaH2.utils;

import com.sj.shoppingCartJpaH2.Repositories.ProductJpa;
import com.sj.shoppingCartJpaH2.VOs.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//short method to calculate the total amount in the cart
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
