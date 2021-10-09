package testPOM;

import POM.FantasyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestFantasyPage extends TestBase {

    FantasyPage fantasyPage;
    List<String> stringList;
    String[][] testData;

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testNavBarMenuList() throws IOException {
        fantasyPage = getFantasyPage();
        List<String> expectedList = getExpectedList("NavBarMenu");
        List<String> actualList = fantasyPage.getNavBarMenuList();
        Assert.assertTrue(fantasyPage.compareListsOfString(actualList,expectedList));
    }

    @Test(description = "Case ID: 0", priority = 2, enabled = false)
    public void testNavigateToSignUpFantasyBasketballPage() throws IOException {
        fantasyPage = getFantasyPage();
        fantasyPage.navigateToSignUpFantasyBasketballPage();
        Assert.assertTrue(fantasyPage.isContentForFantasyBasketballPagePresent());
    }

    @Test(description = "Case ID: 03", priority = 3, enabled = false)
    public void testNavigateToSignUpFantasyHockeyPage() throws IOException {
        fantasyPage = getFantasyPage();
        fantasyPage.navigateToSignUpFantasyHokeyPage();
        Assert.assertTrue(fantasyPage.isContentForFantasyHockeyPagePresent());
    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testNavigateToBaseballPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[3][0];
        fantasyPage.navigateToBaseballPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testNavigateToFootballPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[4][0];
        fantasyPage.navigateToFootballPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 06", priority = 6, enabled = false)
    public void testNavigateToGameHomePage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[5][0];
        fantasyPage.navigateToGamesHomePage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void testNavigateToBasketballPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[6][0];
        fantasyPage.navigateBasketBallPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testNavigateToHockeyPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[7][0];
        fantasyPage.navigateToHockeyPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testNavigateToStreakPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[8][0];
        fantasyPage.navigateToStreakPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 10", priority = 10, enabled = false)
    public void testNavigateToEspnAppPage() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("URL");
        String expectedURL = testData[9][0];
        fantasyPage.navigateToEspnAppPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 11", priority = 11, enabled = false)
    public void testCreateFantasyAccountWithInvalidFirstName() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[0][0],testData[0][1],testData[0][2],testData[0][3]);
        Assert.assertTrue(fantasyPage.isErrorMsgForInvalidFirstNamePresent());
    }

    @Test(description = "Case ID: 12", priority = 12, enabled = false)
    public void testCreateFantasyAccountWithInvalidLastName() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[1][0],testData[1][1],testData[1][2],testData[1][3]);
        Assert.assertTrue(fantasyPage.isErrorMsgForInvalidLastNamePresent());
    }

    @Test(description = "Case ID: 13", priority = 13, enabled = false)
    public void testCreateFantasyAccountWithInvalidEmail() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[2][0],testData[2][1],testData[2][2],testData[2][3]);
        Assert.assertTrue(fantasyPage.isErrorMsgForInvalidEmailPresent());
    }

    @Test(description = "Case ID: 14", priority = 14, enabled = false)
    public void testCreateFantasyAccountWithInvalidPassword() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[3][0],testData[3][1],testData[3][2],testData[3][3]);
        Assert.assertTrue(fantasyPage.isErrorMsgForInvalidPasswordPresent());
    }

    @Test(description = "Case ID: 15", priority = 15, enabled = false)
    public void testCreateFantasyAccountWithValidInfo() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[4][0],testData[4][1],testData[4][2],testData[4][3]);
        fantasyPage.successfulAccountCreationWindow();
        Assert.assertTrue(fantasyPage.isMsgForSuccessfulAccountCreationPresent());
    }

    @Test(description = "Case ID: 16", priority = 16, enabled = true)
    public void testCreateFantasyAccountWithExistingAccountInfo() throws IOException {
        fantasyPage = getFantasyPage();
        testData = getString2DDataFromExcelFile("CreateAccount");
        fantasyPage.createAccountForFantasyLeague(testData[4][0],testData[4][1],testData[4][2],testData[4][3]);
        Assert.assertTrue(fantasyPage.isMsgForAccountAlreadyExistsPresent());
    }

}
