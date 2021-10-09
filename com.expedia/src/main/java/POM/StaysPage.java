package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaysPage extends Base {

    public StaysPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@id=\"location-field-destination-menu\"]/div[1]/button")
    WebElement goingToLocationButton;

    @FindBy(xpath="//*[@id=\"location-field-destination-menu\"]/div[2]/ul/li[1]/button[1]")
    WebElement selectCityFromDropDownMenu;

    @FindBy(xpath="//*[@id=\"location-field-destination\"]")
    WebElement locationFieldDestinationInput;

    @FindBy(xpath="//*[@id=\"d1-btn\"]")
    WebElement checkInDate;

    @FindBy(xpath="//*[@id=\"d2-btn\"]")
    WebElement checkOutDate;

    @FindBy(xpath="//*[@class=\"uitk-date-picker-menu-months-container\"]")
    WebElement calendar;

    @FindBy(xpath="//*[@class = \"uitk-date-picker-menu-months-container\"]/div[1]//h2")
    WebElement checkInMonthYear;

    @FindBy(xpath="//*[@class = \"uitk-date-picker-menu-months-container\"]/div[2]//h2")
    WebElement checkOutMonthYear;

    @FindBy(xpath="//*[@class = \"uitk-date-picker-menu-months-container\"]/div[1]/table/tbody/tr[5]/td[2]/button[@data-day='25']")
    WebElement checkInDay;

    @FindBy(xpath="//*[@class = \"uitk-date-picker-menu-months-container\"]/div[2]/table/tbody/tr[4]/td[1]/button[@data-day='21']")
    WebElement checkOutDay;

    @FindBy(xpath="//*[@class=\"uitk-calendar\"]/div/button[@data-stid=\"date-picker-paging\"][1]")
    WebElement leftArrowButton;

    @FindBy(xpath="//div[@class=\"uitk-calendar\"]//button[@data-stid=\"date-picker-paging\"][2]")
    WebElement rightArrowButton;

    @FindBy(xpath="//*[@data-stid=\"apply-date-picker\"]")
    WebElement doneButton;

    @FindBy(xpath="//button[@type = \"submit\" and text() = \"Search\"]")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]//div[@class='uitk-flex main-region']")
    WebElement searchResultTitle;

//    @FindBy(xpath="//*[@id=\"sort\"]")
//    WebElement sortByRecommandedButton;

    void clickOnGoingToLocationButton() {
        clickOnElement(goingToLocationButton);
    }
    void selectCityFromLocation(){
        clickOnElement(selectCityFromDropDownMenu);
    }

    void clickCheckInDateButton(){
        clickOnElement(checkInDate);
    }
    void clickCheckoutDateButton(){
        clickOnElement(checkOutDate);
    }

    void selectCheckInDay(String expectedDay){
        try{
            driver.findElement(By.xpath("//*[@class = \"uitk-date-picker-menu-months-container\"]/div[1]/table/tbody/tr[5]/td[2]/button[@data-day='" + expectedDay +"']")).click();
        }catch(Exception e){
            System.out.println("Wrong date selection");
        }
    }

    void selectCheckoutDay(String expectedDay){
        driver.findElement(By.xpath("//*[@class = \"uitk-date-picker-menu-months-container\"]/div[2]/table/tbody/tr[4]/td[1]/button[@data-day='" + expectedDay + "']")).click();
    }

    void clickOnLeftArrowButton(){
        clickOnElement(leftArrowButton);
    }

    void clickOnRightArrowButton(){
        clickOnElement(rightArrowButton);
    }

    void clickOnDoneButton(){
        clickOnElement(doneButton);
    }

    void clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    void calenderToVisible(){
        waitForElementToBeVisible(calendar);
    }

    void waitForSearchResultPageToBeVisible(){
        waitForElementToBeVisible(searchResultTitle);
    }

    void sendLocationFieldDestinationInput(String goingToLocation){
        sendKeysToInput(locationFieldDestinationInput,goingToLocation);
    }

    String getCheckInMonthYear(){
        return checkInMonthYear.getText();
    }


    public boolean isSearchResultTitlePresent(){
        return isElementPresent(searchResultTitle);
    }

    public void doSearchBySelectGoingToLocation(String location,String checkInDay, String checkInMonth, String checkInYear, String checkOutDay, String checkOutMonth, String checkOutYear){

        clickOnGoingToLocationButton();
        waitForElementToBeVisible(locationFieldDestinationInput);

        sendLocationFieldDestinationInput(location);
        selectCityFromLocation();

        clickCheckInDateButton();
        calenderToVisible();

        datePicker(checkInDay,checkInMonth,checkInYear);
        datePicker(checkOutDay,checkOutMonth,checkOutYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();

    }

    public void doSearchWithoutAnySelection(){
        clickOnSearchButton();
    }

    public void doSearchBySelectCheckInAndCheckOutDate(String location,String checkInDay, String checkInMonth, String checkInYear, String checkOutDay, String checkOutMonth, String checkOutYear) throws InterruptedException {

        clickOnGoingToLocationButton();
        waitForElementToBeVisible(locationFieldDestinationInput);

        sendLocationFieldDestinationInput(location);
        selectCityFromLocation();

        clickCheckInDateButton();
        calenderToVisible();

        datePicker(checkInDay,checkInMonth,checkInYear);
        datePicker(checkOutDay,checkOutMonth,checkOutYear);

        clickOnDoneButton();
        clickOnSearchButton();
        waitForSearchResultPageToBeVisible();

    }
    public void datePicker(String expectedDay, String expectedMonth, String expectedYear){

        String monthYear = getCheckInMonthYear();
        String month = monthYear.split(" ")[0].trim();
        String year = monthYear.split(" ")[1].trim();

        while(!(month.equalsIgnoreCase(expectedMonth) && year.equalsIgnoreCase(expectedYear))){
            clickOnRightArrowButton();

            monthYear = getCheckInMonthYear();
            month = monthYear.split(" ")[0].trim();
            year = monthYear.split(" ")[1].trim();
        }
        selectCheckInDay(expectedDay);


    }





















}
