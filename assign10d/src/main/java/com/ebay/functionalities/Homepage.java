package com.ebay.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Homepage {

    WebDriver driver;


    By home = By.xpath("//li[@class='hl-cat-nav__active']");
    By saved = By.xpath("//a[normalize-space()='Saved']");
    By motors = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[3"
                    + "]/a[1]");
    By electronics = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[4"
                    + "]/a[1]");
    By collectiblesAndArt =
            By.xpath("//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Collectibles & Art')]");
    By homeAndGarden = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[6"
                    + "]/a[1]");
    By clothingAndAccess =
            By.xpath("//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Clothing & Accessories')]");
    By toys = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[8"
                    + "]/a[1]");
    By sportingGoods = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li[9"
                    + "]/a[1]");
    By busAndInd = By.xpath("//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Business & Industrial')]");
    By jewAndWatch = By.xpath("//li[@class='hl-cat-nav__js-tab']//a[contains(text(),'Jewelry & Watches')]");
    By ebayRefurb = By.xpath(
            "//body/div[@id='mainContent']/div[@class='hl-cat-nav']/ul[@class='hl-cat-nav__container']/li"
                    + "[12]/a[1]");
    By todaysDeal = By.xpath("//a[contains(text(),\"Today's Deals – All With Free Shipping\")]");
    By search = By.xpath("//input[@id='gh-btn']");
    //    By searchCategory = By.xpath("//select[@id='gh-cat']");
    By searchCategory = By.xpath("//button[@id='gh-shop-a']");
    By subCategory = By.xpath("/html/body/header/table/tbody/tr/td[4]/div/div/table/tbody/tr/td/ul/li/a");
    By advSearch = By.xpath("//a[@id='gh-as-a']");
    By searchbox = By.xpath("//input[@id='gh-ac']");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void todaysDeal() {
        driver.findElement(todaysDeal).click();
    }

    public void search(String keywords) {
        driver.findElement(searchbox).sendKeys(keywords);
        driver.findElement(search).click();
    }

    public void searchCategory(String category) {
        driver.findElement(searchCategory).click();
//        driver.findElement(By.xpath("//*[contains(text(),'"+category+"')]")).click();
        List<WebElement> subCategories = driver.findElements(subCategory);
        for (WebElement element : subCategories) {
            if (element.getText().toLowerCase().contains(category.toLowerCase())) {
                element.click();
                return;
            }
        }
        driver.findElement(searchCategory).click();
/*        Select chosenCategory = new Select(driver.findElement(searchCategory));
        int index = 0;
        for (WebElement element : chosenCategory.getOptions()) {
            if (element.getText().equalsIgnoreCase(category)) {
                break;
            }
            index = index + 1;
        }
        chosenCategory.selectByIndex(index);*/
    }

    public void advSearch() {
        driver.findElement(advSearch).click();
    }

    public void home() {
        driver.findElement(home).click();
    }

    public void saved() {
        driver.findElement(saved).click();
    }

    public void motors() {
        driver.findElement(motors).click();
    }

    public void expandMotors() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(motors)).build().perform();

    }

    public void electronics() {
        driver.findElement(electronics).click();
    }

    public void expandElectronics() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(electronics)).build().perform();
    }

    public void collectiblesAndArt() {
        driver.findElement(collectiblesAndArt).click();
    }

    public void collectiblesAndArtExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(collectiblesAndArt)).build().perform();
    }

    public void homeAndGarden() {
        driver.findElement(homeAndGarden).click();
    }

    public void homeAndGardenExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(homeAndGarden)).build().perform();
    }

    public void clothingAndAccess() {
        driver.findElement(clothingAndAccess).click();
    }

    public void clothingAndAccessExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(clothingAndAccess)).build().perform();
    }

    public void toys() {
        driver.findElement(toys).click();
    }

    public void toysExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(toys)).build().perform();
    }

    public void sportingGoods() {
        driver.findElement(sportingGoods).click();
    }

    public void sportingGoodsExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(sportingGoods)).build().perform();
    }

    public void busAndInd() {
        driver.findElement(busAndInd).click();
    }

    public void busAndIndExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(busAndInd)).build().perform();
    }

    public void jewAndWatch() {
        driver.findElement(jewAndWatch).click();
    }

    public void jewelAndWatchExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(jewAndWatch)).build().perform();
    }

    public void ebayRefurb() {
        driver.findElement(ebayRefurb).click();
    }

    public void ebayRefurbExpand() {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(ebayRefurb)).build().perform();
    }

}
