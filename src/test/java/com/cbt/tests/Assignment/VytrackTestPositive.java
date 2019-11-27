package com.cbt.tests.Assignment;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class VytrackTestPositive {

    public static void main(String[] args) {

        /*
        • Go to the login page of VyTrack
        • Enter valid credential (can be any role)
        • Click login button
        • Verify that the user login successfully
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = driver.findElement(By.xpath("//*[@id='prependedInput']"));

        usernameBox.sendKeys("user24");

        WebElement passwordBox = driver.findElement(By.cssSelector("#prependedInput2"));

        passwordBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[(text()='Log in')]"));

        loginButton.click();

        String expectedTitle = "Dashboard";

        String actualTitle = driver.getTitle();

        verifyEquals(expectedTitle,actualTitle);

        driver.quit();

    }

}
