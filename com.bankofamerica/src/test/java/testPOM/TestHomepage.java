package testPOM;

import POM.CreditCardHomePage;
import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {

    @Test
    public void testNavigateToCreditCardPage(){
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        waitForElementToBeVisible(credit.creditInfo);
        String actualText = credit.creditInfo.getText();
        String expectedText = "Find the perfect credit card from among our most popular options";
        Assert.assertEquals(expectedText, actualText);
        System.out.println("FOUND CREDIT WEBSITE");
    }

}
