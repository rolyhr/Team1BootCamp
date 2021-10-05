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
    public void tesForCompareFilterOptionsList() throws IOException, InterruptedException {

        homepage = getHomepage();
        expectedList = getExpectedList("FilterOptions");
        List<String> actualList = homepage.getAListOfStringOfFilterOptions();
        compareListsOfString(actualList,expectedList);

    }

    @Test(description = "ID:11",priority = 11, enabled = true)
    public void tesdoSearchForFinancialCenterLocationApplyingFilter() throws IOException, InterruptedException {

        homepage = getHomepage();
        testData = getString2DDataFromExcelFile("URL");
        expectedList = getExpectedList("FilterOptions");
        homepage.doSearchForFinancialCenterLocationApplyingFilter(testData[2][1],expectedList.get(0));
        Assert.assertEquals("","");
    }

}
