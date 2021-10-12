package testPOM;

import POM.Homepage;
import POM.MotorsHomePage;
import base.Base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestMotorsHomePage extends TestBase {
    Homepage homepage;
    List<String> testData;
    String[][] stingValue;


    @Test(description = "Case ID: 02", priority = 2, enabled = false)
    public void testNavigateToSearchByCategory() throws IOException {
        Homepage homepage = getHomepage();
        MotorsHomePage motorsHomePage = homepage.navigateToShopByCategoryMotorsTab();
        clickJScript(homepage.shopByCategoryMotorTab);
        List<String> expectedList = getExpectedList("Ebay");
        String actualText = homepage.shopByCategoryMotorTab.getText();
        String expectedText = "";
        Assert.assertEquals(actualText,expectedText);
        System.out.println("Found Motors Website");


    }



    @Test(description = "Case ID: 03", priority = 3, enabled = false)
    public void testNavigateToHoverMotorsHomePage() throws IOException {
        Homepage homepage = getHomepage();
        MotorsHomePage motorsHomePage = homepage.navigateToHoverToMotorsTab();
        clickJScript(homepage.hoverMotorsTab);
        List<String> expectedList = getExpectedList("Ebay");
        String actualText = homepage.hoverMotorsTab.getText();
        String expectedText = "Motors";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Found Motors Website");

    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testFindPartsAndAccessoriesHeaderPage() throws IOException {
        Homepage homepage = getHomepage();
        MotorsHomePage motorsHomePage = homepage.navigateToShopByCategoryMotorsTab();
        clickJScript(homepage.shopByCategoryMotorTab);
        homepage.clickJScript(motorsHomePage.eBayMotors);
        List<String> expectedList = getExpectedList("Ebay");
        String actualText = motorsHomePage.eBayMotors.getText();
        String expectedText = "Find Parts & Accessories";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Found Find Parts & Accessories page");

    }
//not complete yet
    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testToSelectCarsAndTruck() throws IOException {
        Homepage homepage = getHomepage();
        MotorsHomePage motorsHomePage = homepage.navigateToShopByCategoryMotorsTab();
        clickJScript(homepage.shopByCategoryMotorTab);
        clickJScript(motorsHomePage.eBayMotors);
        clickJScript(motorsHomePage.selectYearForCarsAndTrucks);
        clickJScript(motorsHomePage.selectMakeForCarsAndTrucks);
        clickJScript(motorsHomePage.selectModelForCarsAndTrucks);
        clickJScript(motorsHomePage.trimForCarsAndTrucks);
        clickJScript(motorsHomePage.engineForCarsAndTrucks);
        clickJScript(motorsHomePage.searchPartsForCarsAndTrucks);
        List<String> expectedList = getExpectedList("Ebay");
        String actualText = motorsHomePage.selectCarsAndTrucksHeader.getText();
        String expectedText = "Cars & trucks";
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Found Find Parts & Accessories page");

    }




}
