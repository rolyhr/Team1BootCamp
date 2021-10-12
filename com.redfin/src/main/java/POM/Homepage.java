package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"header-content\"]/header[2]/div[2]/div[2]/a")
    public WebElement buyHouse;

    public BuyHousesHomePage navigateToBuy(){
        clickOnElement(buyHouse);
        System.out.println("clicked");
        return new BuyHousesHomePage();
    }

    public BuyHousesHomePage hoverToBuy(){
        hoverAction(buyHouse);
        return new BuyHousesHomePage();
    }

    public void doPriceRanges(WebElement click,WebElement minPrice,WebElement click2, WebElement maxPrice){
        clickOnElement(click);
        clickOnElement(minPrice);
        clickOnElement(click2);
        clickOnElement(maxPrice);
    }

    public void clearSearch(WebElement searchButtonLocation,WebElement clearButton){
        clickOnElement(searchButtonLocation);
        clickOnElement(clearButton);
    }

    public void sendKeywordLocation(WebElement keywordSearch,String location,WebElement firstChoice){
        sendKeysToInput(keywordSearch,location);
        clickOnElement(firstChoice);
    }

}
