package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    void clickOnBackToTopButton(){clickOnElement(backToTopButton);}

    void clickOnDoNotSellMyInfo(){clickOnElement(doNotSellMyPersonalInformationLink);}

    public String getURLOfDoNotSellMyPersonalInfoPage(){ return driver.getCurrentUrl();}

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

    public void openDoNotSellMyInfoIntoNewTab(){
        pageUpDown(900);
        String parentTab = driver.getWindowHandle();
        clickOnDoNotSellMyInfo();
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> all = driver.getWindowHandles();

        for(String winHandle : driver.getWindowHandles())
        {
            if(winHandle.equals(parentTab))
            {
                //Condition satisfied. Switching to the parent tab and closing it
                driver.switchTo().window(winHandle);
                driver.close();
            }
        }
        all.remove(parentTab);

        for(String winHandle : all) {
            driver.switchTo().window(winHandle);
        }
    }

    public void clickBackOnTopButtonATDoNotSellMyInfoTab(){
        pageUpDown(900);
        String parentTab = driver.getWindowHandle();
        clickOnDoNotSellMyInfo();
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> all = driver.getWindowHandles();

        for(String winHandle : driver.getWindowHandles())
        {
            if(winHandle.equals(parentTab))
            {
                //Condition satisfied. Switching to the parent tab and closing it
                driver.switchTo().window(winHandle);
                driver.close();
            }
        }
        all.remove(parentTab);

        for(String winHandle : all) {
            driver.switchTo().window(winHandle);
        }

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
        pageUpDown(400);
        clickOnOptInCheckBox();
        clickOnSignUpButton();
    }

    public void doSignUpForNewsLetterWithoutEmailAndOptInBox(){
        pageUpDown(500);
        clickOnSignUpButton();
    }

    public void playWatchNow(){
        mouseHoverOnWatchMenu();
        clickOnPlayButton();
        waitForProviderPage();
    }

    public List<String> getNavigationBarMenuList(){
        return getListFromADiv(By.cssSelector("div #cbs-site-nav nav li.nav-list-item.nav-item-overflow a"));
    }

}
