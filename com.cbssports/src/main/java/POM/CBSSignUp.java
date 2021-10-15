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
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 0, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 0, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 0, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 0, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 0, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 0, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 0, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 0, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 0, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningRegistrationSuccess)).getText();
    }

    //TC002REG
    public String registerNewAccountWithAllInvalidData() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 1, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 1, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 1, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 1, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 1, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 1, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 1, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 1, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 1, 8));
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
        return notValidEmail + " " +
                warningPass + " " +
                warningPasswordNotMarch + " ";
    }

    //TC003REG
    public String registerNewAccountWithInvalidEmailOnly() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 2, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 2, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 2, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 2, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 2, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 2, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 2, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 2, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 2, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningEmail)).getText();
    }

    //TC004REG
    public String registerNewAccountWithDuplicateEmail() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 3, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 3, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 3, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 3, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 3, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 3, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 3, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 3, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 3, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningEmail)).getText();
    }

    //TC005REG
    public String registerNewAccountWithInvalidPasswordOnly() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 4, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 4, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 4, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 4, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 4, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 4, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 4, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 4, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 4, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPassword)).getText();
    }

    //TC006REG
    public String registerNewAccountWithInvalidPasswordSixCharOrLess() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 5, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 5, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 5, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 5, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 5, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 5, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 5, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 5, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 5, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPassword)).getText();
    }

    //TC007REG
    public String registerNewAccountWhenConfirmPasswordDoNotMatch() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 6, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 6, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 6, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 6, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 6, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 6, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 6, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 6, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 6, 8));
        clickOnElement(newsletterCheckbox1);
        clickJScript(newsletterCheckbox2);
        clickJScript(termsCheckbox);
        clickJScript(registerButton);
        return explicitWait.until(ExpectedConditions.visibilityOf(warningPasswordNotMatch)).getText();
    }

    //TC008REG
    public String registerNewAccountWithTOSCheckboxUnchecked() {
        navigateToSignUpPage();
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 7, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 7, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 7, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 7, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 7, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 7, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 7, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 7, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 7, 8));
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
        sendKeysToElement(emailInput, readFromExcel2D("REGCredentials", 8, 0));
        sendKeysToElement(firstNameInput, readFromExcel2D("REGCredentials", 8, 1));
        sendKeysToElement(lastNameInput, readFromExcel2D("REGCredentials", 8, 2));
        sendKeysToElement(passwordInput, readFromExcel2D("REGCredentials", 8, 3));
        sendKeysToElement(reEnterPassword, readFromExcel2D("REGCredentials", 8, 4));
        dropdownSelectByVisibleText(monthInput, readFromExcel2D("REGCredentials", 8, 5));
        dropdownSelectByVisibleText(dayInput, readFromExcel2D("REGCredentials", 8, 6));
        dropdownSelectByVisibleText(yearInput, readFromExcel2D("REGCredentials", 8, 7));
        sendKeysToElement(zipCodeInput, readFromExcel2D("REGCredentials", 8, 8));
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
