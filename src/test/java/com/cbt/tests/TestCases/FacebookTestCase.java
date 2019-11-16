package com.cbt.tests.TestCases;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookTestCase {

    public static void main(String[] args) {

        //user should not be able to sign up with any invalid credential

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.navigate().to("https://en-gb.facebook.com/");

        WebElement firstnameBox = driver.findElement(By.xpath("//input[@name='firstname']"));

        firstnameBox.sendKeys("Hacı");

        WebElement surnameBox = driver.findElement(By.xpath("//input[@name='lastname']"));

        surnameBox.sendKeys("Hacıoğlu");

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='reg_email__']"));

        emailBox.sendKeys("email@secret.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

        passwordBox.sendKeys("12345");

        WebElement selectDay = driver.findElement(By.xpath("//select[@id='day']"));

        selectDay.sendKeys("15");

        WebElement selectMont = driver.findElement(By.xpath("//select[@id='month']"));

        selectDay.sendKeys("Nov");

        WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));

        selectDay.sendKeys("1990");

        WebElement selectGender = driver.findElement(By.xpath("(//span/input[@name='sex'])[1]"));

        selectGender.click();

        WebElement signUpButton = driver.findElement(By.xpath("(//button[text()='Sign Up'])[1]"));

        signUpButton.click();

        String actualTitle = driver.getTitle();

        String loginPageTitle = "Facebook - log in or sign up";

        if(!actualTitle.equals(loginPageTitle)){

            System.out.println("Pass");

        }else{

            System.out.println("Fail");
            System.out.println("loginPageTitle = " + loginPageTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.quit();
    }
}
