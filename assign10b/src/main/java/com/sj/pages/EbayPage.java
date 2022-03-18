package com.sj.pages;

import com.sj.utils.FileWriteToText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class EbayPage {

    static WebDriver driver;

    By searchbox = By.id("gh-ac");
    By searchbutton = By.id("gh-btn");

    public EbayPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchbox(String item) {
        driver.findElement(searchbox).sendKeys(item);
    }

    public void clickSearch() {
        driver.findElement(searchbutton).click();
    }

    public void getResults() throws IOException {
        List<WebElement> searchResult =
                driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li" + "/div/div[2]/a/h3"));
        List<WebElement> searchResultPrice = driver.findElements(
                By.xpath("//*[@id=\"srp-river-results" + "\"]/ul/li/div[1]/div[2]/div/div[1]/span[1]"));
        FileWriteToText f1 = new FileWriteToText();
        f1.fileWriter("ebay", searchResult, searchResultPrice);
    }

    public void searchAndResult( String item) throws IOException {
        setSearchbox(item);
        clickSearch();
        getResults();
    }
}
