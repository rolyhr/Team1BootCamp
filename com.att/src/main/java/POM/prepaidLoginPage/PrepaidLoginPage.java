package POM.prepaidLoginPage;

import POM.PrepaidPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrepaidLoginPage extends PrepaidPage {

    public PrepaidLoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name=\"phoneNumber\"]")
    WebElement accountNumberInput;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement passwordInput;

    @FindBy(css = "#login-form_0")
    WebElement signInButton;

    @FindBy(css = "#forgot-password")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//h5")
    WebElement requestPasswordMessage;

    @FindBy(css = ".custom-error-message")
    WebElement errorMessageForInvalidPhoneNumber;

    @FindBy(xpath = "//input[@id =\"pin-request-phone-phone-number\"]")
    WebElement requestPasswordInputBox;

    @FindBy(xpath = "//label[@for = \"updatePasswordFlag\"]")
    WebElement requestOnlinePassCheckBox;

    @FindBy(xpath = "//label[@for = \"updatePinFlag\"]")
    WebElement request4DigitPinCheckBox;

    @FindBy(css = "#requestNewAccessCode_0")
    WebElement sendTemporaryButton;

    @FindBy(css = "#error")
    WebElement errorMessageForInvalidAccount;

    @FindBy(xpath = "//label[@class = \"custom-error-message\" and @for = \"login-pin-pin-number\"]")
    WebElement errorMessageForInvalidPassword;

    @FindBy(xpath = "//label[@class = \"custom-error-message\" and @for = \"pin-request-phone-phone-number\"]")
    WebElement messageToEnterAccountNumberAtForgetPasswordPage;

    @FindBy(xpath = "//section[@id = \"error\"]")
    WebElement messageToSelectAtLeastOneOption;

    @FindBy(xpath = "//input[@type = \"tel\" and @class = \"parsley-validated\"]")
    WebElement accountNumberForForgetPassword;


    public void sendKeysToAccountTextBox(String accountNumber){
        sendKeysToElement(accountNumberInput, accountNumber);
    }

    public void sendKeysToPasswordTextBox(String password){
        sendKeysToElement(passwordInput, password);
    }

    public void clickOnSignInButton(){
        clickOnElement(signInButton);
    }

    public boolean isErrorMessageForInvalidAccountPresent(){
        return isElementPresent(errorMessageForInvalidAccount);
    }

    public boolean isErrorMessageForInvalidPhoneNumberPresent(){
        return isElementPresent(errorMessageForInvalidPhoneNumber);
    }

    public boolean isErrorMessageForInvalidPasswordPresent(){
        return isElementPresent(errorMessageForInvalidPassword);
    }

    void navigateToForgetPasswordPage(){
        navigateToPrepaidAccountPage();
        waitForElementToBeVisible(forgotPasswordLink);
        clickOnElement(forgotPasswordLink);
        waitForElementToBeVisible(requestPasswordMessage);
    }

    void clickOnRequestOnlinePasswordCheckBox(){
        clickOnElement(requestOnlinePassCheckBox);
    }

    void clickOnRequest4DigitPINCheckBox(){
        clickOnElement(request4DigitPinCheckBox);
    }

    void clickOnSendTemporaryPasswordButton(){
        clickOnElement(sendTemporaryButton);
    }

    public boolean isMessageForAccountNumberPresent(){
        return isElementPresent(messageToEnterAccountNumberAtForgetPasswordPage);
    }

    public boolean isMessageForSelectingAtLeastOneOption(){
        return isElementPresent(messageToSelectAtLeastOneOption);
    }

    void sendKeysToAccountInputOfForgetPasswordPage(String accountNumber){
        sendKeysToElement(accountNumberForForgetPassword, accountNumber);
    }

    public void doLoginPrepaidAccount(String accountNumber, String password){
        navigateToPrepaidAccountPage();
        sendKeysToAccountTextBox(accountNumber);
        sendKeysToPasswordTextBox(password);
        clickOnSignInButton();
    }

    public void doRequestPasswordWithoutClickAnyChekBox(String accountNumber){
        navigateToForgetPasswordPage();
        sendKeysToAccountInputOfForgetPasswordPage(accountNumber);
        clickOnSendTemporaryPasswordButton();
    }

    public void doRequestPasswordWithRequestPasswordOnlineCheckBox(String accountNumber){
        navigateToForgetPasswordPage();
        sendKeysToAccountInputOfForgetPasswordPage(accountNumber);
        clickOnRequestOnlinePasswordCheckBox();
        clickOnSendTemporaryPasswordButton();
    }

    public void doRequestPasswordWithRequest4DigitPINCheckBox(String accountNumber){
        navigateToForgetPasswordPage();
        sendKeysToAccountInputOfForgetPasswordPage(accountNumber);
        clickOnRequest4DigitPINCheckBox();
        clickOnSendTemporaryPasswordButton();
    }

    public void doRequestPasswordWithBothOptions(String accountNumber){
        navigateToForgetPasswordPage();
        sendKeysToAccountInputOfForgetPasswordPage(accountNumber);
        clickOnRequestOnlinePasswordCheckBox();
        clickOnRequest4DigitPINCheckBox();
        clickOnSendTemporaryPasswordButton();
    }

    public void doRequestPasswordWithoutAccountNumberAndAnyOption(){
        navigateToForgetPasswordPage();
        clickOnSendTemporaryPasswordButton();
    }

    public void doRequestPasswordWithoutAccountNumberAndBothOption(){
        navigateToForgetPasswordPage();
        clickOnRequestOnlinePasswordCheckBox();
        clickOnRequest4DigitPINCheckBox();
        clickOnSendTemporaryPasswordButton();
    }
}