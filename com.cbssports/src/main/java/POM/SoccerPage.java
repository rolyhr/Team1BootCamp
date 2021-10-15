package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SoccerPage extends Base {

    public SoccerPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id = 'cbs-site-nav']//span[@class = 'narrow-text' and text() = 'Watch']")
    WebElement watchNavBarMenu;

    @FindBy(xpath = "//*[@id='cbs-site-nav']//div[@class = 'site-nav-side']//div[@class = 'nav-dropdown-top']/a")
    WebElement playCFBButton;

    @FindBy(css = "#MvpdList > div.MvpdList-headerText")
    WebElement chooseYourProviderPage;

    @FindBy(css = "#Newsletter > div.Newsletter-stateNotSent input:nth-child(9)")
    WebElement signUpButton;

    @FindBy(name = "emailAddress")
    WebElement emailInputField;

    @FindBy(xpath = "//*[@id=\"Newsletter\"]//p/label")
    WebElement optInCheckBox;

    @FindBy(xpath = "//*[@class ='Newsletter-stateCheck']")
    WebElement messageFoUnsuccessfulSignUp;

    @FindBy(xpath = "//*[@id=\"Newsletter\"]/div[3]/h3")
    WebElement messageForSuccessFulSignUp;

    @FindBy(xpath = "//*[@id=\"Newsletter\"]/div[1]/div[1]")
    WebElement messageForEmailRequired;

    @FindBy(css = "#cbs-site-footer  ul > li:nth-child(10) > a")
    WebElement doNotSellMyPersonalInformationLink;

    @FindBy(css = "body > header > div > a")
    WebElement backToTopButton;

    @FindBy(css = "#language-selector")
    WebElement selectLanguageComboBox;

    @FindBy(css = "body > footer > div > p")
    WebElement footerForChangedLanguage;


    void clickOnBackToTopButton(){clickOnElement(backToTopButton);}

    void clickOnDoNotSellMyInfo(){clickOnElement(doNotSellMyPersonalInformationLink);}

    public String getURLOfDoNotSellMyPersonalInfoPage(){ return driver.getCurrentUrl();}

    public String changedLanguageForFooter(){return footerForChangedLanguage.getText();}

    public boolean isMessageForEmailRequiredPresent(){return isElementPresent(messageForEmailRequired);}

    public boolean isMessageForSuccessfulSignUpPresent(){return isElementPresent(messageForSuccessFulSignUp);}

    public boolean isMessageForUnsuccessfulSignUpPresent(){ return isElementPresent(messageFoUnsuccessfulSignUp);}

    void clickOnOptInCheckBox(){clickOnElement(optInCheckBox);}

    void sendEmailToeEmailInputField(String email){sendKeysToElement(emailInputField,email);}

    void clickOnSignUpButton(){ clickOnElement(signUpButton);}

    public boolean isProviderPageVisible(){
        return isElementPresent(chooseYourProviderPage);
    }

    void waitForProviderPage(){
        waitForElementToBeVisible(chooseYourProviderPage);
    }

    void clickOnPlayButton(){
        clickJScript(playCFBButton);
    }

    void mouseHoverOnWatchMenu(){
        mouseHoverOnAnElement(watchNavBarMenu);
    }



    public void doSelectALanguageFromLanguageComboBox(String language){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        clickOnDoNotSellMyInfo();
        switchToANewTabAndCloseParentTab();
        dropdownSelectByVisibleText(selectLanguageComboBox,language);

    }

    public void openDoNotSellMyInfoIntoNewTab(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        clickOnDoNotSellMyInfo();
        switchToANewTabAndCloseParentTab();
    }

    public void clickBackOnTopButtonATDoNotSellMyInfoTab(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        clickOnDoNotSellMyInfo();

        switchToANewTabAndCloseParentTab();

        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        clickOnBackToTopButton();
    }

    public void doSignUpForNewsLetter(String email){
        clickOnOptInCheckBox();
        sendEmailToeEmailInputField(email);
        clickOnSignUpButton();
    }

    public void doSignUpForNewsLetterWithoutClickingOptInBox(String email){
        sendEmailToeEmailInputField(email);
        clickOnSignUpButton();
    }

    public void doSignUpForNewsLetterWithoutEmail(){
        pageScroll(400);
        clickOnOptInCheckBox();
        clickOnSignUpButton();
    }

    public void doSignUpForNewsLetterWithoutEmailAndOptInBox(){
        pageScroll(500);
        clickOnSignUpButton();
    }

    public void playWatchNow(){
        mouseHoverOnWatchMenu();
        clickOnPlayButton();
        waitForProviderPage();
    }

    public List<String> getNavigationBarMenuList(){
        return getStringListFromADiv(By.cssSelector("div #cbs-site-nav nav li.nav-list-item.nav-item-overflow a"));
    }


}
