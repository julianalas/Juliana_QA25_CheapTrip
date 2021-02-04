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
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method, Object[] parameter) {
        logger.info("Start test: " + method.getName());
        if (parameter.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(parameter));
        }
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");
        options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://test70.lowcoststrip.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown (ITestResult result) {
        driver.quit();

        if (result.isSuccess()) {
            logger.info("PASSED: Test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: Test method " + result.getMethod().getMethodName() + "\n");
        }
        logger.info("Stop test ");
        logger.info("======================================================================");
    }
}






