package POM;

import base.Base;
import base.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Homepage extends Base {


    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"z1-tier1Nav\"]/a[1]")
    public WebElement dealsLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND01\"]/span/a")
    public WebElement phonesAndDevicesLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND02\"]/span/a")
    public WebElement wirelessLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND03\"]/span/a")
    public WebElement internetLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND04\"]/span/a")
    public WebElement tvLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND05\"]/span/a")
    public WebElement prepaidLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"HEADBAND06\"]/span/a")
    public WebElement bundlesLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-globe\"]/a")
    public WebElement attLogoFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-pullMenu-open\"]")
    public WebElement topLeftHamBurgerIconFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-searchfield\"]")
    public WebElement searchBarFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-searchfield\"]")
    public WebElement inputSendKeysToSearchBar;

    @FindBy(xpath="//*[@id=\"searchForm\"]/button")
    public WebElement searchIcon;

    @FindBy(xpath="//*[@id=\"z1-wishlist-link\"]")
    public WebElement myFavoriteIconFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-cart-open\"]")
    public WebElement cartIconFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-support\"]/a")
    public WebElement supportLinkFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-profile-open\"]")
    public WebElement accountButtonFromHomepage;

    @FindBy(xpath="//*[@id=\"z1-profile-open\"]/i[2]")
    public WebElement accountDropDownMenuFromHomepage;

    @FindBy(xpath="//*[@id=\"profile-unauth\"]/div[2]/ul/li[1]/a")
    public WebElement accountDropDownSubMenuSignIn;

    @FindBy(xpath="//*[@id=\"createNow\"]")
    public WebElement accountCreateNow;

    @FindBy(xpath="//*[@id=\"root\"]/div//div[2]/div/div[3]//fieldset/label[6]")
    public WebElement selectServiceHomePhone;

    @FindBy(xpath="//*[@id=\"root\"]//div[2]//div[4]//button")
    public WebElement continueTab;

    @FindBy(xpath="//*[@id=\"account-number\"]")
    public WebElement inputNineDigitAccountNumber;

    @FindBy(xpath="//*[@id=\"billing-zip-code\"]")
    public WebElement inputBillingZipCode;

    @FindBy(xpath="//*[@id=\"root\"]//div[7]//button")
    public WebElement continueButton;


    public Homepage navToHomepage(){
        return new Homepage();
    }

    public void clickOnDealsLinkFromHomepage(){
        clickOnElement(dealsLinkFromHomepage);
    }

    public void clickOnPhonesAndDevicesLinkFromHomepage(){
        clickOnElement(phonesAndDevicesLinkFromHomepage);
    }

    public void clickOnWirelessLinkFromHomepage(){
        clickOnElement(wirelessLinkFromHomepage);
    }

    public void clickOnInternetLinkFromHomepage(){
        clickOnElement(internetLinkFromHomepage);
    }

    public void clickOnTvLinkFromHomepage(){
        clickOnElement(tvLinkFromHomepage);
    }

    public void clickOnPrepaidLinkFromHomepage(){
        clickOnElement(prepaidLinkFromHomepage);
    }

    public void clickOnBundlesLinkFromHomepage(){
        clickOnElement(bundlesLinkFromHomepage);
    }

    public void clickOnAttLogoFromHomepage(){
        clickOnElement(attLogoFromHomepage);
    }

    public void clickOnTopLeftHamBurgerIconFromHomepage(){
        clickOnElement(topLeftHamBurgerIconFromHomepage);
    }

    public void clickOnSearchBarFromHomepage(){
        clickOnElement(searchBarFromHomepage);
    }

    public void InputSendKeysToSearchBar(){
        sendKeysToInput(inputSendKeysToSearchBar,"Accessories Deals");
    }

    public void clickOnSearchIcon() {
        clickOnElement(searchIcon);
    }

    public void clickOMmyFavoriteIconFromHomepage() {
        clickOnElement(myFavoriteIconFromHomepage);
    }


    public void clickOnCartIconFromHomepage() {
        clickOnElement(cartIconFromHomepage);
    }

    public void clickOnSupportLinkFromHomepage() {
        clickOnElement(supportLinkFromHomepage);
    }


    public void clickOnAccountButtonFromHomepage() {
        clickOnElement(accountButtonFromHomepage);
    }


    public void clickOnAccountDropDownMenuFromHomepage() {
        clickOnElement(accountDropDownMenuFromHomepage);
    }


    public void clickOnAccountDropDownSubMenuSignIn() {
        clickOnElement(accountDropDownSubMenuSignIn);
    }


    public void clickOnAccountCreateNow() {
        clickOnElement(accountCreateNow);
    }


    public void clickOnselectServiceHomePhone() {
        clickOnElement(selectServiceHomePhone);
    }


    public void clickOnContinueTab() {
        clickOnElement(continueTab);
    }


    public void InputNineDigitAccountNumber() {
        sendKeysToInput(inputNineDigitAccountNumber,"123456789");
    }


    public void InputBillingZipCode() {
        sendKeysToInput(inputBillingZipCode,"12345");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }



    public void validateTopLeftHamburgerDDMenuListTest() {
        SoftAssert softAssert = new SoftAssert();
        //navigateToPhonesAndDevicesPage();
        //openHamburgerMenu();
        navToHomepage().validateTopLeftHamburgerDDMenuListTest();
//        List<String> topHamburgerMenu = getListItems(TOP_LEFT_HAMBURGER_DD_MENU_LIST);
        List<String> topHamburgerMenu=getListItems("#tab-desktop-menu > li > a > span:nth-child(1)");

        for (int i = 0; i < topHamburgerMenu.size(); i++) {
            String actualText = topHamburgerMenu.get(i);
            String expectedText = readFromExcel("TopHamburgerMenu", i);
            softAssert.assertEquals(actualText, expectedText, "failed");
        }
        softAssert.assertAll();
    }



    public String readFromExcel(String sheetName, int index) {
        String[] excelData = new String[index];
        try {
            ExcelReader dataReader = new ExcelReader();
            excelData = dataReader.fileReaderStringXSSF(EXCEL_FILE_PATH, sheetName);
        } catch (IOException e) {
            System.out.println("UNABLE TO READ FROM EXCEL FILE!");
        }
        return Arrays.toString(new String[]{excelData[index]})
                .replace("[", "")
                .replace("]", "");
    }



    }
