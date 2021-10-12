package testPOM;

import POM.Homepage;
import POM.MercedesBenzMyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestMercedesBenzMyAccountPage extends TestBase {

    Homepage homepage;

    List<String> testData;

    String[][] stingValue;

    @Test(description = "Case ID: 01", priority = 1, enabled = true)
    public void testNavigateToMercedesBenzMyAccountPage() throws IOException {
        Homepage homepage = getHomepage();
        MercedesBenzMyAccountPage myAccountPage = homepage.navigateToMercedesBenzPageMyAccount();
        clickOnElement(homepage.myAccountTab);
        List<String> expectedList = getExpectedList("Mercedes-Benz");
        String actualText = homepage.myAccountTab.getText();
        String expectedText = "My Account";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Found MercedesBenzMyAccountPage Website");
    }


    @Test(description = "Case ID: 02", priority = 2, enabled = true)
    public void testNavigateToLoginOrRegisterPage() throws IOException {
        Homepage homepage = getHomepage();
        MercedesBenzMyAccountPage myAccountPage = homepage.navigateToMercedesBenzPageMyAccount();
        waitForElementToBeVisible(myAccountPage.registerTab);
        clickOnElement(myAccountPage.registerTab);
        List<String> expectedList = getExpectedList("Mercedes-Benz");
        String actualText = myAccountPage.registerTab.getText();
        String expectedText = "Register";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Found MercedesBenzRegister Page");
    }

    @Test(description = "Case ID: 03", priority = 3, enabled = true)
    public void testNavigateToCreateUserAccountPage() throws IOException {
        Homepage homepage = getHomepage();
        MercedesBenzMyAccountPage myAccountPage = homepage.navigateToMercedesBenzPageMyAccount();
        waitForElementToBeVisible(myAccountPage.registerTab);
        clickOnElement(myAccountPage.registerTab);
        clickOnElement(myAccountPage.createUserAccount);
        sendKeysToElement(myAccountPage.inputEmailAddress, "john@gmail.com");
        sendKeysToElement(myAccountPage.inputFirstName,"John");
        sendKeysToElement(myAccountPage.inputLastName,"Smith");
        clickOnElement(myAccountPage.selectLanguageDropDownMenu);
        clickOnElement(myAccountPage.selectLanguageEnglishUS);
        clickOnElement(myAccountPage.selectCountryDropDownMenu);
        clickOnElement(myAccountPage.selectCountryUSA);
        sendKeysToElement(myAccountPage.inputPassword,"John12345!");
        clickOnElement(myAccountPage.checkBox);
        clickOnElement(myAccountPage.createAUserAccount);
        List<String> expectedList = getExpectedList("Mercedes-Benz");
        String actualText = myAccountPage.createUserAccount.getText();
        String expectedText = "Create a user account";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Found MercedesBenz Create  a User Account Page");
    }

    @Test(description = "Case ID: 04", priority = 4, enabled = true)
    public void testNavigateToLoginPage() throws IOException {
        Homepage homepage = getHomepage();
        MercedesBenzMyAccountPage myAccountPage = homepage.navigateToMercedesBenzPageMyAccount();
        waitForElementToBeVisible(myAccountPage.loginButton);
        clickOnElement(myAccountPage.loginButton);
        clickOnElement(myAccountPage.loginPage);
        sendKeysToElement(myAccountPage.inputUserName, "john@gmail.com");
        clickOnElement(myAccountPage.continueTab);
        List<String> expectedList = getExpectedList("Mercedes-Benz");
        String actualText = myAccountPage.loginPage.getText();
        String expectedText = "Login";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Found MercedesBenz Login Page");

    }


}
