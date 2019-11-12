package com.cbt.tests.TestCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class TestCase2 {

    public static void main(String[] args) {

        /*
        go to amazon
        Go to ebay
        enter search term
        click on search button
        verify title contains search term
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.name("_nkw"));

        searchBox.sendKeys("iphone");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));

        searchButton.click();

        String actualTitle = driver.getTitle();

        System.out.println(actualTitle);

        String expectedTitle = "iphone | eBay";

        verifyEquals(actualTitle,expectedTitle);

        driver.quit();

    }
}
