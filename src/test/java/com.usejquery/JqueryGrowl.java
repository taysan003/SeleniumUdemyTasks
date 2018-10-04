package com.usejquery;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JqueryGrowl {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() throws Exception {

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("http://freecrm.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void freeCRMTitleTest() throws InterruptedException {
        String title = driver.getTitle();
        System.out.println(title);
        getRunTimeInfoMessage("info", title);

        if (title.equals("#1 Free CRM software in the cloud for sales and service")){
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }


    }

    public void getRunTimeInfoMessage(String messageType, String message) throws InterruptedException {


        // Check for jQuery on the page, add it if need be
        js.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        Thread.sleep(5000);

        // Use jQuery to add jquery-growl to the page
        js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

        //js.executeScript("$.getScript('/Users/NaveenKhunteta/Documents/workspace/Test/src/testcases/jquery.growl.js')");

        // Use jQuery to add jquery-growl styles to the page
        js.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        Thread.sleep(5000);

        // jquery-growl w/ no frills
        js.executeScript("$.growl({ title: 'GET', message: '/' });");

        // jquery-growl w/ colorized output
        if (messageType.equals("error")){
            js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
        } else if (messageType.equals("info")){
            js.executeScript("$.growl.notice({ title: 'Notice', message: '"+message+"' });");
        } else if (messageType.equals("warning")){
            js.executeScript("$.growl.warning({ title: 'Warning!', message: '"+message+"' });");
        }



    }

}
