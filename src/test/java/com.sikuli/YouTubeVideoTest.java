package com.sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


import java.util.concurrent.TimeUnit;

public class YouTubeVideoTest {



    public static void main(String[] args) throws FindFailed {
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.youtube.com/watch?v=qvE2miLMbNk");

        //Create object of screen class - sikuli
        //pause icon
        Screen s = new Screen();

        Pattern settingsImg = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\settings.png");
        s.wait(settingsImg, 200);
        s.click();

        Pattern Img720 = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\720.png");
        s.wait(Img720, 200);
        s.click();


        Pattern pauseImg = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\pause.png");
        s.wait(pauseImg, 200);
        s.click();
        //play icon

        Pattern playImg = new Pattern("G:\\SeleniumProjects\\SeleniumUdemy\\src\\test\\java\\com.sikuli\\play.png");
        s.wait(playImg, 200);
        s.click();
        s.click();


    }
}
