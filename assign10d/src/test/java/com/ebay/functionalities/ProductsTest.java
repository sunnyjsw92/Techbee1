package com.ebay.functionalities;

import com.ebay.utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductsTest {
    private static WebDriver driver;
    private static String browserName = "firefox";
    private static String url = "https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=laptops&_sacat=0";
    private Products products;

    @Test
    public void acceptOffersTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        driver.get(url);
        products.acceptOffers();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void auctionTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        driver.get(url);
        products.auction();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void buyItNowTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        driver.get(url);
        products.buyItNow();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void localTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        driver.get(url);
        products.local("in-store");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void priceTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        driver.get(url);
        products.price(100,2000);
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void prodPriceTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        String newUrl = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=laptops&_sacat=0&rt=nc&_udlo=10"
                + "&_udhi=2000";
        driver.get(newUrl);
        String test = products.prodPrice();
        Assert.assertTrue(test!=null);
        driver.quit();
    }

    @Test
    public void buyNowTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        String newUrl = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=laptops&_sacat=0&rt=nc&_udlo=10"
                + "&_udhi=2000";
        driver.get(newUrl);
        products.buyNow();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        driver.quit();
    }

    @Test
    public void productDescTest () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        products = new Products(driver);
        String newUrl = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=laptops&_sacat=0&rt=nc&_udlo=10"
                + "&_udhi=2000";
        driver.get(newUrl);
        String test = products.productDesc();
        Assert.assertTrue(test!=null);
        driver.quit();
    }
}
