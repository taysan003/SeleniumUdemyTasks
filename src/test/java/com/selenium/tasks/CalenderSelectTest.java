package com.selenium.tasks;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderSelectTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
       /* driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
        driver.navigate().to("https://www.freecrm.com");
        driver.findElement(By.name("username")).sendKeys("taysan");
        driver.findElement(By.name("password")).sendKeys("Kostuchenko0");
        driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-small']")).submit();

        driver.switchTo().frame("mainpanel");
        String date = "21-October-2017";
        String dateArr[] = date.split("-");
        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];

        Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(driver.findElement(By.name("slctYear")));
        selectYear.selectByVisibleText(year);

        //div[@id='crmcalendar']/table[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
        //div[@id='crmcalendar']/table[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
        //div[@id='crmcalendar']/table[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr[2]/td[3]

        String beforeXpath = "//div[@id='crmcalendar']/table[@class='crmcalendar']/tbody/tr[2]/td/table/tbody/tr[";
        String afterXpath = "//]/td[";

        final  int totalWeekDays = 7;

        for (int rowNum = 2; rowNum <=totalWeekDays ; rowNum++) {
            for ( int colNum = 1; colNum <=totalWeekDays ; colNum++) {

                String dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
                System.out.println(dayVal);
            }
        }


    }
}
