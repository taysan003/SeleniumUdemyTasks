package com.selenium.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownOperations {
    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeMethod
    public void openBrowser() {

        driver = new ChromeDriver();

        // To maximize the Window
        driver.manage().window().maximize();
        // To Open the Application
        driver.navigate().to("http://www.facebook.com");
    }

    // It will close the Browser after Test
    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void selectbyIndexTest() throws InterruptedException {

        // Store the dropdwon webelement
        WebElement element = driver.findElement(By.id("month"));

        Select oSelect = new Select(element);
        oSelect.selectByIndex(1);
        Thread.sleep(4000);
    }

    @Test
    public void selectbyValueTest() throws InterruptedException {

        // Store the dropdwon webelement
        WebElement element = driver.findElement(By.id("year"));

        Select oSelect = new Select(element);
        Thread.sleep(3000);
        oSelect.selectByValue("2007");

        Thread.sleep(3000);
    }


    @Test
    public void selectbyTextTest() throws InterruptedException {

        // Store the dropdwon webelement
        WebElement element = driver.findElement(By.id("month"));

        Select oSelect = new Select(element);
        oSelect.selectByValue("9");
        Thread.sleep(3000);
    }

    @Test
    public void printAllValuesTest() throws InterruptedException {

        // Store the dropdwon webelement
        WebElement element = driver.findElement(By.id("month"));

        Select oSelect = new Select(element);
        List<WebElement> months = oSelect.getOptions();
        System.out.println("Total Options are : " + months.size());

        for (WebElement monthValue : months) {
            String value = monthValue.getText();
            System.out.println(value);
        }
    }
}
