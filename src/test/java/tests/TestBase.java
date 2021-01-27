package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(options);
        driver.get("http://test70.lowcoststrip.com/");
    }
    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: Test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: Test method " + result.getMethod().getMethodName() + "\n");
        }
        logger.info("Stop test ");
        logger.info("======================================================================");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
