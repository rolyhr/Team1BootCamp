package testPOM;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;
import testPOM.dataProvider.FlightsDataProvider;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TestFlights extends TestBase {

    @Test(description = "TC002PE", enabled = false, priority = 2)
    public void testgetSearchWitoutLocationErrorMessage() throws IOException {
        String acutalResult =   getFlights().getSearchErrorMessage();
        String[] expectedResult =getExcelFile("Error");
        Assert.assertEquals(acutalResult,expectedResult[0],"ERROR IS NOT DISPLAYING PROPERLY");
    }

    @Test(description = "TC002PE", enabled = false,dataProvider = "SearchLocationDataProvider",dataProviderClass = FlightsDataProvider.class,priority = 2)
    public void testgetSearchWithLocation(String startlocation,String endlocation) throws IOException, InterruptedException {
        getFlights().searchFlightWithStartAndEndLocation(startlocation,endlocation);
        String actualResult = getFlights().getSearchResult();
        String[] expectedResult =getExcelFile("Result");
         Assert.assertEquals(actualResult,expectedResult[0],"DID NOT RECEIVE EXPECTED SEARCH RESULT");
    }

    @Test(description = "TC003PE", enabled = false,dataProvider = "SearchLocationDataProvider",dataProviderClass = FlightsDataProvider.class,priority = 2)
    public void testgetSearchWitoutLeavingFromLocation(String startlocation,String endlocation) throws IOException, InterruptedException {
        String actualResult = getFlights().searchFlightWithoutLeavingFromLocation(endlocation);
        String[] expectedResult =getExcelFile("Error");
        Assert.assertEquals(actualResult,expectedResult[1],"DID NOT RECEIVE EXPECTED SEARCH RESULT");
    }

    @Test(description = "TC004PE", enabled = true,dataProvider = "SearchLocationDataProvider",dataProviderClass = FlightsDataProvider.class,priority = 2)
    public void testgetSearchWitoutGoingToLocation(String startlocation,String endlocation) throws IOException, InterruptedException {
        String actualResult = getFlights().searchFlightWithoutGoingToLocation(startlocation);
        String[] expectedResult =getExcelFile("Error");
        Assert.assertEquals(actualResult,expectedResult[1],"DID NOT RECEIVE EXPECTED SEARCH RESULT");
    }
    @Test(description = "TC005PE", enabled = false, priority = 2)
    public void testClickTravelerDropDown() throws AWTException, InterruptedException {
        flights = getFlights();
        clickOnPage();
        flights.navigateToFlights();
        Thread.sleep(8000);
        String actualAriaExpanded = flights.clickOnTravelerDropDown();
        String expectedAriaExpanded = "true";
        Thread.sleep(8000);
        Assert.assertEquals(actualAriaExpanded,expectedAriaExpanded,"TRAVELER DROP DOWN IS NOT EXPANDED");
    }
    }

//    @Test(description = "TC001PE", enabled = false, priority = 2)
//    public void testListofSelectClass() throws IOException {
//        getFlights().getSearchErrorMessage();
//        List<String> acutalCategories =  getShop().getListofSelectClassList();
//        String[] expectedCategories =getExcelFile("class");
//        compareStringList(acutalCategories,expectedCategories);
//    }

