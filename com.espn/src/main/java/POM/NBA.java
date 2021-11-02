package POM;

import base.Base;
import static espnLocators.ESPNLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class NBA extends Base {

    public NBA() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = NBA_PAGE)
    public WebElement nbaPage;

    @FindBy(xpath = ESPN_PLUS_LIST)
    public WebElement espnPlusList;

    @FindBy(xpath = QUICK_LINK_LIST)
    public WebElement quickLinksList;

    @FindBy(xpath = STATS_LISTS_SUB_HEADER)
    public WebElement subHeaderStatsList;

    @FindBy(xpath = STATS_BOX)
    public WebElement statsBox;

    @FindBy(xpath = TEAMS_BOX)
    public WebElement teamsBox;

    @FindBy(xpath = TEAMS_SUB_HEADER)
    public WebElement subHeaderTeams;

    @FindBy(xpath = PODCAST_LISTS)
    public WebElement podcastsList;

    @FindBy(xpath = FANTASY_LIST)
    public WebElement fantasyList;

    @FindBy(xpath = ESPN_SITE_LIST)
    public WebElement espnSitesList;

    @FindBy(xpath = ESPN_APPS_LIST)
    public WebElement espnAppsList;

    @FindBy(xpath = ESPN_FOLLOW_LIST)
    public WebElement followESPNList;

    @FindBy(xpath = TOP_EVENT_DROPDOWN)
    public WebElement topEventsDropdown;

    @FindBy(css = TOP_EVENT_DROPDOWN_MENU)
    public WebElement topEventsDropdownMenu;

    @FindBy(xpath = ESPN_FOOTER_LIST)
    public WebElement espnFooterList;

    @FindBy(css = NBA_DROPDOWN_LIST)
    public WebElement nbaDropdown;

    @FindBy(css = NBA_DROPDOWN_LEFT_MENU)
    public WebElement nbaDropdownMenuLeft;

    public void getNBAPage() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(nbaPage));
        clickOnElement(nbaPage);
    }

    public String validateNBAPage() {
        getNBAPage();
        explicitWait.until(ExpectedConditions.urlToBe(NBA_PAGE_URL));
        return getCurrentPageTitle();
    }

    public void validateESPNPlusLinkList() throws Exception {
        getNBAPage();
        List<WebElement> espnLinkListArray = espnPlusList.findElements(By.xpath(ESPN_PLUS_LIST));
        String[] expectedESPNPlusList = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "ESPNPlusList");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < espnLinkListArray.size(); i++) {
            String actualText = espnLinkListArray.get(i).getText();
            System.out.println(actualText);
            String expectedESPNPlusListArray = expectedESPNPlusList[i];
            softAssert.assertEquals(actualText, expectedESPNPlusListArray);
        }
        softAssert.assertAll();
    }

    public void validateESPNQuickLinks() throws Exception {
        getNBAPage();
        List<WebElement> espnQuickLinkArray = quickLinksList.findElements(By.xpath(QUICK_LINK_LIST));
        String[] expectedQuickLinksArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "QuickLinksTitles");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < espnQuickLinkArray.size(); i++) {
            String actualText = espnQuickLinkArray.get(i).getText();
            System.out.println(actualText);
            String expectedQuickLinks = expectedQuickLinksArray[i];
            softAssert.assertEquals(actualText, expectedQuickLinks);
        }
        softAssert.assertAll();
    }

    public String getStatsListText(int a){
        List<WebElement> subHeaderStatsListArray = subHeaderStatsList.findElements(By.xpath(STATS_LISTS_SUB_HEADER));
        return subHeaderStatsListArray.get(a).getText();
    }

    public String validateStatsList(int x) throws Exception {
        String[] expectedStatsListArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "StatsList");
        explicitWait.until(ExpectedConditions.elementToBeClickable(statsBox));
        mouseHoverOnly(statsBox);
        return expectedStatsListArray[x];
    }

    public void validateTeamsList() throws Exception {
        getNBAPage();
        List<WebElement> teamListArray = subHeaderTeams.findElements(By.xpath(TEAMS_SUB_HEADER));
        String[] expectedTeamsArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "TeamCategories");
        explicitWait.until(ExpectedConditions.elementToBeClickable(teamsBox));
        mouseHoverOnly(teamsBox);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < teamListArray.size(); i++) {
            String actualText = teamListArray.get(i).getText();
            System.out.println(actualText);
            String expectedTeamList = expectedTeamsArray[i];
            softAssert.assertEquals(actualText, expectedTeamList);
        }
        softAssert.assertAll();
    }

    public void validatePodcastsList() throws Exception {
        getNBAPage();
        List<WebElement> podcastListArray = podcastsList.findElements(By.xpath(PODCAST_LISTS));
        String[] expectedPodcastArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "PodcastsTitles");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < podcastListArray.size(); i++) {
            String actualText = podcastListArray.get(i).getText();
            System.out.println(actualText);
            String expectedPodcastsList = expectedPodcastArray[i];
            softAssert.assertEquals(actualText, expectedPodcastsList);
        }
        softAssert.assertAll();
    }

    public void validateFantasyList() throws Exception {
        getNBAPage();
        List<WebElement> fantasyListArray = fantasyList.findElements(By.xpath(FANTASY_LIST));
        String[] expectedFantasyArray = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "FantasyTitles");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < fantasyListArray.size(); i++) {
            String actualText = fantasyListArray.get(i).getText();
            System.out.println(actualText);
            String expectedFantasyList = expectedFantasyArray[i];
            softAssert.assertEquals(actualText, expectedFantasyList);
        }
        softAssert.assertAll();
    }

    public void validateESPNSitesList() throws Exception {
        getNBAPage();
        List<WebElement> espnSitesListArray = espnSitesList.findElements(By.xpath(ESPN_SITE_LIST));
        String[] expectedESPNSitesList = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "ESPNSites");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < espnSitesListArray.size(); i++) {
            String actualText = espnSitesListArray.get(i).getText();
            System.out.println(actualText);
            String expectedESPNSitesArray = expectedESPNSitesList[i];
            softAssert.assertEquals(actualText, expectedESPNSitesArray);
        }
        softAssert.assertAll();
    }

    public void validateESPNAppsList() throws Exception {
        getNBAPage();
        List<WebElement> espnAppsListArray = espnAppsList.findElements(By.xpath(ESPN_APPS_LIST));
        String[] expectedESPNAppsList = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "ESPNApps");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < espnAppsListArray.size(); i++) {
            String actualText = espnAppsListArray.get(i).getText();
            System.out.println(actualText);
            String expectedESPNAppsArray = expectedESPNAppsList[i];
            softAssert.assertEquals(actualText, expectedESPNAppsArray ,"Fantasy title at index of " + i + " " + "Does not match");
        }
        softAssert.assertAll();
    }

    public void validateFollowESPNList() throws Exception {
        getNBAPage();
        List<WebElement> followESPNListArray = followESPNList.findElements(By.xpath(ESPN_FOLLOW_LIST));
        String[] expectedFollowESPNList = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "FollowESPN");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < followESPNListArray.size(); i++) {
            String actualText = followESPNListArray.get(i).getText();
            System.out.println(actualText);
            String expectedFollowESPNArray = expectedFollowESPNList[i];
            softAssert.assertEquals(actualText, expectedFollowESPNArray ,"Fantasy title at index of " + i + " " + "Does not match");
        }
        softAssert.assertAll();
    }

    public int topEventsDropdownList() {
        mouseHoverOnly(topEventsDropdown);
        List<WebElement> topEventsDropDownList = getListOfWebElementsByXpath(topEventsDropdownMenu, TOP_EVENT_DROPDOWN_MENU_ITEMS);
        return topEventsDropDownList.size();
    }

    public void validateTopEventsDropdownListSizeAndLinks() {
        int actualListSize = topEventsDropdownList();
        System.out.println("Size of 'Top Events' Dropdown List: " + actualListSize);
        Assert.assertEquals(actualListSize, TOP_EVENT_DROPDOWN_COUNT, "LIST SIZE DOES NOT MATCH");
    }

    public void validateESPNFooterList() throws Exception {
        getNBAPage();
        scrollToElementJScript(espnFooterList);
        List<WebElement> espnFooterListArray = espnFooterList.findElements(By.xpath(ESPN_FOOTER_LIST));
        String[] expectedESPNFooterList = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "ESPNFooter");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < espnFooterListArray.size(); i++) {
            String actualText = espnFooterListArray.get(i).getText();
            System.out.println(actualText);
            String expectedESPNFooterArray = expectedESPNFooterList[i];
            softAssert.assertEquals(actualText, expectedESPNFooterArray ,"Fantasy title at index of " + i + " " + "Does not match");
        }
        softAssert.assertAll();
    }

    public List<WebElement> getNBADropdownMenuLeft() {
        mouseHoverOnly(nbaDropdown);
        return getListOfWebElementsByCss(nbaDropdownMenuLeft, NBA_DROPDOWN_MENU_ITEMS_LEFT);
    }

    public void validateNBADropdownMenuLeftSize() throws IOException {
        int actualSize = getNBADropdownMenuLeft().size();
        System.out.println("Number of elements in NBA Menu (Left Side): " + actualSize);
        String[] expectedNBADropdownMenu = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "NBADropdownMenuLinksLeft");
        SoftAssert softAssert = new SoftAssert();
        int expectedHeaderDropdownListSize = expectedNBADropdownMenu.length;
        softAssert.assertEquals(actualSize, expectedHeaderDropdownListSize, "SIZE OF LIST (NBA MENU LEFT) DOES NOT MATCH");
        softAssert.assertAll();
    }

    public void validateNBADropdownMenuLeftItemsText() throws IOException {
        List<WebElement> nbaDropdownElementsLeftList = getNBADropdownMenuLeft();
        SoftAssert softAssert = new SoftAssert(); String[] expectedNBADropdownMenuItems = excelReader.fileReaderStringXSSF(System.getProperty("user.dir") + "\\src\\main\\resources\\ESPNnbapageElements.xlsx", "NBADropdownMenuItemsLeft");

        for (int i = 0; i < nbaDropdownElementsLeftList.size(); i++) {
            String actualText = nbaDropdownElementsLeftList.get(i).getAttribute("innerHTML");
            System.out.println(nbaDropdownElementsLeftList.get(i).getAttribute("innerHTML"));
            softAssert.assertEquals(actualText, expectedNBADropdownMenuItems[i], "ELEMENT OF LIST AT POSITION " + i + " (NBA MENU LEFT) DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

}
