package testPOM;

import POM.Homepage;
import POM.NFLHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestNFLHomePage extends TestBase {

    NFLHomePage mlbHomePage;

    List<String> testData;

    String[][] stingValue;

    @Test(description = "Case ID: 01", priority = 1, enabled = true)
    public void testNavigateToNFLPage() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
//        waitForElementToBeVisible(nflHomePage.navNFLBarMenuList);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.navNFLBarMenuList.getText();
        String expectedText = "";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL WEBSITE");
    }

    @Test(description = "Case ID: 02", priority = 2, enabled = false)
    public void testHomeTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().homeTab);
        waitForElementToBeVisible(nflHomePage.homeTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.homeTab.getText();
        String expectedText = "HOME";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL Home");

    }

    @Test(description = "Case ID: 03", priority = 3, enabled = false)
    public void testScoresTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().scoresTab);
        waitForElementToBeVisible(nflHomePage.scoresTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.scoresTab.getText();
        String expectedText = "SCORES";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL SCORES");

    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testScheduleTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().scheduleTab);
        waitForElementToBeVisible(nflHomePage.scheduleTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.scheduleTab.getText();
        String expectedText = "SCHEDULE";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL SCHEDULE");

    }

    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testStandingsTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().standingsTab);
        waitForElementToBeVisible(nflHomePage.standingsTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.standingsTab.getText();
        String expectedText = "STANDINGS";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL STANDINGS");

    }

    @Test(description = "Case ID: 6", priority = 6, enabled = false)
    public void testNflTeamsTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().nflTeamsTab);
        waitForElementToBeVisible(nflHomePage.nflTeamsTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.nflTeamsTab.getText();
        String expectedText = "TEAMS";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL TEAMS");

    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void testStatsTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().statsTab);
        waitForElementToBeVisible(nflHomePage.statsTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.statsTab.getText();
        String expectedText = "STATS";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL STATS");

    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testIconMoonNavMenuBarTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.iconMoonNavMenuBar);
        //clickOnElement(getNFLhomePage().iconMoonNavSubMenuBar);
        waitForElementToBeVisible(nflHomePage.iconMoonNavMenuBar);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.iconMoonNavMenuBar.getText();
        String expectedText = "";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL IconMoonNavMenuBar");

    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testIconMoonNavSubMenuPlayersBar() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.iconMoonNavMenuBar);
        waitForElementToBeVisible(nflHomePage.playersTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.playersTab.getText();
        String expectedText = "PLAYERS";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL PLAYERS");

    }

    @Test(description = "Case ID: 10", priority = 10, enabled = false)
    public void testPlayHoverOverTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.playTab);
//        nflHomePage.clickJScript(getNFLhomePage().homeTab);
        waitForElementToBeVisible(nflHomePage.playTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.playTab.getText();
        String expectedText = "PLAY";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL PLAY");

    }

    @Test(description = "Case ID: 11", priority = 11, enabled = false)
    public void testWatchHoverOverTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.watchMenuTabBar);
//        nflHomePage.clickJScript(getNFLhomePage().playTab);
        waitForElementToBeVisible(nflHomePage.watchMenuTabBar);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.watchMenuTabBar.getText();
        String expectedText = "WATCH";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL WATCH");

    }

    @Test(description = "Case ID: 12", priority = 12, enabled = false)
    public void testBetHoverOverTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.betMenuTabBar);
//        nflHomePage.clickJScript(getNFLhomePage().homeTab);
        waitForElementToBeVisible(nflHomePage.betMenuTabBar);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.betMenuTabBar.getText();
        String expectedText = "BET";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL BET");

    }

    @Test(description = "Case ID: 13", priority = 13, enabled = false)
    public void testPodCastsHoverOverTab() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.mouseHover(nflHomePage.podcastsTab);
//        nflHomePage.clickJScript(getNFLhomePage().homeTab);
        waitForElementToBeVisible(nflHomePage.podcastsTab);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.podcastsTab.getText();
        String expectedText = "PODCASTS";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL PODCASTS");

    }

    @Test(description = "Case ID: 14", priority = 14, enabled = true)
    public void testLoginButton() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().loginButton);
        waitForElementToBeVisible(nflHomePage.loginButton);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.loginButton.getText();
        String expectedText = "LOG IN";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL LOGIN");

    }

    @Test(description = "Case ID: 15", priority = 15, enabled = false)
    public void testdontHaveAnyAccountSignUpLink() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        nflHomePage.clickJScript(getNFLhomePage().loginButton);
        nflHomePage.clickJScript(getNFLhomePage().dontHaveAnyAccountSignUp);
        waitForElementToBeVisible(nflHomePage.dontHaveAnyAccountSignUp);
        List<String> expectedList = getExpectedList("CBSSports");
        String actualText = nflHomePage.dontHaveAnyAccountSignUp.getText();
        String expectedText = "Dont have an Account?Sign Up?";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND NFL Dont have an Account?Sign Up?");

    }
    @Test(description = "Case ID: 16", priority = 16, enabled = true)
    public void testRegistrationPage() throws IOException {
        Homepage homepage = getHomepage();
        NFLHomePage nflHomePage = homepage.navigateToNFLHomePage();
        clickOnElement(nflHomePage.loginButton);
        clickOnElement(nflHomePage.dontHaveAnyAccountSignUp);
        clickOnElement(nflHomePage.registrationPage);
        sendKeysToElement(nflHomePage.inputEmail,"john@gmail.com");
        clickOnElement(nflHomePage.inputEmail);
        sendKeysToElement(nflHomePage.inputPassword,"John12345!");
        clickOnElement(nflHomePage.inputPassword);
        sendKeysToElement(nflHomePage.inputConformPassword,"John12345!");
        clickOnElement(nflHomePage.inputConformPassword);
        sendKeysToElement(nflHomePage.inputFirstName,"John");
        clickOnElement(nflHomePage.inputFirstName);
        sendKeysToElement(nflHomePage.inputLastName,"Smith");
        clickOnElement(nflHomePage.inputLastName);
        sendKeysToElement(nflHomePage.inputBirthDateMonth,"January");
        clickOnElement(nflHomePage.inputBirthDateMonth);
        sendKeysToElement(nflHomePage.inputBirthDateDay,"10");
        clickOnElement(nflHomePage.inputBirthDateDay);
        sendKeysToElement(nflHomePage.inputBirthDateYear,"1979");
        clickOnElement(nflHomePage.inputBirthDateYear);
        sendKeysToElement(nflHomePage.inputZipCode,"12345");
        clickOnElement(nflHomePage.inputZipCode);
        waitForElementToBeVisible(nflHomePage.privacyPolicyCheckBox);
        clickOnElement(nflHomePage.privacyPolicyCheckBox);
        clickJScript(nflHomePage.registerTab);
        String actualText = nflHomePage.inputEmail.getText();
        String expectedText = "";
        Assert.assertEquals(actualText, expectedText);

    }
}
