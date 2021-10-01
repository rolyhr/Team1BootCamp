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

    String expDay;

    @FindBy(id = "location-field-locn-menu")
    WebElement pickingLocationButton;

    @FindBy(xpath = "//*[@class=\"uitk-typeahead-results no-bullet\"]//li[1]//button[1]")
    WebElement selectALocationFromPickupDropDown;

    @FindBy(css = "#location-field-locn")
    WebElement pickupLocationInput;

    @FindBy(xpath = "")
    WebElement dropOffLocationButton;

    @FindBy(css = "#location-field-loc2")
    WebElement dropOffLocationInput;

    @FindBy(xpath = "")
    WebElement droppingLocation;

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
    WebElement dropOffUpDaySameWindow;

    @FindBy(xpath = "")
    WebElement pickUpTimeComboBox;

    @FindBy(xpath = "")
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

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]//div[@class = 'uitk-flex-item']/span")
    WebElement searchResultTitle;

    @FindBy(xpath = "//label[@for='diff-loc']")
    WebElement searchPageDropOffLoc;

    @FindBy(xpath = "//div[@data-testid = 'lob-error-summary']")
    WebElement errorMessageForPickUpLocation;

    void clickPickingLocationButton(){ clickOnElement(pickingLocationButton);}
    void clickDropOffLocationButton(){ clickOnElement(dropOffLocationButton);}
    void selectPickUpLocation(){ clickOnElement(selectALocationFromPickupDropDown);}
    void selectDropOffLocation(){}
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

    void sendLocationToDropOffInputField(WebElement element, String dropOffLocation){
        sendKeysToInput(dropOffLocationInput,dropOffLocation);
    }

    String getPickUpMonthYear(){
        return pickUpMonthYear.getText();
    }

    public boolean isErrorMsgForPickUpLocationPresent(){
        return isElementPresent(errorMessageForPickUpLocation);
    }

    public void doSearchWithoutAnySelection(){
        clickOnSearchButton();
    }

    public void doSelectPickupAndDropOffDate(String picDay,String pickMonth, String pickYear,String dropDay,String dropMonth, String dropYear) throws InterruptedException {

        clickPickingLocationButton();
        waitForElementToBeVisible(pickupLocationInput);

        sendLocationToPickupInputField("New York");
        selectPickUpLocation();

        clickPickUpDateButton();
        calenderToVisible();

        datePicker(picDay,pickMonth,pickYear);
        datePicker(dropDay,dropMonth,dropYear);

        clickOnDoneButton();
        clickOnSearchButton();
        //waitForSearchResultPageToBeVisible();

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
