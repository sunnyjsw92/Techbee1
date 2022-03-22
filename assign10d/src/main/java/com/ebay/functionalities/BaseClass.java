package com.ebay.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BaseClass {

    WebDriver driver;

    By signIn = By.xpath("//span[@id='gh-ug']//a[contains(text(),'Sign in')]");
    By register = By.xpath("//a[normalize-space()='register']");
    By dailyDeals = By.xpath("//a[normalize-space()='Daily Deals']");
    By brandOutlet = By.xpath("//a[normalize-space()='Brand Outlet']");
    By helpAndContact = By.xpath("//a[@class='gh-p'][normalize-space()='Help & Contact']");
    By sell  = By.xpath("//a[@class='gh-p'][normalize-space()='Sell']");
    By watchList = By.xpath("//a[@title='Watchlist']");
    By myEbay = By.xpath("//li[@id='gh-eb-My']");
    By notification = By.xpath("//i[@id='gh-Alerts-i']");
    By cart = By.xpath("//a[@aria-label='Your shopping cart']");
    By aboutEbay  = By.xpath("//a[@class='gf-bttl thrd'][normalize-space()='About eBay']");
    By announcements = By.xpath("//a[@class='thrd'][normalize-space()='Announcements']");
    By community = By.xpath("//a[@class='gf-bttl thrd'][normalize-space()='Community']");
    By sellerCenter = By.xpath("//a[@class='thrd'][normalize-space()='Seller Center']");
    By policies = By.xpath("//a[@class='thrd'][normalize-space()='Policies']");
    By affliliates = By.xpath("//a[@class='thrd'][normalize-space()='Affiliates']");
    By contactFoot = By.xpath("//a[normalize-space()='Contact Us']");
    By siteMap = By.xpath("//tbody/tr/td[2]/ul[1]/li[9]");

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn() {
        driver.findElement(signIn).click();

    }

    public void register () {
        driver.findElement(register).click();
    }

    public void dailyDeals () {
        driver.findElement(dailyDeals).click();
    }

    public void brandOutlet () {
        driver.findElement(brandOutlet).click();
    }

    public void helpAndContact () {
        driver.findElement(helpAndContact).click();
    }

    public void sell () {
        driver.findElement(sell).click();
    }

    public void watchList () {
        driver.findElement(watchList).click();
    }

    public void myEbay () {
        driver.findElement(myEbay).click();
    }

    public void notification () {
        driver.findElement(notification).click();
    }

    public void cart () {
        driver.findElement(cart).click();

    }

    public void aboutEbay () {
        driver.findElement(aboutEbay).click();
    }

    public void announcements () {
        driver.findElement(announcements).click();
    }

    public void community () {
        driver.findElement(community).click();
    }

    public void sellerCenter () {
        driver.findElement(sellerCenter).click();
    }

    public void policies () {
        driver.findElement(policies).click();
    }

    public void affliliates () {
        driver.findElement(affliliates).click();
    }

    public void contactFoot () {
        driver.findElement(contactFoot).click();
    }

    public void siteMap() {
        driver.findElement(siteMap).click();
    }

}
