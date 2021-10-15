package POM;

import base.Base;
import static footerLocators.FooterLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Footer extends Base {

    public Footer() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = FOOTER_TITLES)
    public WebElement footerTitles;

    @FindBy (css = SHOP_LIST)
    public WebElement shopList;

    @FindBy (css = TOP_DEVICE_BRANDS_LIST)
    public WebElement topDeviceBrandsList;

    @FindBy (css = SUPPORT_LIST)
    public WebElement supportList;

    @FindBy (css = ABOUT_VERIZON_LIST)
    public WebElement aboutVerizonList;

    @FindBy (css = MOST_POPULAR_LIST)
    public WebElement mostPopularList;

    @FindBy (css = TOP_ACCESSORIES_BRAND_LIST)
    public WebElement topAccessoriesBrandList;

    @FindBy (css = IMPORTANT_CONSUMER_INFO_LIST)
    public WebElement importantConsumerInfoList;

    @FindBy (css = FOLLOW_VERIZON_LIST)
    public WebElement followVerizonList;

    @FindBy (css = FOLLOW_VERIZON_FIOS_LIST)
    public WebElement followVerizonFiosList;

    //TC001VZ
    public void validateFooterTitleText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> footerTitles = getListItemsByCss(FOOTER_TITLES);

        for (int i = 0; i < footerTitles.size(); i++) {
            String actualText = footerTitles.get(i);
            String expectedText = readFromExcel("FooterTitles", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC002VZ
    public void validateShopListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> shopList = getListItemsByCss(SHOP_LIST);

        for (int i = 0; i < shopList.size(); i++) {
            String actualText = shopList.get(i);
            String expectedText = readFromExcel("ShopList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC003VZ
    public void validateTopDeviceBrandListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> brandList = getListItemsByCss(TOP_DEVICE_BRANDS_LIST);

        for (int i = 0; i < brandList.size(); i++) {
            String actualText = brandList.get(i);
            String expectedText = readFromExcel("TopBrandList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC004VZ
    public void validateSupportListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> supportList = getListItemsByCss(SUPPORT_LIST);

        for (int i = 0; i < supportList.size(); i++) {
            String actualText = supportList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("SupportList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC005VZ
    public void validateAboutVerizonListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> aboutVerizonList = getListItemsByCss(ABOUT_VERIZON_LIST);

        for (int i = 0; i < aboutVerizonList.size(); i++) {
            String actualText = aboutVerizonList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("AboutVerizon", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC006VZ
    public void validateMostPopularListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> popularList = getListItemsByCss(MOST_POPULAR_LIST);

        for (int i = 0; i < popularList.size(); i++) {
            String actualText = popularList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("MostPopularList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC007VZ
    public void validateTopAccessoriesBrandsListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> accessoriesList = getListItemsByCss(TOP_ACCESSORIES_BRAND_LIST);

        for (int i = 0; i < accessoriesList.size(); i++) {
            String actualText = accessoriesList.get(i);
            String expectedText = readFromExcel("AccessoriesList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC008VZ
    public void validateImportantConsumerInfoListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> consumerInfoList = getListItemsByCss(IMPORTANT_CONSUMER_INFO_LIST);

        for (int i = 0; i < consumerInfoList.size(); i++) {
            String actualText = consumerInfoList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("ConsumerInfoList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC009VZ
    public void validateFollowVerizonListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> verizonList = getListItemsByCss2(FOLLOW_VERIZON_LIST);

        for (int i = 0; i < verizonList.size(); i++) {
            String actualText = verizonList.get(i);
            String expectedText = readFromExcel("VerizonList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC010VZ
    public void validateFollowVerizonFiosListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> verizonFiosList = getListItemsByCss2(FOLLOW_VERIZON_FIOS_LIST);

        for (int i = 0; i < verizonFiosList.size(); i++) {
            String actualText = verizonFiosList.get(i);
            String expectedText = readFromExcel("VerizonFiosList", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC011VZ
    public void footerTitlesTextCount() {
        List<String> footerTitles = getListItemsByCss(FOOTER_TITLES);
        String actualResult = String.valueOf(footerTitles.size());
        String expectedResult = readFromExcel("Counts", 0);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC011VZ");
    }

    //TC012VZ
    public void shopListTextCount() {
        List<String> shopList = getListItemsByCss(SHOP_LIST);
        String actualResult = String.valueOf(shopList.size());
        String expectedResult = readFromExcel("Counts", 1);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC012VZ");
    }

    //TC013VZ
    public void topDeviceBrandsListTextCount() {
        List<String> brandList = getListItemsByCss(TOP_DEVICE_BRANDS_LIST);
        String actualResult = String.valueOf(brandList.size());
        String expectedResult = readFromExcel("Counts", 2);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC013VZ");
    }

    //TC014VZ
    public void supportListTextCount() {
        List<String> supportList = getListItemsByCss(SUPPORT_LIST);
        String actualResult = String.valueOf(supportList.size());
        String expectedResult = readFromExcel("Counts", 3);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC014VZ");
    }

    //TC015VZ
    public void aboutVerizonListTextCount() {
        List<String> aboutVerizonList = getListItemsByCss(ABOUT_VERIZON_LIST);
        String actualResult = String.valueOf(aboutVerizonList.size());
        String expectedResult = readFromExcel("Counts", 4);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC015VZ");
    }

    //TC016VZ
    public void mostPopularListTextCount() {
        List<String> popularList = getListItemsByCss(MOST_POPULAR_LIST);
        String actualResult = String.valueOf(popularList.size());
        String expectedResult = readFromExcel("Counts", 5);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC016VZ");
    }

    //TC017VZ
    public void topAccessoriesBrandListTextCount() {
        List<String> accessoriesList = getListItemsByCss(TOP_ACCESSORIES_BRAND_LIST);
        String actualResult = String.valueOf(accessoriesList.size());
        String expectedResult = readFromExcel("Counts", 6);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC017VZ");
    }

    //TC018VZ
    public void importantConsumerInfoListTextCount() {
        List<String> consumerInfoList = getListItemsByCss(IMPORTANT_CONSUMER_INFO_LIST);
        String actualResult = String.valueOf(consumerInfoList.size());
        String expectedResult = readFromExcel("Counts", 7);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC018VZ");
    }

    //TC019VZ
    public void followVerizonListTextCount() {
        List<String> verizonList = getListItemsByCss2(FOLLOW_VERIZON_LIST);
        String actualResult = String.valueOf(verizonList.size());
        String expectedResult = readFromExcel("Counts", 8);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC019VZ");
    }

    //TC020VZ
    public void followVerizonFiosListTextCount() {
        List<String> verizonFiosList = getListItemsByCss2(FOLLOW_VERIZON_FIOS_LIST);
        String actualResult = String.valueOf(verizonFiosList.size());
        String expectedResult = readFromExcel("Counts", 9);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC020VZ");
    }

    //HELPER METHODS
    public List<String> getListItemsByCss2(String cssSelector) {
        List<WebElement> menuItems = driver.findElements(By.cssSelector(cssSelector));
        List<String> element = new ArrayList<>();
        for (WebElement menuItem : menuItems) {
            element.add(menuItem.getAttribute("innerHTML"));
        }
        return element;
    }

}
