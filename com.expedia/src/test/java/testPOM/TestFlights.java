package testPOM;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.awt.*;

public class TestFlights extends TestBase {


    @Test
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
