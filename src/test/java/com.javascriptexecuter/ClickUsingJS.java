package com.javascriptexecuter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClickUsingJS {

    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeTest
    public void openBrowser() {

        driver = new ChromeDriver();

        // To maximize the Window
        driver.manage().window().maximize();
        // To Open the Application
        driver.get("http://www.facebook.com");
    }

    // It will close the Browser after Test
    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void clickAsJavaScript() throws InterruptedException {

        // Finding button by ID locator
        WebElement createAccountButton = driver.findElement(By.id("u_0_x"));

        String javaScript = "arguments[0].click();";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(javaScript , createAccountButton);

        Thread.sleep(3000);
    }
}
