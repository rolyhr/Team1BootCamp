package testPOM;

import POM.Homepage;
import POM.MLBHomePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestMLBHomePage extends TestBase {



    MLBHomePage mlbHomePage;

    List<String> testData;

    String[][] stingValue;

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testNavigateToMLBPage() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        waitForElementToBeVisible(mlbHomePage.navMLBBarMenuList);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.navMLBBarMenuList.getText();
        String expectedText = "MLB";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB WEBSITE");
    }

    @Test(description = "Case ID: 02", priority = 2, enabled = false)
    public void testHomeTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.homeTab);
        waitForElementToBeVisible(mlbHomePage.homeTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.homeTab.getText();
        String expectedText = "Home";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Home");

    }

    @Test(description = "Case ID: 3", priority = 3, enabled = false)
    public void testNavigateToscoresTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.scoresTab);
        waitForElementToBeVisible(mlbHomePage.scoresTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.scoresTab.getText();
        String expectedText = "Scores";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Scores");
    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testNavigateToScheduleTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.scheduleTab);
        waitForElementToBeVisible(mlbHomePage.scheduleTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.scheduleTab.getText();
        String expectedText = "Schedule";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Schedule");
    }


    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testNavigateToStandingTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.standingsTab);
        waitForElementToBeVisible(mlbHomePage.standingsTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.standingsTab.getText();
        String expectedText = "Standings";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Standings");
    }

    @Test(description = "Case ID: 06", priority = 6, enabled = false)
    public void testNavigateToStats() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.statsTab);
        waitForElementToBeVisible(mlbHomePage.statsTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.statsTab.getText();
        String expectedText = "Stats";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Stats");
    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void testNavigateTomlbTeamsTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.mlbTeamsTab);
        waitForElementToBeVisible(mlbHomePage.mlbTeamsTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.mlbTeamsTab.getText();
        String expectedText = "Teams";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Teams");
    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testNavigateToMLBTeamsDropDownMenu() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.mlbTeamsDropdownMenu);
        waitForElementToBeVisible(mlbHomePage.mlbTeamsDropdownMenu);
        mlbHomePage.mlbTeamsDropdownMenu.click();

    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testNavigateToDailyLines() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.dailyLinesTab);
        waitForElementToBeVisible(mlbHomePage.dailyLinesTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.dailyLinesTab.getText();
        String expectedText = "Daily Lines";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND MLB Daily lines");
    }

    @Test(description = "Case ID: 10", priority = 10, enabled = false)
    public void testNavigateToDepthChartsTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.depthChartsTab);
        waitForElementToBeVisible(mlbHomePage.depthChartsTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.depthChartsTab.getText();
        String expectedText = "Depth Charts";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB Depth Charts");


    }

    @Test(description = "Case ID: 11", priority = 11, enabled = false)
    public void testNavigateToPlayersTab() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.mlbPlayersTab);
        waitForElementToBeVisible(mlbHomePage.mlbPlayersTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.mlbPlayersTab.getText();
        String expectedText = "Players";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB Players");


    }

    @Test(description = "Case ID: 12", priority = 12, enabled = false)
    public void testNavigateToNewYorkYankees() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.mlbPlayersTab);
        waitForElementToBeVisible(mlbHomePage.mlbPlayersTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.mlbPlayersTab.getText();
        isElementPresent(getMLBhomePage().newYorkYankees);
        String expectedText = "New York Yankees";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB New York Yankees");
    }

    @Test(description = "Case ID: 13", priority = 13, enabled = false)
    public void testNavigateToRoster() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.roster);
        waitForElementToBeVisible(mlbHomePage.roster);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.roster.getText();
        isElementPresent(getMLBhomePage().roster);
        String expectedText = "Roster";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB Roster");

    }


    @Test(description = "Case ID: 14", priority = 14, enabled = false)
    public void testNavigateInjuries() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.injuries);
        waitForElementToBeVisible(mlbHomePage.injuries);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.injuries.getText();
        String expectedText = "Injuries";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB Injuries");

    }

    @Test(description = "Case ID: 15", priority = 15, enabled = false)
    public void testNavigateToTickets() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.tickets);
        waitForElementToBeVisible(mlbHomePage.tickets);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.tickets.getText();
        String expectedText = "Tickets";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB Tickets");

    }


    @Test(description = "Case ID: 16", priority = 16, enabled = false)
    public void testNavigateToMore() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.moreTab);
        waitForElementToBeVisible(mlbHomePage.moreTab);
        List<String> expectedList = getExpectedList("ESPN");
        String actualText = mlbHomePage.moreTab.getText();
        String expectedText = "More";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("FOUND MLB More");


    }

    @Test(description = "Case ID: 17", priority = 17, enabled = false)
    public void testNavigateToMoreTabDropDownMenu() throws IOException {
        Homepage homepage = getHomepage();
        MLBHomePage mlbHomePage = homepage.navigateToMLBHomePage();
        mlbHomePage.mouseHover(mlbHomePage.moreTabDropDownMenu);
        waitForElementToBeVisible(mlbHomePage.moreTabDropDownMenu);
        mlbHomePage.moreTabDropDownMenu.click();

    }



}
