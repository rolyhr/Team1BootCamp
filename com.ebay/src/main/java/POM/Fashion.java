package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    //SHOP BY CATEGORY SEE ALL
    @FindBy(css = SEE_ALL_WOMENSHOES_SH0PBYBRAND)
    public WebElement seeAllWomenshoesShopByBrand ;

    @FindBy(id = SEE_ALL_CONTAINER)
    public WebElement seeAllContainer;

    @FindBy(id = DELEIVERY_OPTION)
    public WebElement DeleiveryOption;

    @FindBy(css = CHECK_BOX_FREE_INTERNATIONAL_SHIPPING)
    public WebElement checkBoxFreeInternationalShipping;

    @FindBy(css = APPLY_BUTTON)
    public WebElement applyButton;

    @FindBy(css = FILTER_RESULT)
    public WebElement filterResult;


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

    //search
    public void  sendValueInSearchFashion(String element){
        searchBox.sendKeys(element);
    }

    public void  clickOnSearchButton(){
        clickOnElement(searchButton);
    }

    public  int searchFashionProduct(String element){
        sendValueInSearchFashion(element);
        clickOnSearchButton();
        String stringSearchResult = searchResult.getText().replaceAll(",","");
        return Integer.parseInt(stringSearchResult);
    }

    /*women Fashion
    public void navigateToWomenShoes(){
      clickOnElement(fashionShopByCategoryList.get(6));
    }

    public void clickOnSellWallWomenShoeShopByBrand(){
        clickOnElement(seeAllWomenshoesShopByBrand);
        waitForElementToBeVisible(seeAllContainer);
    }

    public void clickOnDeleiveryOption(){
        clickOnElement(DeleiveryOption);
     //   waitForElementToBeVisible(checkBoxFreeInternationalShipping);
    }

    public void selectCheckBox(){
        clickOnElement(checkBoxFreeInternationalShipping);
    }

    public void clickOnApplyButton(){
        clickOnElement(applyButton);
    }

    public void filterProductByShopByBradFreeInternationalShipping(){
        navigateToWomenShoes();
        String parent_window = getCurrentWindow();
        clickOnSellWallWomenShoeShopByBrand();
        windowHandel(parent_window);
        clickJScript(applyButton);
        //waitForElementToBeVisible(filterResult);
    }*/



}