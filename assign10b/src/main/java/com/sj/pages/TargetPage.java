package com.sj.pages;

import com.sj.utils.FileWriteToText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TargetPage {

    WebDriver driver;

    By searchbox = By.id("search");
    By searchbutton = By.xpath("//button[contains(text(),'go')]");

    public TargetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchbox(String item) {
        driver.findElement(searchbox).sendKeys(item);
    }

    public void clickSearch() {
        driver.findElement(searchbutton).click();
    }

    public void getResults() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1"
                        + "]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1"
                        + "]")));
        List<WebElement> searchResult = driver.findElements(By.xpath(
                "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1"
                        + "]/section[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]"));
        List<WebElement> searchResultPrice = driver.findElements(By.xpath(
                "/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1"
                        + "]/section[1]/div[1]/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1"
                        + "]/div[1]/span[1]"));

        FileWriteToText f2 = new FileWriteToText();
        f2.fileWriter("target", searchResult, searchResultPrice);
    }

    public void searchAndResult( String item) throws IOException {
        setSearchbox(item);
        clickSearch();
        getResults();
    }
}

