package com.findlinks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindBrokenLink {
    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeTest
    public void openBrowser() {

        driver = new ChromeDriver();

        //To maximize the Window
        driver.manage().window().maximize();
        //To Open the Application
        driver.get("https://www.google.com");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void getBrokenLinks() {

        // Find all Elements on the page with 'a' tag
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Total Number of Links : " +allLinks.size());

        //Iterate over all available Links on webpage
        for (WebElement link : allLinks) {
            String linkURL = link.getAttribute("href");

            //Call VerifyURL form GetResponse Code Class
            GetResponseCode.verifyUrl(linkURL);
        }

        System.out.println("Total Number of Links : " +allLinks.size());
        GetResponseCode.getInvalidLinkCount();
    }
}
