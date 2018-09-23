package com.selenium.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MouseHoverSample {
    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeMethod
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.easybix.com/");
    }

    // It will close the Browser after Test
    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void performMouseHover() throws InterruptedException{
        WebElement seleniumLink = driver.findElement(By.xpath("//*[@id='menu-item-10548']/a"));
        Actions act = new Actions(driver);
        act.moveToElement(seleniumLink).perform();
        Thread.sleep(5000);

        WebElement webdriverLink = driver.findElement(By.xpath("//*[@id='menu-item-9383']/a"));
        webdriverLink.click();
        Thread.sleep(5000);
    }
}
