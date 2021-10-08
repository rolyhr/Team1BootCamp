package testPOM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomeLoans extends TestBase {
/****************************************************/
    @Test  (description = "TC001HLP",enabled = false,priority = 1)
    public void testVideoPlayButton() throws InterruptedException {

        getHomeLoans().navigateToMortgageAndHomeLoans();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");

        getHomeLoans().clickOnVideoPlayButton();
        Thread.sleep(8000);
    }
    /****************************************************/

    @Test (description = "TC002HLP",enabled = false,priority = 1)
    public void testSwitchTabPurchaseRatesTorefinanceRate() throws InterruptedException {

        getHomeLoans().navigateToMortgageAndHomeLoans();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,352)", "");
        String actualResult = getHomeLoans().clickOnrefinanceRateTabs();
        Assert.assertEquals(actualResult,"true","UNABLE TO SWITCH TAB");
    }
    /****************************************************/

    @Test (description = "TC003HLP",enabled = false,priority = 1)
    public void testIFrameTellUsMoreAboutYouSelectMultipleCheckBox() throws InterruptedException {

        getHomeLoans().navigateToMortgageAndHomeLoans();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

        getHomeLoans().navigateToRatesANDpayments();
        getHomeLoans().switchTIframeMortgageCalculator();
        getHomeLoans().expandMortgageCalculatorAdvanced();

        String actualResult = getHomeLoans().selectMultipleCheckBoxTellUSMoreAboutYou();
        String expectedResult = "true";
        Assert.assertEquals(actualResult,expectedResult,"RADIO BUTTON US CITIZEN IS NOT WORKING PROPERLY");

    }

    @Test (description = "TC004HLP",enabled = false,priority = 1)
    public void testPDFDownloadPrivateMortgageInsurance() throws InterruptedException {

        getHomeLoans().navigateToMortgageAndHomeLoans();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

        getHomeLoans().navigateToPrivateMortgageInsurancePDF();
    }


}
