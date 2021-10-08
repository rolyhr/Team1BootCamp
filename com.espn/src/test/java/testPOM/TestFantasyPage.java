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

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testNavBarMenuList() throws IOException {
        fantasyPage = getFantasyPage();
        List<String> expectedList = getExpectedList("NavBarMenu");
        List<String> actualList = fantasyPage.getNavBarMenuList();
        Assert.assertTrue(fantasyPage.compareListsOfString(actualList,expectedList));
    }

    @Test(description = "Case ID: 02", priority = 2, enabled = true)
    public void testNavigateToSignUpFantasyBasketballPage() throws IOException {
        fantasyPage = getFantasyPage();
        fantasyPage.navigateToSignUpFantasyBasketballPage();
        Assert.assertTrue(fantasyPage.isResultForFantasyBasketballPresent());
    }
}
