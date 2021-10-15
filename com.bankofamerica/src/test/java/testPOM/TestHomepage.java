package testPOM;

import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestHomepage extends TestBase {

    String[][] testData;
    Homepage homepage;
    List<String> expectedList;

    @Test(description = "ID:01",priority = 1, enabled = false)
    public void testDoSignInWithInvalidIDAndPassword() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("BOALogin");
        homepage.doSignIn(testData[0][0],testData[0][1]);
        Assert.assertTrue(homepage.isWarningForInvalidCredentialPresent());

    }

    @Test(description = "ID:02",priority = 2, enabled = false)
    public void testDoResetPasswordByClickingForgetPasswordLink() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("PasswordReset");
        homepage.doResetPasswordByInvalidAccountInformation(testData[0][0],testData[0][1]);
        Assert.assertTrue(homepage.isWarningMessageForUnableToVerifyPresent());

    }


    @Test(description = "ID:03",priority = 3, enabled = false)
    public void testDoResetPasswordByProvidingInvalidAccountNumber() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("PasswordReset");
        homepage.doResetPasswordByProvidingInvalidAccountNumber(testData[1][0]);
        Assert.assertTrue(homepage.isErrorMessageForInvalid6DigitAccountNumberPresent());

    }

    @Test(description = "ID:04",priority = 4, enabled = false)
    public void testDoResetPasswordByProvidingInvalidSSN() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("PasswordReset");
        homepage.doResetPasswordByProvidingInvalidSSNNumber(testData[2][0],testData[2][1]);
        Assert.assertTrue(homepage.isErrorMessageForInvalidSSNPresent());

    }

    @Test(description = "ID:05",priority = 5, enabled = false)
    public void testDoVerifySSNHelperButton() throws IOException {

        homepage = getHomepage();
        homepage.doVerifySSNHelperButton();
        Assert.assertTrue(homepage.isContentForSSNHelperPresent());

    }

    @Test(description = "ID:06",priority = 6, enabled = false)
    public void testDoVerifyForgetPasswordCancelButton() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("PasswordReset");
        homepage.doVerifyForgetPasswordCancelButton(testData[0][0],testData[0][1]);
        String expectedURL = "https://www.bankofamerica.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test(description = "ID:07",priority = 7, enabled = false)
    public void testNavigateSecurityAndHelpLink() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        homepage.doNavigateSecurityAndHelpLink();
        String expectedURL = testData[0][0];
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test(description = "ID:08",priority = 8, enabled = false)
    public void testNavigateLocationPageForATM() throws IOException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        homepage.doNavigateFinancialCenterAndATMLocationPage();
        String expectedURL = testData[1][0];
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test(description = "ID:09",priority = 9, enabled = false)
    public void testSearchForFinancialCenterLocation() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        homepage.doSearchForFinancialCenterLocation(testData[2][1]);
        String expectedURL = testData[2][0];
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

    }

    @Test(description = "ID:10",priority = 10, enabled = false)
    public void testForCompareFilterOptionsList() throws IOException, InterruptedException {

        homepage = getHomepage();
        expectedList = getExpectedList("FilterOptions");
        List<String> actualList = homepage.getAListOfStringOfFilterOptions();
        compareListsOfString(actualList,expectedList);

    }

    @Test(description = "ID:11",priority = 11, enabled = false)
    public void testDoSearchForFinancialCenterLocationApplyingFilter() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        expectedList = getExpectedList("FilterOptions");
        String expectedResult = "38";
        homepage.doSearchForFinancialCenterLocationApplyingFilter(testData[2][1],expectedList.get(0));
        Assert.assertEquals(homepage.getTextOfFilteredResult(),expectedResult);
    }

    @Test(description = "ID:12", priority = 12, enabled = false)
    public void testDoSearchForFinancialCenterLocationApplyingDifferentFilter() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        expectedList = getExpectedList("FilterOptions");
        String expectedResult = "6";
        homepage.doSearchForFinancialCenterLocationApplyingFilter(testData[2][1],expectedList.get(7));
        Assert.assertEquals(homepage.getTextOfFilteredResult(),expectedResult);
    }

    @Test(description = "ID:13", priority = 13, enabled = false)
    public void testCompareNavigationBarMenuList() throws IOException, InterruptedException {

        homepage = getHomepage();
        expectedList = getExpectedList("NavigationBarMenu");
        List<String> actualList = homepage.getListOfNavigationBarMenu();
        Assert.assertTrue(compareListsOfString(actualList,expectedList));
    }

    @Test(description = "ID:14", priority = 14, enabled = false)
    public void testDoSearchForRoutingNumber() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchForRoutingNumber();
        Assert.assertTrue(homepage.isSearchResultForRoutingNumberPresent());
    }

    @Test(description = "ID:15", priority = 15, enabled = false)
    public void testDoSearchForErica() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchForErica();
        Assert.assertTrue(homepage.isSearchResultForEricaPresent());
    }

    @Test(description = "ID:16", priority = 16, enabled = false)
    public void testDoSearchForBillPay() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchForBillPay();
        Assert.assertTrue(homepage.isSearchResultForBillPayPresent());
    }

    @Test(description = "ID:17", priority = 17, enabled = false)
    public void testDoSearchForBillingDispute() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchForBillingDispute();
        Assert.assertTrue(homepage.isSearchResultForBillingDisputePresent());
    }

    @Test(description = "ID:18", priority = 18, enabled = false)
    public void testDoSearchBySendingSearchTerm() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchBySendingSearchTerm("OverDraft Charge");
        Assert.assertTrue(homepage.isSearchResultForSearchTermPresent());
    }

    @Test(description = "ID:19", priority = 19, enabled = false)
    public void testDoSearchBySendingSearchTermAndSelectSuggestedTopic() throws IOException, InterruptedException {

        homepage = getHomepage();
        homepage.doSearchBySendingSearchTermAndSelectSuggestedTerm("Balance");
        Assert.assertTrue(homepage.isSearchResultForSearchTermPresent());
    }

    @Test(description = "ID:20", priority = 20, enabled = false)
    public void testDoManageAppointmentBySendingEmail() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("ManageAppointment");
        homepage.doManageAppointmentBySendingEmail(testData[0][0]);
        Assert.assertTrue(homepage.isConfirmationOfAppointmentPresent());
    }

    @Test(description = "ID:21", priority = 21, enabled = false)
    public void testDoManageAppointmentBySendingConfirmationCode() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("ManageAppointment");
        homepage.doManageAppointmentBySendingConfirmationCode(testData[0][1]);
        Assert.assertTrue(homepage.isConfirmationOfAppointmentPresent());
    }

    @Test(description = "ID:22", priority = 22, enabled = true)
    public void testDoManageAppointmentBySendingConfirmationCodeAndCancel() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("ManageAppointment");
        homepage.doManageAppointmentBySendingConfirmationCodeAndCancel(testData[0][1]);
        Assert.assertTrue(homepage.isManageAppointmentButtonPresent());
    }




}
