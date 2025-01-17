package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ExtentReportsGenerator {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testReports.html");
        sparkReporter.config().setDocumentTitle("Test Results");
        sparkReporter.config().setReportName("Testing Report");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Successful Test Case execution: " + result.getName());
    }


    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Skipped Test Case execution: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Failed Test Case execution: " + result.getName());
        test.log(Status.FAIL, "Cause of Failure execution: " + result.getThrowable());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

