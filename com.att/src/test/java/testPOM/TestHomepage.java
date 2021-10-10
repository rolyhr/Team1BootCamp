package testPOM;

import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestHomepage extends TestBase {

    Homepage homepage;


    List<String> testData;

    String[][] stingValue;

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testNavigateToDealsPage() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(homepage.dealsLinkFromHomepage);
        waitForElementToBeVisible(homepage.dealsLinkFromHomepage);
        String actualTest ="Deals";
        String expectedTest = readFromExcel("ATT", 0);
        System.out.println("click on deals Tab");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Deals page!");

    }

    @Test(description = "Case ID: 02", priority = 2, enabled = false)
    public void testToPhonesAndDevicesTab() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().phonesAndDevicesLinkFromHomepage);
        String actualTest ="Phones & devices";
        String expectedTest = readFromExcel("ATT", 1);
        System.out.println("click on Phones and Devices Tab");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Phones And devices page!");


    }

    @Test(description = "Case ID: 03", priority = 3, enabled = false)
    public void testWirelessTab() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().wirelessLinkFromHomepage);
        String actualTest ="Wireless";
        String expectedTest = readFromExcel("ATT", 2);
        System.out.println("click on Wireless");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Wireless page!");


    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testInternetTab() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().internetLinkFromHomepage);
        String actualTest ="Internet";
        String expectedTest = readFromExcel("ATT", 3);
        System.out.println("click on Internet");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Internet page!");

    }

    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testTVLink() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().tvLinkFromHomepage);
        String actualTest ="TV";
        String expectedTest = readFromExcel("ATT", 4);
        System.out.println("click on TV");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test TV page!");


    }

    @Test(description = "Case ID: 06", priority = 6, enabled = false)
    public void testPrepaidTab() throws IOException {
       Homepage homepage = getHomepage();
        clickOnElement(getHomepage().prepaidLinkFromHomepage);
        String actualTest ="Prepaid";
        String expectedTest = readFromExcel("ATT", 5);
        System.out.println("click on Prepaid");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Prepaid page!");

    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void tesBundlesTab() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().bundlesLinkFromHomepage);
        String actualTest ="Bundles";
        String expectedTest = readFromExcel("ATT", 6);
        System.out.println("click on Bundles");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Bundles page!");
    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testAttLogo() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().attLogoFromHomepage);
        String actualTest ="logo";
        String expectedTest = readFromExcel("ATT", 7);
        System.out.println("click on ATT logo");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test ATT logo page!");

    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testTopLeftHamBurgerIcon() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().topLeftHamBurgerIconFromHomepage);
        String actualTest ="HamBurger menu Icon";
        String expectedTest = readFromExcel("ATT", 8);
        System.out.println("HamBurger menu Icon");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test HamBurger menu Icon page!");

    }

    @Test(description = "Case ID: 10", priority = 10, enabled = false)
    public void testSearchItem() throws IOException {
       Homepage homepage = getHomepage();
        clickOnElement(getHomepage().searchBarFromHomepage);
        clickOnElement(getHomepage().inputSendKeysToSearchBar);
        sendKeysToInput(homepage.inputSendKeysToSearchBar, "Accessories Deals");
        clickOnElement(getHomepage().searchIcon);
        String actualTest ="Accessories Deals";
        String expectedTest = readFromExcel("ATT", 9);
        System.out.println("click on Search icon");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Search Item in Homepage!");
    }

    @Test(description = "Case ID: 11", priority = 11, enabled = false)
    public void testmyFavouriteIcon() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().myFavoriteIconFromHomepage);
        String actualTest ="My Favourite icon";
        String expectedTest = readFromExcel("ATT", 10);
        System.out.println("My Favourite icon");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test My Favourite icon Icon page!");

    }

    @Test(description = "Case ID: 12", priority = 12, enabled = false)
    public void testCartIcon() throws IOException {
       Homepage homepage = getHomepage();
        clickOnElement(getHomepage().cartIconFromHomepage);
        String actualTest ="Cart icon";
        String expectedTest = readFromExcel("ATT", 11);
        System.out.println("click on Cart icon");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Cart icon!");

    }

    @Test(description = "Case ID: 13", priority = 13, enabled = false)
    public void testSupportTab() throws IOException {
       Homepage homepage = getHomepage();
        clickOnElement(getHomepage().supportLinkFromHomepage);
        String actualTest ="Support";
        String expectedTest = readFromExcel("ATT", 12);
        System.out.println("click on Support");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Support page!");
    }

    @Test(description = "Case ID: 14", priority = 14, enabled = false)
    public void testAccountButton() throws IOException {
      Homepage homepage = getHomepage();
        clickOnElement(getHomepage().accountButtonFromHomepage);
        String actualTest ="Account";
        String expectedTest = readFromExcel("ATT", 13);
        System.out.println("click on Account");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Account Button!");
    }

    @Test(description = "Case ID: 15", priority = 15, enabled = false)
    public void testAccountDropDownMenu() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().accountDropDownMenuFromHomepage);
        String actualTest = "Account Drop Down Menu";
        String expectedTest = readFromExcel("ATT", 14);
        System.out.println("click on Account Drop Down Menu");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Account drop down menu!");
    }

    @Test(description = "Case ID: 16", priority = 16, enabled = false)
    public void testAccountDropDownSubmenuSignInPage() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().accountDropDownMenuFromHomepage);
        clickOnElement(getHomepage().accountDropDownSubMenuSignIn);
        String actualTest = "Sign In";
        String expectedTest = readFromExcel("ATT", 15);
        System.out.println("click on Account Drop Down Sub Menu Sign In");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Account drop down Sub menu SignIn!");
    }

    @Test(description = "Case ID: 17", priority = 17, enabled = false)
    public void testAccountCreateNowPage() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().accountDropDownMenuFromHomepage);
        clickOnElement(getHomepage().accountDropDownSubMenuSignIn);
        clickOnElement(getHomepage().accountCreateNow);
        String actualTest = "Create one Now";
        String expectedTest = readFromExcel("ATT", 16);
        System.out.println("click on Account Create one Now");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Account Create one Now!");
    }

    @Test(description = "Case ID: 18", priority = 18, enabled = false)
    public void testSelectaServicePage() throws IOException {
        Homepage homepage = getHomepage();
        clickOnElement(getHomepage().accountDropDownMenuFromHomepage);
        clickOnElement(getHomepage().accountDropDownSubMenuSignIn);
        clickOnElement(getHomepage().accountCreateNow);
        clickOnElement(getHomepage().selectServiceHomePhone);
        clickOnElement(getHomepage().continueTab);
        String actualTest = "Home phone";
        String expectedTest = readFromExcel("ATT", 17);
        System.out.println("click on Home phone then continue");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test selectServiceHomePhone!");
    }

    @Test(description = "Case ID: 19", priority = 19, enabled = false)
    public void testSendKeysToTheAccountPage() throws IOException {
        Homepage homepage = getHomepage();
        sendKeysToInput(homepage.inputNineDigitAccountNumber, "123456789");
        sendKeysToInput(homepage.inputBillingZipCode, "12345");
        clickOnElement(getHomepage().continueButton);
        String actualTest ="Account Number And Zip Code";
        String expectedTest = readFromExcel("ATT", 18);
        System.out.println("click on Account Number And Zip Code");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test to input Account Number And Zip Code !");
    }


}
