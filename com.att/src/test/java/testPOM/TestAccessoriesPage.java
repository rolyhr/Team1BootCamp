package testPOM;

import POM.AccessoriesPage;
import POM.Homepage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestAccessoriesPage extends TestBase {
//    Homepage homepage=new Homepage();
    AccessoriesPage accessoriesPage;



    @Test(description = "TCAP:001", priority = 1, enabled = true)
    public void testDoDealsLink() throws IOException, InterruptedException {

       getAccessoriesPage().navToHomepage();
        Thread.sleep(3000);
        String actualTest ="AT&T Official Site - Unlimited Data Plans, Internet Service, & TV";
        String expectedTest = readFromExcel("ATT", 0);
        System.out.println("click on deals Tab");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");


    }

    @Test (description = "TC003PD", priority = 3, enabled = false)
    public void testValidateTopLeftHamburgerMenuListTest() {
        accessoriesPage= new AccessoriesPage();
        accessoriesPage.validateTopLeftHamburgerDDMenuListTest();
    }

//    @Test (description = "TC004PD", priority = 4, enabled = true)
//    public void testValidatePickYourPhoneMenuBarText() {
//        pd = new PhonesAndDevices();
//        pd.validatePickYourPhoneMenuBarText();
//    }

    @Test(description = "TCAP:002", priority = 2, enabled = true)
    public void testDoAccessoriesLink() throws IOException, InterruptedException {

        getAccessoriesPage().clickOnAccessoriesLink();
        Thread.sleep(3000);
        String actualTest ="Att:Accessories";
        String expectedTest = readFromExcel("ATT", 1);
        System.out.println("click on Accessories Tab");
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessories page!");


    }

    @Test(description = "TCHP:003", priority = 3, enabled = true)
    public void testDoClickOnHeadPhonesLink() throws IOException, InterruptedException {

        getAccessoriesPage().clickOnHeadPhonesLink();
        Thread.sleep(3000);
        String actualTest ="Att:Headphones";
        String expectedTest = readFromExcel("ATT", 2);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCCS:004", priority = 4, enabled = true)
    public void testDoClickOnCasesLink() throws IOException, InterruptedException {
        getAccessoriesPage().clickOnCasesLink();
        Thread.sleep(3000);
        String actualTest ="Att:Cases";
        String expectedTest = readFromExcel("ATT", 3);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCCR:005", priority = 5, enabled =true)
    public void testDoClickOnChargersLink() throws IOException, InterruptedException {
        getAccessoriesPage().clickOnChargersLink();
        Thread.sleep(3000);
        String actualTest ="Att:Chargers";
        String expectedTest = readFromExcel("ATT", 4);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCCS:006", priority = 6, enabled = true)
    public void testDoClickOnScreenProtectorsLink() throws IOException, InterruptedException {

        getAccessoriesPage().clickOnScreenProtectorsLink();
        Thread.sleep(3000);
        String actualTest ="Att:Screen Protectors";
        String expectedTest = readFromExcel("ATT", 5);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCSASH:007", priority = 7, enabled = true)
    public void testDoClickOnSpeakersAndSmartHomesLink() throws IOException, InterruptedException {
        getAccessoriesPage().clickOnSpeakersAndSmartHomesLink();
        Thread.sleep(3000);
        String actualTest ="Att:Speakers And Smart Home";
        String expectedTest = readFromExcel("ATT", 6);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCIATE:008", priority = 8, enabled = true)
    public void testDoClickOnInternetAndTvEquipmentLink() throws IOException, InterruptedException {
        getAccessoriesPage().clickOnInternetAndTvEquipmentLink();
        Thread.sleep(3000);
        String actualTest ="Att:Internet And Tv Equipment";
        String expectedTest = readFromExcel("ATT", 7);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCPSAM:009", priority = 9, enabled = true)
    public void testDoClickOnPopSocketsAndMoreLink() throws IOException, InterruptedException {

        getAccessoriesPage().clickOnPopSocketsAndMoreLink();
        Thread.sleep(3000);
        String actualTest ="Att:Pop Sockets And More";
        String expectedTest = readFromExcel("ATT", 8);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }

    @Test(description = "TCGAG:010", priority = 10, enabled = true)
    public void testDoClickOnGadgetsAndGamingLink() throws IOException, InterruptedException {
        getAccessoriesPage().clickOnGadgetsAndGamingLink();
        Thread.sleep(3000);
        String actualTest ="Att:Gadgets And Gaming";
        String expectedTest = readFromExcel("ATT", 9);
        Assert.assertEquals(actualTest, expectedTest, "Failed Navigate To Test Accessorries page!");
    }
}
