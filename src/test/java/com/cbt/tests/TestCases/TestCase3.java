package com.cbt.tests.TestCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class TestCase3 {

    public static void main(String[] args) {

        /*
            Go to wikipedia.org (Links to an external site.)
            enter search term `selenium webdriver`
            click on search button
            click on search result `Selenium (software)`
            verify url ends with `Selenium_(software)'
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.wikipedia.org/");

        WebElement searchBox = driver.findElement(By.id("searchInput"));

        searchBox.sendKeys("selenium webdriver");

        WebElement searchButton = driver.findElement(By.xpath("//*[@class='pure-button pure-button-primary-progressive']"));

        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//*[@title='Selenium (software)']"));

        searchResult.click();

        String actualUrl = driver.getCurrentUrl();

        Boolean urlEndWith = actualUrl.endsWith("Selenium_(software)");

       if(urlEndWith){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
           System.out.println("actualUrl = " + actualUrl);
           System.out.println("urlEndWith = " + urlEndWith);
       }

       driver.quit();

    }
}
