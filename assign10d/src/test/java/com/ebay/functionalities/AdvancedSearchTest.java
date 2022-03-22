package com.ebay.functionalities;

import com.ebay.utils.BrowserSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdvancedSearchTest {

    private static WebDriver driver;
    private static String url = "https://www.ebay.com/sch/ebayadvsearch";
    private static String browserName = "firefox";
    private AdvancedSearch advancedSearch;

    @BeforeTest
    public void initialize () {
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        advancedSearch = new AdvancedSearch(driver);
    }

    @Test
    public void itemsInStoresTest () {
        driver.get(url);
        advancedSearch.itemsInStores();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
    }

    @Test
    public void searchIncludingTest () {
        driver.get(url);
        advancedSearch.searchIncluding("title");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
        driver.get(url);
        advancedSearch.searchIncluding("completed");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
        driver.get(url);
        advancedSearch.searchIncluding("sold");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void searchPriceTest () {
        driver.get(url);
        advancedSearch.searchPrice(10,1300);
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void searchBuyFormatTest () {
        driver.get(url);
        advancedSearch.searchBuyFormat("auc");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.searchBuyFormat("buy");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.searchBuyFormat("ad");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void seachConditionTest () {
        driver.get(url);
        advancedSearch.searchCondition("new");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.searchCondition("used");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.searchCondition("");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void showResultsTest () {
        driver.get(url);
        advancedSearch.showResults("listings", "ending in", 2, 10, 20, 1,10);
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.showResults("listings", "started", 2, 10, 20, 1,10);
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.showResults("listings", "ending within", 2, 10, 20, 1,10);
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void shippingOptionTest () {
        driver.get(url);
        advancedSearch.shippingOption("free");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));

        driver.get(url);
        advancedSearch.shippingOption("local");
        url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void sortByTest () {
        driver.get(url);
        advancedSearch.sortBy("newly");
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url1));
    }

    @Test
    public void clearOptionsTest () {
        driver.get(url);
        advancedSearch.clearOptions();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
    }

    @Test
    public void searchButtonTest () {
        driver.get(url);
        advancedSearch.searchButton();
        String url1 = driver.getCurrentUrl();
        Assert.assertTrue(!url.equals(url1));
    }

    @AfterTest
    public void closeDriver() {
        BrowserSetup.quitBrowser(driver);
    }

}
