package com.sj.ShopingCartHibernate.controllers;

import com.sj.ShopingCartHibernate.Repositories.ProductJpa;
import com.sj.ShopingCartHibernate.VOs.Product;
import com.sj.ShopingCartHibernate.utils.AmountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//main controller class for different operations
@RestController
@RequestMapping("/sj")
public class ShoppingCartConrollerHibernate {
    @Autowired
    ProductJpa productJpa;

    @Autowired
    AmountCalculator calculator;

//    gets all products from shopping cart
    @RequestMapping("/getList")
    public List<Product> getProductList() {
        return productJpa.findAll();
    }

//    adds a product to the shopping cart
    @RequestMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productJpa.save(product);
        return "product added";
    }

//    removes a product from the shopping cart
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        Optional<Product> opt = Optional.of(productJpa.getById(id));
        if (opt.isPresent()) {
            productJpa.deleteById(id);
            return "successfully deleted product";
        }
        else {
            return "product with that id not found";
        }
    }

//    updates a product in the shopping cart
    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product, @RequestParam int id) {
        Optional<Product> opt = productJpa.findById(id);
        Product product_set = product;
        if (opt.isPresent()) {
            productJpa.save(product);
            return "product updated successfully";
        }
        else {
            return "porduct with that id not found";
        }
    }

//    gets total disntinct items in teh cart - each distinct item is counted as one irrespective of teh quantity
    @RequestMapping("/totalItems")
    public String totalItemsInCart() {
        String message = " the total number of items in the cart are - " + productJpa.findAll().size();
        return message;
    }

//    total charge amount in the shopping cart based on quanity and price of each item
    @RequestMapping("/totalAmount")
    public String totalAmountInCart() {
        return calculator.amountCalculator();
    }

}
