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

public class HomePageTest {

    private static WebDriver driver;
    private static String url = "https://www.ebay.com/";
    private static String browserName = "firefox";
    private Homepage homepage;

    @BeforeTest
    public void initialize() {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        homepage = new Homepage(driver);
    }

    @Test
    public void todaysDealTest() throws IOException {
        driver.get(url);
        HttpURLConnection huc = null;
        homepage.todaysDeal();
        String url1 = driver.getCurrentUrl();
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void searchTest() throws IOException {
        driver.get(url);
        String keyword = "search";
        homepage.search(keyword);
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void searchCategoryTest() throws IOException {
        driver.get(url);
        String category = "measurement";
        homepage.searchCategory(category);
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(!url.equals(url1));
    }

    @Test
    public void advSearchTest() throws IOException {
        driver.get(url);
        homepage.advSearch();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void homeTest() throws IOException {
        driver.get(url);
        homepage.home();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);

    }

    @Test
    public void savedTest() throws IOException {
        driver.get(url);
        homepage.saved();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void motorsTest() throws IOException {
        driver.get(url);
        homepage.motors();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void expandMotorsTest() throws IOException {
        driver.get(url);
        homepage.expandMotors();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void electronicsTest() throws IOException {
        driver.get(url);
        homepage.electronics();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void expandElectronicsTest() throws IOException {
        driver.get(url);
        homepage.expandElectronics();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void collectiblesAndArtTest() throws IOException {
        driver.get(url);
        homepage.collectiblesAndArt();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void collectiblesAndArtExpandTest() throws IOException {
        driver.get(url);
        homepage.collectiblesAndArtExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

    }

    @Test
    public void homeAndGardenTest() throws IOException {
        driver.get(url);
        homepage.homeAndGarden();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void homeAndGardenExpandTest() throws IOException {
        driver.get(url);
        homepage.homeAndGardenExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void clothingAndAccessTest() throws IOException {
        driver.get(url);
        homepage.clothingAndAccess();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void clothingAndAccessExpandTest() throws IOException {
        driver.get(url);
        homepage.clothingAndAccessExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void toysTest() throws IOException {
        driver.get(url);
        homepage.toys();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void toysExpandTest() throws IOException {
        driver.get(url);
        homepage.toysExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void sportingGoodsTest() throws IOException {
        driver.get(url);
        homepage.sportingGoods();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void sportingGoodsExpandTest() throws IOException {
        driver.get(url);
        homepage.sportingGoodsExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void busAndIndTest() throws IOException {
        driver.get(url);
        homepage.busAndInd();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void busAndIndExpandTest() throws IOException {
        driver.get(url);
        homepage.busAndIndExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void jewAndWatchTest() throws IOException {
        driver.get(url);
        homepage.jewAndWatch();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void jewAndWatchExpandTest() throws IOException {
        driver.get(url);
        homepage.jewelAndWatchExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void ebayRefurbTest() throws IOException {
        driver.get(url);
        homepage.ebayRefurb();
        String url1 = driver.getCurrentUrl();
        HttpURLConnection huc = null;
        huc = (HttpURLConnection) new URL(url1).openConnection();
        huc.setRequestMethod("HEAD");
        huc.connect();
        int responseCode = huc.getResponseCode();
        Assert.assertTrue(responseCode < 400);
    }

    @Test
    public void ebayRefurbExpandTest() throws IOException {
        driver.get(url);
        homepage.ebayRefurbExpand();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @AfterTest
    public void closeDriver() {
        BrowserSetup.quitBrowser(driver);
    }


}
