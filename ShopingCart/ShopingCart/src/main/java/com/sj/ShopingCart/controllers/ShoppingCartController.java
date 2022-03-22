package com.sj.ShopingCart.controllers;

import com.sj.ShopingCart.daos.ProductDAO;
import com.sj.ShopingCart.vos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sj")
public class ShoppingCartController {

    @Autowired private ProductDAO productDAO;

    @RequestMapping("/getList")
    public List<Product> getProductList() {
        return productDAO.getProductList();
    }

    @RequestMapping("/addProduct")
    public String addProduct(@RequestBody Product product) {
        productDAO.addProduct(product);
        return "product added";
    }

    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        return productDAO.deleteProduct(id);
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestBody Product product, @RequestParam int id) {
        System.out.println("the id is " + id);
        return productDAO.updateProduct(product, id);
    }

    @RequestMapping("/totalItems")
    public int totalItemsInCart() {
        return productDAO.totalItemsInCart();
    }

    @RequestMapping("/totalAmount")
    public double totalAmountInCart() {
        return productDAO.totalAmountCart();
    }

}
