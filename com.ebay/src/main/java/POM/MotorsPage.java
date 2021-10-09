package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MotorsPage extends Base {

    public MotorsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a[text() = \"Motors\"]")
    WebElement motorsPageLink;

    @FindBy(xpath="//*[@class=\"pagecontainer__top\"]//h1/span")
    WebElement eBayMotorHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[1]/a")
    WebElement allPartsAndAccessories;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement autoPartsAndAccessoriesHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[2]/a")
    WebElement carAndTruckParts;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement carAndTruckPartsHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[3]/a")
    WebElement wheelsTiresParts;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement wheelTiresPartsHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[4]/a")
    WebElement motorCyclesParts;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement motorCyclesPartsHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[5]/a")
    WebElement aTvSideBySideUtvParts;


    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement aTvSideBySideUtvPartsHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[6]/a")
    WebElement commercialTruckParts;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement commercialTruckPartsHeaderPage;

    @FindBy(xpath="//*[@id=\"s0-16-13-0-1[1]-0-0-0\"]/ul/li[7]/a")
    WebElement automativeToolsAndSupply;

    @FindBy(css="div.pagecontainer.srp-main--isLarge > div.pagecontainer__top > h1 > span")
    WebElement automativeToolsAndSupplyHeaderPage;

//    public String getTextOfHeaderOfSamsungPhone(){
//        return headerOfSamsungPhonePage.getText();
//    }
//
//    public String getTextOfHeaderOfCellPhonesAndSmartWatch(){
//        return headerOfCellPhonesAndSmartWatchPage.getText();
//    }

    void clickOnMotorNavBar(){
        clickOnElement(motorsPageLink);
    }

    public String getTextOfeBayMotorHeaderPage(){
        return eBayMotorHeaderPage.getText();
    }

    void selectCategoryAllPartsAndAccessories() {
        clickJScript(allPartsAndAccessories);
    }

//    void selectCategoryCellPhoneSmartWatches(){ clickJScript();}
//
//    void selectSubCategoryOfCameraAndPhoto(String category) {
//        List<WebElement> listOfCameraAndPhotoDropDown = ();
//        List<String > webElementTextList = new ArrayList<>();
//
//        for(WebElement e : listOfCameraAndPhotoDropDown){
//            webElementTextList.add(e.getText());
//        }
//
//        for(int i = 0; i < webElementTextList.size(); i++){
//            if(category.equalsIgnoreCase(webElementTextList.get(i))){
//                listOfCameraAndPhotoDropDown.get(i).click();
//                break;
//            }
//        }
//    }




}
