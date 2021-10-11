package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static POM.locators.SalesDelasLocators.*;

public class SalesDeals  extends Base {

    public SalesDeals() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = SALESANDDEALS)
    public WebElement salesAndDeals;

    @FindBy(css = SALESANDDEALS_NAVBAR_LIST)
    public List<WebElement> salesAndDealsNavBarList;

    @FindBy(css = SHHOP_BY_DEPARTMENT_LIST )
    public List<WebElement> shopByDeppartmentList;

    @FindBy(css = SEASONAL_SALES_HEADINGS)
    public WebElement seasonalSalesHeading;

    @FindBy(css = DEALS_BY_DEPARTMENT_HEADING )
    public WebElement dealsByDepartmentheadings;

    @FindBy(xpath = FILTER_CATEGORY_LIST)
    public List<WebElement> filterCategoryList;

    @FindBy(css = FILTER_COLOR_LIST)
    public List<WebElement> filterColorList;

    @FindBy(css = FILTER_COLOR_RESULT)
    public List<WebElement>  filterColorResult;

    @FindBy(css = PRODUCT_PRICE_LIST)
    public List<WebElement> productPriceList;

    @FindBy(css = PRODUCT_DETAILS_BUTTON )
    public WebElement  productDetailsButton;

    @FindBy(css = DETAILS_RESULT)
    public WebElement detailsResult;

    @FindBy(id = ADD_PRODUCT_QUANTITY)
    public WebElement addProductQuantity ;

    @FindBy(css = QUANTITY_DROP_DOWN_LIST )
    public List<WebElement>  quantityDropDownList;

    @FindBy(id = ADD_T0_CART_BUTTON)
    public WebElement addToCartButton;

    @FindBy(css = ADD_T0_CART_ALERT_MESSAGE)
    public WebElement addToCAartAlertMessage;

    @FindBy(css = ADD_T0_CART_PRODUCT_COLOR_OPTION)
    public WebElement addToCartProductColorOption;

    @FindBy(css = ADD_T0_CART_ERROR_MESSAGE)
    public WebElement addToCartErrorMessage;


    public void navigateToSalesAndDeals() throws AWTException {
       clickOnPage();
        clickOnElement(salesAndDeals);
    }

    public void navigateToLivingRoomProducts() throws AWTException {
        navigateToSalesAndDeals();
        clickOnLivingRoomProduct();
    }
    public void clickOnDetails(){
      clickOnElement(productDetailsButton);
    }

    public void clickAddProductQuantity(){
        clickOnElement(addProductQuantity);
    }

    public void clickAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public void clickColorOption(){
        clickOnElement(addToCartProductColorOption);
    }

    public void clickOnLivingRoomProduct(){
        clickOnElement(shopByDeppartmentList.get(0));
    }

    public void clickOnLivingRoomColorFilter(){
        clickOnElement(filterCategoryList.get(2));
    }

    public void checkTanFilterColor(){
        clickOnElement(filterColorList.get(1));
    }

    public void checkGrayTanBlackFilterColor(){
        clickOnElement(filterColorList.get(0));
        switchTab();
      //  waitForElementToBeVisible(filterColorResult.get(0));
        clickOnElement(filterColorList.get(1));
        switchTab();
        clickOnElement(filterColorList.get(2));
        switchTab();
    }

    public String getAddtoCartErrorMessage(){
        return addToCartErrorMessage.getText();
    }

    public String getAddtoCartAlertMessage(){
        return addToCAartAlertMessage.getText();
    }

    public String getDetailsResult(){
        return detailsResult.getText();
    }

    public String getSeasonalSaleHeading(){
       return seasonalSalesHeading.getText();
    }

    public String getDealsByDepartmentHeading(){
        return dealsByDepartmentheadings.getText();
    }

    public List<String> getListofSalesAndDealsNavBarElements(){
        return getListOfStringElements(salesAndDealsNavBarList);
    }

    public List<String> getShopByDeppartmentList(){
        return getListOfStringElements(shopByDeppartmentList);
    }

    public List<String> getFilterCategoryList(){
        return getListOfStringElements(filterCategoryList);
    }

    public List<String> getFilterColorList(){
        return getListOfStringElements(filterColorList);
    }

    public List<String> getFilterColorResult(){
        return getListOfStringElements(filterColorResult);
    }
    public List<String> getProductPriceList() throws InterruptedException {
        return getListOfStringElementsWithScroll(productPriceList);
    }

    public List<String> getQuantityDropDownList(){
        return getListOfStringElements(quantityDropDownList);
    }

    public List<String> getFilturedProductByColor() throws AWTException, InterruptedException {
        navigateToLivingRoomProducts();
        clickOnLivingRoomColorFilter();
        checkGrayTanBlackFilterColor();
        return getFilterColorResult();
    }


}
