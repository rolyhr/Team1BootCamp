package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ptsLocators.PTSLocators.*;

public class PlacesToStay extends Base {

    public PlacesToStay() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = MM_PLACES_TO_STAY)
    public WebElement mmPlacesToStay;

    @FindBy (css = LOCATION_INPUT)
    public WebElement locationInput;

    @FindBy (css = MONTH_YEAR_TEXT)
    public WebElement monthYearText;

    @FindBy (css = DAYS_OF_MONTH)
    public WebElement daysOfMonth;

    @FindBy (css = NEXT_MONTH_BUTTON)
    public WebElement nextMonthButton;

    @FindBy (css = FIRST_ITEM_FROM_SEARCH_DD_OPTIONS)
    public WebElement firstItemFromSearchDD;

    //TC001PTS
    public void calendar() {
        enterLocation("Niagara Falls, NY");
        pickCalendarDate(monthYearText, nextMonthButton, "december", 25);

    }

    //HELPER METHODS
    public void enterLocation(String location) {
        clickOnElement(mmPlacesToStay);
        sendKeysToElement(locationInput, location);
        clickOnElement(firstItemFromSearchDD);
    }

    public void pickCalendarDate(WebElement monthYearElement, WebElement monPickerBtn, String month, int day) {
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
        WebElement exactDay = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("\""+getCustomLocator(day)+"\"")));
        exactDay.click();
    }

    public String getCustomLocator(int day) {
        return "#panel--tabs--0 div:nth-child(2) > div > table > tbody > tr > td > div[data-testid=\"datepicker-day-2021-10-"+day+"\"] > div > div";
    }

}
