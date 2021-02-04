package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.TestBase;

import java.util.List;

public class MainPage extends PageBase{
    public MainPage(WebDriver driver) {
        super(driver);
    }
//    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy(css="ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;

    @FindBy(id="ion-selopt-0")
    WebElement englishLang;

    @FindBy(css = "ion-item.select-interface-option")
    List<WebElement> langList;

    @FindBy(tagName = "ion-card-title")
    WebElement title;

    @FindBy(name="ion-input-0")
    WebElement fromField;

    @FindBy(name="ion-input-1")
    WebElement toField;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-0-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityFrom;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-1-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityTo;

    @FindBy(css = ".ion-color-primary.button")
    WebElement letsGoButton;

    @FindBy(css = ".city")
    List<WebElement> resultsList;

    @FindBy(xpath = "//a[@href='/']")
    WebElement newSearchButton;


    public boolean isSloganContainsText(String text) {
//        logger.info("Slogan =" + slogan.getText());
        return slogan.getText().contains(text);

    }

    public void selectEnglishLanguage() {
        selectLang.click();
        waitUntilElementVisible(englishLang,5);
        langList.get(0).click();
    }

    public boolean isLanguageOnPageEnglish() {
        return title.getText().contains("Discover the cheapest way to get anywhere combining plane, train, bus and rideshare");
    }

    public void inputCityInFromField(String cityFrom) {
        inputTextToField(fromField, cityFrom);
        waitUntilElementVisible(submitCityFrom, 10);
        submitCityFrom.click();
    }

    public void inputCityInToField(String cityTo) {
        inputTextToField(toField, cityTo);
        waitUntilElementVisible(submitCityTo, 10);
        submitCityTo.click();
    }

    public void clickOnLetsGoButton() {
        letsGoButton.click();
    }

    public boolean searchResultIsDisplayed() {
        waitUntilAllElementsVisible(resultsList, 10);
        return resultsList.size()>0;
    }


    public void clickOnNewSearchButton() {
        waitUntilElementVisible(newSearchButton, 10);
        newSearchButton.click();
    }
}
