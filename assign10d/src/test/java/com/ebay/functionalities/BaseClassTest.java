package com.ebay.functionalities;

import com.ebay.utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseClassTest {
    private static WebDriver driver;
    private static String url = "https://www.ebay.com/";
    private static String browserName = "firefox";
    private BaseClass baseClass;

    @BeforeTest
    public void initialize() {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        baseClass = new BaseClass(driver);
    }

    @Test
    public void registerTest () throws IOException {
        driver.get(url);
        baseClass.register();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void dailyDealsTest () throws IOException {
        driver.get(url);
        baseClass.dailyDeals();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void brandOutletTest () throws IOException {
        driver.get(url);
        baseClass.brandOutlet();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void helpAndContactTest () throws IOException {
        driver.get(url);
        baseClass.helpAndContact();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void sellTest () throws IOException {
        driver.get(url);
        baseClass.sell();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void watchListTest () throws IOException {
        driver.get(url);
        baseClass.watchList();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void myEbayTest () throws  IOException {
        driver.get(url);
        baseClass.myEbay();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void notificationTest () throws IOException {
        driver.get(url);
        baseClass.notification();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void cartTest () throws IOException {
        driver.get(url);
        baseClass.cart();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void aboutEbayTest () throws IOException {
        driver.get(url);
        baseClass.aboutEbay();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void announcementsTest () throws  IOException {
        driver.get(url);
        baseClass.announcements();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void communityTest () throws IOException {
        driver.get(url);
        baseClass.community();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void sellerCenterTest () throws IOException {
        driver.get(url);
        baseClass.sellerCenter();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void policiesTest () throws IOException {
        driver.get(url);
        baseClass.policies();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void affliliatesTest () throws IOException {
        driver.get(url);
        baseClass.affliliates();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void contactFootTest () throws IOException {
        driver.get(url);
        baseClass.contactFoot();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }
    @Test
    public void siteMapTest () throws IOException {
        driver.get(url);
        baseClass.siteMap();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void signInTest() {
        driver.get(url);
        baseClass.signIn();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
    }

    @AfterTest
    public void closeDriver() {
        BrowserSetup.quitBrowser(driver);
    }

}
