package com.cbt.tests.TestCases_Day10;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases_1to5 {

    WebDriver driver;

    @BeforeMethod
    public void driverSetup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void driverClose() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase1() {

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter “wrong_dob” into date of birth input box.
        Step 4. Verify that warning message is displayed: “The date of birth is not valid”
        */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();

        WebElement dateOfBirthBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("wrong_dob");

        WebElement invalidMessage = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        System.out.println("invalidMessage is displayed = " + invalidMessage.isDisplayed());
        Assert.assertTrue(invalidMessage.isDisplayed(),"Verify that invalid message is displayed");

    }

    @Test
    public void testCase2(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();

        List<WebElement> prgLanguages = driver.findElements(By.className("form-check-input"));
        System.out.println("Element number of prgLanguages = " + prgLanguages.size());

        Assert.assertEquals(prgLanguages.size(),3,"Verify we have 3 elements");

        for(WebElement elements : prgLanguages){
            System.out.println(elements.getText()); // why it does not get text of eleemnts?
        }
    }

    @Test
    public void testCase3(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into first name input box.
        Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();

        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("U");

        WebElement warningMessage = driver.findElement(By.xpath("(//small[@data-bv-result='INVALID'])[1]"));

        System.out.println("warningMessage = " + warningMessage.getText());

        Assert.assertTrue(warningMessage.isDisplayed(),"Verify warning message is displayed");
    }

    @Test
    public void testCase4(){

        /*
        Step 1. Go to https://practice-cybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter only one alphabetic character into last name input box.
        Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("U");

        WebElement warningMessage = driver.findElement(By.xpath("(//small[@data-bv-result='INVALID'])[1]")); //better to find anaother way to reach

        System.out.println("warningMessage = " + warningMessage.getText());

        Assert.assertTrue(warningMessage.isDisplayed(),"Verify warning message is displayed");
    }


}
