package POM;

import static attLocators.ATTLocators.*;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PhonesAndDevices extends Base {

    public PhonesAndDevices() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = PHONE_AND_DEVICES_FROM_MAIN_HOME_PAGE)
    public WebElement phoneDevicesFromMainHomePage;

    @FindBy (css = TOP_LEFT_MENU_BAR)
    public WebElement topLeftMenuBar;

    @FindBy (css = TOP_CENTER_MENU_BAR_WITH_ICON)
    public WebElement topCenterMenuBarWithIcon;

    @FindBy (css = TOP_LEFT_HAMBURGER_ICON)
    public WebElement topLeftHamburgerIcon;

    @FindBy (css = TOP_LEFT_HAMBURGER_DD_MENU_LIST)
    public WebElement topLeftHamburgerDDMenuList;

    @FindBy (css = PICK_YOUR_PHONE_MENU_BAR)
    public WebElement pickYourPhoneMenuBar;

    @FindBy (css = FILTER_AND_SORT_BUTTON)
    public WebElement filterSortButton;

    @FindBy (css = BRANDS)
    public WebElement brands;

    @FindBy (css = DEVICE_CONDITIONS)
    public WebElement deviceConditions;

    @FindBy (css = OS)
    public WebElement os;

    @FindBy (css = FEATURED)
    public WebElement featured;

    @FindBy (css = PRICE_RANGE)
    public WebElement priceRange;

    @FindBy (css = COLOR)
    public WebElement color;

    @FindBy (css = COLOR_SHOW_MORE_BUTTON)
    public WebElement colorShowMoreButton;

    @FindBy (css = SORT_BY)
    public WebElement sortBy;

    //TC001PD
    public void validateTopLeftMenuBarText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        List<String> topLeftMenu = getListItemsByCss(TOP_LEFT_MENU_BAR);

        for (int i = 0; i < topLeftMenu.size(); i++) {
            String actualText = topLeftMenu.get(i);
            String expectedText = readFromExcel("TopLeftMenu", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC002PD
    public void validateTopCenterMenuBarText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        List<String> topCenterMenu = getListItemsByCss(TOP_CENTER_MENU_BAR_WITH_ICON);

        for (int i = 0; i < topCenterMenu.size(); i++) {
            String actualText = topCenterMenu.get(i);
            String expectedText = readFromExcel("TopCenterMenu", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC003PD
    public void validateTopLeftHamburgerDDMenuListTest() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        openHamburgerMenu();
        List<String> topHamburgerMenu = getListItemsByCss(TOP_LEFT_HAMBURGER_DD_MENU_LIST);

        for (int i = 0; i < topHamburgerMenu.size(); i++) {
            String actualText = topHamburgerMenu.get(i);
            String expectedText = readFromExcel("TopHamburgerMenu", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC004PD
    public void validatePickYourPhoneMenuBarText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        List<String> phoneMenuBar = getListItemsByCss(PICK_YOUR_PHONE_MENU_BAR);

        for (int i = 0; i < phoneMenuBar.size(); i++) {
            String actualText = phoneMenuBar.get(i);
            String expectedText = readFromExcel("PhoneMenuBar", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC005PD
    public void validateBrandNameText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> brands = getListItemsByCss(BRANDS);

        for (int i = 0; i < brands.size(); i++) {
            String actualText = brands.get(i);
            String expectedText = readFromExcel("Brands", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC006PD
    public void validateDeviceConditionText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> deviceConditions = getListItemsByCss(DEVICE_CONDITIONS);

        for (int i = 0; i < deviceConditions.size(); i++) {
            String actualText = deviceConditions.get(i);
            String expectedText = readFromExcel("DeviceCondition", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC007PD
    public void validateOSText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> os = getListItemsByCss(OS);

        for (int i = 0; i < os.size(); i++) {
            String actualText = os.get(i);
            String expectedText = readFromExcel("OS", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC008PD
    public void validateFeaturedText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> featured = getListItemsByCss(FEATURED);

        for (int i = 0; i < featured.size(); i++) {
            String actualText = featured.get(i);
            String expectedText = readFromExcel("Featured", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC009PD
    public void validatePriceRangeText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> prices = getListItemsByCss(PRICE_RANGE);

        for (int i = 0; i < prices.size(); i++) {
            String actualText = prices.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("Prices", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC010PD
    public void validateColorText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        clickOnElement(colorShowMoreButton);
        List<String> colors = getListItemsByCss(COLOR);

        for (int i = 0; i < colors.size(); i++) {
            String actualText = colors.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("Colors", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC011PD
    public void validateSortByText() {
        SoftAssert softAssert = new SoftAssert();
        navigateToPhonesAndDevicesPage();
        clickOnElement(filterSortButton);
        List<String> sortBy = getListItemsByCss(SORT_BY);

        for (int i = 0; i < sortBy.size(); i++) {
            String actualText = sortBy.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("SortBy", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC012PD
    //verifyAddToFavoritesFunctionality()

    //TC013PD
    public void topLeftMenuBarTextCount() {
        navigateToPhonesAndDevicesPage();
        List<String> topLeftMenu = getListItemsByCss(TOP_LEFT_MENU_BAR);
        String actualResult = String.valueOf(topLeftMenu.size());
        String expectedResult = readFromExcel("Counts", 0);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC013PD");
    }

    //TC014PD
    public void topCenterMenuBarTextCount() {
        navigateToPhonesAndDevicesPage();
        List<String> topCenterMenu = getListItemsByCss(TOP_CENTER_MENU_BAR_WITH_ICON);
        String actualResult = String.valueOf(topCenterMenu.size());
        String expectedResult = readFromExcel("Counts", 1);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC014PD");
    }

    //TC015PD
    public void topLeftHamburgerDDMenuListTestCount() {
        navigateToPhonesAndDevicesPage();
        openHamburgerMenu();
        List<String> topHamburgerMenu = getListItemsByCss(TOP_LEFT_HAMBURGER_DD_MENU_LIST);
        String actualResult = String.valueOf(topHamburgerMenu.size());
        String expectedResult = readFromExcel("Counts", 2);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC015PD");
    }

    //TC016PD
    public void pickYourPhoneMenuBarTextCount() {
        navigateToPhonesAndDevicesPage();
        List<String> phoneMenuBar = getListItemsByCss(PICK_YOUR_PHONE_MENU_BAR);
        String actualResult = String.valueOf(phoneMenuBar.size());
        String expectedResult = readFromExcel("Counts", 3);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC016PD");
    }

    //HELPER METHODS
    public void navigateToPhonesAndDevicesPage() {
        try {
            clickOnElement(phoneDevicesFromMainHomePage);
        } catch (Exception e) {
            clickJScript(phoneDevicesFromMainHomePage);
        }
    }

    public void openHamburgerMenu() {
        try {
            clickOnElement(topLeftHamburgerIcon);
        } catch (Exception e) {
            clickJScript(topLeftHamburgerIcon);
        }
    }
}
