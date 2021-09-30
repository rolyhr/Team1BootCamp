package POM;

import base.Base;
import static locators.RegisterLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Register extends Base {
    public Register() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = REGISTER_LINK)
    public WebElement registerLink;

    @FindBy (css = REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)
    public WebElement registerPersonalAccountRadioButton;

    @FindBy (css = REGISTER_FIRST_NAME_INPUT)
    public WebElement registerFirstNameInput;

    @FindBy (css = REGISTER_LAST_NAME_INPUT)
    public WebElement registerLastNameInput;

    @FindBy (css = REGISTER_EMAIL_INPUT)
    public WebElement registerEmailInput;

    @FindBy (css = REGISTER_PASSWORD_INPUT)
    public WebElement registerPasswordInput;

    @FindBy (css = REGISTER_CREATE_ACCOUNT_BUTTON)
    public WebElement registerCreateAccountButton;

    @FindBy (css = REGISTER_DISPLAY_NAME_AFTER_REG)
    public WebElement registerDisplayNameAfterReg;

    @FindBy (css = REGISTER_EMAIL_ERROR)
    public WebElement registerEmailError;

    public void createNewPersonalAccountWithValidData() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, "John");
        sendKeysToElement(registerLastNameInput, "Smith");
        sendKeysToElement(registerEmailInput, "sample09764@email.com");
        sendKeysToElement(registerPasswordInput, "qaz@890.xyz");
        clickOnElement(registerCreateAccountButton);
    }

    public void createNewPersonalAccountWithNoData() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, "");
        sendKeysToElement(registerLastNameInput, "");
        sendKeysToElement(registerEmailInput, "");
        sendKeysToElement(registerPasswordInput, "");
    }

    public void createNewPersonalAccountWithExistingEmail() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, "John");
        sendKeysToElement(registerLastNameInput, "Smith");
        sendKeysToElement(registerEmailInput, "john@yahoo.com");
        sendKeysToElement(registerPasswordInput, "john@4580.xyz");
    }

    public void createNewPersonalAccountWithInvalidEmail() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, "John");
        sendKeysToElement(registerLastNameInput, "Smith");
        sendKeysToElement(registerEmailInput, "john7890");
        sendKeysToElement(registerPasswordInput, "john@4580.xyz");
    }

    public void createNewPersonalAccountWithInvalidPasswordLess6Char() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, "John");
        sendKeysToElement(registerLastNameInput, "Smith");
        sendKeysToElement(registerEmailInput, "john7890");
        sendKeysToElement(registerPasswordInput, "john@4580.xyz");
    }

    //createNewPersonalAccountWithInvalidPasswordNoSymbol
    //createNewPersonalAccountWithInvalidPasswordNoLetter


    public boolean checkButtonStatus() {
        return isButtonEnabled(registerCreateAccountButton);
    }

    public String getText(WebElement element) {
        WebElement Text = explicitWait.until(ExpectedConditions.visibilityOf(element));
        return Text.getText();
    }

    public void bypassCaptcha() {
        driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
    }
}
