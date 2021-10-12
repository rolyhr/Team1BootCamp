package POM;

import base.Base;
import org.openqa.selenium.Keys;
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

    @FindBy(css = BREAD_CRUMB_LIST)
    public  List<WebElement>  breadCrumbList;

    @FindBy(css = BUYING_FORMAT_FILTER)
    public WebElement buyingFortmatFilter;

    @FindBy(css = BUYING_FORMAT_FILTER_DROP_DOWN_CONTAINER)
    public WebElement buyingFormatFIlterDropDownContainer;

    @FindBy(css = BUYING_FORMAT_FILTER_LIST)
    public List<WebElement> buyingformatFilterList;

    @FindBy(css = BUYING_FORMAT_FILTER_RESULT)
    public  WebElement buyingFormatFilterResult;

    @FindBy(css = CONDITION_FILTER)
    public WebElement conditionFilter;

    @FindBy(css = CONDITION_FILTER_DROP_DOWN_CONTAINER)
    public WebElement conditionFIlterDropDownContainer;

    @FindBy(css = CONDITION_FILTER_LIST)
    public List<WebElement> conditionFilterList;

    @FindBy(css = CONDITION_FILTER_RESULT)
    public  WebElement conditionFilterResult;


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

    public  int searchFashionProductWithKeyboard(String element){
        sendValueInSearchFashion(element);
        searchBox.sendKeys(Keys.ENTER);
        String stringSearchResult = searchResult.getText().replaceAll(",","");
        return Integer.parseInt(stringSearchResult);
    }

   // women Fashion
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
    }

    //breadcrumb

    public List<String> getBreadcrumbList(){
        return getListOfStringElements(breadCrumbList);
    }
    public List<String> getBreadcrumFashionWomenShoe(){
        clickOnElement(fashionShopByCategoryList.get(6));
        return  getBreadcrumbList();
    }


    //filter - buying format filter
    public void clickOnBuyingFormat(){
        clickOnElement(buyingFortmatFilter);
        waitForElementToBeVisible(buyingFormatFIlterDropDownContainer);
    }

    public List<String> getListofBuyingformat(){
        return getListOfStringElements(buyingformatFilterList);
    }

    public List<String> getBuyingformats(){
        navigateToFashion();
        navigateToWomenShoes();
        clickOnBuyingFormat();
        return getListofBuyingformat();
    }

    public String selectbuyingFormatContainerRadioButton(String selectTerm){
        for(int i = 0; i<getListofBuyingformat().size();i++){
            if(getListofBuyingformat().get(i).equals(selectTerm)){
               clickOnElement(buyingformatFilterList.get(i));
               waitForElementToBeVisible(buyingFormatFilterResult);
            }
        }
        return buyingFormatFilterResult.getText();
    }

    //filter - codition
    public void clickOnConditonFilter(){
        clickOnElement(conditionFilter);
        waitForElementToBeVisible(conditionFIlterDropDownContainer);
    }

    public List<String> getListofCconditonFilter(){
        return getListOfStringElements(conditionFilterList);
    }

    public List<String> getConditonfilter(){
        navigateToFashion();
        navigateToWomenShoes();
        clickOnConditonFilter();
        return getListofCconditonFilter();
    }

    public String selectCconditonFilterCheckBox(String selectTerm){
        for(int i = 0; i<getListofCconditonFilter().size();i++){
            if(getListofCconditonFilter().get(i).equals(selectTerm)){
                System.out.println("***************************");
                clickOnElement(conditionFilterList.get(i));
                waitForElementToBeVisible(conditionFilterResult);
            }
        }
        return conditionFilterResult.getText();
    }


}