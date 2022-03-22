package com.ebay.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Products extends BaseClass {

    By acceptOffers = By.xpath("//*[@id=\"s0-62-10-5-3[1]\"]/div[2]/div[1]/div/ul/li[2]/a");
    By auction = By.xpath("//*[@id=\"s0-62-10-5-3[1]\"]/div[2]/div[1]/div/ul/li[3]/a");
    By buyItNow = By.xpath("//*[@id=\"s0-62-10-5-3[1]\"]/div[2]/div[1]/div/ul/li[4]/a");
    By local = By.xpath("(//button[@type='button'])[16]");
    By localDP1 = By.xpath("//*[@id=\"s0-62-10-5-3[1]-56[3]-11-content-menu\"]/li[1]/a/span/span/input");
    By localDP2 = By.xpath("//*[@id=\"s0-62-10-5-3[1]-56[3]-11-content-menu\"]/li[2]/a/span/span/input");
    By priceMin = By.xpath("//*[@id=\"s0-62-10-0-1-2-6-0-6[3]-0-textrange-beginParamValue-textbox\"]");
    By priceMax = By.xpath("//*[@id=\"s0-62-10-0-1-2-6-0-6[3]-0-textrange-endParamValue-textbox\"]");
    By priceEnter = By.xpath("//*[@id=\"s0-62-10-0-1-2-6-0-6[3]-0-textrange\"]/div/div[3]/button");
    By prodClick = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a");
    By prodDesc = By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1");
    By prodPrice = By.xpath("//span[@id='prcIsum']");
    By buyNow = By.xpath("//*[@id=\"binBtn_btn\"]");

    public Products(WebDriver driver) {
        super(driver);
    }

    public void acceptOffers() {
        System.out.println(driver.getCurrentUrl());
        driver.findElement(acceptOffers).click();
    }

    public void auction() {
        driver.findElement(auction).click();
    }

    public void buyItNow() {
        driver.findElement(buyItNow).click();
    }

    public void local(String s) {
        driver.findElement(local).click();
        if (s.toLowerCase().contains("local")) {
            driver.findElement(localDP2).click();
        }
        else
            driver.findElement(localDP1).click();

    }

    public void price(int min, int max) {
        driver.findElement(priceMin).sendKeys(String.valueOf(min));
        driver.findElement(priceMax).sendKeys(String.valueOf(max));
        driver.findElement(priceEnter).click();
    }

    public String prodPrice() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(prodClick).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
        Set<String> handles = driver.getWindowHandles();
        for(String whandle: handles){
            if(!whandle.contains("ebay")){driver.switchTo().window(whandle);
            }
        }
        String price = driver.findElement(prodPrice).getText();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
        driver.switchTo().window(mainWindow);
        return price;
    }

    public void buyNow() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(prodClick).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
        Set<String> handles = driver.getWindowHandles();
        for(String whandle: handles){
            if(!whandle.contains("ebay")){driver.switchTo().window(whandle);
            }
        }
        driver.findElement(buyNow).click();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
        driver.switchTo().window(mainWindow);
    }

    public String productDesc() {
        String mainWindow = driver.getWindowHandle();
        driver.findElement(prodClick).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
        Set<String> handles = driver.getWindowHandles();
        for(String whandle: handles){
            if(!whandle.contains("ebay")){driver.switchTo().window(whandle);
            }
        }
        String desc = driver.findElement(prodDesc).getText();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
        driver.switchTo().window(mainWindow);
        return desc;
    }
}
