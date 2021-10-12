package testPOM;

import POM.BuyHousesHomePage;
import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {

    @Test
    public void testNavigateToBuyHouses(){
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        waitForElementToBeVisible(houses.textBuyHouses);
        String actualText =houses.textBuyHouses.getText();
        String expectedText = "Houses for sale near me";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("FOUND REDFIN WEBSITE");
    }

}
