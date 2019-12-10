package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_8 {

    @Test
    public void testCase8() throws InterruptedException {

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Autocomplete”.
        Step 3. Enter “United States of America” into country input box.
        Step 4. Verify that following message is displayed: “You selected: United States of America”
        */

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement autocompleteLink = driver.findElement(By.linkText("Autocomplete"));
        autocompleteLink.click();

        WebElement countryBox = driver.findElement(By.id("myCountry"));
        countryBox.sendKeys("United States of America");

        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit']"));
        submitButton.click();

        WebElement messageLine = driver.findElement(By.id("result"));
        String actualMessage = messageLine.getText();
        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(actualMessage,"You selected: United States of America", "Verify you got select message correctly");
        
        Thread.sleep(2000);
        driver.quit();

    }



}
