package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static ptsLocators.PTSLocators.*;

public class PlacesToStay extends Base {

    public PlacesToStay() {
        PageFactory.initElements(driver, this);
    }

    //PLACE TO STAY SEARCH LOCATORS
    @FindBy (css = MM_PLACES_TO_STAY)
    public WebElement mmPlacesToStay;

    @FindBy (css = LOCATION_INPUT)
    public WebElement locationInput;

    @FindBy (css = MONTH_YEAR_TEXT)
    public WebElement monthYearText;

    @FindBy (css = DAYS_OF_MONTH)
    public WebElement daysOfMonth;

    @FindBy (css = NEXT_MONTH_BUTTON)
    public WebElement nextMonthButton;

    @FindBy (css = FIRST_ITEM_FROM_SEARCH_DD_OPTIONS)
    public WebElement firstItemFromSearchDD;

    //HOMEPAGE LOCATORS
    @FindBy (css = FOOTER_LIST_TITLE)
    public WebElement footerListTitle;

    @FindBy (css = ABOUT_LIST)
    public WebElement aboutList;

    @FindBy (css = COMMUNITY_LIST)
    public WebElement communityList;

    @FindBy (css = HOST_LIST)
    public WebElement hostList;

    @FindBy (css = SUPPORT_LIST)
    public WebElement supportList;

    @FindBy (css = FUTURE_GATEWAY_TABS)
    public WebElement futureGatewayTabs;

    @FindBy (css = TABS_ARTS_AND_CULTURE)
    public WebElement tabsArtsAndCulture;

    @FindBy (css = TABS_OUTDOOR_ADVENTURE)
    public WebElement tabsOutdoorAdventure;

    //TC001PTS
    public void validateFooterListTitleText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> footerTitle = getListItemsByCss(FOOTER_LIST_TITLE);

        for (int i = 0; i < footerTitle.size(); i++) {
            String actualText = footerTitle.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("FooterTitle", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC002PTS
    public void validateAboutListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> aboutList = getListItemsByCss(ABOUT_LIST);

        for (int i = 0; i < aboutList.size(); i++) {
            String actualText = aboutList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("About", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC003PTS
    public void validateCommunityListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> communityList = getListItemsByCss(COMMUNITY_LIST);

        for (int i = 0; i < communityList.size(); i++) {
            String actualText = communityList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("Community", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC004PTS
    public void validateHostListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> hostList = getListItemsByCss(HOST_LIST);

        for (int i = 0; i < hostList.size(); i++) {
            String actualText = hostList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("Host", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC005PTS
    public void validateSupportListText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> supportList = getListItemsByCss(SUPPORT_LIST);

        for (int i = 0; i < supportList.size(); i++) {
            String actualText = supportList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("Support", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC006PTS
    public void validateFutureGatewayTabsText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> futureGatewayList = getListItemsByCss(FUTURE_GATEWAY_TABS);

        for (int i = 0; i < futureGatewayList.size(); i++) {
            String actualText = futureGatewayList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("FutureGateway", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC007PTS
    public void validateTabsArtsAndCultureText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> artsCultureList = getListItemsByCss(TABS_ARTS_AND_CULTURE);

        for (int i = 0; i < artsCultureList.size(); i++) {
            String actualText = artsCultureList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("ArtsCulture", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC008PTS
    public void validateTabsOutdoorAdventureText() {
        SoftAssert softAssert = new SoftAssert();
        List<String> outdoorAdventureList = getListItemsByCss(TABS_OUTDOOR_ADVENTURE);

        for (int i = 0; i < outdoorAdventureList.size(); i++) {
            String actualText = outdoorAdventureList.get(i);
            System.out.println(actualText);
            String expectedText = readFromExcel("OutdoorAdventure", i);
            softAssert.assertEquals(actualText, expectedText, "FAILED, TEXT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    //TC009PTS
    public void footerListTitleTextCount() {
        List<String> footerList = getListItemsByCss(FOOTER_LIST_TITLE);
        String actualResult = String.valueOf(footerList.size());
        String expectedResult = readFromExcel("Counts", 0);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC009PTS");
    }

    //TC010PTS
    public void aboutListTextCount() {
        List<String> aboutList = getListItemsByCss(ABOUT_LIST);
        String actualResult = String.valueOf(aboutList.size());
        String expectedResult = readFromExcel("Counts", 1);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC010PTS");
    }

    //TC011PTS
    public void communityListTextCount() {
        List<String> communityList = getListItemsByCss(COMMUNITY_LIST);
        String actualResult = String.valueOf(communityList.size());
        String expectedResult = readFromExcel("Counts", 2);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC011PTS");
    }

    //TC012PTS
    public void hostListTextCount() {
        List<String> hostList = getListItemsByCss(HOST_LIST);
        String actualResult = String.valueOf(hostList.size());
        String expectedResult = readFromExcel("Counts", 3);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC012PTS");
    }

    //TC013PTS
    public void supportListTextCount() {
        List<String> supportList = getListItemsByCss(SUPPORT_LIST);
        String actualResult = String.valueOf(supportList.size());
        String expectedResult = readFromExcel("Counts", 4);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC013PTS");
    }

    //TC014PTS
    public void futureGatewayTabsListTextCount() {
        List<String> futureGateway = getListItemsByCss(FUTURE_GATEWAY_TABS);
        String actualResult = String.valueOf(futureGateway.size());
        String expectedResult = readFromExcel("Counts", 5);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC014PTS");
    }

    //TC015PTS
    public void tabsArtsAndCultureTextCount() {
        List<String> artsAdventure = getListItemsByCss(TABS_ARTS_AND_CULTURE);
        String actualResult = String.valueOf(artsAdventure.size());
        String expectedResult = readFromExcel("Counts", 6);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC015PTS");
    }

    //TC016PTS
    public void tabsOutdoorAdventureListTextCount() {
        List<String> outdoorAdventure = getListItemsByCss(TABS_OUTDOOR_ADVENTURE);
        String actualResult = String.valueOf(outdoorAdventure.size());
        String expectedResult = readFromExcel("Counts", 7);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC016PTS");
    }

    //HELPER METHODS
    public void enterLocation(String location) {
        clickOnElement(mmPlacesToStay);
        sendKeysToElement(locationInput, location);
        clickOnElement(firstItemFromSearchDD);
    }

    public void pickCalendarDate(WebElement monthYearElement, WebElement monPickerBtn, String month, int day) {
        while (true) {
            String extractMonthYear = explicitWait.until(ExpectedConditions.visibilityOf(monthYearElement)).getText().toLowerCase();
            String[] array = extractMonthYear.split(" ");
            String extractedMonth = array[0].trim();
            if (extractedMonth.equals(month.toLowerCase())) {
                break;
            } else {
                explicitWait.until(ExpectedConditions.elementToBeClickable(monPickerBtn)).click();
            }
        }
        WebElement exactDay = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("\""+getCustomLocator(day)+"\"")));
        exactDay.click();
    }

    public String getCustomLocator(int day) {
        return "#panel--tabs--0 div:nth-child(2) > div > table > tbody > tr > td > div[data-testid=\"datepicker-day-2021-10-"+day+"\"] > div > div";
    }

}
