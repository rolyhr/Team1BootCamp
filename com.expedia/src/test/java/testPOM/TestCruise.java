package testPOM;

import POM.Cruise;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCruise extends TestBase {

    Cruise cruise;

    @Test (description = "TC001C", priority = 1, enabled = false)
    public void testSearchCruiseWithAllValidData() {
        cruise = new Cruise();
        String actualResult = cruise.searchCruiseWithAllValidData();
        String expectedResult = readFromExcel("REGAssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001C");
    }

    @Test (description = "TC002C", priority = 2, enabled = false)
    public void testSearchCruiseWithAllInvalidData() {
        cruise = new Cruise();
        cruise.searchCruiseWithAllInvalidData();
        String actualResult = cruise.searchCruiseWithAllInvalidData();
        String expectedResult = readFromExcel("REGAssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002C");
    }

    @Test (description = "TC003C", priority = 3, enabled = false)
    public void testSearchCruiseWithNoDestination() {
        cruise = new Cruise();
        String actualResult = cruise.searchCruiseWithAllInvalidData();
        String expectedResult = readFromExcel("REGAssertionResult", 2);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002C");
    }

    @Test (description = "TC004C", priority = 4, enabled = false)
    public void testSearchCruiseWithNoDate() {
        cruise = new Cruise();
        cruise.searchCruiseWithNoDate();
        String actualResult = cruise.searchCruiseWithNoDate();
        String expectedResult = readFromExcel("REGAssertionResult", 2);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC003C");
    }

    @Test (description = "TC005C", priority = 5, enabled = false)
    public void testSearchCruiseWithAddingChildren() {
        cruise = new Cruise();
        String actualResult = cruise.searchCruiseWithAddingChildren();
        String expectedResult = readFromExcel("REGAssertionResult", 3);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC005C");
    }

    @Test (description = "TC006C", priority = 6, enabled = false)
    public void testNumOfMaxAdultsCanBeAdded() {
        cruise = new Cruise();
        String actualResult = cruise.numOfMaxAdultsCanBeAdded();
        String expectedResult = readFromExcel("REGAssertionResult", 4);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC006C");
    }

    @Test (description = "TC007C", priority = 7, enabled = false)
    public void testNumOfMinAdultsCanBeAdded() {
        cruise = new Cruise();
        String actualResult = cruise.numOfMinAdultsCanBeAdded();
        String expectedResult = readFromExcel("REGAssertionResult", 5);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC007C");
    }

    @Test (description = "TC008C", priority = 8, enabled = false)
    public void testNumOfMaxChildrenCanBeAdded() {
        cruise = new Cruise();
        String actualResult = cruise.numOfMaxChildrenCanBeAdded();
        String expectedResult = readFromExcel("REGAssertionResult", 6);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC008C");
    }

    @Test (description = "TC009C", priority = 9, enabled = false)
    public void testNumOfMinChildrenCanBeAdded() {
        cruise = new Cruise();
        String actualResult = cruise.numOfMinChildrenCanBeAdded();
        String expectedResult = readFromExcel("REGAssertionResult", 7);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC009C");
    }

    @Test (description = "TC010C", priority = 10, enabled = false)
    public void testMaxAgeOfChildrenAllowed() {
        cruise = new Cruise();
        String actualResult = cruise.maxAgeOfChildrenAllowed();
        String expectedResult = readFromExcel("REGAssertionResult", 8);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC010C");
    }

    @Test (description = "TC011C", priority = 11, enabled = false)
    public void testWarningMessageIfChildAgeNotProvided() {
        cruise = new Cruise();
        String actualResult = cruise.warningMessageIfChildAgeNotProvided();
        String expectedResult = readFromExcel("REGAssertionResult", 9);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC011C");
    }

    @Test (description = "TC012C", priority = 12, enabled = false)
    public void testWarningMessageIfMaxNumOfTravelersAllowed() {
        cruise = new Cruise();
        String actualResult = cruise.warningMessageIfMaxNumOfTravelersAllowed();
        String expectedResult = readFromExcel("REGAssertionResult", 10);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC012C");
    }

    @Test (description = "TC013C", priority = 13, enabled = false)
    public void testPhoneNumDisplayedForCruiseExpert() {
        cruise = new Cruise();
        String actualResult = cruise.phoneNumDisplayedForCruiseExpert();
        String expectedResult = readFromExcel("REGAssertionResult", 11);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC013C");
    }

    @Test (description = "TC014C", priority = 14, enabled = false)
    public void testCheckCruiseResult() {
        cruise = new Cruise();
        String actualResult = cruise.checkCruiseResult();
        String expectedResult = readFromExcel("REGAssertionResult", 12);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC014C");
    }

    @Test (description = "TC015C", priority = 15, enabled = true)
    public void testAfterSearchDateChange() {
        cruise = new Cruise();
        String actualResult = cruise.afterSearchDateChange();
        String expectedResult = readFromExcel("REGAssertionResult", 13);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC015C");
        /*
        IMPLEMENT LOGIC IN pickCalendarDate() METHOD HOW TO GO BACK AND CHECK FOR DATE IF THE EXPECTED
        DATE IS IN THE PREVIOUS PAGE OF THE CALENDAR TAB
        */
    }

}