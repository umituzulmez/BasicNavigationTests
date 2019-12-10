package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases_9to12 {

    WebDriver driver;

    @BeforeMethod
    public void driverSetUp(){

        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void driverClose() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase9(){

        /*
        Step 1. Go to “https://practice- cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “200”.
        Step 4. Verify that following message is displayed: “This page returned a 200 status code”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();

        WebElement _200Link = driver.findElement(By.linkText("200"));
        _200Link.click();

        WebElement _200LinkMessage = driver.findElement(By.xpath("//*[contains(text(),'200')]"));
        System.out.println("_200LinkMessage = " + _200LinkMessage.getText());

        String actualMessage = _200LinkMessage.getText();

        Assert.assertTrue(actualMessage.contains("This page returned a 200 status code"),"Verify message contains expected message");

    }

    @Test
    public void testCase10(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “301”.
        Step 4. Verify that following message is displayed: “This page returned a 301 status code”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();

        WebElement _301Link = driver.findElement(By.linkText("301"));
        _301Link.click();

        WebElement _301LinkMessage = driver.findElement(By.xpath("//*[contains(text(),'301')]"));
        System.out.println("_301LinkMessage = " + _301LinkMessage.getText());

        String actualMessage = _301LinkMessage.getText();

        Assert.assertTrue(actualMessage.contains("This page returned a 301 status code"), "Verify message contains expected message");
    }

    @Test
    public void testCase11(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “404”.
        Step 4. Verify that following message is displayed: “This page returned a 404 status code”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();

        WebElement _404Link = driver.findElement(By.linkText("404"));
        _404Link.click();

        WebElement _404LinkMessage = driver.findElement(By.xpath("//*[contains(text(),'404')]"));
        System.out.println("_404LinkMessage = " + _404LinkMessage.getText());

        String actualMessage = _404LinkMessage.getText();

        Assert.assertTrue(actualMessage.contains("This page returned a 404 status code"),"Verify that message contains expected message");
    }

    @Test
    public void testCase12(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “500”.
        Step 4. Verify that following message is displayed: “This page returned a 500 status code”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement statusCodesLink = driver.findElement(By.linkText("Status Codes"));
        statusCodesLink.click();

        WebElement _500Link = driver.findElement(By.linkText("500"));
        _500Link.click();

        WebElement _500LinkMessage = driver.findElement(By.xpath("//*[contains(text(),'500')]"));
        System.out.println("_500LinkMessage = " + _500LinkMessage.getText());

        String actualMessage = _500LinkMessage.getText();

        Assert.assertTrue(actualMessage.contains("This page returned a 500 status code"),"Verify message contains expected message");

    }
}
