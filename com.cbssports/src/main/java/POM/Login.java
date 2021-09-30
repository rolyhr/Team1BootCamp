package POM;

import base.Base;
import static loginLocators.LoginLocators.*;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends Base {

    public Login() {
        PageFactory.initElements(driver, this);
    }

    //START - LOGIN
    @FindBy (css = HOME_PAGE_LOGIN_BUTTON)
    public WebElement homePageLoginButton;

    @FindBy (css = LOGIN_USER_ID)
    public WebElement loginUserId;

    @FindBy (css = LOGIN_PASSWORD)
    public WebElement loginPassword;

    @FindBy (css = LOGIN_SUBMIT_BUTTON)
    public WebElement loginSubmitButton;

    @FindBy (css = WARNING_EMAIL_FIELD)
    public WebElement warningEmailField;

    @FindBy (css = WARNING_PASSWORD_FIELD)
    public WebElement warningPasswordField;

    @FindBy (css = WARNING_FOR_BOTH_EMAIL_PASS_FIELDS)
    public WebElement warningForBothEmailPassFields;

    @FindBy (css = SUCCESSFUL_LOGIN_VERIFICATION_MSG)
    public WebElement successfulLoginVerificationMsg;
    //END - LOGIN

    //START - LOGOUT
    @FindBy (css = MY_TEAM_DD_HOVER_MM)
    public WebElement myTeamDdHoverMM;

    @FindBy (css = MY_TEAM_DD_HOVER_SM)
    public WebElement myTeamDdHoverSM;
    //START - LOGOUT

    //START - FORGOT PASSWORD
    @FindBy (css = FORGOT_PASSWORD_LINK)
    public WebElement forgotPasswordLink;
    //END - FORGOT PASSWORD

    //START - REGISTRATION
    @FindBy (css = SUCCESSFUL_CONFIRMATION_MSG_FOR_NEW_REG)
    public WebElement successfulConfirmationMsgForNewReg;

    @FindBy (css = NEW_ACCOUNT_SIGN_UP_LINK)
    public WebElement newAccountSignUpLink;
    //END - REGISTRATION

    //TC001L
    public String loginFunctionalityWithValidData() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, "sample789098@yahoo.com");
        sendKeysToElement(loginPassword, "QAZ@xsw.7890");
        clickJScript(loginSubmitButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(successfulLoginVerificationMsg)).getText();
    }

    //TC002LI
    public String loginFunctionalityWithInvalidData() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, "sample@yahoo.com");
        sendKeysToElement(loginPassword, "password123");
        clickJScript(loginSubmitButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningForBothEmailPassFields)).getText();
    }

    //TC003LI
    public String loginFunctionalityWithNoData() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, "");
        sendKeysToElement(loginPassword, "");
        clickJScript(loginSubmitButton);
        String warningEmail = explicitWait.until(ExpectedConditions.visibilityOf(warningEmailField)).getText();
        String warningPass = explicitWait.until(ExpectedConditions.visibilityOf(warningPasswordField)).getText();
        return warningEmail + " + " + warningPass;
    }

    //TC004LI
    public String loginFunctionalityWithInvalidEmailOnly() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, "sample.yahoo.com");
        sendKeysToElement(loginPassword, "QAZ@xsw.7890");
        clickJScript(loginSubmitButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningEmailField)).getText();
    }

    //TC005LI
    public String loginFunctionalityWithInvalidPasswordOnly() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, "sample.yahoo.com");
        sendKeysToElement(loginPassword, "QAZ");
        clickJScript(loginSubmitButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPasswordField)).getText();
    }

    //TC006LI
    public boolean isForgotPasswordOptionAvailable() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        String actualForgotPassLinkText = explicitWait.until(ExpectedConditions.visibilityOf(forgotPasswordLink)).getText();
        String expectedForgotPassLinkText = "FORGOT YOUR PASSWORD?";
        if (actualForgotPassLinkText.equals(expectedForgotPassLinkText)) {
            return true;
        } else {
            return false;
        }
    }

    //TC007LI
    public boolean isSignUpOptionAvailable() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        String actualSignUpLinkText = explicitWait.until(ExpectedConditions.visibilityOf(newAccountSignUpLink)).getText();
        String expectedSignUpLinkText = "DON'T HAVE AN ACCOUNT? SIGN UP";
        if (actualSignUpLinkText.equals(expectedSignUpLinkText)) {
            return true;
        } else {
            return false;
        }
    }
}
