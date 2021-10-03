package POM;

import base.Base;
import static bmwlocators.LoginLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BMWLogin extends Base {
    public BMWLogin() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = MY_BMW_LINK)
    public WebElement myBmwLink;

    @FindBy (css = LOGIN_EMAIL_ADDRESS_INPUT)
    public WebElement loginEmailAddressInput;

    @FindBy (css = LOGIN_PASSWORD_INPUT)
    public WebElement loginPasswordInput;

    @FindBy (css = REMEMBER_ME_CHECKBOX)
    public WebElement rememberMeCheckbox;

    @FindBy (css = LOGIN_BUTTON)
    public WebElement loginButton;

    @FindBy (css = FORGOT_YOUR_PASSWORD_LINK)
    public WebElement forgotYourPasswordLink;

    @FindBy (css = REGISTER_NOW_LINK)
    public WebElement registerNowLink;

    @FindBy (css = NEED_HELP_LINK)
    public WebElement needHelpLink;

    @FindBy (css = FAQ_TEXT_VALIDATION)
    public WebElement faqTextValidation;

    @FindBy (css = MY_BMW_TEXT_VALIDATION)
    public WebElement myBmwTextValidation;

    @FindBy (css = WARNING_INVALID_EMAIL)
    public WebElement warningInvalidEmail;

    @FindBy (css = WARNING_INVALID_PASSWORD)
    public WebElement warningInvalidPassword;

    @FindBy (css = WARNING_INVALID_EMAIL_PASSWORD)
    public WebElement warningInvalidEmailPassword;

    @FindBy (css = AFTER_LOGIN_MY_BMW_LINK)
    public WebElement afterLoginMyBmwLink;

    @FindBy (css = LOGOUT_LINK)
    public WebElement logoutLink;

    @FindBy (css = LOGIN_PAGE_VALIDATION_MSG)
    public WebElement loginPageValidationMsg;

    @FindBy (css = AFTER_LOGIN_UP_ARROW)
    public WebElement afterLoginUpArrow;

    //TC001L
    public String loginFunctionalityWithValidData() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "sample7890321@outlook.com");
        sendKeysToElement(loginPasswordInput, "qazxsw@7890");
        clickJScript(loginButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(myBmwLink)).getText();
    }

    //TC002LI
    public String loginFunctionalityWithInvalidData() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "sample@email.com");
        sendKeysToElement(loginPasswordInput, "password123");
        clickJScript(loginButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningInvalidEmailPassword)).getText();
    }

    //TC003LI
    public boolean loginFunctionalityWithNoData() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "");
        sendKeysToElement(loginPasswordInput, "");
        return explicitWait.until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    //TC004LI
    public boolean loginFunctionalityWithInvalidEmailOnly() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "sample");
        sendKeysToElement(loginPasswordInput, "qazxsw@7890");
        return explicitWait.until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
    }

    //TC005LI
    public String  loginFunctionalityWithInvalidPasswordOnly() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "sample7890321@outlook.com");
        sendKeysToElement(loginPasswordInput, "0");
        clickJScript(loginButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningInvalidEmailPassword)).getText();
    }

    //TC006LI
    public boolean isForgotPasswordOptionAvailable() {
        navigateToLoginPage();
        String actualForgotPassLinkText = explicitWait.until(ExpectedConditions.visibilityOf(forgotYourPasswordLink)).getText();
        String expectedForgotPassLinkText = "Forgot your password?";
        return actualForgotPassLinkText.equals(expectedForgotPassLinkText);
    }

    //TC007LI
    public boolean isRegisterNowOptionAvailable() {
        navigateToLoginPage();
        String actualForgotPassLinkText = explicitWait.until(ExpectedConditions.visibilityOf(registerNowLink)).getText();
        String expectedForgotPassLinkText = "Register now";
        return actualForgotPassLinkText.equals(expectedForgotPassLinkText);
    }

    //TC008LO
    public boolean isLoggedOut() {
        navigateToLoginPage();
        sendKeysToElement(loginEmailAddressInput, "sample7890321@outlook.com");
        sendKeysToElement(loginPasswordInput, "qazxsw@7890");
        clickJScript(loginButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        fluentWait.until(ExpectedConditions.elementToBeClickable(afterLoginUpArrow)).click();
        clickJScript(logoutLink);
        String actualLoginPageMsg =  explicitWait.until(ExpectedConditions.visibilityOf(loginPageValidationMsg)).getText();
        String expectedLoginPageMsg = "ONE LOGIN. ALL ACCESS.";
        return actualLoginPageMsg.equals(expectedLoginPageMsg);
    }

    //HELPER METHODS
    public void navigateToLoginPage() {
        try {
            clickOnElement(myBmwLink);
        } catch (Exception e) {
            clickJScript(myBmwLink);
        }
    }
}
