package POM;

import static attLocators.ATTLocators.*;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
    //validateBrandNameText()

    //TC006PD
    //validateDeviceConditionText()

    //TC007PD
    //validateOSText()

    //TC008PD
    //validateFeaturedText()

    //TC009PD
    //validatePriceRangeText()

    //TC010PD
    //validateColorText()

    //TC011PD
    //validateDeliveryMethodText()

    //TC012PD
    //validateSortByText()

    //TC013PD
    //verifyAddToFavoritesFunctionality()

    //TC014PD
    //validateDeliveryMethodText()

    //TC015PD
    //topLeftMenuBarTextCount()

    //TC016PD
    //topCenterMenuBarTextCount()

    //TC017PD
    //topLeftHamburgerDDMenuListTestCount()

    //TC018PD
    //pickYourPhoneMenuBarTextCount()

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
