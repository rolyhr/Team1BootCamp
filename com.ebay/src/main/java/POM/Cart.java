package POM;

import base.Base;
import static locators.CartLocators.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends Base {

    public Cart() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = SEARCH_INPUT)
    public WebElement searchInput;

    @FindBy (css = SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy (css = FIRST_ITEM_OF_SEARCH_RESULT)
    public WebElement firstItemOfSearchResult;

    @FindBy (css = ADD_TO_CART)
    public WebElement addToCart;

    @FindBy (css = DECLINE_PROTECTION_PLAN_BUTTON)
    public WebElement declineProtectionPlanButton;

    //TC001CT
    public void addItemToCart() {
        sendKeysToElement(searchButton, "Playstation 5");
        clickOnElement(searchButton);
        clickOnElement(firstItemOfSearchResult);

    }

    //HELPER METHODS


}
