package POM;

import base.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

public class Homepage extends Base {
    public Homepage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "div.UserDropDowns_alertStabilizer_9d>svg.UserDropDowns_icon_06")
    public WebElement accountDropDownMenu;

    @FindBy(css = "a[data-tid='HEAD:USERBAR:ACCOUNT:CREATEACCOUNT']>div.Account_title_84")
    public WebElement createAnAccountButton;

    @FindBy(xpath = "//*[@id='register-email']")
    public WebElement emailInputField;

    @FindBy(css = "#register-password")
    public WebElement passwordInputField;

    @FindBy(css = "button[class='os-btn-cl btn-cl-secondary btn-cl-lg'][type='submit']")
    public WebElement createAccountButton;

    @FindBy(css="a[href='/myaccount'][data-tid='HEAD:MY:MyActivity']")
    public WebElement myAccountButton;

    @FindBy(css="iFrame[id='loginIframe']")
    public WebElement loginIFrame;

    @FindBy(css = "input.os-input#login-email")
    public WebElement emailSignInInputField;

    @FindBy(css = "input.os-input#login-password")
    public WebElement passwordSignInInputField;

    @FindBy(css = "form#login-form button.os-btn-cl.btn-cl-primary.btn-cl-lg")
    public WebElement signInButton;

    @FindBy(xpath = "//div[text()='Sign In']")
    public WebElement signInButtonFromAccountDropMenu;

    @FindBy(css="div#ostk-search-combobox input.search_searchBar_de")
    public WebElement searchBar;

    @FindBy (css="button.search_button_00")
    public WebElement searchButton;

    @FindBy (xpath ="//a[@class='TopNav_topNavLink_13'][@data-tid='TN:Furn']")
    public WebElement furnitureHeaderDropMenu;

    @FindBy (css = "a[href='https://www.youtube.com/user/Overstock?feature=guide']")
    public WebElement navigateToYoutubeChannelButton;

    @FindBy (css="div#notification_deny")
    public WebElement denyNotificationWindowButton;

    public void registerAnAccount(String email, String password) {
        try {
            waitForElementToBeVisible(accountDropDownMenu);
            hoverOverElement(accountDropDownMenu);
            waitForElementToBeClickable(createAnAccountButton);
            clickOnElement(createAnAccountButton);
            waitForElementToBeVisible(loginIFrame);
            driver.switchTo().frame(loginIFrame);
            waitForElementToBeVisible(emailInputField);
            sendKeysToInput(emailInputField, email);
            waitForElementToBeVisible(passwordInputField);
            sendKeysToInput(passwordInputField, password);
            waitForElementToBeClickable(createAccountButton);
            clickOnElement(createAccountButton);

        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }


    }



    public WebElement loggedInConfirmation() {
        waitForElementToBeVisible(accountDropDownMenu);
        hoverOverElement(accountDropDownMenu);
        waitForElementToBeVisible(myAccountButton);
        return myAccountButton;
    }

    public void signIn(String email, String password) {
        try {
            waitForElementToBeVisible(accountDropDownMenu);
            hoverOverElement(accountDropDownMenu);
            waitForElementToBeClickable(signInButtonFromAccountDropMenu);
            clickOnElement(signInButtonFromAccountDropMenu);
            waitForElementToBeVisible(loginIFrame);
            driver.switchTo().frame(loginIFrame);
            waitForElementToBeVisible(emailSignInInputField);
            sendKeysToInput(emailSignInInputField, email);
            waitForElementToBeVisible(passwordSignInInputField);
            sendKeysToInput(passwordSignInInputField, password);
            waitForElementToBeClickable(signInButton);
            clickOnElement(signInButton);
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }


    }
    public void searchForProductOnSearchBar(String product) {
        try {
            waitForElementToBeClickable(searchBar);
            sendKeysToInput(searchBar, product);
            waitForElementToBeClickable(searchButton);
            clickOnElement(searchButton);
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public void navigateToYoutubeChannel() {
        try {
            waitForElementToBeClickable(denyNotificationWindowButton);
            clickOnElement(denyNotificationWindowButton);
            scrollJS(5700);
            waitForElementToBeClickable(navigateToYoutubeChannelButton);
            String parentTab = driver.getWindowHandle();
            clickOnElement(navigateToYoutubeChannelButton);

            webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> tabHandles = driver.getWindowHandles();

            Iterator<String> iterator = tabHandles.iterator();

            while (iterator.hasNext()) {
                String childTab = iterator.next();

                if (!childTab.equalsIgnoreCase(parentTab)) {
                    driver.switchTo().window(childTab);

                }
            }
            webDriverWait.until(ExpectedConditions.titleContains("YouTube"));
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }




}
