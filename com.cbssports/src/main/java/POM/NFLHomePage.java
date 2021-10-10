package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NFLHomePage extends Base {

    public NFLHomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"cbs-site-nav\"]/div/div[1]/div/div[3]/a/span")
    public WebElement navNFLBarMenuList;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[1]/a")
    public WebElement homeTab;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[2]/a")
    public WebElement scoresTab;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[3]/a")
    public WebElement scheduleTab;

    @FindBy (xpath ="//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[4]/a")
    public WebElement standingsTab;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[5]/a")
    public WebElement nflTeamsTab;

    @FindBy(xpath="//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[6]/a")
    public WebElement statsTab;

    @FindBy(xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[20]/span")
    public WebElement iconMoonNavMenuBar;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[20]/ul/li[6]/a")
    public WebElement iconMoonNavSubMenuBar;

    @FindBy (xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[7]/div/ul[1]/li[3]/a")
    public WebElement playersTab;

//    @FindBy(xpath="///*[@id=\"gridContainer\"]/div/div[1]/h1")
//    public WebElement nflPlayerPageHeader;

    @FindBy(xpath="//*[@id=\"GlobalNav-dropdown--games\"]/span[1]")
    public WebElement playTab;

    @FindBy(xpath="//*[@id=\"cbs-site-nav\"]/div/div[2]/ul/li[2]/span[1]")
    public WebElement watchMenuTabBar;

    @FindBy(xpath="//*[@id=\"GlobalNav-dropdown--bet\"]/span[1]")
    public WebElement betMenuTabBar;

    @FindBy(xpath="//*[@id=\"cbs-site-nav\"]/div/div[2]/ul/li[4]/span[1]")
    public WebElement podcastsTab;

    @FindBy(xpath="//*[@id=\"cbs-site-nav\"]/div/div[2]/ul/li[5]/a/span")
    public WebElement loginButton;

    @FindBy(xpath="//*[@id=\"page-content\"]/div/div[2]/a[2]")
    public WebElement dontHaveAnyAccountSignUp;

    @FindBy(xpath="//*[@id=\"uRegContainer\"]/div/h5")
    public WebElement registrationPage;

    @FindBy (xpath = "//*[@id=\"email\"]")
    public WebElement inputEmail;

    @FindBy (xpath = "//*[@id=\"password\"]")
    public WebElement inputPassword;

    @FindBy (xpath = "//*[@id=\"password2\"]")
    public WebElement inputConformPassword;

    @FindBy (xpath = "//*[@id=\"firstname\"]")
    public WebElement inputFirstName;

    @FindBy (xpath = "//*[@id=\"lastname\"]")
    public WebElement inputLastName;

    @FindBy (xpath = "//*[@id=\"birthdate_month\"]")
    public WebElement inputBirthDateMonth;

    @FindBy (xpath = "//*[@id=\"birthdate_day\"]")
    public WebElement inputBirthDateDay;

    @FindBy (xpath = "//*[@id=\"birthdate_year\"]")
    public WebElement inputBirthDateYear;

    @FindBy (xpath = "//*[@id=\"zip\"]")
    public WebElement inputZipCode;

    @FindBy (xpath = "//*[@id=\"privacy_policy_optin\"]")
    public WebElement privacyPolicyCheckBox;

    @FindBy (xpath="//*[@id=\"user_data\"]/div[1]/div[3]/input")
    public WebElement registerTab;




    void clickOnhomepageTab(){
        clickOnElement(homeTab);
    }


    void clickOnScoresPage(){
        clickJScript(scoresTab);
    }

    void clickOnSchedulesPage(){
        clickJScript(scheduleTab);
    }

    void clickOnStandingsPage(){
        clickJScript(standingsTab);
    }

    void clickOnNflTeamsPage(){
        clickJScript(nflTeamsTab);
    }

    void clickOnStatsTab(){
        clickJScript(statsTab);
    }

    void mouseHoverOnIconMoonNavMenuBar(){
        clickJScript(iconMoonNavMenuBar);
    }

    void mouseHoverOnIconMoonNavSubMenuBar(){
        clickJScript(iconMoonNavSubMenuBar);
    }

    void mouseHoverOnIconMoonNavSubMenuPlayersBar(){
        clickJScript(playersTab);
//        nflPlayerPageHeader.getText();
    }

    public void mouseHoverPlayTabBar(){
        clickJScript(playTab);
    }

    public void mouseHoverWatchMenuTabBar(){
        clickJScript(watchMenuTabBar);

    }

    public void mouseHoverBetMenuTabBar(){
        clickJScript(betMenuTabBar);
    }

    public void mouseHoverPodcastsTab(){
        clickJScript(podcastsTab);
    }

    public void clickOnLoginButton(){
        clickJScript(loginButton);
    }

    public void clickOnDontHaveAnyAccountSignUplink(){
        clickJScript(dontHaveAnyAccountSignUp);
    }


    public void NavigateToRegisterPage(){
        clickJScript(registrationPage);


    }

    public void clickOnPrivacyPolicyBox(){
        clickJScript(privacyPolicyCheckBox);
    }

    public void clickOnRegisterTab(){
        clickJScript(registerTab);
    }





}
