package com.singelton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
    public static DriverInit instanceDriver = null;
    private WebDriver driver;

    private DriverInit() {

    }

    public WebDriver openBrowser(){
        driver = new ChromeDriver();
        return driver;
    }

    public static DriverInit getInstance(){
        if (instanceDriver == null)
            instanceDriver = new DriverInit();
        return instanceDriver;

    }

}
