package POM;

import base.Base;
import static loginLocators.SignUpLocators.*;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CBSSignUp extends Base {

    public CBSSignUp() {
        PageFactory.initElements(driver, this);
    }

    //START - REGISTRATION INPUTS
    @FindBy (css = HOME_PAGE_LOGIN_BUTTON)
    public WebElement homePageLoginButton;

    @FindBy (css = SIGN_UP_LINK)
    public WebElement signUpLink;

    @FindBy (css = EMAIL_INPUT)
    public WebElement emailInput;

    @FindBy (css = PASSWORD_INPUT)
    public WebElement passwordInput;

    @FindBy (css = RE_ENTER_PASSWORD_INPUT)
    public WebElement reEnterPassword;

    @FindBy (css = FIRST_NAME_INPUT)
    public WebElement firstNameInput;

    @FindBy (css = LAST_NAME_INPUT)
    public WebElement lastNameInput;

    @FindBy (css = MONTH_INPUT)
    public WebElement monthInput;

    @FindBy (css = DAY_INPUT)
    public WebElement dayInput;

    @FindBy (css = YEAR_INPUT)
    public WebElement yearInput;

    @FindBy (css = ZIP_CODE_INPUT)
    public WebElement zipCodeInput;

    @FindBy (css = NEWSLETTER_CHECKBOX1)
    public WebElement newsletterCheckbox1;

    @FindBy (css = NEWSLETTER_CHECKBOX2)
    public WebElement newsletterCheckbox2;

    @FindBy (css = TERMS_CHECKBOX)
    public WebElement termsCheckbox;

    @FindBy (css = REGISTER_BUTTON)
    public WebElement registerButton;
    //END - REGISTRATION INPUTS

    //START - WARNINGS
    @FindBy (css = WARNING_REGISTRATION_SUCCESS)
    public WebElement warningRegistrationSuccess;

    @FindBy (css = WARNING_EMAIL)
    public WebElement warningEmail;

    @FindBy (css = WARNING_PASSWORD)
    public WebElement warningPassword;

    @FindBy (css = WARNING_PASSWORD_NOT_MATCH)
    public WebElement warningPasswordNotMatch;

    @FindBy (css = WARNING_TOS)
    public WebElement warningTOS;
    //END - WARNINGS

    //TC001REG
    public String registerNewAccountWithAllValidData() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample021788@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "Password%1234");
        sendKeysToElement(reEnterPassword, "Password%1234");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningRegistrationSuccess)).getText();
    }

    //TC002REG
    public String registerNewAccountWithAllInvalidData() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888");
        sendKeysToElement(firstNameInput, "S");
        sendKeysToElement(lastNameInput, "E");
        sendKeysToElement(passwordInput, "Pas");
        sendKeysToElement(reEnterPassword, "Pa");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "25");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "1143");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        String notValidEmail = explicitWait.until
                (ExpectedConditions.visibilityOf(warningEmail)).getText();
        String warningPass = explicitWait.until
                (ExpectedConditions.visibilityOf(warningPassword)).getText();
        String warningPasswordNotMarch = explicitWait.until
                (ExpectedConditions.visibilityOf(warningPasswordNotMatch)).getText();
        return notValidEmail + "\n" +
                warningPass + "\n" +
                warningPasswordNotMarch + "\n";
    }

    //TC003REG
    public String registerNewAccountWithInvalidEmailOnly() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "Password%1234");
        sendKeysToElement(reEnterPassword, "Password%1234");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningEmail)).getText();
    }

    //TC004REG
    public String registerNewAccountWithDuplicateEmail() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "Password%1234");
        sendKeysToElement(reEnterPassword, "Password%1234");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningEmail)).getText();
    }

    //TC005REG
    public String registerNewAccountWithInvalidPasswordOnly() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "password34");
        sendKeysToElement(reEnterPassword, "password34");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPassword)).getText();
    }

    //TC006REG
    public String registerNewAccountWithInvalidPasswordSixCharOrLess() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "pas");
        sendKeysToElement(reEnterPassword, "pas");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPassword)).getText();
    }

    //TC007REG
    public String registerNewAccountWhenConfirmPasswordDoNotMatch() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "pas");
        sendKeysToElement(reEnterPassword, "pass");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPasswordNotMatch)).getText();
    }

    //TC008REG
    public String registerNewAccountWithTOSCheckboxUnchecked() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "Password%1234");
        sendKeysToElement(reEnterPassword, "Password%1234");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningTOS)).getText();
    }

    //registerNewAccountWithNewsletterCheckboxesUnchecked()

    //registerNewAccountWithNewsletterCheckboxesChecked()

    //TC009REG
    public boolean isNewsletterCheckboxCheckedByDefault() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, "sample73888@gmail.com");
        sendKeysToElement(firstNameInput, "Sample");
        sendKeysToElement(lastNameInput, "Email");
        sendKeysToElement(passwordInput, "Password%1234");
        sendKeysToElement(reEnterPassword, "Password%1234");
        dropdownSelectByVisibleText(monthInput, "April");
        dropdownSelectByVisibleText(dayInput, "15");
        dropdownSelectByVisibleText(yearInput, "2001");
        sendKeysToElement(zipCodeInput, "11433");
        boolean cbsSport =  explicitWait.until(ExpectedConditions.visibilityOf(newsletterCheckbox1)).isSelected();
        boolean sportsLine =  explicitWait.until(ExpectedConditions.visibilityOf(newsletterCheckbox2)).isSelected();
        return cbsSport && sportsLine;
    }

    //HELPER METHODS
    public void navigateToSignUpPage() {
        try {
            clickOnElement(homePageLoginButton);
        } catch (ElementNotVisibleException e) {
            clickJScript(homePageLoginButton);
        }
        try {
            clickOnElement(signUpLink);
        } catch (ElementNotVisibleException e) {
            clickJScript(signUpLink);
        }
    }

}
