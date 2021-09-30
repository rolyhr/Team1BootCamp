package testPOM;

import POM.Mortgage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestMortgage extends TestBase {

    @Test (description = "TC001MC", enabled = false)
    public void testMortgageCalculateWithPercentage() {
        Mortgage mortgage = new Mortgage();
        mortgage.navigateToMortgageRatePage();
        mortgage.calculateMortgageRateWithPercentage();
        //Do assertion...
    }

    @Test (description = "TC002MC", enabled = false)
    public void testMortgageCalculateWithDollarAmount() {
        Mortgage mortgage = new Mortgage();
        mortgage.navigateToMortgageRatePage();
        mortgage.calculateMortgageRateWithDollarAmount();
        //Do assertion...
    }

    @Test (description = "TC003MC", enabled = true)
    public void testMortgageCalculateWithWithAdvanceOptions() {
        Mortgage mortgage = new Mortgage();
        mortgage.navigateToMortgageRatePage();
        mortgage.calculateMortgageRateWithAdvanceOptions();
        //Do assertion...
    }
}
