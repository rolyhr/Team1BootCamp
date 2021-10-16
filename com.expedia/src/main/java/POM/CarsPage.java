package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarsPage extends Base {

    public CarsPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "location-field-locn-menu")
    WebElement pickingLocationButton;

    @FindBy(xpath = "//*[@class=\"uitk-typeahead-results no-bullet\"]//li[1]//button[1]")
    WebElement selectALocationFromPickupDropDown;

    @FindBy(css = "#location-field-locn")
    WebElement pickupLocationInput;

    @FindBy(xpath = "//*[@id=\"location-field-loc2-menu\"]/div[1]/button")
    WebElement dropOffLocationButton;

    @FindBy(css = "#location-field-loc2")
    WebElement dropOffLocationInput;

    @FindBy(id = "d1-btn")
    WebElement pickUpDateButton;

    @FindBy(id = "d2-btn")
    WebElement dropOffDateButton;

    @FindBy(xpath = "//*[@class = \"uitk-date-picker-menu-months-container\"]")
    WebElement calendar;

    @FindBy(xpath = "//*[@class = \"uitk-date-picker-menu-months-container\"]/div[1]//h2")
    WebElement pickUpMonthYear;

    @FindBy(xpath = "//*[@class = \"uitk-date-picker-menu-months-container\"]/div[2]//h2")
    WebElement dropOffMothYear;

    @FindBy(xpath = "//*[@class = \"uitk-date-picker-menu-months-container\"]//div[1]//tr//button[@data-day='20']")
    public WebElement pickUpDay;

    @FindBy(xpath = "//*[@class = \"uitk-date-picker-menu-months-container\"]//div[2]//tr//button[@data-day=20]")
    WebElement dropOffDaySameCalender;

    @FindBy(css = "#Rental-cars-transportation select[aria-label = 'Pick-up time']")
    WebElement pickUpTimeComboBox;

    @FindBy(css = "#Rental-cars-transportation select[aria-label = 'Drop-off time']")
    WebElement dropOffTimeComboBox;

    @FindBy(xpath = "")
    WebElement pickUpTime;

    @FindBy(xpath = "")
    WebElement dropOffTime;

    @FindBy(xpath = "//div[@class='uitk-calendar']//button[@data-stid=\"date-picker-paging\"][1]")
    WebElement leftArrowButton;

    @FindBy(xpath = "//div[@class='uitk-calendar']//button[@data-stid=\"date-picker-paging\"][2]")
    WebElement rightArrowButton;

    @FindBy(xpath = "//button[@data-stid=\"apply-date-picker\"]")
    WebElement doneButton;

    @FindBy(xpath = "//button[@type = \"submit\" and text() = \"Search\"]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]//label[contains(text(), 'Add a different')]")
    WebElement searchResultTitle;

    @FindBy(xpath = "//label[@for='diff-loc']")
    WebElement searchPageDropOffLoc;

    @FindBy(xpath = "//div[@data-testid = 'lob-error-summary']")
    WebElement errorMessageForPickUpLocation;

    @FindBy(xpath = "//*[@id=\"location-field-loc2-menu\"]/div[2]/ul/li[1]/button")
    WebElement selectALocationFromDropOffDropDown;

    @FindBy(css = "#countryCode")
    WebElement countryCodeDropDown;

    @FindBy(css = "#phoneNumber")
    WebElement phoneNumberInputField;

    @FindBy(css = "#submitBtn")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'download the app')]")
    WebElement messageForSuccessfulSubmit;

    @FindBy(xpath = "//div[contains(text(),'enter a valid')]")
    WebElement messageForUnsuccessfulSubmit;

    void sendPhoneNumberToPhoneNumberInputField(String phoneNumber){sendKeysToInput(phoneNumberInputField,phoneNumber);}

    void clickOnSubmitButton(){clickOnElement(submitButton);}

    void clickOnCountryCode(){clickOnElement(countryCodeDropDown);}

    void clickDropOffTimeComboBox(){clickOnElement(dropOffTimeComboBox);}

    void selectDropOffTime(String time){dropdownSelectByVisibleText(dropOffTimeComboBox,time);}

    void clickPickUpTimeComboBox(){clickOnElement(pickUpTimeComboBox);}

    void selectPickUpTime(String time){dropdownSelectByVisibleText(pickUpTimeComboBox,time);}

    void clickPickingLocationButton(){ clickOnElement(pickingLocationButton);}

    void clickDropOffLocationButton(){ clickOnElement(dropOffLocationButton);}

    void selectPickUpLocation(){ clickOnElement(selectALocationFromPickupDropDown);}

    void selectDropOffLocation(){clickOnElement(selectALocationFromDropOffDropDown);}

    void clickPickUpDateButton(){ clickOnElement(pickUpDateButton);}

    void clickDropOffDateButton(){ clickOnElement(dropOffDateButton);}


    void selectPickUpDay(String expDay){
        try {
            driver.findElement(By.xpath("//*[@class = \"uitk-date-picker-menu-months-container\"]//div[1]//tr//button[@data-day='" + expDay + "']")).click();
        }catch (Exception e){
            System.out.println("Invalid Date Selection");
        }
    }

    void selectDropOffDay(String expDay){
        driver.findElement(By.xpath("//*[@class = \"uitk-date-picker-menu-months-container\"]//div[1]//tr//button[@data-day='"+expDay+"']")).click();
    }

    void clickOnRightArrowButton(){ clickOnElement(rightArrowButton);}

    void clickOnLeftArrowButton(){ clickOnElement(leftArrowButton);}

    void clickOnDoneButton(){clickOnElement(doneButton);}

    void clickOnSearchButton(){ clickOnElement(searchButton);}

    void calenderToVisible(){ waitForElementToBeVisible(calendar);}

    void waitForSearchResultPageToBeVisible(){waitForElementToBeVisible(searchResultTitle);}

    public boolean isSearchPageDropOffLocPresent(){
        return isElementPresent(searchPageDropOffLoc);
    }

    void sendLocationToPickupInputField(String pickUpLocation){
        sendKeysToInput(pickupLocationInput,pickUpLocation);
    }

    void sendLocationToDropOffInputField(String dropOffLocation){sendKeysToInput(dropOffLocationInput,dropOffLocation);}

    String getPickUpMonthYear(){
        return pickUpMonthYear.getText();
    }

    public boolean isErrorMsgForPickUpLocationPresent(){
        return isElementPresent(errorMessageForPickUpLocation);
    }

    public boolean isSearchResultTitlePresent(){ return isElementPresent(searchResultTitle);}

    public boolean hasMessageAppearForValidSubmission(){return isElementPresent(messageForSuccessfulSubmit);}

    public boolean hasMessageAppearForInvalidSubmission(){return isElementPresent(messageForUnsuccessfulSubmit);}



    public void doSearchCarBySelectSamePickUpAndDropOffTime(String location, String pickTime, String dropOffTime,String picDay,String pickMonth,String pickYear,String dropDay,String dropMonth,String dropYear){
        clickPickingLocationButton();
        waitForElementToBeVisible(pickupLocationInput);

        sendLocationToPickupInputField(location);
        selectPickUpLocation();

        clickPickUpTimeComboBox();
        selectPickUpTime(pickTime);

        clickDropOffTimeComboBox();
        selectDropOffTime(dropOffTime);

        clickPickUpDateButton();
        calenderToVisible();

        datePicker(picDay,pickMonth,pickYear);
        datePicker(dropDay,dropMonth,dropYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();
    }

    public void doSearchCarBySelectPickUpTime(String time,String location,String picDay,String pickMonth,String pickYear,String dropDay,String dropMonth,String dropYear){
        clickPickingLocationButton();
        waitForElementToBeVisible(pickupLocationInput);

        sendLocationToPickupInputField(location);
        selectPickUpLocation();

        clickPickUpTimeComboBox();
        selectPickUpTime(time);

        clickPickUpDateButton();
        calenderToVisible();

        datePicker(picDay,pickMonth,pickYear);
        datePicker(dropDay,dropMonth,dropYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();
    }

    public void doDownloadAppByInvalidPhoneNumber(String countryCode, String phoneNumber){
        clickOnCountryCode();
        dropdownSelectByVisibleText(countryCodeDropDown,countryCode);
        sendPhoneNumberToPhoneNumberInputField(phoneNumber);
        clickOnSubmitButton();
        waitForElementToBeVisible(messageForUnsuccessfulSubmit);
    }

    public void doDownloadAppByValidPhoneNumber(String countryCode, String phoneNumber){
        clickOnCountryCode();
        dropdownSelectByVisibleText(countryCodeDropDown,countryCode);
        sendPhoneNumberToPhoneNumberInputField(phoneNumber);
        clickOnSubmitButton();
        waitForElementToBeVisible(messageForSuccessfulSubmit);
    }

    public void doDownLoadAppForDifferentCountry(String countryCode, String phoneNumber){
        clickOnCountryCode();
        dropdownSelectByVisibleText(countryCodeDropDown,countryCode);
        sendPhoneNumberToPhoneNumberInputField(phoneNumber);
        clickOnSubmitButton();
        waitForElementToBeVisible(messageForSuccessfulSubmit);
    }

    public void doSearchBySelectDropOffLocation(String pickLocation,String dropOffLocation, String picDay, String pickMonth, String pickYear, String dropDay, String dropMonth, String dropYear){

        clickPickingLocationButton();
        waitForElementToBeVisible(pickupLocationInput);

        sendLocationToPickupInputField(pickLocation);
        selectPickUpLocation();

        clickDropOffLocationButton();
        waitForElementToBeVisible(dropOffLocationInput);

        sendLocationToDropOffInputField(dropOffLocation);
        selectDropOffLocation();

        clickPickUpDateButton();
        calenderToVisible();

        datePicker(picDay,pickMonth,pickYear);
        datePicker(dropDay,dropMonth,dropYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();

    }

    public void doSearchWithoutAnySelection(){
        clickOnSearchButton();
    }

    public void doSearchBySelectPickupAndDropOffDate(String location,String picDay, String pickMonth, String pickYear, String dropDay, String dropMonth, String dropYear) throws InterruptedException {

        clickPickingLocationButton();
        waitForElementToBeVisible(pickupLocationInput);

        sendLocationToPickupInputField(location);
        selectPickUpLocation();

        clickPickUpDateButton();
        calenderToVisible();

        datePicker(picDay,pickMonth,pickYear);
        datePicker(dropDay,dropMonth,dropYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();

    }
    public void datePicker(String expDay, String expMonth, String expYear){

        String monthYear = getPickUpMonthYear();
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();

        while(!(month.equalsIgnoreCase(expMonth) && year.equalsIgnoreCase(expYear))){
            clickOnRightArrowButton();

            monthYear = getPickUpMonthYear();
            month = monthYear.split(" ")[0].trim();
            year = monthYear.split(" ")[1].trim();
        }
        selectPickUpDay(expDay);


    }


}
