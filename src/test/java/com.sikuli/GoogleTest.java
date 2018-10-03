package com.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.concurrent.TimeUnit;

public class GoogleTest {

    public static void main(String[] args) throws FindFailed {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");

        Screen s = new Screen();

        Pattern searchBtnImg = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\search.png");
        s.wait(searchBtnImg, 200);
        s.click();

        Pattern signInBtnImg = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\signin.png");
        s.wait(signInBtnImg, 200);
        s.click();
    }
}
