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

public class AccessoriesPage extends Base {

    private static final String EXCEL_FILE_PATH = "/src/test/resources/TestData.xlsx";

    public AccessoriesPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"HEADBAND00\"]/span/a")
    public WebElement dealsLinkFromHomepage;

    @FindBy (css = "div#gn-zone1 div#z1-pullMenu a#z1-pullMenu-open")
    public WebElement topLeftHamBurgerIcon;

    @FindBy (css = "#tab-desktop-menu > li > a > span:nth-child(1)")
    public WebElement topLeftHamburgerMenuList;

    @FindBy(xpath="//*[@id=\"carouselRow-col-2\"]//span//a[@href=\"/buy/accessories/browse/all/deals/\"]")
    public WebElement accessoriesLink;

    @FindBy(xpath="//*[@id=\"Categories-1\"]")
    public WebElement headPhonesLink;

    @FindBy(xpath="//*[@id=\"Categories-2\"]")
    public WebElement casesLink;

    @FindBy(xpath="//*[@id=\"Categories-3\"]")
    public WebElement chargersLink;

    @FindBy(xpath="//*[@id=\"Categories-4\"]")
    public WebElement screenProtectorsLink;

    @FindBy(xpath="//*[@id=\"Categories-5\"]")
    public WebElement speakersAndSmartHomesLink;

    @FindBy(xpath="//*[@id=\"Categories-6\"]")
    public WebElement internetAndTvEquipmentLink;

    @FindBy(xpath="//*[@id=\"Categories-7\"]")
    public WebElement popSocketsAndMoreLink;

    @FindBy(xpath="//*[@id=\"Categories-8\"]")
    public WebElement gadgetsAndGamingLink;



    public AccessoriesPage navToHomepage(){

        clickOnElement(dealsLinkFromHomepage);
        return new AccessoriesPage();
    }

    public void clickOnTopLeftHamBurgerIcon(){
        clickOnElement(topLeftHamBurgerIcon);
    }

    public void clickOnHamburgerMenuList(){
        clickOnElement(topLeftHamburgerMenuList);
    }

    public void clickOnAccessoriesLink(){
        clickOnElement(accessoriesLink);
    }

    public void clickOnHeadPhonesLink(){
        clickOnElement(headPhonesLink);
    }

    public void clickOnCasesLink(){
        clickOnElement(casesLink);
    }

    public void clickOnChargersLink(){
        clickOnElement(chargersLink);
    }

    public void clickOnScreenProtectorsLink(){
        clickOnElement(screenProtectorsLink);
    }

    public void clickOnSpeakersAndSmartHomesLink(){
        clickOnElement(speakersAndSmartHomesLink);
    }

    public void clickOnInternetAndTvEquipmentLink(){
        clickOnElement(internetAndTvEquipmentLink);
    }

    public void clickOnPopSocketsAndMoreLink(){
        clickOnElement(popSocketsAndMoreLink);
    }

    public void clickOnGadgetsAndGamingLink(){
        clickOnElement(gadgetsAndGamingLink);
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
