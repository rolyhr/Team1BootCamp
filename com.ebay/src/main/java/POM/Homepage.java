package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@type='text']")
    public WebElement searchInput;

    @FindBy (css = "select#gh-cat")
    public WebElement categoryDropdown;

    @FindBy (css = "input#gh-btn")
    public WebElement searchButton;

    @FindBy (css = "div.srp-controls__control.srp-controls__count > h1 > span:nth-child(2)")
    public WebElement searchResultPageElement;

    @FindBy(xpath="//*[@id=\"s0-14-11-5-2[1]\"]/div[2]/div[1]/div/ul/li[3]/a/span")
    public WebElement clickOnAuctionTab;


    public void doSearch(String searchTerm, String category) {
        sendKeysToSearchInput(searchTerm);
        selectSearchCategory(category);
        clickSearchButton();
    }

    private void clickSearchButton() {
        clickJScript(searchButton);
    }

    private void selectSearchCategory(String category) {
        dropdownSelectByVisibleText(categoryDropdown, category);
    }

    private void sendKeysToSearchInput(String keys) {
        sendKeysToInput(searchInput, keys);
    }

    private void clickOnAuctionTab(){
        clickOnElement(clickOnAuctionTab);
    }





}
