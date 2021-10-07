package POM;

import base.Base;
import static loginLocators.LoginLocators.*;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CBSLogin extends Base {

    public CBSLogin() {
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
        sendKeysToElement(loginUserId, readFromExcel2D("Credentials", 0, 0));
        sendKeysToElement(loginPassword, readFromExcel2D("Credentials", 0, 1));
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
        sendKeysToElement(loginUserId, readFromExcel2D("Credentials", 1, 0));
        sendKeysToElement(loginPassword, readFromExcel2D("Credentials", 1, 1));
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
        sendKeysToElement(loginUserId, readFromExcel2D("Credentials", 2, 0));
        sendKeysToElement(loginPassword, readFromExcel2D("Credentials", 2, 1));
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
        sendKeysToElement(loginUserId, readFromExcel2D("Credentials", 3, 0));
        sendKeysToElement(loginPassword, readFromExcel2D("Credentials", 3, 1));
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
        String expectedForgotPassLinkText = readFromExcel("Expected", 0);
        return actualForgotPassLinkText.equals(expectedForgotPassLinkText);
    }

    //TC007LI
    public boolean isSignUpOptionAvailable() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        String actualSignUpLinkText = explicitWait.until(ExpectedConditions.visibilityOf(newAccountSignUpLink)).getText();
        String expectedSignUpLinkText = readFromExcel("Expected", 1);
        return actualSignUpLinkText.equals(expectedSignUpLinkText);
    }

    //TC008LO
    public boolean isLoggedOut() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        sendKeysToElement(loginUserId, readFromExcel2D("Credentials", 4, 0));
        sendKeysToElement(loginPassword, readFromExcel2D("Credentials", 4, 1));
        clickJScript(loginSubmitButton);
        hoverOverElement(myTeamDdHoverMM, myTeamDdHoverSM);
        String actualLoginBtnText = explicitWait.until(ExpectedConditions.visibilityOf(homePageLoginButton)).getText();
        String expectedLoginBtnText = readFromExcel("Expected", 2);
        return actualLoginBtnText.equals(expectedLoginBtnText);
    }
}
