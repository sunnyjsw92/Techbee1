package com.aspiration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    static WebDriver driver;
    static Properties properties;
    static By homepage;
    static By spendAndSave;
    static By getStarted;

    public BaseClass(WebDriver driver, Properties properties) throws IOException {
        this.driver = driver;
        this.properties = properties;
        homepage = By.xpath(properties.getProperty("homepage"));
        spendAndSave = By.xpath(properties.getProperty("spendAndSave"));
        getStarted = By.xpath(properties.getProperty("getStarted"));
    }

    //    goes to the aspiration homepage logo link
    public void goToHomePage() {
        driver.findElement(homepage).click();
    }

    //    goes to spend and save link
    public void goTospendAndSave() {
        driver.findElement(spendAndSave).click();
    }

    //    goes to the get started link -directs to sign-up page check in test
    public void goTogetStarted() {
        driver.findElement(getStarted).click();
    }

}
