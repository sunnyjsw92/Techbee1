package com.sj.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    public static String[] browserDetails() throws IOException {
        Properties file = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/browser.properties");
        file.load(fileInputStream);
        String[] browserData = new String[3];
        browserData[0] = file.getProperty("browserName");
        browserData[1] = file.getProperty("url1");
        browserData[2] = file.getProperty("url2");
        return browserData;
    }

    public static String searchItem() throws IOException {
        Properties file = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/search.properties");
        file.load(fileInputStream);
        String searchitem = file.getProperty("item");
        return searchitem;
    }

}
