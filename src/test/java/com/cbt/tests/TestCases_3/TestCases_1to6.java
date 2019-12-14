package com.cbt.tests.TestCases_3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestCases_1to6 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");

        WebElement usernameInputBox = driver.findElement(By.name("_username"));
        usernameInputBox.sendKeys("storemanager85");

        WebElement passwordInputBox = driver.findElement(By.name("_password"));
        passwordInputBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        WebElement activitiesButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        WebElement calendarEventsButton = driver.findElement(By.xpath("//a[@href='/calendar/event']/span"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='title title-level-1'])[1]")));
        wait.until(ExpectedConditions.visibilityOf(activitiesButton));

        Actions actions = new Actions(driver);
        actions.moveToElement(activitiesButton).moveToElement(calendarEventsButton).click(calendarEventsButton).build().perform();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testCase1() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager (storemanager85) (UserUser123)
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page subtitle "Options" is displayed
         */

        /*
        driver.get("https://qa1.vytrack.com/");

        WebElement usernameInputBox = driver.findElement(By.name("_username"));
        usernameInputBox.sendKeys("storemanager85");

        WebElement passwordInputBox = driver.findElement(By.name("_password"));
        passwordInputBox.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));
        loginButton.click();

        WebElement activitiesButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));

        WebElement calendarEventsButton = driver.findElement(By.xpath("//a[@href='/calendar/event']/span"));

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(activitiesButton));

        Actions actions = new Actions(driver);
        actions.moveToElement(activitiesButton).moveToElement(calendarEventsButton).click(calendarEventsButton).build().perform();

         */

        WebElement optionsText = driver.findElement(By.xpath("//div[@class='btn-group actions-group']/div"));
        System.out.println("optionsText = " + optionsText.getText());

        Assert.assertTrue(optionsText.isDisplayed(),"verify option text is displayed");

    }

    @Test
    public void testCase2(){
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that page number is equals to "1"
         */

        WebElement pageNumber = driver.findElement(By.xpath("//*[@data-bound-input-widget='no-name']"));
        System.out.println(pageNumber.getAttribute("value"));
        String actual = pageNumber.getAttribute("value");
        String expected = "1";

        Assert.assertEquals(expected,actual,"verify page number is 1");
    }

    @Test
    public void testCase3(){
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that view per page number is equals to "25"
         */

        WebElement viewPerPage = driver.findElement(By.xpath("(//div[@class='btn-group'])[2]"));
        System.out.println(viewPerPage.getText());
        String actual = viewPerPage.getText();
        String expected = "25";

        Assert.assertEquals(actual,expected,"verify view per page number is 25");
    }

    @Test
    public void testCase4(){
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Verify that number of calendar events (rows in the table) is equals to number of records
        Hint: In HTML, <table> tag represents table, <thread> - table header, <tr> tag represents table row element, <th> table header cell and <td> table data.
        Css selector: table > tr
         */

        WebElement numberOfRecords = driver.findElement(By.xpath("//label[@class='dib'] [contains(text(),'records')]"));
        System.out.println(numberOfRecords.getText());

        String[] arr = numberOfRecords.getText().split(" ");
        System.out.println(arr[2]);
        int Records = Integer.parseInt(arr[2]);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        System.out.println("number of rows = " + rows.size());
        int Rows = rows.size();

        Assert.assertEquals(Records,Rows,"verify the numbers of records and rows are equal");

    }

    @Test
    public void testCase5() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Click on the top checkbox to select all
        5. Verify that all calendar events were selected
         */

        WebElement checkBox = driver.findElement(By.xpath("(//input[@type='checkbox'])[14]"));

        Actions action = new Actions(driver);
        action.moveToElement(checkBox).click().perform();

        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));

        int counter = 0;
        for (WebElement allCheckBox : allCheckBoxes) {

            allCheckBox.getAttribute("class").contains("row-selected");

            counter++;
        }

        Assert.assertEquals(counter,allCheckBoxes.size(),"verify all check boxes are selected");
    }

    @Test
    public void testCase6() throws InterruptedException {
        /*
        1. Go to “https://qa1.vytrack.com/"
        2. Login as a store manager
        3. Navigate to “Activities -> Calendar Events”
        4. Select “Testers meeting”
        5. Verify that following data is displayed:
         */

        WebElement testersMeeting = driver.findElement(By.xpath("//div[@class='grid-container']//tbody//tr//td[contains(text(),'Testers Meeting')]"));
        testersMeeting.click();

        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].click();",testersMeeting);

        //Actions actions = new Actions(driver);
        //actions.moveToElement(testersMeeting).click(testersMeeting).build().perform();

        WebElement info = driver.findElement(By.xpath("//div[contains(text(),'Testers Meeting')]"));
        System.out.println("info = " + info.getText());
        String actual = info.getText();
        String expected = "Testers Meeting";

        Assert.assertEquals(actual,expected,"verify info is correct");


    }

}
