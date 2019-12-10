package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
      //  driver.quit();
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

        List<WebElement> prgLanguages = driver.findElements(By.cssSelector(".form-check.form-check-inline"));
        System.out.println("Element number of prgLanguages = " + prgLanguages.size());

        Assert.assertEquals(prgLanguages.size(),3,"Verify we have 3 elements");

        for(WebElement elements : prgLanguages){
            System.out.println(elements.getText());
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

    @Test
    public void testCase5(){

        /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. Click on “Registration Form”
        Step 3. Enter any valid first name
        Step 4. Enter any valid last name
        Step 5. Enter any valid user name
        Step 6. Enter any valid email adress
        Step 7. Enter any valid password
        Step 8. Enter any valid phone number
        Step 9. Select gender.
        Step 10. Enter any valid date of birth
        Step 11. Select any department.
        Step 12. Enter any job title.
        Step 13. Select java as a programming language.
        Step 14. Click Sign up.
        Step 15. Verify that following success message is displayed: “You've successfully completed registration!”
         */

        driver.get("https://practice-cybertekschool.herokuapp.com");

        WebElement registrationFormLink = driver.findElement(By.linkText("Registration Form"));
        registrationFormLink.click();

        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("Ahmet");

        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("Mesut");

        WebElement userNameBox = driver.findElement(By.xpath("//input[@name='username']"));
        userNameBox.sendKeys("ahmetmesut");

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("email@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("12345678");

        WebElement phoneBox = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneBox.sendKeys("571-000-0000");

        WebElement maleGenderRadio = driver.findElement(By.xpath("//input[@value='male']"));
        maleGenderRadio.click();

        WebElement dateOfBirthBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("12/26/2000");

        WebElement departmentBox = driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentSelectList = new Select(departmentBox);
        departmentSelectList.selectByVisibleText("Department of Engineering");

        WebElement jobTitleBox = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobTitleList = new Select(jobTitleBox);
        jobTitleList.selectByVisibleText("SDET");

        WebElement prgLangCheckBox = driver.findElement(By.xpath("//input[@value='java']"));
        prgLangCheckBox.click();

        WebElement signInButton = driver.findElement(By.cssSelector("#wooden_spoon"));
        signInButton.click();

        WebElement registrationMessage = driver.findElement(By.xpath("//p[contains(text(),'registration!')]"));

        String actualMessage = registrationMessage.getText();

        System.out.println("actualMessage = " + actualMessage);

        Assert.assertEquals(actualMessage,"You've successfully completed registration!","Verify registration message");

    }

}
