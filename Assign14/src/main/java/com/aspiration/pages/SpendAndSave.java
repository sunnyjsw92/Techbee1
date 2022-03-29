package com.aspiration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SpendAndSave extends BaseClass {

    static By aspiration;
    static By aspirationPlus;
    static By yearlyPrice;
    static By monthlyPrice;
    static By aONNoCB;
    static By ootATMNoCB;
    static By pApCNoCB;

    public SpendAndSave(WebDriver driver, Properties properties) throws IOException {
        super(driver, properties);
        aspiration = By.xpath(properties.getProperty("aspiration"));
        aspirationPlus = By.xpath(properties.getProperty("aspirationPlus"));
        yearlyPrice = By.xpath(properties.getProperty("yearlyPrice"));
        monthlyPrice = By.xpath(properties.getProperty("monthlyPrice"));
        aONNoCB = By.xpath(properties.getProperty("aONNoCB"));
        ootATMNoCB = By.xpath(properties.getProperty("ootATMNoCB"));
        pApCNoCB = By.xpath(properties.getProperty("pApCNoCB"));
    }

    //    checks if aspiiration and aspiration plus are present
    public boolean aspirationAndPlusArePresent() {
        if (driver.findElement(aspiration).getText().equalsIgnoreCase("Aspiration") && driver.findElement(
                aspirationPlus).getText().equalsIgnoreCase("Aspiration Plus"))
            return true;
        else
            return false;
    }

    //    gets the yearly price from spend and save page
    public String getYearlyPrice() {
        return driver.findElement(yearlyPrice).getText();
    }

    //    gets monthly price from spend and save page
    public String getMonthlyPrice() {
        return driver.findElement(monthlyPrice).getText();
    }

    //    Automatic offsets for the negative climate impact of driving your car with Planet Protection - no
    //    checkbox
    public boolean aONNNoCheckBox() {
        List<WebElement> webElements = driver.findElements(aONNoCB);
        if (webElements.size() > 0)
            return false;
        else
            return true;
    }

    //    One out-of-network ATM reimbursement monthly -no checkbox
    public boolean ootATMNoCheckBox() {
        List<WebElement> webElements = driver.findElements(ootATMNoCB);
        if (webElements.size() > 0)
            return false;
        else
            return true;
    }

    //    Purchase Assurance provides coverage for items that are damaged or stolen within 90 days - no
    //    checkbox
    public boolean pApCNoCheckBox() {
        List<WebElement> webElements = driver.findElements(pApCNoCB);
        if (webElements.size() > 0)
            return false;
        else
            return true;
    }

}
