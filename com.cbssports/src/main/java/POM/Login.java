package POM;

import base.Base;
import static loginLocators.LoginLocators.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {

    public Login() {
        PageFactory.initElements(driver, this);
    }

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

    //loginFunctionalityWithValidData()

    //loginFunctionalityWithInvalidData()

    //loginFunctionalityWithNoData()

    //loginFunctionalityWithValidEmailOnly()

    //loginFunctionalityWithValidPasswordOnly()

    //isForgotPasswordOptionAvailable()

    //isSignUpOptionAvailable()
}
