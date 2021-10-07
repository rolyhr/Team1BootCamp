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

    @Test(description = "ID:02", priority = 2, enabled = false)
    public void testDoNavigateToMortgageOverviewPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToMortgageOverviewPage();
        Assert.assertTrue(mortgagePage.isContentForMortgageOverviewPagePresent());

    }

    @Test(description = "ID:03", priority = 3, enabled = false)
    public void testDoNavigateToGetPreQualifiedPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToGetPreQualifiedPage();
        Assert.assertTrue(mortgagePage.isContentForPreQualifiedPagePresent());

    }

    @Test(description = "ID:04", priority = 4, enabled = false)
    public void testDoNavigateToMortgageRatesPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToMortgageRatesPage();
        Assert.assertTrue(mortgagePage.isContentForMortgageRatePagePresent());

    }

    @Test(description = "ID:05", priority = 5, enabled = false)
    public void testDoNavigateToRefinanceRatesPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToRefinanceRatesPage();
        Assert.assertTrue(mortgagePage.isContentForRefinanceRatesPage());

    }

    @Test(description = "ID:06", priority = 6, enabled = false)
    public void testDoNavigateToMortgageCalculatorPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToMortgageCalculatorPage();
        Assert.assertTrue(mortgagePage.isContentForMortgageCalculatorPagePresent());

    }

    @Test(description = "ID:07", priority = 7, enabled = false)
    public void testDoNavigateToAffordabilityCalculatorPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToAffordabilityCalculatorPage();
        Assert.assertTrue(mortgagePage.isContentForAffordabilityCalculatorPage());

    }

    @Test(description = "ID:08", priority = 8, enabled = false)
    public void testDoNavigateToRefinanceCalculatorPage() throws IOException {

        mortgagePage = getMortgagePage();
        mortgagePage.doNavigateToRefinanceCalculatorPage();
        Assert.assertTrue(mortgagePage.isContentForRefinanceCalculatorPagePresent());

    }
}
