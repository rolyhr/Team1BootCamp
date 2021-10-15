package POM;

import base.Base;
import static cruiseLocators.CruiseLocators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Cruise extends Base {

    public Cruise() {
        PageFactory.initElements(driver, this);
    }

    //START - BEFORE SEARCH DES, DATE
    @FindBy (css = BS_CRUISE_MM_BUTTON)
    public WebElement bsCruiseMMButton;

    @FindBy (css = BS_SELECT_DESTINATION_DD)
    public WebElement bsSelectDestinationDD;

    @FindBy (css = BS_CALENDAR_MONTH_YEAR)
    public WebElement bsCalendarMonthYear;

    @FindBy (css = BS_NEXT_MONTH_BUTTON)
    public WebElement bsNextMonthButton;

    @FindBy (css = BS_DEPART_AS_EARLY)
    public WebElement bsDepartAsEarly;

    @FindBy (css = BS_WARNING_MSG_FOR_MAX_CHILDREN_OR_ADULTS)
    public WebElement bsWarningMsgForMaxChildrenOrAdults;

    @FindBy (css = BS_CRUISE_EXPERT_PH_NUM)
    public WebElement bsCruiseExpertPhNum;

    @FindBy (css = BS_SEARCH_RESULT_OF_NUM_OF_CRUISES)
    public WebElement bsSearchResultOfNumOfCruises;
    //END - BEFORE SEARCH DES, DATE

    //START - NUMBER OF TRAVELERS
    @FindBy (css = BS_NUMBER_OF_TRAVELERS_MENU)
    public WebElement bsNumOfTravelersMenu;

    @FindBy (css = BS_DECREASE_NUM_OF_ADULT)
    public WebElement bsDecreaseNumOfAdult;

    @FindBy (css = BS_INCREASE_NUM_OF_ADULT)
    public WebElement bsIncreaseNumOfAdult;

    @FindBy (css = BS_DECREASE_NUM_OF_CHILDREN)
    public WebElement bsDecreaseNumOfChildren;

    @FindBy (css = BS_INCREASE_NUM_OF_CHILDREN)
    public WebElement bsIncreaseNumOfChildren;

    @FindBy (css = BS_CHILD_1_AGE)
    public WebElement bsChild1Age;

    @FindBy (css = BS_CHILD_2_AGE)
    public WebElement bsChild2Age;

    @FindBy (css = BS_CHILD_3_AGE)
    public WebElement bsChild3Age;

    @FindBy (css = BS_CHILD_4_AGE)
    public WebElement bsChild4Age;

    @FindBy (css = BS_NUMBER_OF_TRAVELERS_DONE_BUTTON)
    public WebElement bsNumberOfTravelersDoneButton;

    @FindBy (css = BS_NUM_OF_ADULT_SELECTED)
    public WebElement bsNumberOfAdultSelected;

    @FindBy (css = BS_NUM_OF_CHILD_SELECTED)
    public WebElement bsNumberOfChildSelected;
    //END - NUMBER OF TRAVELERS

    //BEFORE SEARCH BUTTON
    @FindBy (xpath = BS_BEFORE_SEARCH_BUTTON)
    public WebElement bsSearchButton;

    //START - AFTER SEARCH
    @FindBy (css = AS_MODIFY_SEARCH)
    public WebElement asModifySearch;

    @FindBy (css = AS_SELECT_DESTINATION_DD)
    public WebElement asSelectDestinationDD;

    @FindBy (css = AS_DEPART_AS_EARLY)
    public WebElement asDepartAsEarly;

    @FindBy (css = AS_DEPART_AS_LATE)
    public WebElement asDepartAsLate;

    @FindBy (css = AS_CALENDAR_MONTH_YEAR_AS_EARLY)
    public WebElement asCalendarMonthYearAsEarly;

    @FindBy (css = AS_CALENDAR_MONTH_YEAR_AS_LATE)
    public WebElement asCalendarMonthYearAsLate;

    @FindBy (css = AS_NEXT_MONTH_BUTTON_AS_EARLY)
    public WebElement asNextMonthButtonAsEarly;

    @FindBy (css = AS_NEXT_MONTH_BUTTON_AS_LATE)
    public WebElement asNextMonthButtonAsLate;

    @FindBy (css = AS_NUM_OF_ADULTS)
    public WebElement asNumOfAdults;

    @FindBy (css = AS_NUM_OF_CHILDREN)
    public WebElement asNumOfChildren;

    @FindBy (css = AS_SEARCH_BUTTON)
    public WebElement asSearchButton;

    @FindBy (css = AS_NUM_OF_CHILDREN_ADDED)
    public WebElement asNumOfChildrenAdded;

    @FindBy (css = AS_MODAL_WINDOW)
    public WebElement asModalWindow;

    @FindBy (css = AS_MODAL_WINDOW_CLOSE_BUTTON)
    public WebElement asModalWindowCloseButton;

    @FindBy (css = AS_DATE_CHANGE_VERIFY)
    public WebElement asDateChangeVerify;
    //END - AFTER SEARCH

    //TC001C
    public String searchCruiseWithAllValidData() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(2);
        addChildren(2);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        return explicitWait.until(ExpectedConditions.visibilityOf(bsSearchResultOfNumOfCruises)).getText();
    }

    //TC002C
    public String searchCruiseWithAllInvalidData() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsCruiseMMButton)).click();
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(0);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        boolean isModalDisplayed = explicitWait.until(ExpectedConditions.visibilityOf(asModalWindow)).isDisplayed();
        System.out.println(isModalDisplayed);
        if (isModalDisplayed) {
            explicitWait.until(ExpectedConditions.visibilityOf(asModalWindowCloseButton)).click();
        }
        return explicitWait.until(ExpectedConditions.visibilityOf(bsSearchResultOfNumOfCruises)).getText();
    }

    //TC003C
    public String searchCruiseWithNoDestination() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsCruiseMMButton)).click();
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(4);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        return explicitWait.until(ExpectedConditions.visibilityOf(bsSearchResultOfNumOfCruises)).getText();
    }

    //TC004C
    public String searchCruiseWithNoDate() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(4);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        return explicitWait.until(ExpectedConditions.visibilityOf(bsSearchResultOfNumOfCruises)).getText();
    }

    //TC005C
    public String searchCruiseWithAddingChildren() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(3);
        addChildren(2);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        String numOfChildrenAndAdult = explicitWait.until(ExpectedConditions.visibilityOf(asNumOfChildrenAdded)).getText();
        String[] array = numOfChildrenAndAdult.split(",");
        return array[1].trim();
    }

    //TC006C
    public String numOfMaxAdultsCanBeAdded() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(7);
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(bsIncreaseNumOfAdult)).isEnabled();
        int maxNumOfAdultAllowed = 0;
        if (!buttonEnabled){
            maxNumOfAdultAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        }
        clickNumOfTravelersDoneButton();
        return String.valueOf(maxNumOfAdultAllowed);
    }

    //TC007C
    public String numOfMinAdultsCanBeAdded() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        int defaultTravelers = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        while (defaultTravelers != 1){
            explicitWait.until(ExpectedConditions.elementToBeClickable(bsDecreaseNumOfAdult)).click();
            defaultTravelers = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        }
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(bsDecreaseNumOfAdult)).isEnabled();
        int minNumOfAdultAllowed = 0;
        if (!buttonEnabled){
            minNumOfAdultAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        }
        clickNumOfTravelersDoneButton();
        return String.valueOf(minNumOfAdultAllowed);
    }

    //TC008C
    public String numOfMaxChildrenCanBeAdded() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addChildren(6);
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(bsIncreaseNumOfChildren)).isEnabled();
        int maxNumOfChildrenAllowed = 0;
        if (!buttonEnabled){
            maxNumOfChildrenAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(bsNumberOfChildSelected)).getAttribute("value"));
        }
        clickNumOfTravelersDoneButton();
        return String.valueOf(maxNumOfChildrenAllowed);
    }

    //TC009C
    public String  numOfMinChildrenCanBeAdded() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        boolean buttonEnabled = explicitWait.until(ExpectedConditions.visibilityOf(bsDecreaseNumOfChildren)).isEnabled();
        int minNumOfChildrenAllowed = 0;
        if (!buttonEnabled) {
            minNumOfChildrenAllowed = Integer.parseInt(explicitWait.until
                    (ExpectedConditions.visibilityOf(bsNumberOfChildSelected)).getAttribute("value"));
        }
        clickNumOfTravelersDoneButton();
        return String.valueOf(minNumOfChildrenAllowed);
    }

    //TC010C
    public String maxAgeOfChildrenAllowed() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addChildren(1);

        Select select = new Select(bsChild1Age);
        int selectOptions = select.getOptions().size();
        ArrayList<WebElement> childAges = (ArrayList<WebElement>) select.getOptions();
        ArrayList<String> ages = new ArrayList<>();
        for (WebElement age : childAges) {
            ages.add(age.getAttribute("innerHTML"));
        }
        clickNumOfTravelersDoneButton();
        return ages.get(ages.size() -1);
    }

    //TC011C
    public String warningMessageIfChildAgeNotProvided() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsIncreaseNumOfChildren)).click();
        String warningMsg = explicitWait.until(ExpectedConditions.visibilityOf(bsWarningMsgForMaxChildrenOrAdults)).getText();
        clickNumOfTravelersDoneButton();
        return warningMsg;
    }

    //TC012C
    public String warningMessageIfMaxNumOfTravelersAllowed() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(5);
        addChildren(1);
        String warningMsg = explicitWait.until(ExpectedConditions.visibilityOf(bsWarningMsgForMaxChildrenOrAdults)).getText();
        clickNumOfTravelersDoneButton();
        return warningMsg;
    }

    //TC013C
    public String phoneNumDisplayedForCruiseExpert() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        return explicitWait.until(ExpectedConditions.visibilityOf(bsCruiseExpertPhNum)).getText();
    }

    //TC014C
    public String checkCruiseResult() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(3);
        addChildren(2);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        return explicitWait.until(ExpectedConditions.visibilityOf(bsSearchResultOfNumOfCruises)).getText();
    }

    //TC015C
    public String afterSearchDateChange() {
        selectBSDestination(readFromExcel("REGExpected", 0));
        try {
            selectDate(readFromExcel("REGExpected", 1),
                    Integer.parseInt(readFromExcel("REGExpected", 2)),
                    readFromExcel("REGExpected", 3),
                    Integer.parseInt(readFromExcel("REGExpected", 4)));
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        clickOnAddTravelersMenu();
        addAdults(3);
        addChildren(2);
        clickNumOfTravelersDoneButton();
        searchForCruise();
        navigateToModifySearchPanel();
        modifyAsEarlyDate(asCalendarMonthYearAsEarly,
                          asNextMonthButtonAsEarly,
                readFromExcel("REGExpected", 5),
                Integer.parseInt(readFromExcel("REGExpected", 6)),
                          "start");
        modifyAsLateDate(asCalendarMonthYearAsLate,
                         asNextMonthButtonAsLate,
                readFromExcel("REGExpected", 7),
                Integer.parseInt(readFromExcel("REGExpected", 8)),
                         "end");
        modifySearchForCruise();
        return explicitWait.until(ExpectedConditions.visibilityOf(asDateChangeVerify)).getText();
    }

    public void selectBSDestination(String location) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsCruiseMMButton)).click();
        dropdownSelectByVisibleText(bsSelectDestinationDD, location.trim());
    }

    public void selectDate(String asEarlyMonth, int asEarlyDay, String asLateMonth, int asLateDay) throws ParseException {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsDepartAsEarly)).click();
        getCruiseDate(asEarlyMonth, asEarlyDay);
        getCruiseDate(asLateMonth, asLateDay);
    }

    public void clickOnAddTravelersMenu() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsNumOfTravelersMenu)).click();
    }

    public void clickNumOfTravelersDoneButton() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsNumberOfTravelersDoneButton)).click();
    }

    public void addAdults(int numberOfAdult) {
        int defaultTravelers = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        while (defaultTravelers != 1){
            explicitWait.until(ExpectedConditions.elementToBeClickable(bsDecreaseNumOfAdult)).click();
            defaultTravelers = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
        }
        for (int i = 2; i <= numberOfAdult; i++) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(bsIncreaseNumOfAdult)).click();
            int numOfAdult = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfAdultSelected)).getAttribute("value"));
            if (numOfAdult == 5) {
                break;
            }
        }
    }

    public void addChildren(int numberOfChild) {
        for (int i = 1; i <= numberOfChild; i++) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(bsIncreaseNumOfChildren)).click();
            int numOfChildren = Integer.parseInt(explicitWait.until(ExpectedConditions.visibilityOf(bsNumberOfChildSelected)).getAttribute("value"));
            switch (i) {
                case 1:
                    dropdownSelectByVisibleText(bsChild1Age,
                            "4");
                    break;
                case 2:
                    dropdownSelectByVisibleText(bsChild2Age,
                            "16");
                    break;
                case 3:
                    dropdownSelectByVisibleText(bsChild3Age,
                            "Under 1");
                    break;
                case 4:
                    dropdownSelectByVisibleText(bsChild4Age,
                            "7");
                    break;
            }
            if (numOfChildren == 4) {
                break;
            }
        }
    }

    public void searchForCruise() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(bsSearchButton)).click();
    }

    public void navigateToModifySearchPanel() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(asModifySearch)).click();
    }

    public void modifyDestination(String location) {
        dropdownSelectByVisibleText(asSelectDestinationDD, location.trim());
    }

    public void modifyAsEarlyDate(WebElement asCalendarMonthYear,
                                  WebElement asNextMonthButton,
                                  String asEarlyMonth,
                                  int asEarlyDay,
                                  String start) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(asDepartAsEarly)).click();
        pickCalendarDate(asCalendarMonthYear, asNextMonthButton, asEarlyMonth, asEarlyDay, start);
    }

    public void modifyAsLateDate(WebElement asCalendarMonthYear,
                                 WebElement asNextMonthButton,
                                 String asLateMonth,
                                 int asLateDay,
                                 String end) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(asDepartAsLate)).click();
        pickCalendarDate(asCalendarMonthYear, asNextMonthButton, asLateMonth, asLateDay, end);
    }

    public void modifyNumOfAdult(String numOfAdult) {
        dropdownSelectByVisibleText(asNumOfAdults, numOfAdult);
    }

    public void modifyNumOfChildren(String numOfChildren) {
        dropdownSelectByVisibleText(asNumOfChildren, numOfChildren);
    }

    public void modifySearchForCruise() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(asSearchButton)).click();
    }

    public void getCruiseDate(String months, int day) throws ParseException {
        while (true) {
            String extractMonthYear = explicitWait.until(ExpectedConditions.visibilityOf(bsCalendarMonthYear)).getText().toLowerCase();
            String[] extractMonth = extractMonthYear.split(" ");
            String formattedMonth = extractMonth[0].trim();
            if (formattedMonth.equals(months.toLowerCase())) {
                break;
            } else {
                explicitWait.until(ExpectedConditions.elementToBeClickable(bsNextMonthButton)).click();
            }
        }
        if (isCalendarDayDisabled(day)){
            driver.findElement(By.cssSelector("#wizard-cruise-pwa-1 > div div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody tr td button[data-day='"+getDate()+"']")).click();
        } else {
            WebElement exactDay = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#wizard-cruise-pwa-1 > div div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody tr td button[data-day='" + day + "']")));
            exactDay.click();
        }
    }

    public boolean isCalendarDayDisabled(int day) {
        String className = driver.findElement(By.cssSelector("#wizard-cruise-pwa-1 > div div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody tr td button[data-day='"+day+"']")).getAttribute("class");
        String subString = "is-disabled";
        if (className.contains(subString)) {
            return true;
        } else {
            return false;
        }
    }

    public String getDate() {
        String[] dateArray = new String[6];
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            Date todayWithZeroTime = formatter.parse(formatter.format(today));
            dateArray = todayWithZeroTime.toString().split(" ");
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return dateArray[2].trim();
    }

    public void pickCalendarDate(WebElement monthYearElement, WebElement monPickerBtn, String month, int day, String startORend) {
        while (true) {
            String extractMonthYear = explicitWait.until(ExpectedConditions.visibilityOf(monthYearElement)).getText().toLowerCase();
            String[] array = extractMonthYear.split(" ");
            String extractedMonth = array[0].trim();
            if (extractedMonth.equals(month.toLowerCase())) {
                break;
            } else {
                explicitWait.until(ExpectedConditions.elementToBeClickable(monPickerBtn)).click();
            }
        }
        WebElement exactDay = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(getCustomLocator(day, startORend))));
        exactDay.click();
    }

    //NEED TO MODIFY THIS getDay() HELPER METHOD BASED ON THE PROJECT REQUIREMENT
    //HELPER METHOD FOR pickCalendarDay()
    public String getCustomLocator(int day, String startORend) {
        return "#departureDate-"+startORend+"DateRange > div > div > div:nth-child(4) > table > tbody > tr > td > button[data-day='" + day + "']";
    }


}