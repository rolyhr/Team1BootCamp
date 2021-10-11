package POM;

import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static POM.locators.RealStateAgentsLocators.*;

public class RealStateAgents extends Base {
    public  RealStateAgents(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = REALESTATEAGENT)
    public WebElement realEstateAgents;

    @FindBy(css = REALESTATEAGENT_SEARCH_BOX)
    public WebElement realestateAgentsSearchBox;

    @FindBy(css = REALESTATEAGENT_SEARCH_BUTTON)
    public WebElement realestateAgentsSearchButton;

    @FindBy(css = REALESTATEAGENT_SEARCH_CONTAINER_RESULT)
    public WebElement realestateAgentsSearchContainerResult;

    @FindBy(css = SEARCH_HOME_BOX )
    public WebElement  searchHomeBox;

    @FindBy(css = SEARCH_HOME_BOX_BUTTON)
    public WebElement searchHomeButton;

    @FindBy(css = SEARCH_HOME_FORM_EMAIL )
    public WebElement searchHomeFormEmail;

    @FindBy(css = SEARCH_HOME_FORM_PHONE)
    public WebElement searchHomeFormPhone;

    @FindBy(css = SEARCH_HOME_FORM_EMAIL_ERROR)
    public WebElement searchHomeEmailError;

    @FindBy(id = IFRAME)
    public WebElement iframe;

    @FindBy(css = SEARCH_HOME_FORM_CONTAINER)
    public WebElement searchHomeForContainer;

    @FindBy(css = SEARCH_HOME_FORM_SEND_BUTTON)
    public  WebElement searchHomeFormSendButton;

    @FindBy(css = SEARCH_HOME_FORM_PHONE_ERROR)
    public WebElement phoneError;

    public void navigateToRealEstateAgents(){
        clickOnElement(realEstateAgents);
    }

    public void sendValueRealestateAgentsSearchBox(String element){
        realestateAgentsSearchBox.sendKeys(element);
    }

    public void clickOnRealestateAgentsSearchButton(){
        clickOnElement(realestateAgentsSearchButton);
    }

    public void pressEnterRealestateAgentsSearchBox(){
        realestateAgentsSearchBox.sendKeys(Keys.ENTER);
    }
    public void searchrealestateAgentsWithButton(String element){
        navigateToRealEstateAgents();
        sendValueRealestateAgentsSearchBox(element);
        clickOnElement(realestateAgentsSearchButton);
        waitForElementToBeVisible(realestateAgentsSearchContainerResult);
        //switchToIframe(iframe);
    }

    public void searchrealestateAgentsWithKeyBorad(String element){
        navigateToRealEstateAgents();
        sendValueRealestateAgentsSearchBox(element);
        pressEnterRealestateAgentsSearchBox();
        waitForElementToBeVisible(realestateAgentsSearchContainerResult);
        //switchToIframe(iframe);
    }
    public String getrealestateAgentsSearchContainerResult(){
        return realestateAgentsSearchContainerResult.getText();
    }

    /*************************************************************/
    public void sendValueHomeSearchBox(String element){
        searchHomeBox.sendKeys(element);
    }

    public void clickOnHomeSearchButton(){
        clickOnElement(searchHomeButton);
    }

    public void pressEnterHomeSearchBox(){
        searchHomeBox.sendKeys(Keys.ENTER);
    }

    public void sendValueHomeEmail(String element){
        searchHomeFormEmail.sendKeys(element);
    }

    public void sendValueHomePhone(String element){
        searchHomeFormPhone.sendKeys(element);
    }

    public void clickOnSearchHomeFormSendButton(){
        clickOnElement(searchHomeFormSendButton);
    }


    public void searchHomeWithButton(String element) throws InterruptedException {
        navigateToRealEstateAgents();
        scroll();
        sendValueHomeSearchBox( element);
        Thread.sleep(4000);
        clickOnHomeSearchButton();
        waitForElementToBeVisible(searchHomeForContainer);
    }
    public void writeEmail(String city , String email) throws InterruptedException {
        searchHomeWithButton(city);
        sendValueHomeEmail( email);
    }

    public void writePhone(String city , String phone) throws InterruptedException {
        searchHomeWithButton(city);
        sendValueHomePhone( phone);

    }

    public String getErrorMessageEmail(){
        clickOnSearchHomeFormSendButton();
        waitForElementToBeVisible(searchHomeEmailError);
        return searchHomeEmailError.getText();
    }

    public String getErrorMessagePhone(){
        clickOnSearchHomeFormSendButton();
        waitForElementToBeVisible(phoneError);
        return phoneError.getText();
    }
}
