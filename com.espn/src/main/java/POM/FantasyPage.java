package POM;

import base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FantasyPage extends Base {

    public FantasyPage(){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li//span[2]")
    WebElement navBarMenuList;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[2]//a")
    WebElement signUpFantasyBasketballMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[3]//a")
    WebElement signUpFantasyHockeyMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[4]//a")
    WebElement baseBallMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[5]//a")
    WebElement footBallMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[6]//a")
    WebElement gamesHomeMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[7]//a")
    WebElement basketBallMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[8]//a")
    WebElement hockeyMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[9]//a")
    WebElement streakMenu;

    @FindBy(xpath = "//*[@class = 'global-nav-container']//li[10]//a")
    WebElement espnFantasyAppMenu;

    @FindBy(xpath = "//*[@id=\"fitt-analytics\"]//span[text() = 'Fantasy Basketball']")
    WebElement contentFantasyBasketballPage;

    @FindBy(xpath = "//*[@id=\"fitt-analytics\"]//span[text() = 'Fantasy Hockey']")
    WebElement contentFantasyHockeyPage;

    @FindBy(css = "#sideLogin-left-rail > button.button.med")
    WebElement signUpButton;

    @FindBy(css = "#sideLogin-left-rail > button.button-alt.med")
    WebElement loginButton;

    @FindBy(css = ".ng-scope > div > header > h1")
    WebElement createAccountWindow;

    @FindBy(css = "#did-ui-view label input[name='firstName']")
    WebElement firstNameInputField;

    @FindBy(css = "#did-ui-view label input[name='lastName']")
    WebElement lastNameInputField;

    @FindBy(css = "#did-ui-view label input[name='email']")
    WebElement emailInputField;

    @FindBy(css = "#did-ui-view label input[name='newPassword']")
    WebElement passwordInputField;

    @FindBy(css = "#did-ui-view button[type = 'submit']")
    WebElement createAccountSignUpButton;

    @FindBy(xpath = "//*[@id=\"notification-create-error-firstName\"]/div/div")
    WebElement errorMsgForFirstName;

    @FindBy(xpath = "//*[@id=\"notification-create-error-lastName\"]/div/div")
    WebElement errorMsgForLastName;

    @FindBy(xpath = "//*[@id=\"notification-create-error-email\"]/div/div")
    WebElement errorMsgForEmail;

    @FindBy(xpath = "//*[@id=\"notification-create-error-newPassword\"]/div/div")
    WebElement errorMsgForPassword;

    @FindBy(css = "#did-ui-view > div > section > section > h2")
    WebElement msgForSuccessfulAccountCreation;

    @FindBy(css = "#notification-create-error-email > div > div")
    WebElement msgAccountAlreadyExist;

    @FindBy(css = "#did-ui-view > div > header")
    WebElement logInAccountWindow;

    @FindBy(css = "#did-ui-view div.btn-group.touch-print-btn-group-wrapper > button")
    WebElement logInButtonToLogIn;

    @FindBy(css = "#did-ui-view div:nth-child(1) > div > label > span.input-wrapper > input")
    WebElement logInEmailInputField;

    @FindBy(css = "#did-ui-view div:nth-child(2) > div span.input-wrapper > input")
    WebElement logInPasswordInputField;

    @FindBy(xpath = "//*[@id=\"did-ui-view\"]//div[@ng-repeat = 'item in parsedItems']")
    WebElement errorMsgForInvalidCredential;

    @FindBy(css = "#global-header ul.account-management > li.display-user")
    WebElement userNameVisible;

    @FindBy(xpath = "//*[@id=\"global-header\"]//a[text() = 'Log Out']")
    WebElement logOutButton;

    @FindBy(css = "#global-user-trigger")
    WebElement globalUserIcon;

    public boolean isLogInButtonAvailable(){return isElementPresent(loginButton);}

    void clickOnLogoutButton(){clickJScript(logOutButton);}

    public boolean isUserNameVisible(){return isElementPresent(userNameVisible);}

    void mouseHoverGlobalUserIcon(){mouseHoverOnAnElement(globalUserIcon);}

    public boolean isErrorMsgForInvalidCredentialPresent(){return isElementPresent(errorMsgForInvalidCredential);}

    void clickOnLoginButtonToLogIn(){clickOnElement(logInButtonToLogIn);}

    void sendPasswordToLogInAccount(String password){sendKeysToElement(logInPasswordInputField,password);}

    void sendEmailToLogInAccount(String email){sendKeysToElement(logInEmailInputField,email);}

    public boolean isMsgForAccountAlreadyExistsPresent(){return isElementPresent(msgAccountAlreadyExist);}

    public void successfulAccountCreationWindow(){waitForElementToBeVisibleForStaleElement(msgForSuccessfulAccountCreation);}

    public boolean isMsgForSuccessfulAccountCreationPresent(){return isElementPresent(msgForSuccessfulAccountCreation);}

    public boolean isErrorMsgForInvalidPasswordPresent(){return isElementPresent(errorMsgForPassword);}

    public boolean isErrorMsgForInvalidEmailPresent(){return isElementPresent(errorMsgForEmail);}

    public boolean isErrorMsgForInvalidLastNamePresent(){return isElementPresent(errorMsgForLastName);}

    public boolean isErrorMsgForInvalidFirstNamePresent(){return isElementPresent(errorMsgForFirstName);}

    void clickOnCreateAccountSignUpButton(){clickOnElement(createAccountSignUpButton);}

    void sendPasswordToInputField(String password){sendKeysToElement(passwordInputField,password);}

    void sendEmailToInputField(String email){sendKeysToElement(emailInputField,email);}

    void sendLastNameToInputField(String lastName){sendKeysToElement(lastNameInputField,lastName);}

    void sendFirstNameToInputField(String firstName){sendKeysToElement(firstNameInputField,firstName);}

    void clickOnLoginButton(){clickOnElement(loginButton);}

    void clickOnSignUpButton(){clickOnElement(signUpButton);}

    public boolean isContentForFantasyHockeyPagePresent(){return isElementPresent(contentFantasyHockeyPage);}

     public boolean isContentForFantasyBasketballPagePresent(){return isElementPresent(contentFantasyBasketballPage);}

    void clickOnNavMenuSignUpFantasyBasketball(){clickOnElement(signUpFantasyBasketballMenu);}

    void clickOnNavMenuSignUpFantasyHockey(){clickJScript(signUpFantasyHockeyMenu);}

    void clickOnNavMenuBaseBall(){clickJScript(baseBallMenu);}

    void clickOnNavMenuFootBall(){clickJScript(footBallMenu);}

    void clickOnNavMenuGamesHome(){clickJScript(gamesHomeMenu);}

    void clickOnNavMenuBasketBall(){clickJScript(basketBallMenu);}

    void clickOnNavMenuHockey(){clickJScript(hockeyMenu);}

    void clickOnNavMenuStreak(){clickJScript(streakMenu);}

    void clickOnNavMenuEspnApp(){clickJScript(espnFantasyAppMenu);}

    public void navigateToEspnAppPage(){
        clickOnNavMenuEspnApp();
    }

    public void navigateToStreakPage(){
        clickOnNavMenuStreak();
    }

    public void navigateToHockeyPage(){
        clickOnNavMenuHockey();
    }

    public void navigateBasketBallPage(){
        clickOnNavMenuBasketBall();
    }

    public void navigateToGamesHomePage(){
        clickOnNavMenuGamesHome();
    }

    public void navigateToFootballPage(){
        clickOnNavMenuFootBall();
    }

    public void navigateToBaseballPage(){
        clickOnNavMenuBaseBall();
    }


    public void logInToFantasyLeagueAccountAndLogOut(String email, String password){

        clickOnLoginButton();
        switchToiFrame("disneyid-iframe");
        waitForElementToBeVisibleForStaleElement(logInAccountWindow);
        sendEmailToLogInAccount(email);
        sendPasswordToLogInAccount(password);
        clickOnLoginButtonToLogIn();
        waitForElementToBeVisible(globalUserIcon);
        mouseHoverGlobalUserIcon();
        clickOnLogoutButton();
        waitForElementToBeVisible(loginButton);
    }

    public void logInToFantasyLeagueAccountWithInvalidCredential(String email, String password){

        clickOnLoginButton();
        switchToiFrame("disneyid-iframe");
        waitForElementToBeVisibleForStaleElement(logInAccountWindow);
        sendEmailToLogInAccount(email);
        sendPasswordToLogInAccount(password);
        clickOnLoginButtonToLogIn();
        waitForElementToBeVisible(errorMsgForInvalidCredential);
    }

    public void logInToFantasyLeagueAccount(String email, String password){

        clickOnLoginButton();
        switchToiFrame("disneyid-iframe");
        waitForElementToBeVisibleForStaleElement(logInAccountWindow);
        sendEmailToLogInAccount(email);
        sendPasswordToLogInAccount(password);
        clickOnLoginButtonToLogIn();
        waitForElementToBeVisible(globalUserIcon);
        mouseHoverGlobalUserIcon();
    }

    public void createAccountForFantasyLeague(String firstName, String lastName, String email, String password){
        clickOnSignUpButton();
        switchToiFrame("disneyid-iframe");
        waitForElementToBeVisibleForStaleElement(createAccountWindow);
        sendFirstNameToInputField(firstName);
        sendLastNameToInputField(lastName);
        sendEmailToInputField(email);
        sendPasswordToInputField(password);
        clickOnCreateAccountSignUpButton();
    }

    public void navigateToSignUpFantasyHokeyPage(){
        clickOnNavMenuSignUpFantasyHockey();
        waitForElementToBeVisible(contentFantasyHockeyPage);
    }

    public void navigateToSignUpFantasyBasketballPage(){
        clickOnNavMenuSignUpFantasyBasketball();
        waitForElementToBeVisible(contentFantasyBasketballPage);
    }

    public List<String> getNavBarMenuList(){
        return getStringListFromADiv(By.xpath("/*[@class = 'global-nav-container']//li//span[2]"));}

}
