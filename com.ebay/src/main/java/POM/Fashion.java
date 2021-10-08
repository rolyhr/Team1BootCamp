package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static POM.locators.FashionLocators.*;

public class Fashion extends Base {
    public Fashion() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = FASHION_NAV)
    public WebElement navigateToFashion;

    @FindBy(css = FASHION_CATEGORY_DROPDOWN_MENU)
    public WebElement dropDownMenuFashion;

    @FindBy(css = FASHION_SUBCATEGORY_PANEL)
    public WebElement fashionSubcategoryPanel;

    @FindBy(css = FASHION_CATEGORY_LIST)
    public List<WebElement> fashionCategoryList;

    @FindBy(css = FASHION_MORE_CATEGORY_LIST)
    public List<WebElement> fashionMoreCategoryList;

    @FindBy(css= FASHION_SHOP_BY_CATEGORY_LIST)
    public List<WebElement> fashionShopByCategoryList;

    //search
    @FindBy(id = SEARCHBOX)
    public WebElement searchBox;

    @FindBy(id = SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy(css = SEARCH_RESULT)
    public WebElement searchResult;

    public void navigateToFashion() {
       clickOnElement(navigateToFashion);
    }

    public boolean hoverFashionFromNavBar() {
        hoverOverElement(dropDownMenuFashion,fashionSubcategoryPanel);
        if (fashionSubcategoryPanel.isDisplayed())
         {
            return true;
        }else{
            return false;
        }
    }

    public List<String> getFashionMostPopularCategory(){
        return getListOfStringElements(fashionCategoryList);
    }

    public List<String> getFashionMoreCategory(){
        return getListOfStringElements(fashionMoreCategoryList);
    }

    public List<String> getFashionShopByCategory(){
        return getListOfStringElements(fashionShopByCategoryList);
    }

    public  String searchFashionProduct(String element){
        searchBox.sendKeys(element);
        clickOnElement(searchButton);
        return searchResult.getText();
    }

}