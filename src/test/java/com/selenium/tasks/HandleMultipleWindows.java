package com.selenium.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleMultipleWindows {
    WebDriver driver;

    // It will open the browser & Application before Test
    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.naukri.com/");
    }

    // It will close the Browser after Test
    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.close();
    }

    @Test
    public void multiWindowTest(){
        verifyHomeTitle();

        //Store Current Window Id
        String homeWinID = driver.getWindowHandle();

        WebElement recruiterLink = driver.findElement(By.cssSelector("a[href='https://www.naukri.com/recruiters']"));
        recruiterLink.click();

        //Store all opened windows Ids
        Set<String> allWindows = driver.getWindowHandles();

        Iterator<String> windowIterator = allWindows.iterator();
        while (windowIterator.hasNext()) {

            String recruiterWinID= windowIterator.next();

            if(!homeWinID.equals(recruiterWinID)){

                driver.switchTo().window(recruiterWinID);

                verifyRecruiterTitle();

                WebElement pageHeading = driver.findElement(By.cssSelector("h1[class ='SrchHd'] span"));
                Assert.assertTrue(pageHeading.isDisplayed());
                System.out.println(pageHeading.getText());

                //To close the Child Window
                driver.close();
            }

            driver.switchTo().window(homeWinID);

            verifyHomeTitle();
        }
    }

    // Method to get Home page title
    public void verifyHomeTitle(){
        Assert.assertEquals(driver.getTitle(), "Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
    }

    //method to get Child Page title
    public void verifyRecruiterTitle(){
        Assert.assertEquals(driver.getTitle(), "HR Manager - HR Executive - HR Recruiter Consultants - Naukri.com");;
    }
}
