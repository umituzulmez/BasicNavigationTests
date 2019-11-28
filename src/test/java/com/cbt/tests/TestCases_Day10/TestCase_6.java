package com.cbt.tests.TestCases_Day10;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_6 {

    /*
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
    Step 9. Navigate back to the “https:// www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from: “do-not- reply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */

    @Test
    public void testCase6() throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.tempmailaddress.com/");

        WebElement emailText = driver.findElement(By.id("email"));
        String email = emailText.getText();
        System.out.println("email = " + email);

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement signUpMailingLink = driver.findElement(By.linkText("Sign Up For Mailing List"));
        signUpMailingLink.click();

        WebElement fullNameBox = driver.findElement(By.cssSelector("[name='full_name']"));
        fullNameBox.sendKeys("Ahmet");

        WebElement emailBox = driver.findElement(By.cssSelector("[name='email']"));
        emailBox.sendKeys(email);

        WebElement signUpButton = driver.findElement(By.cssSelector("[name='wooden_spoon']"));
        signUpButton.click();

        WebElement signUpMessage = driver.findElement(By.cssSelector("[name='signup_message']"));
        System.out.println("sign Up Message = " + signUpMessage.getText());

        Assert.assertTrue(signUpMessage.isDisplayed(),"Verify sign Up message displayed");

        driver.get("https://www.tempmailaddress.com/");

        WebElement mailBox = driver.findElement(By.xpath("/html/body/div/div[5]/div[1]/table/tbody/tr[3]/td[1]/span[2]"));
        mailBox.click(); // cannot click*********

        WebElement checkEmail = driver.findElement(By.id("odesilatel"));
        String gotEmail = checkEmail.getText();
        System.out.println("gotEmail = " + gotEmail);

        Assert.assertEquals(gotEmail,"do-not-reply@practice.cybertekschool.com","Verify I got email from Cybertek");

        Thread.sleep(2000);
        driver.quit();

    }
}
