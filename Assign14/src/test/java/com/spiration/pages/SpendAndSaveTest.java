package com.spiration.pages;

import com.aspiration.pages.SpendAndSave;
import com.aspiration.utils.BrowserSetup;
import com.aspiration.utils.ReadPropertiesFiles;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SpendAndSaveTest {

    private static WebDriver driver;
    private static String url;
    private static String browserName;
    private static SpendAndSave spendAndSave;
    private static Properties browserProperties;
    private static Properties xpathProperties;

//    initialize spend and save - always go there from homepage
    @BeforeTest
    public void init() throws IOException {
        browserProperties = ReadPropertiesFiles.readPropertiesFile("src/test/resources/Browser" +
                ".properties");
        xpathProperties = ReadPropertiesFiles.readPropertiesFile("src/test/resources/Xpath" +
                ".properties");
        url = browserProperties.getProperty("url");
        browserName = browserProperties.getProperty("browserName");
        driver = BrowserSetup.startBrowser(driver, browserName, url);
        spendAndSave = new SpendAndSave(driver, xpathProperties);
    }

//    Verify that you see 2 card products, Aspiration and Aspiration Plus
    @Test
    public void aspirationAndPlusArePresentTest() throws InterruptedException {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebElement element = driver.findElement(By.xpath(xpathProperties.getProperty("aspiration")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        boolean test = spendAndSave.aspirationAndPlusArePresent();
        Assert.assertTrue(test);
    }

//    Verify that yearly cost for Aspiration Plus is $5.99 per month paid yearly
    @Test
    public void getYearlyPriceTest() {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        String messageString = spendAndSave.getYearlyPrice();
        String[] messageDollar = messageString.split(" ");
        String message = messageDollar[0];
        Assert.assertEquals("$5.99/mo", message);
    }

//    Verify that monthly cost for Aspiration Plus is $7.99 paid monthly
    @Test
    public void getMonthlyPriceTest() {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        String messageString = spendAndSave.getMonthlyPrice();
        String[] messageDollar = messageString.split(" ");
        String message = messageDollar[0];
        Assert.assertEquals("$7.99/mo", message);
    }

//    No checkbox - Automatic offsets for the negative climate impact of driving your car with Planet Protection
    @Test
    public void aONNNoCheckBoxTest() {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        Assert.assertTrue(spendAndSave.aONNNoCheckBox());
    }

//    no checkbox - One out-of-network ATM reimbursement monthly
    @Test
    public void ootATMNoCheckBoxTest() {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        Assert.assertTrue(spendAndSave.ootATMNoCheckBox());
    }

//    no checkbox - Purchase Assurance provides coverage for items that are damaged or stolen within 90 days
    @Test
    public void pApCNoCheckBoxTest() {
        driver.get(url);
        spendAndSave.goTospendAndSave();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathProperties.getProperty(
                "aspiration"))));
        Assert.assertTrue(spendAndSave.pApCNoCheckBox());
    }

    @AfterTest
    public void closeDriver() {
        BrowserSetup.quitBrowser(driver);
    }

}
