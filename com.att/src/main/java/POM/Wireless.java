package POM;

import base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static POM.locators.WirelessLocators.*;

public class Wireless extends Base {
    public Wireless() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = WIRELESS )
    public WebElement wireless;

    @FindBy(id = IFRAME3)
    public WebElement iframe;

    @FindBy(css = WIRELESS_NAVBAR_LIST)
    public List<WebElement> wirelessNavBarList;

    @FindBy(css =  TABLE_ROW_LIST)
    public List<WebElement> tableRowList ;

    @FindBy(css = TABLE_COLUMN_LIST )
    public List<WebElement> tableColumnList ;

    @FindBy(css =  TABLE_ELEMENT_LIST)
    public List<WebElement> tableElementList;

    @FindBy(css = ANY_PHONE_YOUR_CHOICE_LIST)
    public List<WebElement> anyPhoneYourChoiceList;

    @FindBy(css = CONTAINER_TITLE)
    public WebElement containerTitle ;

    @FindBy(css = HAMBURGER_MENU )
    public WebElement hamburerMenu ;

    @FindBy(css = HAMBURGER_MENU_LIST)
    public List<WebElement> hamburgerMenuList ;

    @FindBy(css =  ATT_NAVBAR_LIST)
    public List<WebElement> attNavbarList;

    @FindBy(css = SEARCH_RESULT )
    public WebElement searchResult;

    @FindBy(css = SEARCH_BOX )
    public WebElement searchBox ;

    @FindBy(css = SEARCH_BUTTON )
    public WebElement searchButton ;

    public void navigateToWireless(){
        try {
            clickOnElement(wireless);
        }catch (Exception e){
            clickJScript(wireless);
        }
    }

    public void clickOnhamburerMenu(){
       clickOnElement(hamburerMenu);
    }

    public void clickOnSearchBox(){
        clickOnElement(searchBox);
    }

    public void searchProductWithMouse(String element){
        searchBox.sendKeys(element);
    }

    public String getContainerTitle(String element){
        return containerTitle.getText();
    }

    public String getSearchResult(String element){
        return searchResult.getText();
    }

    public int getNumberofRows(){
        scroll();
        waitForElementToBeVisible(tableRowList.get(1));
        return getListOfTableRowList().size();
    }

    public int getNumberofColumns(){
        return getListOfTableColumnList().size();
    }


    public void searchProductWithKeyboard(String element){
        searchBox.sendKeys(element);
        searchBox.sendKeys(Keys.ENTER);

    }


    public List<String> getListOfAttNavBarElements(){
     return getListOfStringElements(attNavbarList);
    }

    public List<String> getListOfWirelessNavBarList(){
        return getListOfStringElements(wirelessNavBarList);
    }

    public List<String> getListOfTableElementList(){
        return getListOfStringElements(tableElementList);
    }

    public List<String> getListOfTableColumnList(){
        return getListOfStringElements(tableColumnList);
    }

    public List<String> getListOfTableRowList(){
        return getListOfStringElements(tableRowList);
    }

    public List<String> getListOfAnyPhoneYourChoiceList(){
        return getListOfStringElements(anyPhoneYourChoiceList);
    }

    public List<String> getListOfHamburgerMenuList(){
        return getListOfStringElements(hamburgerMenuList);
    }


}
