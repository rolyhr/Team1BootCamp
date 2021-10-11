package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    }

    //HELPER METHODS
    public void enterLocation(String location) {
        clickOnElement(mmPlacesToStay);
        sendKeysToElement(locationInput, location);
        clickOnElement(firstItemFromSearchDD);
    }

}
