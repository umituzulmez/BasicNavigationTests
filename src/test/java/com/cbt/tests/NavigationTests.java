package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class NavigationTests {

    public static void main(String[] args) throws InterruptedException {

        chromeTest();
        firefoxTest();
        safariTest();

    }

    public static void chromeTest() throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://google.com");

        String titleGoogle = driver.getTitle();

        String expectedTitleGoogle = titleGoogle;

        Thread.sleep(2000);

        driver.get("https://etsy.com");

        String titleEtsy = driver.getTitle();

        String expectedTitleEtsy = titleEtsy;

        Thread.sleep(2000);

        driver.navigate().back();

        String actualTitleGoogle = driver.getTitle();

        verifyEquals(expectedTitleGoogle,actualTitleGoogle);

        Thread.sleep(2000);

        driver.navigate().forward();

        String actualTitleEtsy = driver.getTitle();

        verifyEquals(expectedTitleEtsy,actualTitleEtsy);

        Thread.sleep(2000);

        driver.quit();

    }


    public static void firefoxTest() throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("https://google.com");

        String titleGoogle = driver.getTitle();

        String expectedTitleGoogle = titleGoogle;

        Thread.sleep(2000);

        driver.get("https://etsy.com");

        String titleEtsy = driver.getTitle();

        String expectedTitleEtsy = titleEtsy;

        Thread.sleep(2000);

        driver.navigate().back();

        String actualTitleGoogle = driver.getTitle();

        verifyEquals(expectedTitleGoogle,actualTitleGoogle);

        Thread.sleep(2000);

        driver.navigate().forward();

        String actualTitleEtsy = driver.getTitle();

        verifyEquals(expectedTitleEtsy,actualTitleEtsy);

        Thread.sleep(2000);

        driver.quit();

    }

    public static void safariTest() throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("safari");

        driver.get("https://google.com");

        String titleGoogle = driver.getTitle();

        String expectedTitleGoogle = titleGoogle;

        Thread.sleep(2000);

        driver.get("https://etsy.com");

        String titleEtsy = driver.getTitle();

        String expectedTitleEtsy = titleEtsy;

        Thread.sleep(2000);

        driver.navigate().back();

        String actualTitleGoogle = driver.getTitle();

        verifyEquals(expectedTitleGoogle,actualTitleGoogle);

        Thread.sleep(2000);

        driver.navigate().forward();

        String actualTitleEtsy = driver.getTitle();

        verifyEquals(expectedTitleEtsy,actualTitleEtsy);

        Thread.sleep(2000);

        driver.quit();

    }
}
