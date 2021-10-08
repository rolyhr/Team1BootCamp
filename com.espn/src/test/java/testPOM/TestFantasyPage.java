package testPOM;

import POM.FantasyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestFantasyPage extends TestBase {

    FantasyPage fantasyPage;
    List<String> testData;

    String[][] stingValue;

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
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[3][0];
        fantasyPage.navigateToBaseballPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testNavigateToFootballPage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[4][0];
        fantasyPage.navigateToFootballPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 06", priority = 6, enabled = false)
    public void testNavigateToGameHomePage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[5][0];
        fantasyPage.navigateToGamesHomePage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void testNavigateToBasketballPage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[6][0];
        fantasyPage.navigateBasketBallPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testNavigateToHockeyPage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[7][0];
        fantasyPage.navigateToHockeyPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testNavigateToStreakPage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[8][0];
        fantasyPage.navigateToStreakPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "Case ID: 10", priority = 10, enabled = false)
    public void testNavigateToEspnAppPage() throws IOException {
        fantasyPage = getFantasyPage();
        stingValue = getString2DDataFromExcelFile("URL");
        String expectedURL = stingValue[9][0];
        fantasyPage.navigateToEspnAppPage();
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }
}
