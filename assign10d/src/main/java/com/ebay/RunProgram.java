package com.ebay;

import com.ebay.functionalities.AdvancedSearch;
import com.ebay.functionalities.BaseClass;
import com.ebay.functionalities.Homepage;
import com.ebay.functionalities.Products;
import com.ebay.utils.BrowserSetup;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RunProgram {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.ebay.com/";
        driver = BrowserSetup.startBrowser(driver, "firefox",url);
        Homepage homepage = new Homepage(driver);
        homepage.search("laptops");
        Products products = new Products(driver);
        products.price(10,2000);
        Thread.sleep(5000);
//        System.out.println("product price is "+products.prodPrice());
        System.out.println("product is "+products.productDesc());
        BrowserSetup.quitBrowser(driver);
    }

}
