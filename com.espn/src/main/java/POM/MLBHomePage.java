package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MLBHomePage extends Base {

    public MLBHomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[1]/span/a/span[2]")
    public WebElement navMLBBarMenuList;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[2]/a/span[1]")
    public WebElement homeTab;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[3]/a/span[1]")
    public WebElement currentYearPlayoffPage;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[4]/a/span[1]")
    public WebElement scoresTab;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[5]/a/span[1]")
    public WebElement scheduleTab;

    @FindBy (xpath ="//*[@id=\"global-nav-secondary\"]/div/ul/li[6]/a/span[1]")
    public WebElement standingsTab;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[7]/a/span[1]")
    public WebElement statsTab;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[8]/a/span[1]")
    public WebElement mlbTeamsTab;

    @FindBy(xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[8]/a")
    public WebElement mlbTeamsDropdownMenu;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[9]/a/span[1]")
    public WebElement dailyLinesTab;

    @FindBy(xpath="//*[@id=\"global-nav-secondary\"]/div/ul/li[10]/a/span[1]")
    public WebElement depthChartsTab;

    @FindBy(xpath="//*[@id=\"global-nav-secondary\"]/div/ul/li[11]/a/span[1]")
    public WebElement mlbPlayersTab;

    @FindBy(xpath="//*[@id=\"my-players-table\"]/div[1]/div/div[2]/ul/li[3]/div/a")
    public WebElement newYorkYankees;

    @FindBy(xpath="//*[@id=\"nav-menu-item-6926\"]/span")
    public WebElement roster;

    @FindBy(xpath="//*[@id=\"nav-menu-item-116\"]/span")
    public WebElement injuries;

    @FindBy(xpath="//*[@id=\"nav-menu-item-9054\"]/span")
    public WebElement tickets;

    @FindBy(xpath="//*[@id=\"global-nav-secondary\"]/div/ul/li[12]/a/span[1]")
    public WebElement moreTab;

    @FindBy (xpath = "//*[@id=\"global-nav-secondary\"]/div/ul/li[10]/a/span[1]")
    public WebElement moreTabDropDownMenu;


    void clickOnhomepageTab(){
        clickOnElement(homeTab);}

    void clickOnCurrentYearPlayoffPage(){
        clickJScript(currentYearPlayoffPage);}

    void clickOnScoresPage(){
        clickJScript(scoresTab);}

    void clickOnSchedulesPage(){
        clickJScript(scheduleTab);}

    void clickOnStandingsPage(){
        clickJScript(standingsTab);
    }

    void clickOnStatsPage(){
        clickJScript(statsTab);}

    void clickOnmlbTeamsPage(){
        clickJScript(mlbTeamsTab);}

    void clickOnmlbTeamsDropdownMenu(){
        clickJScript(mlbTeamsDropdownMenu);}

    void clickOnDailyLinespage(){
        clickJScript(dailyLinesTab);}

    public void navigateToDepthChartspage(){
        clickJScript(depthChartsTab);

    }

    public void mlbPlayerspage(){
        clickJScript(mlbPlayersTab);
    }

    public void newYorkYankees(){
        clickJScript(newYorkYankees);
    }

    public void rosterPage(){
        clickJScript(roster);
    }

    public void injuriesPage(){
        clickJScript(injuries);
    }

    public void tickets(){
        clickJScript(tickets);
    }

    public void moreTab(){
        clickJScript(moreTab);
    }

    public void moreTabDropDownMenu(){
        clickJScript(moreTabDropDownMenu);
    }











}
