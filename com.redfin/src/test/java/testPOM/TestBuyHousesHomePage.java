package testPOM;

import POM.BuyHousesHomePage;
import POM.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.List;

public class TestBuyHousesHomePage extends TestBase {

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testToSearchTheHouse() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        homepage.doPriceRanges(houses.clickButton, houses.minPrice, houses.clickButton2, houses.maxPrice);
        clickOnElement(houses.searchButton);
        clickOnElement(houses.checkTable);
//        database.insertDataFromListToSqlTable(oneDList(houses.listAdresses), "RedFinList", "addresses");
    }

//    @Test(description = "Case ID: 02", priority = 2, enabled = false)
//    public void testToBuyHousesSearchingByMinAndMaxPrice() {
//        Homepage homepage = getHomepage();
//        BuyHousesHomePage houses = homepage.navigateToBuy();
//        homepage.clearSearch(houses.searchButtonLocation, houses.clearButton);
//        waitForElementToBeVisible(houses.sendKeysToInput);
//        clearInputText(houses.sendKeysToInput);
//        homepage.sendKeywordLocation(houses.sendKeysToInput, "maine", houses.mainePick);
//        homepage.doPriceRanges(houses.clickButton, houses.minPrice, houses.clickButton2, houses.maxPrice);
//        clickOnElement(houses.searchButton);
//        clickOnElement(houses.filterButton);
//        clickOnElement(houses.clickHouse);
//        clickOnElement(houses.stepUpBath);
//        clickOnElement(houses.stepUpBathOne);
//        clickJScript(houses.openHouses);
//        clickOnElement(houses.anytimeRadio);
//        clickOnElement(houses.applyFilter);
////        waitForElementToBeVisible(houses.noResults);
//        String actualText = houses.noResults.getText();
//        String expectedText = "No results!";
//        Assert.assertEquals(actualText, expectedText);
//
//    }
//
//    @Test(description = "Case ID: 03", priority = 3, enabled = false)
//    public void testToBuyHousesTour() {
//        Homepage homepage = getHomepage();
//        BuyHousesHomePage houses = homepage.navigateToBuy();
//        clickOnElement(houses.firstOffer);
//        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        waitForElementToBeVisible(houses.tourText);
//        String actualText = houses.tourText.getText();
//        String expectedText = "Go tour this home";
//        Assert.assertEquals(actualText, expectedText);
//        System.out.println("DONE");
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));
//    }

    @Test(description = "Case ID: 04", priority = 4, enabled = false)
    public void testToBuyHouseRedfinVideo() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        oneDList(houses.redfinLinks);
        clickOnElement(houses.ourMission);
        clickOnElement(houses.learnMore);
        clickOnElement(houses.playButton);
        foundIframe(houses.iframeSwitch);
        clickOnElement(houses.pauseButton);

    }

    @Test(description = "Case ID: 05", priority = 5, enabled = false)
    public void testToRedfinBlog() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        clickOnElement(houses.blogButton);
        clickOnElement(houses.buyingHome);
        oneDhref(houses.buyingHomeArticles);
        clickOnElement(houses.HomeArticlesNumOne);
        oneDList(houses.notCovered);
    }


    @Test(description = "Case ID: 06", priority = 6, enabled = false)
    public void testToBuyHouseInCalifornia() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        clickOnElement(houses.landForSale);
        waitForElementToBeVisible(houses.sendKeysToInput);
        clearInputText(houses.sendKeysToInput);
        homepage.sendKeywordLocation(houses.sendKeysToInput, "california", houses.caliPick);
        homepage.doPriceRanges(houses.clickButton, houses.minPriceCA, houses.clickButton2, houses.maxPriceCA);
        clickOnElement(houses.searchButton);
        clickOnElement(houses.checkTable);
        oneDList(houses.caliAreas);
        clickOnElement(houses.clickSF);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        clickOnElement(houses.checkTable);
        oneDList(houses.SFAreas);
        driver.close();
        driver.switchTo().window(tabs2.get(0));

    }

    @Test(description = "Case ID: 07", priority = 7, enabled = false)
    public void testToBuyHouseWithCompleteGuide() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        hoverAction(homepage.buyHouse);
        clickOnElement(houses.buywithRedinColumn2.get(1));
        printOutListOfElements(houses.tableOfContents);
        clickOnElement(houses.tableOfContents.get(2));
        clickOnElement(houses.pickM);
        printOutListOfElements(houses.hrefForM);
        printOutHrefListOfElements(houses.hrefForM);
//        database.insertDataFrom2ListsToSqlTable(oneDList(houses.hrefForM), oneDhref(houses.hrefForM), "GlossaryForM", "Name", "Links");
    }

    @Test(description = "Case ID: 08", priority = 8, enabled = false)
    public void testToBuyHouseWithCompleteGuide2() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        hoverAction(homepage.buyHouse);
        clickOnElement(houses.buywithRedinColumn2.get(1));
        clickOnElement(houses.tableOfContents.get(1));
        printOutListOfElements(houses.homeSellingGuide);
        System.out.println("\n");
        clickOnElement(houses.homeSellingGuideLinks.get(0));
        printOutListOfElements(houses.checklist);
    }

    @Test(description = "Case ID: 09", priority = 9, enabled = false)
    public void testToOpenBookForBuyers() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        hoverAction(homepage.buyHouse);
        clickOnElement(houses.buywithRedinColumn2.get(2));
        clickOnElement(houses.Boston);
        printOutListOfElements(houses.openBookTitles);
        clickOnElement(houses.providersLink);
        List<String> getRangeOfNames = getRangeFromList(houses.getProvidersNames, 0, 51);
        for (String name : getRangeOfNames) {
            System.out.println(name);
        }
        List<String> getRangeOfRedfin = getRangeFromList(houses.getProvidersRedfin, 0, 51);
        for (String name : getRangeOfRedfin) {
            System.out.println(name);
        }
//        Object database = null;
//        database.insertDataFrom2ListsToSqlTable(getRangeOfNames, getRangeOfRedfin, "Providers", "Name", "Redfin");
    }

    @Test(description = "Case ID: 010", priority = 10, enabled = false)
    public void testToBuyHousesWithRealStatesClasses() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        hoverAction(homepage.buyHouse);
        clickOnElement(houses.buywithRedinColumn2.get(3));

        for (int i = 1; i <= 9; i++) {
            clickOnElement(houses.selectCountyBox);
            WebElement testing = driver.findElement(By.xpath("//*[@id=\"content\"]/div[11]/section/div/span/span/div/div[1]/div/div[" + i + "]"));
            clickOnElement(testing);
        }

        clickOnElement(houses.selectCountyBox);
        List<String> getRangeOfRedfin = getRangeFromList(houses.elementsNames, 1, 8);
        for (String element : getRangeOfRedfin) {
            clickOnElement(houses.selectCountyBox);
            System.out.println(element);
        }
        waitForElementToBeVisible(houses.noClasses);
        String actualText = houses.noClasses.getText();
        String expectedText = "No Upcoming Classes";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(description = "Case ID: 011", priority = 11, enabled = false)
    public void testToBuyHouseWithDemandTitle() {
        Homepage homepage = getHomepage();
        BuyHousesHomePage houses = homepage.navigateToBuy();
        hoverAction(homepage.buyHouse);
        clickOnElement(houses.buywithRedinColumn2.get(4));
        clickOnElement(houses.Demand);
        printOutListOfElements(houses.housingDemandTitles);
        printOutListOfElements(houses.housingDemandPercentages);
//        database.insertDataFrom2ListsToSqlTable(oneDList(houses.housingDemandTitles),oneDList(houses.housingDemandPercentages),"HousingDemand","Titles","Percentages");
//        //add assert here
        printOutListOfElements(houses.competitveTowns);
    }
}
