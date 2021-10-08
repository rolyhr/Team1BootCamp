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

    @Test(description = "ID:09", priority = 9, enabled = false)
    public void testMortgagePaymentCalculationLoanType30Year() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[0][3];
        mortgagePage.mortgagePaymentCalculation(testData[0][0], testData[0][1], testData[0][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:10", priority = 10, enabled = false)
    public void testMortgagePaymentCalculationLoanType20Year() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[1][3];
        mortgagePage.mortgagePaymentCalculation(testData[1][0], testData[1][1], testData[1][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:11", priority = 11, enabled = false)
    public void testMortgagePaymentCalculationLoanType15Year() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[2][3];
        mortgagePage.mortgagePaymentCalculation(testData[2][0], testData[2][1], testData[2][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:12", priority = 12, enabled = false)
    public void testMortgagePaymentCalculationLoanType10Year() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[3][3];
        mortgagePage.mortgagePaymentCalculation(testData[3][0], testData[3][1], testData[3][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:13", priority = 13, enabled = false)
    public void testMortgagePaymentCalculationLoanTypeFHA30() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[4][3];
        mortgagePage.mortgagePaymentCalculation(testData[4][0], testData[4][1], testData[4][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:14", priority = 14, enabled = false)
    public void testMortgagePaymentCalculationLoanTypeFHA15() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[5][3];
        mortgagePage.mortgagePaymentCalculation(testData[5][0], testData[5][1], testData[5][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:15", priority = 15, enabled = false)
    public void testMortgagePaymentCalculationLoanTypeVA30() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[6][3];
        mortgagePage.mortgagePaymentCalculation(testData[6][0], testData[6][1], testData[6][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }

    @Test(description = "ID:16", priority = 16, enabled = false)
    public void testMortgagePaymentCalculationLoanTypeVA15() throws IOException, InterruptedException {

        mortgagePage = getMortgagePage();
        testData = getString2DDataFromExcelFile("MortgageCalculator");
        String expectedPayment = testData[7][3];
        mortgagePage.mortgagePaymentCalculation(testData[7][0], testData[7][1], testData[7][2]);
        String actualPayment = mortgagePage.getMortgagePaymentAmount();
        Assert.assertEquals(actualPayment, expectedPayment);

    }
}
