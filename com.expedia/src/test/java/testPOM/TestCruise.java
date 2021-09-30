package testPOM;

import POM.Cruise;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCruise extends TestBase {

    Cruise cruise;

    @Test (description = "TC001C", priority = 1, enabled = false)
    public void testSearchCruiseWithAllValidData() {
        cruise = new Cruise();
        String totalCruisesAvailable = cruise.searchCruiseWithAllValidData();
        System.out.println(totalCruisesAvailable);
    }

    //need to figure out how to check with invalid data on line 146 on Cruise.java
    @Test (description = "TC002C", priority = 2, enabled = false)
    public void testSearchCruiseWithAllInvalidData() {
        cruise = new Cruise();
        cruise.searchCruiseWithAllInvalidData();
    }

    @Test (description = "TC003C", priority = 3, enabled = false)
    public void testSearchCruiseWithNoDestination() {
        cruise = new Cruise();
        String totalCruisesAvailable = cruise.searchCruiseWithNoDestination();
        System.out.println(totalCruisesAvailable);
    }

    //need to figure out how to check with no data
    @Test (description = "TC004C", priority = 4, enabled = false)
    public void testSearchCruiseWithNoDate() {
        cruise = new Cruise();
        cruise.searchCruiseWithNoDate();
    }

    @Test (description = "TC005C", priority = 5, enabled = false)
    public void testSearchCruiseWithAddingChildren() {
        cruise = new Cruise();
        String numOfChildren = cruise.searchCruiseWithAddingChildren();
        System.out.println(numOfChildren);
    }

    @Test (description = "TC006C", priority = 6, enabled = false)
    public void testNumOfMaxAdultsCanBeAdded() {
        cruise = new Cruise();
        cruise.numOfMaxAdultsCanBeAdded();
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsIncreaseNumOfAdult)).isEnabled();
        if (!buttonEnabled){
            int maxNumOfAdultAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(cruise.bsNumberOfAdultSelected)).getAttribute("value"));
            System.out.println("Maximum Number Of Adult Allowed: " + maxNumOfAdultAllowed);
        }
        cruise.clickNumOfTravelersDoneButton();
    }

    @Test (description = "TC007C", priority = 7, enabled = false)
    public void testNumOfMinAdultsCanBeAdded() {
        cruise = new Cruise();
        cruise.numOfMinAdultsCanBeAdded();
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsDecreaseNumOfAdult)).isEnabled();
        if (!buttonEnabled){
            int minNumOfAdultAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(cruise.bsNumberOfAdultSelected)).getAttribute("value"));
            System.out.println("Minimum Number Of Adult Allowed: " + minNumOfAdultAllowed);
        }
        cruise.clickNumOfTravelersDoneButton();
    }

    @Test (description = "TC008C", priority = 8, enabled = false)
    public void testNumOfMaxChildrenCanBeAdded() {
        cruise = new Cruise();
        cruise.numOfMaxChildrenCanBeAdded();
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsIncreaseNumOfChildren)).isEnabled();
        if (!buttonEnabled){
            int maxNumOfChildrenAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(cruise.bsNumberOfChildSelected)).getAttribute("value"));
            System.out.println("Maximum Number Of Children Allowed: " + maxNumOfChildrenAllowed);
        }
        cruise.clickNumOfTravelersDoneButton();
    }

    @Test (description = "TC009C", priority = 9, enabled = false)
    public void testNumOfMinChildrenCanBeAdded() {
        cruise = new Cruise();
        cruise.numOfMinChildrenCanBeAdded();
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsDecreaseNumOfChildren)).isEnabled();
        if (!buttonEnabled) {
            int minNumOfChildrenAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(cruise.bsNumberOfChildSelected)).getAttribute("value"));
            System.out.println("Minimum Number Of Children Allowed: " + minNumOfChildrenAllowed);
        }
        cruise.clickNumOfTravelersDoneButton();
    }

    @Test (description = "TC010C", priority = 10, enabled = false)
    public void testMaxAgeOfChildrenAllowed() {
        cruise = new Cruise();
        cruise.maxAgeOfChildrenAllowed();
        cruise.clickNumOfTravelersDoneButton();
    }

    @Test (description = "TC011C", priority = 11, enabled = false)
    public void testWarningMessageIfChildAgeNotProvided() {
        cruise = new Cruise();
        cruise.warningMessageIfChildAgeNotProvided();
        String warningMsg = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsWarningMsgForMaxChildrenOrAdults)).getText();
        cruise.clickNumOfTravelersDoneButton();
        System.out.println(warningMsg);
    }

    @Test (description = "TC012C", priority = 12, enabled = false)
    public void testWarningMessageIfMaxNumOfTravelersAllowed() {
        cruise = new Cruise();
        cruise.warningMessageIfMaxNumOfTravelersAllowed();
        String warningMsg = explicitWait.until(ExpectedConditions.visibilityOf(cruise.bsWarningMsgForMaxChildrenOrAdults)).getText();
        cruise.clickNumOfTravelersDoneButton();
        System.out.println(warningMsg);
    }

    @Test (description = "TC013C", priority = 13, enabled = false)
    public void testPhoneNumDisplayedForCruiseExpert() {
        cruise = new Cruise();
        String cruiseExpertPhNum = cruise.phoneNumDisplayedForCruiseExpert();
        System.out.println(cruiseExpertPhNum);
    }

    @Test (description = "TC014C", priority = 14, enabled = false)
    public void testCheckCruiseResult() {
        cruise = new Cruise();
        String totalCruisesAvailable = cruise.checkCruiseResult();
        System.out.println(totalCruisesAvailable);
    }

    @Test (description = "TC015C", priority = 15, enabled = true)
    public void testAfterSearchDateChange() {
        cruise = new Cruise();
        cruise.afterSearchDateChange();
        /*
        IMPLEMENT LOGIC IN pickCalendarDate() METHOD HOW TO GO BACK AND CHECK FOR DATE IF THE EXPECTED
        DATE IS IN THE PREVIOUS PAGE OF THE CALENDAR TAB
        */
    }

}