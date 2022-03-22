package com.ebay.functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearch {

    WebDriver driver;

    By itemsInStore = By.xpath("//a[normalize-space()='Items in stores']");
    By searchIncTitleAndDes = By.xpath("//input[@id='LH_TitleDesc']");
    By searchIncCompleteList = By.xpath("//input[@id='LH_Complete']");
    By searchIncSoldList = By.xpath("//input[@id='LH_Sold']");

    By pricebox = By.xpath("//input[@id='_mPrRngCbx']");
    By priceMinPrice = By.xpath("//input[@title='Enter minimum price range value']");
    By priceMaxPrice = By.xpath("//input[@title='Enter maximum price range value']");

    By buyFormatsAuction = By.xpath("//input[@id='LH_Auction']");
    By buyFormatsBuyNow = By.xpath("//input[@id='LH_BIN']");
    By buyFormatClassifieds = By.xpath("//input[@id='LH_CAds']");

    By conditionNew = By.xpath("//label[normalize-space()='New']");
    By conditionUsed = By.xpath("//input[@id='LH_ItemConditionUsed']");
    By conditionUnspec = By.xpath("//input[@id='LH_ItemConditionNS']");

    By showResultsListingCb = By.xpath("//input[@id='LH_Time']");
    By showResultsListingSelect1 = By.xpath("//*[@id=\"adv_search_from\"]/fieldset[6]/div[1]/select[1]");
    By showResultsListingSelecthr = By.xpath("//*[@id=\"adv_search_from\"]/fieldset[6]/div[1]/select[2]");
    By showResultsListingNoBidsCbx = By.xpath("//input[@id='LH_NOB']");
    By showResultsListingNoBidsCbxMin = By.xpath("//input[@id='_sabdlo']");
    By showResultsListingNoBidsCbxMax = By.xpath("//input[@id='_sabdhi']");
    By showResultsMLCb = By.xpath("//input[@id='LH_MIL']");
    By showResultsMLCbMin = By.xpath("//input[@id='_samilow']");
    By showResultsMLCbMax = By.xpath("//input[@id='_samihi']");
    By showResultsItemLots = By.xpath("//input[@id='LH_Lots']");
    By showResultsSaleItems = By.xpath("//input[@id='LH_SaleItems']");
    By showResultsBestOffer = By.xpath("//input[@id='LH_BO']");
    By showResultsECharity = By.xpath("//input[@id='LH_Charity']");

    By shippingoptionsFree = By.xpath("//input[@id='LH_FS']");
    By shippingoptionsLocal = By.xpath("//input[@id='LH_LPickup']");

    By sortBy = By.xpath("//select[@id='LH_SORT_BY']");

   /* By viewResults = By.xpath("//select[@id='LH_VIEW_RESULTS_AS']");
    By resultsPerPage = By.xpath("//select[@id='LH_IPP']");*/

    By clearOptions = By.xpath("//button[@id='searchBtnLowerLnk']");
    By searchButton = By.xpath("//div[@class='bottom-action-bar']//a[1]");

    public AdvancedSearch (WebDriver driver) {
        this.driver = driver;
    }

    public void itemsInStores () {
        driver.findElement(itemsInStore).click();
    }

    public void searchIncluding (String search) {
        if (search.toLowerCase().contains("title") || search.toLowerCase().contains("descrip")) {
            driver.findElement(searchIncTitleAndDes).click();
        }
        if (search.toLowerCase().contains("comp")) {
            driver.findElement(searchIncCompleteList).click();
        }
        if (search.toLowerCase().contains("sold")) {
            driver.findElement(searchIncSoldList).click();
        }
    }

    public void searchPrice (int min, int max) {
        driver.findElement(pricebox).click();
        driver.findElement(priceMinPrice).sendKeys(String.valueOf(min));
        driver.findElement(priceMaxPrice).sendKeys(String.valueOf(max));
    }

    public void searchBuyFormat (String search) {
        if (search.toLowerCase().contains("auc")) {
            driver.findElement(buyFormatsAuction).click();
        }
        if (search.toLowerCase().contains("buy") || search.toLowerCase().contains("now")) {
            driver.findElement(buyFormatsBuyNow).click();
        }
        if (search.toLowerCase().contains("ad") || search.toLowerCase().contains("class")) {
            driver.findElement(buyFormatClassifieds).click();
        }
    }

    public void searchCondition (String cond) {
        if (cond.toLowerCase().contains("new")) {
            driver.findElement(conditionNew).click();
        }
        if (cond.toLowerCase().contains("used")) {
            driver.findElement(conditionUsed).click();
        }
        else {
            driver.findElement(conditionUnspec).click();
        }
    }

    public void showResults (String results, String listings, int hr, int bidmin, int bidmax, int mlcbmin,
            int mlcbmax) {
        if (results.toLowerCase().contains("listings")) {
            driver.findElement(showResultsListingCb).click();
            Select listchoice = new Select(driver.findElement(showResultsListingSelect1));
            int index = 0;
            String listRes = "";
            if (results.toLowerCase().contains("ending within")) {
                listRes = "Ending within";
            }
            else if (listings.toLowerCase().contains("Ending in")) {
                listRes = "Ending in more than";
            }
            else {
                listRes = "Started within";
            }
            for (WebElement element : listchoice.getOptions()) {
                if (element.getText().equalsIgnoreCase(listRes)) {
                    break;
                }
                index = index + 1;
            }
            listchoice.selectByIndex(index);
            Select hours = new Select(driver.findElement(showResultsListingSelecthr));
            index = 0;
            String s2 = String.valueOf(hr) + " hours";
            for (WebElement element : hours.getOptions()) {
                if (element.getText().toLowerCase().contains(s2)) {
                    break;
                }
                index = index + 1;
            }
            hours.selectByIndex(index);
        }
        if (listings.toLowerCase().contains("bids")) {
            driver.findElement(showResultsListingNoBidsCbx).click();
            driver.findElement(showResultsListingNoBidsCbxMin).sendKeys(String.valueOf(bidmin));
            driver.findElement(showResultsListingNoBidsCbxMax).sendKeys(String.valueOf(bidmax));
        }
        if (results.toLowerCase().contains("multiple")) {
            driver.findElement(showResultsMLCb).click();
            driver.findElement(showResultsMLCbMin).sendKeys(String.valueOf(mlcbmin));
            driver.findElement(showResultsMLCbMax).sendKeys(String.valueOf(mlcbmax));
        }
        if (results.toLowerCase().contains("lots")) {
            driver.findElement(showResultsItemLots).click();
        }
        if (results.toLowerCase().contains("sale")) {
            driver.findElement(showResultsSaleItems).click();
        }
        if (results.toLowerCase().contains("best")) {
            driver.findElement(showResultsBestOffer).click();
        }
        if (results.toLowerCase().contains("charity")) {
            driver.findElement(showResultsECharity).click();
        }

    }

    public void shippingOption( String s) {
        if(s.toLowerCase().contains("free")){
            driver.findElement(shippingoptionsFree).click();
        }
        if(s.toLowerCase().contains("local")) {
            driver.findElement(shippingoptionsLocal).click();
        }
    }

    public void sortBy (String s) {
        Select sort1 = new Select(driver.findElement(sortBy));
        int index = -1;
        s= s.toLowerCase();
        for (WebElement element : sort1.getOptions()) {
            index=index+1;
            if (element.getText().toLowerCase().contains(s)) {
                break;
            }
        }
        sort1.selectByIndex(index);
    }

    public void clearOptions () {
        driver.findElement(clearOptions).click();
    }

    public void searchButton () {
        driver.findElement(searchButton).click();
    }
}
