package com.cbt.tests.Assignment;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class VytrackTestNegative {

    public static void main(String[] args) {

        /*
        • Go to the login page of VyTrack
        • Enter invalid credential (can be any role)
        • Click login button
        • Verify that the system shows error message “Invalid user name or password.”
         */

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://qa1.vytrack.com/user/login");

        WebElement usernameBox = driver.findElement(By.xpath("(//html/body/div/div/div/div/div/form/fieldset/div/div/input)[1]"));

        usernameBox.sendKeys("user24");

        WebElement passwordBox = driver.findElement(By.xpath("//div/*[@placeholder='Password']"));

        passwordBox.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-uppercase.btn-primary.pull-right"));

        loginButton.click();

        WebElement message = driver.findElement(By.xpath("//*[(text()='Invalid user name or password.')]"));

        String invalidMessage = message.getText();

        String actualMessage = invalidMessage;

        String expectedMessage = "Invalid user name or password.";

        verifyEquals(expectedMessage,actualMessage);

        driver.quit();


    }
}
