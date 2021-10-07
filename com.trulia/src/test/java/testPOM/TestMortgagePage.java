package testPOM;

import POM.MortgagePage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestMortgagePage extends TestBase {

    MortgagePage mortgagePage;
    String[][] testData;

    @Test(description = "ID:01", priority = 1, enabled = false)
    public void testCompareMortgageMenuDropDownList() throws IOException {

        mortgagePage = getMortgagePage();
        List<String> expectedList = getExpectedList("DropDownList");
        mortgagePage.visibilityOfMortgageNavDropdownMenu();
        List<String > actualList = mortgagePage.getListOfDropDownOfMortgageNavMenu();
        Assert.assertTrue(compareListsOfString(actualList,expectedList));

    }

    @Test(description = "ID:02", priority = 2, enabled = true)
    public void testDoNavigateToMortgageOverviewPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToMortgageOverviewPage();
        Assert.assertTrue(mortgagePage.isContentForMortgageOverviewPagePresent());

    }
}
