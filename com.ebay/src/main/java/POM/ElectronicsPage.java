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
    public WebElement textOfCameraAndHeaderPage;

    String locatorCameraAndPhotoDropDownItems = "//div[@class = \"dialog__cell\"]/section[1]/ul[1]/li[1]//li/a";



    void clickOnElectronicsNavBar(){
        clickOnElement(electronicsPageLink);
    }

    public String getTextOfElectronicsPageHeader(){
        return electronicsPageHeader.getText();
    }

    void selectSubCategoryOfCameraAndPhoto(String category) {
        List<WebElement> listOfCameraAndPhotoDropDown = getListOfDropdownOfCamera();
        List<String > webElementTextList = new ArrayList<>();

        for(WebElement e : listOfCameraAndPhotoDropDown){
            webElementTextList.add(e.getText());
        }

        for(int i = 0; i < webElementTextList.size(); i++){
            if(category.equals(webElementTextList.get(i))){
                listOfCameraAndPhotoDropDown.get(i).click();
            }
        }
    }

    List<WebElement> getListOfDropdownOfCamera(){
        return getWebElementList(By.xpath(locatorCameraAndPhotoDropDownItems));
    }

    void selectCategoryCameraAndPhoto() {
        clickJScript(buttonCameraAndPhoto);
    }

    public void doShopBySubCategoryOfCameraAndPhoto(String category){
        doNavigateToElectronicsPage();
        selectCategoryCameraAndPhoto();
        selectSubCategoryOfCameraAndPhoto(category);
        waitForElementToBeVisible(textOfCameraAndHeaderPage);
    }



    public void doNavigateToElectronicsPage(){
        clickOnElectronicsNavBar();
        waitForElementToBeVisible(electronicsPageHeader);
    }
}
