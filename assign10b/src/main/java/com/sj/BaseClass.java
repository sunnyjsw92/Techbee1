package com.sj;

import com.sj.utils.BrowserSetup;
import com.sj.utils.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseClass {
    public WebDriver driver;

    public void setup () throws IOException {
        String [] browserDetails = ReadPropertiesFile.browserDetails();
        String browserName = browserDetails [0];
        String url1 = browserDetails [1];
        driver = BrowserSetup.startBrowser(driver,browserName,url1);
    }
    public void afterTest () {
        BrowserSetup.quitBrowser(driver);
    }


}
