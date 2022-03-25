package com.sj.shoppingCartJpaH2.controllers;

import com.sj.shoppingCartJpaH2.Repositories.ProductJpa;
import com.sj.shoppingCartJpaH2.VOs.Product;
import com.sj.shoppingCartJpaH2.utils.AmountCalculator;
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
public class ShoppingCartJpaH2Controller {

    @Autowired
    ProductJpa productJpa;

    @Autowired
    AmountCalculator calculator;

//    get all products
    @RequestMapping("/getList")
    public List<Product> getProductList() {
        return productJpa.findAll();
    }

//    add product to the cart
    @RequestMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productJpa.save(product);
        return "product added";
    }

//    remove prod from cart
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

//    update product from cart
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

//    get total items (each disntinct item is counted as 1 irrespective of the euanity)
    @RequestMapping("/totalItems")
    public String totalItemsInCart() {
        String message = " the total number of items in the cart are - " + productJpa.findAll().size();
        return message;
    }

//    total charge for the cart - qty*unit price for each item
    @RequestMapping("/totalAmount")
    public String totalAmountInCart() {
        return calculator.amountCalculator();
    }

}
