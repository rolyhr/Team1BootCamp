package cruiseLocators;

public class CruiseLocators {

    //BEFORE SEARCH LOCATORS
    public final static String BS_CRUISE_MM_BUTTON = "#wizardMainRegionV2 > div div > ul > li:nth-child(6) > a";
    public final static String BS_SELECT_DESTINATION_DD = "#cruise-destination";
    public final static String BS_DEPART_AS_EARLY = "#d1-btn";
    public final static String BS_CALENDAR_MONTH_YEAR = "#wizard-cruise-pwa-1 > div div > div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > h2";
    public final static String BS_NEXT_MONTH_BUTTON = "#wizard-cruise-pwa-1 > div div.uitk-flex.uitk-flex-justify-content-space-between.uitk-date-picker-menu-pagination-container > button:nth-child(2)";
    //HARD CODED IN THE METHOD BUT LOCATOR IS DYNAMIC
    public final static String BS_SEARCH_DAY = "#wizard-cruise-pwa-1 > div div.uitk-calendar > div.uitk-date-picker-menu-months-container > div:nth-child(1) > table > tbody tr td button[data-day=\"6\"]";

    //NUMBER OF TRAVELERS LOCATORS
    public final static String BS_NUMBER_OF_TRAVELERS_MENU = "#adaptive-menu > a";
    public final static String BS_NUM_OF_ADULT_SELECTED = "#adaptive-menu div.adultStepInput.uitk-step-input-mounted div > input";
    public final static String BS_NUM_OF_CHILD_SELECTED = "#adaptive-menu div.childStepInput.uitk-step-input-mounted div > input";
    public final static String BS_DECREASE_NUM_OF_ADULT = "#adaptive-menu div.adultStepInput.uitk-step-input-mounted div > button:nth-child(1)";
    public final static String BS_INCREASE_NUM_OF_ADULT = "#adaptive-menu div.adultStepInput.uitk-step-input-mounted div > button:nth-child(3)";
    public final static String BS_DECREASE_NUM_OF_CHILDREN = "#adaptive-menu div.childStepInput.uitk-step-input-mounted div > button:nth-child(1)";
    public final static String BS_INCREASE_NUM_OF_CHILDREN = "#adaptive-menu div.childStepInput.uitk-step-input-mounted div > button:nth-child(3)";
    public final static String BS_CHILD_1_AGE = "#child-age-input-0-0";
    public final static String BS_CHILD_2_AGE = "#child-age-input-0-1";
    public final static String BS_CHILD_3_AGE = "#child-age-input-0-2";
    public final static String BS_CHILD_4_AGE = "#child-age-input-0-3";
    public final static String BS_NUMBER_OF_TRAVELERS_DONE_BUTTON = "#adaptive-menu > div > div > div.uitk-scrim.guestsDoneBtn.fade-button > button";
    public final static String BS_BEFORE_SEARCH_BUTTON = "//*[@id=\"wizard-cruise-pwa-1\"]/div[3]/div[2]/button";
    public final static String BS_WARNING_MSG_FOR_MAX_CHILDREN_OR_ADULTS = "#adaptive-menu > div > div > div.all-x-padding-one.all-t-padding-two > div > div > h3";
    public final static String BS_CRUISE_EXPERT_PH_NUM = "#wizard-cruise-pwa-1 > div div:nth-child(1) > p";
    public final static String BS_SEARCH_RESULT_OF_NUM_OF_CRUISES = "#ember452 > h1 > span:nth-child(1)";

    //AFTER SEARCH LOCATORS
    public final static String AS_MODIFY_SEARCH = "#change-search-toggle";
    public final static String AS_SELECT_DESTINATION_DD = "div#cruisesSearch div.cruise-menu-item.destination select#destination-select";
    public final static String AS_DEPART_AS_EARLY = "#departureDate-startDateRangeInput";
    public final static String AS_DEPART_AS_LATE = "#departureDate-endDateRangeInput";
    public final static String AS_CALENDAR_MONTH_YEAR_AS_EARLY = "#departureDate-startDateRange > div > div > div:nth-child(4) > table > caption";
    public final static String AS_CALENDAR_MONTH_YEAR_AS_LATE = "#departureDate-endDateRange > div > div > div:nth-child(4) > table > caption";
    public final static String AS_NEXT_MONTH_BUTTON_AS_EARLY = "#departureDate-startDateRange > div > div > button.datepicker-next.next";
    public final static String AS_NEXT_MONTH_BUTTON_AS_LATE = "#departureDate-endDateRange> div > div > button.datepicker-next.next";
    public final static String AS_NUM_OF_CHILDREN_ADDED = "#travelers-select";
    //HARD CODED IN THE METHOD BUT LOCATOR IS DYNAMIC
    public final static String AS_SEARCH_DAY = "#departureDate-startDateRange > div > div > div:nth-child(4) > table > tbody > tr > td > button[data-day=\"6\"]";

    //NUMBER OF TRAVELERS LOCATORS
    public final static String AS_NUM_OF_ADULTS = "#adultOptions-select";
    public final static String AS_NUM_OF_CHILDREN = "#childOptions-select";
    public final static String AS_SEARCH_BUTTON = "#cruiseSearchButton";

}
