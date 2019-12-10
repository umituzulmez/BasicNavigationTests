package com.cbt.tests.TestCases_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase_7 {

        @Test
        public void testCase() throws InterruptedException {

            /*
            Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
            Step 2. And click on “File Upload".
            Step 3. Upload any file with .txt extension from your computer.
            Step 4. Click “Upload” button.
            Step 5. Verify that subject is: “File Uploaded!” Step 6. Verify that uploaded file name is displayed.
            */

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.manage().window().maximize();

            driver.get("https://practice-cybertekschool.herokuapp.com");

            WebElement fileUploadLink = driver.findElement(By.linkText("File Upload"));
            fileUploadLink.click();

            WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
            chooseFileButton.sendKeys("/Users/o/Desktop/file.txt");

            WebElement uploadButton = driver.findElement(By.id("file-submit"));
            uploadButton.click();


            Thread.sleep(2000);
            driver.quit();

        }



}
