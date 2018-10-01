package com.selenium.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxHeadless {
    public static void main(String[] args) {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");

        FirefoxOptions fo = new FirefoxOptions();
        fo.setBinary(firefoxBinary);
        WebDriver driver = new FirefoxDriver(fo);
        driver.get("http://facebook.com");
        String title = driver.getTitle();
        System.out.println(title);

    }
}
