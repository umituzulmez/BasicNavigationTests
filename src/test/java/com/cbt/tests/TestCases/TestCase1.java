package com.cbt.tests.TestCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {

    public static void main(String[] args) {

        /**
         * Go to ebay
         * enter search term
         * click on search button
         * print number of results
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        searchBox.sendKeys("search");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));

        searchButton.click();

        WebElement searchResult = driver.findElement(By.className("srp-controls__count-heading"));

        String searchResultText = searchResult.getText();

        System.out.println(searchResultText);

        String[] arr = searchResultText.split(" result");

        String numberText = arr[0];

        numberText = numberText.replace(",","");

        int number = Integer.parseInt(numberText);

        System.out.println("number of search result is " + number);

        driver.quit();

    }
}
