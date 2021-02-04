package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTests extends TestBase{

    MainPage mainPage;

    @BeforeMethod
    public void initTest(){
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }


    @Test(priority = 2, groups = {"UI"})
    public void sloganValidationTest() {
        String text = " Плати меньше, посети больше!";
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert mainPage.isSloganContainsText(text);
    }

    @Test(priority = 1, groups = {"functional"})
    public void changeLanguageValidationTest(){
        mainPage.selectEnglishLanguage();
        assert mainPage.isLanguageOnPageEnglish();
    }

}
