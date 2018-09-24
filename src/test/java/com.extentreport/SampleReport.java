package com.extentreport;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SampleReport {
    ExtentReports report;
    ExtentHtmlReporter htmlReporter2;
    ExtentTest logger;

    @BeforeTest
    public void startTest() {


        // Provide the Report Path
        htmlReporter2 = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myExtentReport.html");
        report.attachReporter(htmlReporter2);
        report.setSystemInfo("Host Name", "Anshul-702HK");
        report.setSystemInfo("Env", "Automation Testing");
        report.setSystemInfo("User", "Anshul Chauhan");
    }

    @Test
    public void demoTestPass(){
        logger = report.createTest("demoTestPass");
        Assert.assertTrue(true);
        logger.pass("Assert pass as Condition is Pass");
    }

    @Test
    public void demoTestFail(){
        logger = report.createTest("demoTestFail");
        Assert.assertTrue(false);
        logger.pass("Assert Fail as Condition is False");
    }

    @Test
    public void demoTestSkip(){
        logger = report.createTest("demoTestSkip");
        throw new SkipException("Skipping As Test is not ready");
    }

    @AfterMethod
    public void getTestResult(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.fail(result.getName());
            logger.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.skip("Test Case Skipped is "+result.getName());
        }
    }

    @AfterTest
    public void endreport()
    {
        report.flush();
    }
}
