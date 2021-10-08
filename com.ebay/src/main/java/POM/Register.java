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

    @FindBy (css = REGISTER_PASSWORD_ERROR)
    public WebElement registerPasswordError;

    public String createNewPersonalAccountWithValidData() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 0, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 0, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 0, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 0, 3));
        clickOnElement(registerCreateAccountButton);
        return getText(registerDisplayNameAfterReg);
    }

    public boolean createNewPersonalAccountWithNoData() {
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
        return checkButtonStatus();
    }

    public String createNewPersonalAccountWithExistingEmail() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 1, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 1, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 1, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 1, 3));
        return getText(registerEmailError);
    }

    public String createNewPersonalAccountWithInvalidEmail() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 2, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 2, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 2, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 2, 3));
        return getText(registerEmailError);
    }

    public String createNewPersonalAccountWithInvalidPasswordLess6Char() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 3, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 3, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 3, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 3, 3));
        return getText(registerEmailError);
    }

    public String createNewPersonalAccountWithInvalidPasswordNoSymbol() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 4, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 4, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 4, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 4, 3));
        return getText(registerEmailError);
    }

    public String createNewPersonalAccountWithInvalidPasswordNoLetter() {
        clickOnElement(registerLink);
        bypassCaptcha();
        boolean radioBtn = driver.findElement(By.cssSelector(REGISTER_PERSONAL_ACCOUNT_RADIO_BUTTON)).isSelected();
        if (!radioBtn) {
            clickOnElement(registerPersonalAccountRadioButton);
        }
        sendKeysToElement(registerFirstNameInput, readFromExcel2D("REGCredentials", 5, 0));
        sendKeysToElement(registerLastNameInput, readFromExcel2D("REGCredentials", 5, 1));
        sendKeysToElement(registerEmailInput, readFromExcel2D("REGCredentials", 5, 2));
        sendKeysToElement(registerPasswordInput, readFromExcel2D("REGCredentials", 5, 3));
        return getText(registerEmailError);
    }

    //HELPER METHODS
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
