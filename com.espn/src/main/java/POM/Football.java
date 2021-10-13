package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static POM.locators.FootBallLocators.*;

public class Football extends Base {
    public Football() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = FOOTBALL)
    public WebElement football;

    @FindBy(css = FOOTBALL_DROP_DOWN_MENU_CONTAINER)
    public WebElement footballDropDownMenuContainer;

    @FindBy(css = FOOTBALL_DROP_DOWN_MENU)
    public List<WebElement> footballDropDownMenu;

    @FindBy(css = FOOTBAL_ESPN_FANTASY_FOOTBALL)
    public WebElement footBallfantasyFootball;

    @FindBy(css = LOGIN_ESPN_FANTASY_FOOTBALL)
    public WebElement loginESPFantasyFootball;

    @FindBy(css  = LOGIN_EMAIL)
    public WebElement emailLogin;

    @FindBy(css  = LOGIN_PASSWORD)
    public WebElement passwordLogin;

    @FindBy(css  = LOGIN_BUTTON_)
    public WebElement loginButton;

    @FindBy(css  = LOGIN_ERROR)
    public WebElement errorLogin;

    @FindBy(id  = LOGIN_IFRAME)
    public WebElement loginIFrame;

    @FindBy(id =  LOGIN_ERROR_USERNAME)
    public WebElement loginErrorUsername;

    @FindBy(id =  LOGIN_ERROR_PASSWORD)
    public WebElement loginErrorPassword;

    @FindBy(css =  TABLE)
    public WebElement table;

    @FindBy(css = TABLE_ROWS_ENGLISH_PREMIUM_LEAGUE)
    public List<WebElement> tableRows;

    @FindBy(css = TABLE_COLUMNS_ENGLISH_PREMIUM_LEAGUE)
    public List<WebElement> tableColumns;

    @FindBy(css = YEAR_DROPDOWN)
    public WebElement yearDropDown;

    @FindBy(css = Year_DROPDOWN_CONTAINER)
    public WebElement yearDropdownContainer;

    @FindBy(css = YEAR_DROPDOWN_LIST)
    public List<WebElement> yearDropDownList;

    @FindBy(css = TEAM_POSITION_LIST)
    public List<WebElement> teamPositionList;

    @FindBy(css = TEAMS)
    public WebElement teams;

    @FindBy(css = TEAMS_LIST)
    public List<WebElement> teamsList;

    @FindBy(css = YEAR_RESULT)
    public WebElement result;


    public void clickOnFootball() {
        clickOnElement(football);
    }

    public boolean hoverOverFootball(){
        hoverOverElementWithoutCLick(football,footballDropDownMenuContainer);
        waitForElementToBeVisible(footballDropDownMenuContainer);
        if (footballDropDownMenuContainer.isDisplayed())
        {
            return true;
        }else{
            return false;
        }
    }

    public List<String> getListOfFootballDropDownMenuList(){
        return getListOfStringElements(footballDropDownMenu);
    }

    public void navigateToESPNFantasyFootball(){
        clickOnElement(footBallfantasyFootball);
        switchTab();
    }

    public void navigateToFootballTeam() throws InterruptedException {
        clickOnFootball();
        clickOnElement(teams);
        waitForElementToBeVisible(teamsList.get(0));
        System.out.println(teamsList.get(0));
    }

    public List<String> getListOfTeamlist(){
        return getListOfStringElements(teamsList);
    }

    public void switchTab(){
       String parentWindow = getCurrentWindow();
        windowHandel(parentWindow);
    }

    public void clickLoginButtonESPNFootballFantasy(){
        try {
            clickOnElement(loginESPFantasyFootball);
            switchTab();
        }catch (Exception e){
            System.out.println("Unable to click login Button");
        }

    }

    public void writeEmail(String email){
        emailLogin.sendKeys(email);
    }

    public void writePassword(String password){
        passwordLogin.sendKeys(password);
    }

    public void clickOnLoginButton(){
       clickOnElement(loginButton);
    }

    public void loginEspnFantasy(String email, String password){
        clickLoginButtonESPNFootballFantasy();
        switchTab();
        switchToIframe(loginIFrame);
        writeEmail(email);
        writePassword(password);
        clickOnLoginButton();
        waitForElementToBeVisible(errorLogin);
        waitForElementToBeVisible(loginErrorUsername);

    }
    public void loginEspnFantasyWithoutUsername(String email, String password){
        clickLoginButtonESPNFootballFantasy();
        switchTab();
        switchToIframe(loginIFrame);
        writeEmail(email);
        writePassword(password);
        clickOnLoginButton();
        waitForElementToBeVisible(loginErrorUsername);

    }

    public void loginEspnFantasyWithoutPassword(String email, String password) throws InterruptedException {
        clickLoginButtonESPNFootballFantasy();
        switchTab();
        switchToIframe(loginIFrame);
        writeEmail(email);
        writePassword(password);
        clickOnLoginButton();
        waitForElementToBeVisible(loginErrorPassword);

    }

    public void navigateToFootballTable(){
        clickOnFootball();
        clickOnElement(table);
        waitForElementToBeVisible(yearDropDown);
    }

    public List<String> accessEnglishPremierLeagueTableAttributes(int numberOfRows, int numberOfColoumns){
//        int numberOfRows = numberOfRows();
//        int numberOfColoumns = numberOfColumns();
        List<String> list = new ArrayList<String>();
        for(int i = 1; i<= numberOfRows; i++){
            for(int j = 1; j<= numberOfColoumns; j++){
                list.add(driver.findElement(By.cssSelector("#main-container  table > tbody > tr:nth-child("+i+") > td:nth-child("+j+")")).getText());
            }
        }
        return list;
    }

    public List<String> getListOfTableRows(){
        return getListOfStringElements(tableRows);
    }

    public List<String> getListOfTableColoumns(){
        return getListOfStringElements(tableColumns);
    }

    public int numberOfRows(){
        return getListOfStringElements(tableRows).size();
    }

    public int numberOfColumns(){
        return getListOfStringElements(tableColumns).size();
    }

    public List<String> getListOfTeamPosition(){
        return getListOfStringElements(teamPositionList);
    }
    public List<String> getListOfYear(){
        return getListOfStringElements(yearDropDownList);
    }

    public void clickOnYearDropDown(){
        navigateToFootballTable();
        hoverOverElement(yearDropDown,yearDropdownContainer);
        System.out.println( getListOfYear().size());
    }

    public ArrayList<String> selectAYear() throws InterruptedException {
        ArrayList<String> resultList = new ArrayList<String>();
        navigateToFootballTable();
        clickOnElement(yearDropDown);
        for(int i = 0; i<yearDropDownList.size();i++){
            waitForElementToBeVisible(yearDropdownContainer);
            clickOnElement(yearDropDownList.get(i));
            waitForElementToBeVisible(yearDropDown);
            resultList.add(yearDropDown.getText());
            clickOnElement(yearDropDown);
        }
        System.out.println(resultList);
        return  resultList;
    }



}
