package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsPage extends Base {

    public ElectronicsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@id = \"mainContent\"]//li[5]//a[text() = \"Electronics\"]")
    WebElement electronicsPageLink;

    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"]//h1//span")
    WebElement electronicsPageHeader;

    @FindBy(xpath = "//div[@class = \"dialog__cell\"]//button/span[text() = \"Cameras & Photo\"]")
    WebElement buttonCameraAndPhoto;

    @FindBy(xpath = "//div[@class = \"dialog__cell\"]/section[1]/ul[1]/li[1]//li/a")
    WebElement dropDownCategoryOfCameraAndPhoto;

    @FindBy(css = "div.pagecontainer.srp-main--isLarge h1 > span")
    public WebElement headerOfCameraPage;

    @FindBy(css = "div.pagecontainer.srp-main--isLarge h1 > span")
    public WebElement textOfCameraDronesPage;

    @FindBy(xpath = "//div[@class=\"dialog__cell\"]//button//span[text()=\"Cell Phones, Smart Watches, & Accessories\"]")
    WebElement buttonCellPhonesSmartWatches;

    @FindBy(css = "div.pagecontainer.srp-main--isLarge  h1 > span")
    WebElement headerOfCellPhonesAndSmartWatchPage;

    @FindBy(xpath = "//section//div[@class=\"title-banner__layer__info\"]//h1")
    WebElement headerOfSamsungPhonePage;

    String locatorOfCellPhonesSmartWatches = "//li[@id = \"s0-16-13-0-1[0]-0-0-0-29[1]-0\"]//ul//li/a";
    String locatorCameraAndPhotoDropDownItems = "//div[@class = \"dialog__cell\"]/section[1]/ul[1]/li[1]//li/a";

    public String getTextOfHeaderOfSamsungPhone(){
        return headerOfSamsungPhonePage.getText();
    }

    public String getTextOfHeaderOfCellPhonesAndSmartWatch(){
        return headerOfCellPhonesAndSmartWatchPage.getText();
    }

    void clickOnElectronicsNavBar(){
        clickOnElement(electronicsPageLink);
    }

    public String getTextOfElectronicsPageHeader(){
        return electronicsPageHeader.getText();
    }

    void selectCategoryCameraAndPhoto() {
        clickJScript(buttonCameraAndPhoto);
    }

    void selectCategoryCellPhoneSmartWatches(){ clickJScript(buttonCellPhonesSmartWatches);}

    void selectSubCategoryOfCameraAndPhoto(String category) {
        List<WebElement> listOfCameraAndPhotoDropDown = getListOfDropdownOfCamera();
        List<String > webElementTextList = new ArrayList<>();

        for(WebElement e : listOfCameraAndPhotoDropDown){
            webElementTextList.add(e.getText());
        }

        for(int i = 0; i < webElementTextList.size(); i++){
            if(category.equalsIgnoreCase(webElementTextList.get(i))){
                listOfCameraAndPhotoDropDown.get(i).click();
                break;
            }
        }
    }

    List<WebElement> getListOfDropdownOfCamera(){
        return getListOfADropDownMenu(By.xpath(locatorCameraAndPhotoDropDownItems));
    }

    String getShopByCategoryNameElements(){
        return "//div[@id = \"mainContent\"]//section[1]//div[@class=\"b-visualnav__grid\"]//div[2]";
    }

    String getEbayRefurbishedNameElements(){
        return "//div[@id = \"mainContent\"]//section[2]//div[@class= \"b-visualnav__grid\"]//div[2]";
    }

    String getMostPopularNameElements(){
        return "//div[@id = \"mainContent\"]//section[3]//div[@class= \"b-visualnav__grid\"]//div[2]";
    }

    public List<String> getListOfMostPopularName(){
        return  getListFromADiv(By.xpath(getMostPopularNameElements()));
    }

    public List<String> getListOfEbayRefurbishedName(){
        return getListFromADiv(By.xpath(getEbayRefurbishedNameElements()));
    }

    public List<String> getListOfShopByCategoryName(){

        return getListFromADiv(By.xpath(getShopByCategoryNameElements()));
    }

    public void doShopBySubCategoryOfCameraAndPhoto(String category){
        doNavigateToElectronicsPage();
        selectCategoryCameraAndPhoto();
        selectSubCategoryOfCameraAndPhoto(category);
        waitForElementToBeVisible(headerOfCameraPage);
    }

    public void doShopBySubCategoryOfCellPhonesAndSmartWatches(String category){
        doNavigateToElectronicsPage();
        selectCategoryCellPhoneSmartWatches();
        selectASubCategoryOfADropDownMenuByPassingTestData(By.xpath(locatorOfCellPhonesSmartWatches),category);
        waitForElementToBeVisible(headerOfCellPhonesAndSmartWatchPage);
    }

    public void doShopBySubCategorySamsungPhoneOfCellPhonesAndSmartWatch(String category){
        doNavigateToElectronicsPage();
        selectCategoryCellPhoneSmartWatches();
        selectASubCategoryOfADropDownMenuByPassingTestData(By.xpath(locatorOfCellPhonesSmartWatches),category);
        waitForElementToBeVisible(headerOfSamsungPhonePage);
    }

    public void doNavigateToElectronicsPage(){
        clickOnElectronicsNavBar();
        waitForElementToBeVisible(electronicsPageHeader);
    }
}
