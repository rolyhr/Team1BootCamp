package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FantasyPage extends Base {

    public FantasyPage(){
        PageFactory.initElements(driver,this);}

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
    WebElement espnAppMenu;

    @FindBy(xpath = "//*[@id=\"fitt-analytics\"]//span[text() = 'Fantasy Basketball']")
    WebElement contentFantasyBasketballPage;



    public boolean isResultForFantasyBasketballPresent(){return isElementPresent(contentFantasyBasketballPage);}
    void clickOnNavMenuSignUpFantasyBasketball(){clickOnElement(signUpFantasyBasketballMenu);}
    void clickOnNavMenuSignUpFantasyHockey(){clickOnElement(signUpFantasyHockeyMenu);}
    void clickOnNavMenuBaseBall(){clickOnElement(baseBallMenu);}
    void clickOnNavMenuFootBall(){clickOnElement(footBallMenu);}
    void clickOnNavMenuGamesHome(){clickOnElement(gamesHomeMenu);}
    void clickOnNavMenuBasketBall(){clickOnElement(basketBallMenu);}
    void clickOnNavMenuHockey(){clickOnElement(hockeyMenu);}
    void clickOnNavMenuStreak(){clickOnElement(streakMenu);}
    void clickOnNavMenuEspnApp(){clickOnElement(espnAppMenu);}




    public void navigateToSignUpFantasyBasketballPage(){
        clickOnNavMenuSignUpFantasyBasketball();
        waitForElementToBeVisible(contentFantasyBasketballPage);
    }

    public List<String> getNavBarMenuList(){
        return getStringListFromADiv(By.xpath("/*[@class = 'global-nav-container']//li//span[2]"));}



}
