package com.sj.utils;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriteToText {

    public static File file;
    public static FileWriter fileWriter;

    public static void fileWriter(String filename, List<WebElement> productTitle, List<WebElement> price)
            throws IOException {
        String path = "output/" + filename + ".txt";
        file = new File(path);
        fileWriter = new FileWriter(file);
        fileWriter.write(System.getProperty("line.separator"));

        for (int i = 0; i < productTitle.size(); i++) {
            fileWriter.write(productTitle.get(i).getText());
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.write(price.get(i).getText());
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.write(System.getProperty("line.separator"));

        }
        fileWriter.close();

    }

}
