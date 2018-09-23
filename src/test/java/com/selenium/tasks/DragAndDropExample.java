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

public class DragAndDropExample {

    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeMethod
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com/droppable/");
    }

    // It will close the Browser after Test
    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void performDragAndDrop() throws InterruptedException{
        WebElement iFrame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iFrame);

        // Store the web elements
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        act.dragAndDrop(src, dest).build().perform();
        Thread.sleep(5000);
    }

    @Test
    public void performDragAndDrop2() throws InterruptedException{
        WebElement iFrame = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(iFrame);

        // Store the web elements
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dest = driver.findElement(By.id("droppable"));
        Thread.sleep(2000);

        Actions act = new Actions(driver);
        act.clickAndHold(src).moveToElement(dest).release().perform();
        Thread.sleep(5000);
    }
}
