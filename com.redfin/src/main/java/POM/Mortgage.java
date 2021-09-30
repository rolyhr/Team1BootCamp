package POM;

import base.Base;
import static locators.MortgageLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Mortgage extends Base {

    public Mortgage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = MORTGAGE_MM_BUTTON)
    public WebElement mortgageMMButton;

    @FindBy (css = MORTGAGE_SM_COMPARE_RATE_BUTTON)
    public WebElement mortgageSMCompareRateButton;

    @FindBy (css = MORTGAGE_SM_PAYMENT_CAL_BUTTON)
    public WebElement mortgageSMPaymentCalButton;

    @FindBy (css = MORTGAGE_PURCHASE_BUTTON)
    public WebElement mortgagePurchaseButton;

    @FindBy (css = MORTGAGE_REFINANCE_BUTTON)
    public WebElement mortgageRefinanceButton;

    @FindBy (css = MORTGAGE_LOCATION_INPUT_DEFAULT_VALUE)
    public WebElement mortgageLocationInputDefaultValue;

    @FindBy (css = MORTGAGE_LOCATION_INPUT)
    public WebElement mortgageLocationInput;

    @FindBy (css = MORTGAGE_LOCATION_INPUT_RESULT)
    public WebElement mortgageLocationInputResult;

    @FindBy (css = MORTGAGE_HOME_PRICE_INPUT)
    public WebElement mortgageHomePriceInput;

    @FindBy (css = MORTGAGE_DOWN_PAYMENT_DOLLAR)
    public WebElement mortgageDownPaymentDollar;

    @FindBy (css = MORTGAGE_DOWN_PAYMENT_PERCENTAGE)
    public WebElement mortgageDownPaymentPercentage;

    @FindBy (css = MORTGAGE_UPDATE_RATE_BUTTON)
    public WebElement mortgageUpdateRateButton;

    @FindBy (css = MORTGAGE_MORE_OPTIONS)
    public WebElement mortgageMoreOptions;

    @FindBy (css = MORTGAGE_LOAN_TYPE_SELECT_DP)
    public WebElement mortgageLoanTypeSelectDP;

    @FindBy (css = MORTGAGE_CREDIT_SCORE_SELECT_DP)
    public WebElement mortgageCreditScoreSelectDP;

    @FindBy (css = MORTGAGE_MILITARY_SELECT_DP)
    public WebElement mortgageMilitarySelectDP;

    public void navigateToMortgageRatePage() {
        hoverOverElement(mortgageMMButton, mortgageSMCompareRateButton);
    }

    public void navigateToMortgageCalPage() {
        hoverOverElement(mortgageMMButton, mortgageSMPaymentCalButton);
    }

    public void calculateMortgageRateWithPercentage() {
        clickOnElement(mortgagePurchaseButton);
        sendKeysToElement(mortgageLocationInput, "Queens");
        clickOnElement(mortgageLocationInputResult);
        driver.findElement(By.cssSelector(MORTGAGE_HOME_PRICE_INPUT)).clear();
        sendKeysToElement(mortgageHomePriceInput, "550000");
        driver.findElement(By.cssSelector(MORTGAGE_DOWN_PAYMENT_PERCENTAGE)).clear();
        sendKeysToElement(mortgageDownPaymentPercentage, "25");
        clickOnElement(mortgageUpdateRateButton);
    }

    public void calculateMortgageRateWithDollarAmount() {
        clickOnElement(mortgagePurchaseButton);
        sendKeysToElement(mortgageLocationInput, "Queens");
        clickOnElement(mortgageLocationInputResult);
        driver.findElement(By.cssSelector(MORTGAGE_HOME_PRICE_INPUT)).clear();
        sendKeysToElement(mortgageHomePriceInput, "550000");
        driver.findElement(By.cssSelector(MORTGAGE_DOWN_PAYMENT_DOLLAR)).clear();
        sendKeysToElement(mortgageDownPaymentDollar, "125000");
        clickOnElement(mortgageUpdateRateButton);
    }

    public void calculateMortgageRateWithAdvanceOptions() {
        clickOnElement(mortgagePurchaseButton);
        sendKeysToElement(mortgageLocationInput, "Queens");
        clickOnElement(mortgageLocationInputResult);
        driver.findElement(By.cssSelector(MORTGAGE_HOME_PRICE_INPUT)).clear();
        sendKeysToElement(mortgageHomePriceInput, "550000");
        driver.findElement(By.cssSelector(MORTGAGE_DOWN_PAYMENT_DOLLAR)).clear();
        sendKeysToElement(mortgageDownPaymentDollar, "125000");
        clickOnElement(mortgageMoreOptions);
        Select loanType = new Select(mortgageLoanTypeSelectDP);
        loanType.selectByValue("20yr");
        Select creditScore = new Select(mortgageCreditScoreSelectDP);
        creditScore.selectByValue("740-759");
        Select military = new Select(mortgageMilitarySelectDP);
        loanType.selectByValue("NationalGuard");
        clickOnElement(mortgageUpdateRateButton);
    }

    public String getLocation(String city) {

        return city;
    }

//    public ArrayList<String> returnArrayList(String locator)    {
//        ArrayList<WebElement> lists = (ArrayList<WebElement>) driver.findElements(By.cssSelector(locator));
//        ArrayList<String> allCity = new ArrayList<>();
//        for (WebElement location : lists) {
//            allCity.add(location.getText());
//        }
//        return allCity;
//    }

}
