package testPOM;

import POM.NBA;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;

public class TestNBA extends TestBase {

    NBA nba;

    @Test(description = "TC001NBA", priority = 1, enabled = false)
    public void testNBApage() throws Exception {
        nba = new NBA();
        String actualTitle = nba.validateNBAPage();
        String [] expectedNBApageTitleArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir")+ "\\src\\main\\resources\\ESPNnbapageElements.xlsx","ESPNnbaTitle");
        String expectedNBApageTitle = expectedNBApageTitleArray[0];
        System.out.println("Expected Page Title: " + expectedNBApageTitle);
        Assert.assertEquals(actualTitle,expectedNBApageTitle,"NBApage Title does not match");
    }

    @Test(description = "TC002NBA", priority = 2, enabled = false)
    public void testESPNPlusList() throws Exception{
        nba = new NBA();
        nba.validateESPNPlusLinkList();
    }

    @Test(description = "TC003NBA", priority = 3, enabled = false)
    public void testQuickLinks() throws Exception{
        nba = new NBA();
        nba.validateESPNQuickLinks();
    }

    @Test(description = "TC004NBA", priority = 4, enabled = false)
    public void testStatsList() throws Exception{
        nba = new NBA();
        nba.getNBAPage();
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < 4;i++) {
            String actualText =  nba.getStatsListText(i);
            System.out.println(actualText);
            String expectedStatsList = nba.validateStatsList(i);
            softAssert.assertEquals(actualText, expectedStatsList, "Stats list at index of " + i + " " + "Does not match");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC005NBA", priority = 5, enabled = false)
    public void testTeamsCategories() throws Exception {
        nba = new NBA();
        nba.validateTeamsList();
    }

    @Test(description = "TC006NBA", priority = 6, enabled = false)
    public void testPodcastList() throws Exception {
        nba = new NBA();
        nba.validatePodcastsList();
    }

    @Test(description = "TC007NBA", priority = 7, enabled = false)
    public void testFantasyList() throws Exception {
        nba = new NBA();
        nba.validateFantasyList();
    }

    @Test(description = "TC008NBA", priority = 8, enabled = false)
    public void testESPNSitesList() throws Exception {
        nba = new NBA();
        nba.validateESPNSitesList();
    }

    @Test(description = "TC009NBA", priority = 9, enabled = false)
    public void testESPNAppsList() throws Exception {
        nba = new NBA();
        nba.validateESPNAppsList();
    }

    @Test(description = "TC010NBA", priority = 10, enabled = false)
    public void testFollowESPNList() throws Exception {
        nba = new NBA();
        nba.validateFollowESPNList();
    }

    @Test(description = "TC011NBA", priority = 11, enabled = false)
    public void testTopEventsDropdownListSize(){
        nba = new NBA();
        nba.getNBAPage();
        nba.topEventsDropdownList();
        nba.validateTopEventsDropdownListSizeAndLinks();
    }

    @Test(description = "TC012NBA", priority = 12, enabled = false)
    public void testESPNFooter() throws Exception {
        nba = new NBA();
        nba.validateESPNFooterList();
    }

    @Test(description = "TC013NBA", priority = 13, enabled = false)
    public void testNBADropdownMenuLeftItemsCountAndText() throws IOException {
        nba = new NBA();
        nba.getNBADropdownMenuLeft();
        nba.validateNBADropdownMenuLeftSize();
        nba.validateNBADropdownMenuLeftItemsText();
    }

}
