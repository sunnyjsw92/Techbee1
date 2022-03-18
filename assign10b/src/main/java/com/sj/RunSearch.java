package com.sj;

import com.sj.pages.EbayPage;
import com.sj.pages.TargetPage;
import com.sj.utils.BrowserSetup;
import com.sj.utils.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RunSearch {

    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        String item = ReadPropertiesFile.searchItem();
        String[] browserDetails = ReadPropertiesFile.browserDetails();
//        Setting up for ebay using browserDetails1 as url
        driver = BrowserSetup.startBrowser(driver, browserDetails[0],browserDetails [1]);
        EbayPage Ebay = new EbayPage(driver);
        Ebay.searchAndResult(item);
        /*Ebay.setSearchbox(item);
        Ebay.clickSearch();
        Ebay.getResults();*/
        BrowserSetup.quitBrowser(driver);

//        Setting up for Target using browserDetails2 as url
        driver = BrowserSetup.startBrowser(driver, browserDetails[0],browserDetails [2]);
        TargetPage Target = new TargetPage(driver);
        Target.searchAndResult(item);
       /* Target.setSearchbox(item);
        Target.clickSearch();
        Target.getResults();*/
        BrowserSetup.quitBrowser(driver);
    }
}
