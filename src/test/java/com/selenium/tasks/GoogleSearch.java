package com.selenium.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.manage().deleteAllCookies();
       // driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://google.com");
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testing");
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));

        System.out.println(list.size());
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getText().contains("testing center"))
                list.get(i).click();
            break;

        }
        driver.close();
    }

}
