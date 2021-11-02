package POM;

import base.Base;
import static espnLocators.ESPNLocators.*;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ESPNHomepage extends Base {

    public ESPNHomepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = TOP_EVENTS_DROPDOWN)
    public WebElement topEventsDropdown;

    @FindBy(css = TOP_EVENTS_DROPDOWN_MENU)
    public WebElement topEventsDropdownMenu;

    @FindBy(css = UFC_HEADER_TILE)
    public WebElement ufcHeaderTile;

    @FindBy(css = HEADER_SCROLL_RIGHT)
    public WebElement headerScrollRight;

    @FindBy(css = HEADER_SCROLL_LEFT)
    public WebElement headerScrollLeft;

    @FindBy(css = NFL_DROPDOWN)
    public WebElement nflDropdown;

    @FindBy(xpath = NFL_DROPDOWN_MENU_LEFT)
    public WebElement nflDropdownMenuLeft;

    @FindBy(css = NFL_DROPDOWN_MENU_RIGHT)
    public WebElement nflDropdownMenuRight;

    @FindBy(css = NBA_DROPDOWN)
    public WebElement nbaDropdown;

    @FindBy(css = NBA_DROPDOWN_MENU_LEFT)
    public WebElement nbaDropdownMenuLeft;

    @FindBy(css = NBA_DROPDOWN_MENU_RIGHT)
    public WebElement nbaDropdownMenuRight;

    @FindBy(css = MLB_DROPDOWN)
    public WebElement mlbDropdown;

    @FindBy(css = MLB_DROPDOWN_MENU_LEFT)
    public WebElement mlbDropdownMenuLeft;

    @FindBy(css = MLB_DROPDOWN_MENU_RIGHT)
    public WebElement mlbDropdownMenuRight;

    @FindBy(xpath = I_FRAME)
    public WebElement iFrame;

    @FindBy(xpath = LOGIN_BUTTON)
    public WebElement loginButton;

    @FindBy(xpath = INPUT_EMAIL_ADDRESS)
    public WebElement inputEmailAddress;

    @FindBy(xpath = INPUT_PASSWORD)
    public WebElement inputPassword;

    @FindBy(xpath = FORM_LOGIN_BUTTON)
    public WebElement formLoginButton;

    @FindBy(xpath = WARNING_LOGIN_ERROR_MSG)
    public WebElement warningLoginErrorMessage;

    @FindBy(css = CONTAINER_ESPN_SITE_HEADER)
    public WebElement containerESPNSitesHeader;

    @FindBy(css = CONTAINER_ESPN_SITE_LIST)
    public WebElement containerESPNSitesList;

    @FindBy(css = CONTAINER_FOLLOW_ESPN_HEADER)
    public WebElement containerFollowESPNHeader;

    @FindBy(css = CONTAINER_FOLLOW_ESPN_LIST)
    public WebElement containerFollowESPNList;

    //HELPER METHODS
    @Override
    public String getCurrentPageTitle() {
        return super.getCurrentPageTitle();
    }

    public void validateCurrentPage() {
        String actualTitle = getCurrentPageTitle();
        String expectedTitle = "ESPN: Serving sports fans. Anytime. Anywhere.";
        Assert.assertEquals(actualTitle, expectedTitle, "FAILED, TITLE DOES NOT MATCH!");
    }

    public int topEventsDropdownList() {
        mouseHoverOnly(topEventsDropdown);
        List<WebElement> topEventsDropDownList = getListOfWebElementsByXpath(topEventsDropdownMenu, TOP_EVENTS_DROPDOWN_MENU_ITEMS);
        return topEventsDropDownList.size();
    }

    public void validateTopEventsDropdownListSizeAndLinks() {
        int actualListSize = topEventsDropdownList();
        Assert.assertEquals(actualListSize, TOP_EVENT_DROPDOWN_COUNT, "FAILED, LIST SIZE DOES NOT MATCH!");
    }

    public boolean scrollHeader() {
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(headerScrollRight));
            headerScrollRight.click();
        } catch (Exception e) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(headerScrollRight));
            headerScrollRight.click();
        }
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(headerScrollLeft));
            headerScrollLeft.click();
        } catch (Exception e1) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(headerScrollLeft));
            headerScrollLeft.click();
        }

        boolean isPresent = false;
        if (ufcHeaderTile.isDisplayed()) {
            isPresent = true;
            return isPresent;
        } else if (!(ufcHeaderTile.isDisplayed())) {
            isPresent = false;
            return isPresent;
        }
        return isPresent;
    }

    public void validateScrollHeader() {
        boolean actualScroll = scrollHeader();
        System.out.println("Header Scroll: " + actualScroll);
        Assert.assertEquals(actualScroll, true, "FAILED, COULD NOT SCROLL ON HEADER");
    }

    public List<WebElement> getNFLDropdownMenuLeft() {
        mouseHoverOnly(nflDropdown);
        List<WebElement> nflDropdownElementsLeftList = nflDropdownMenuLeft.findElements(By.cssSelector(NFL_DROPDOWN_LEFT_MENU_ITEMS));
        return nflDropdownElementsLeftList;
    }

    public void validateNFLDropdownMenuLeftSize() {
        int actualSize = getNFLDropdownMenuLeft().size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSize, HEADER_DROPDOWN_LIST_SIZE, "SIZE OF LIST (NFL MENU LEFT) DOES NOT MATCH");
        softAssert.assertAll();
    }

    public void validateNFLDropdownMenuLeftItemsText() {
        List<WebElement> nflDropdownElementsLeftList = getNFLDropdownMenuLeft();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < nflDropdownElementsLeftList.size(); i++) {
            String actualText = nflDropdownElementsLeftList.get(i).getAttribute("innerHTML");
            System.out.println(nflDropdownElementsLeftList.get(i).getAttribute("innerHTML"));
            softAssert.assertEquals(actualText, NFL_DROPDOWN_MENU_LEFT_ITEMS[i], "ELEMENT OF LIST AT POSITION " + i + " (NFL MENU LEFT) DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getNFLDropdownMenuLeftLinks() {
        Actions hover = new Actions(driver);
        hover.moveToElement(nflDropdown).perform();

        List<WebElement> nflMenuListLeft = getListOfWebElementsByCss(nflDropdownMenuLeft, NFL_DROPDOWN_LEFT_MENU_LINKS);
        String[] nflMenuListLeftLinks = new String[nflMenuListLeft.size()];

        for (int i = 0; i < nflMenuListLeft.size(); i++) {
            nflMenuListLeftLinks[i] = nflMenuListLeft.get(i).getAttribute("href");
        }
        return nflMenuListLeftLinks;
    }

    public void validateNFLDropdownMenuLeftLinks() {
        String[] actualNFLDropdownMenuLeftPageLinks = getNFLDropdownMenuLeftLinks();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < actualNFLDropdownMenuLeftPageLinks.length; i++) {
            System.out.println(actualNFLDropdownMenuLeftPageLinks[i]);
            softAssert.assertEquals(actualNFLDropdownMenuLeftPageLinks[i], EXPECTED_NFL_DROPDOWN_LEFT_MENU_LINKS[i], "DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getNFLDropdownMenuRightNFLDivisionNames() {
        Actions hover = new Actions(driver);
        try {
            hover.moveToElement(nflDropdown).perform();
        } catch (StaleElementReferenceException exception) {
            exception.getMessage();
            hover.moveToElement(nflDropdown).perform();
        }
        List<WebElement> nflDivisions = nflDropdownMenuRight.findElements(By.cssSelector(NFL_DROPDOWN_MENU_DIVISION));
        String[] nflDivision = new String[nflDivisions.size()];

        for (int i = 0; i < nflDivisions.size(); i++) {
            nflDivision[i] = nflDivisions.get(i).getAttribute("innerHTML");
        }
        return nflDivision;
    }

    public void validateNFLDropdownMenuRightNFLDivisionNames() {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < getNFLDropdownMenuRightNFLDivisionNames().length; i++) {
            System.out.println(getNFLDropdownMenuRightNFLDivisionNames()[i]);
            softAssert.assertEquals(getNFLDropdownMenuRightNFLDivisionNames()[i], EXPECTED_NFL_DIVISION[i], "DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getNFLDropdownMenuRightNFLTeams() {
        Actions hover = new Actions(driver);
        try {
            hover.moveToElement(nflDropdown).perform();
        } catch (StaleElementReferenceException exception) {
            exception.getMessage();
            hover.moveToElement(nflDropdown).perform();
        }

        List<WebElement> nflTeamsList = nflDropdownMenuRight.findElements(By.cssSelector(NFL_DROPDOWN_MENU_TEAMS));
        String[] nflTeams = new String[nflTeamsList.size()];

        for (int i = 0; i < nflTeamsList.size(); i++) {
            nflTeams[i] = nflTeamsList.get(i).getAttribute("innerHTML");
        }
        return nflTeams;
    }

    public void validateNFLDropdownMenuRightNFLTeamsCount() {
        int actualNFLTeamsCount = getNFLDropdownMenuRightNFLTeams().length;
        Assert.assertEquals(actualNFLTeamsCount, NFL_TEAMS_COUNT, "NFL TEAMS DO NOT MATCH");
    }

    public void validateNFLDropdownMenuRightNFLTeams() {
        SoftAssert softAssert = new SoftAssert();
        String[] actualNFLTeams = getNFLDropdownMenuRightNFLTeams();

        for (int i = 0; i < actualNFLTeams.length; i++) {
            System.out.println(actualNFLTeams[i]);
            softAssert.assertEquals(actualNFLTeams[i], EXPECTED_NFL_TEAM_NAMES[i], "TEAM NAME DOES NOT MATCH");
        }
    }

    public List<WebElement> getNBADropdownMenuLeft() {
        mouseHoverOnly(nbaDropdown);
        List<WebElement> nbaDropdownElementsLeftList = getListOfWebElementsByCss(nbaDropdownMenuLeft, NBA_DROPDOWN_MENU_ITEMS_LEFT);

        return nbaDropdownElementsLeftList;
    }

    public void validateNBADropdownMenuLeftSize() {
        int actualSize = getNBADropdownMenuLeft().size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSize, HEADER_DROPDOWN_LIST_SIZE, "SIZE OF LIST DOES NOT MATCH");
        softAssert.assertAll();
    }

    public void validateNBADropdownMenuLeftItemsText() {
        List<WebElement> nbaDropdownElementsLeftList = getNBADropdownMenuLeft();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < nbaDropdownElementsLeftList.size(); i++) {
            String actualText = nbaDropdownElementsLeftList.get(i).getAttribute("innerHTML");
            System.out.println(nbaDropdownElementsLeftList.get(i).getAttribute("innerHTML"));
            softAssert.assertEquals(actualText, EXPECTED_NBA_DROPDOWN_MENU_ITEMS_LEFT[i], "ELEMENT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getNBADropdownMenuLeftLinks() {
        mouseHoverOnly(nbaDropdown);

        List<WebElement> nbaMenuListLeft = getListOfWebElementsByCss(nbaDropdownMenuLeft, NBA_DROPDOWN_MENU_LINKS_LEFT);
        String[] nbaMenuListLeftLinks = new String[nbaMenuListLeft.size()];

        for (int i = 0; i < nbaMenuListLeft.size(); i++) {
            nbaMenuListLeftLinks[i] = nbaMenuListLeft.get(i).getAttribute("href");
        }
        return nbaMenuListLeftLinks;
    }

    public void validateNBADropdownMenuLeftLinks() {
        String[] actualNBADropdownMenuLeftPageLinks = getNBADropdownMenuLeftLinks();
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actualNBADropdownMenuLeftPageLinks.length; i++) {
            System.out.println(actualNBADropdownMenuLeftPageLinks[i]);
            softAssert.assertEquals(actualNBADropdownMenuLeftPageLinks[i], EXPECTED_NBA_DROPDOWN_MENU_LEFT_LINKS[i], "LINK DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getNBADropdownMenuRightNBADivisionNames() {
        mouseHoverOnly(nbaDropdown);

        List<WebElement> nbaDivisions = nbaDropdownMenuRight.findElements(By.cssSelector(NBA_DROPDOWN_MENU_DIVISIONS));
        String[] nflDivision = new String[nbaDivisions.size()];

        for (int i = 0; i < nbaDivisions.size(); i++) {
            nflDivision[i] = nbaDivisions.get(i).getAttribute("innerHTML");
        }
        return nflDivision;
    }

    public void validateNBADropdownMenuRightNBADivisionNames() {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < getNBADropdownMenuRightNBADivisionNames().length; i++) {
            System.out.println(getNBADropdownMenuRightNBADivisionNames()[i]);
            softAssert.assertEquals(getNBADropdownMenuRightNBADivisionNames()[i], NBA_DIVISIONS[i], "NBA DIVISION DOES NOT MATCH");
        }
    }

    public String[] getNBADropdownMenuRightNBATeams() {
        mouseHoverOnly(nbaDropdown);

        List<WebElement> nbaTeamsList = nbaDropdownMenuRight.findElements(By.cssSelector(NBA_DROPDOWN_MENU_TEAMS));
        String[] nflTeams = new String[nbaTeamsList.size()];

        for (int i = 0; i < nbaTeamsList.size(); i++) {
            nflTeams[i] = nbaTeamsList.get(i).getAttribute("innerHTML");
        }
        return nflTeams;
    }

    public void validateNBADropdownMenuRightNBATeamsCount() {
        int actualNBATeamsCount = getNBADropdownMenuRightNBATeams().length;
        Assert.assertEquals(actualNBATeamsCount, EXPECTED_NBA_TEAMS_COUNT, "DO NOT MATCH");
    }

    public void validateNBADropdownMenuRightNBATeams() {
        SoftAssert softAssert = new SoftAssert();
        String[] actualNBATeams = getNBADropdownMenuRightNBATeams();

        for (int i = 0; i < actualNBATeams.length; i++) {
            System.out.println(actualNBATeams[i]);
            softAssert.assertEquals(actualNBATeams[i], EXPECTED_NBA_TEAM_NAMES[i], "TEAM NAME DOES NOT MATCH");
        }
    }

    public List<WebElement> getMLBDropdownMenuLeft() {
        mouseHoverOnly(mlbDropdown);
        List<WebElement> mlbDropdownElementsLeftList = getListOfWebElementsByCss(mlbDropdownMenuLeft, MLB_DROPDOWN_LEFT_MENU_ITEM);

        return mlbDropdownElementsLeftList;
    }

    public void validateMLBDropdownMenuLeftSize() {
        int actualSize = getMLBDropdownMenuLeft().size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSize, HEADER_DROPDOWN_LIST_SIZE, "SIZE DOES NOT MATCH");
        softAssert.assertAll();
    }

    public void validateMLBDropdownMenuLeftItemsText() {
        List<WebElement> mlbDropdownElementsLeftList = getMLBDropdownMenuLeft();
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < mlbDropdownElementsLeftList.size(); i++) {
            String actualText = mlbDropdownElementsLeftList.get(i).getAttribute("innerHTML");
            System.out.println(mlbDropdownElementsLeftList.get(i).getAttribute("innerHTML"));
            softAssert.assertEquals(actualText, MLB_DROPDOWN_MENU_ITEMS_LEFT[i], "ELEMENT DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getMLBDropdownMenuLeftLinks() {
        mouseHoverOnly(mlbDropdown);

        List<WebElement> mlbMenuListLeft = getListOfWebElementsByCss(mlbDropdownMenuLeft, MLB_DROPDOWN_LEFT_MENU_LINKS);
        String[] mlbMenuListLeftLinks = new String[mlbMenuListLeft.size()];

        for (int i = 0; i < mlbMenuListLeft.size(); i++) {
            mlbMenuListLeftLinks[i] = mlbMenuListLeft.get(i).getAttribute("href");
        }
        return mlbMenuListLeftLinks;
    }

    public void validateMLBDropdownMenuLeftLinks() {
        String[] actualMLBDropdownMenuLeftPageLinks = getMLBDropdownMenuLeftLinks();
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < actualMLBDropdownMenuLeftPageLinks.length; i++) {
            System.out.println(actualMLBDropdownMenuLeftPageLinks[i]);
            softAssert.assertEquals(actualMLBDropdownMenuLeftPageLinks[i], EXPECTED_MLB_DROPDOWN_MENU_LEFT_LINKS[i], "LINK AT POSITION " + i + " (MLB MENU LEFT) DOES NOT MATCH");
        }
        softAssert.assertAll();
    }

    public String[] getMLBDropdownMenuRightMLBDivisionNames() {
        mouseHoverOnly(mlbDropdown);

        List<WebElement> mlbDivisions = mlbDropdownMenuRight.findElements(By.cssSelector(MLB_DROPDOWN_MENU_DIVISIONS));
        String[] mlbDivision = new String[mlbDivisions.size()];

        for (int i = 0; i < mlbDivisions.size(); i++) {
            mlbDivision[i] = mlbDivisions.get(i).getAttribute("innerHTML");
        }
        return mlbDivision;
    }

    public void validateMLBDropdownMenuRightMLBDivisionNames() {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < getMLBDropdownMenuRightMLBDivisionNames().length; i++) {
            System.out.println(getMLBDropdownMenuRightMLBDivisionNames()[i]);
            softAssert.assertEquals(getMLBDropdownMenuRightMLBDivisionNames()[i], EXPECTED_ELEMENT_MLB_DIVISIONS[i], "MLB DIVISION AT POSITION" + i + " (MLB MENU RIGHT) DOES NOT MATCH");
        }
    }

    public String[] getMLBDropdownMenuRightMLBTeams() {
        mouseHoverOnly(mlbDropdown);

        List<WebElement> mlbTeamsList = mlbDropdownMenuRight.findElements(By.cssSelector(MLB_DROPDOWN_MENU_TEAMS));
        String[] mlbTeams = new String[mlbTeamsList.size()];

        for (int i = 0; i < mlbTeamsList.size(); i++) {
            mlbTeams[i] = mlbTeamsList.get(i).getAttribute("innerHTML");
        }
        return mlbTeams;
    }

    public void validateMLBDropdownMenuRightMLBTeamsCount() {
        int actualMLBTeamsCount = getMLBDropdownMenuRightMLBTeams().length;
        Assert.assertEquals(actualMLBTeamsCount, EXPECTED_MLB_TEAMS_COUNT, "NUMBER OF MLB TEAMS DO NOT MATCH");
    }

    public void validateMLBDropdownMenuRightMLBTeams() {
        SoftAssert softAssert = new SoftAssert();
        String[] actualMLBTeams = getMLBDropdownMenuRightMLBTeams();

        for (int i = 0; i < actualMLBTeams.length; i++) {
            System.out.println(actualMLBTeams[i]);
            softAssert.assertEquals(actualMLBTeams[i], EXPECTED_MLB_TEAM_NAMES[i], "TEAM NAME DOES NOT MATCH");
        }
    }

    public void validateLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        clickOnElement(loginButton);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));

        inputEmailAddress.sendKeys("DemoAccount1");
        inputPassword.sendKeys("demoPassword");
        formLoginButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(warningLoginErrorMessage, LOGIN_ERROR_MESSAGE));
        Assert.assertEquals(warningLoginErrorMessage.getText(), LOGIN_ERROR_MESSAGE, "LOGIN ERROR DOES NOT MATCH");
    }

    public void validateESPNSitesContainerHeadingAndCount(){
        SoftAssert softAssert = new SoftAssert();
        String actualHeaderTitle = containerESPNSitesHeader.getText();
        List<WebElement> listESPNSitesList = containerESPNSitesList.findElements(By.cssSelector(ESPN_SITE_LIST_ITEMS));
        int actualESPNSitesListCount = listESPNSitesList.size();
        softAssert.assertEquals(actualHeaderTitle, ESPN_SITES_HEADER_TITLE);
        softAssert.assertEquals(actualESPNSitesListCount, ESPN_SITES_LIST_COUNT);
    }

    public void validateESPNSitesContainerListItemNames(){
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> listESPNSitesList = containerESPNSitesList.findElements(By.cssSelector(ESPN_SITE_LIST_ITEMS));
        int i=0;
        for(WebElement element : listESPNSitesList){
            softAssert.assertEquals(element.getAttribute("innerHTML"), ESPN_SITES_LIST_ITEM_NAMES[i], "LIST ITEM DOES NOT MATCH");
            i++;
        }
    }

    public void validateFollowESPNContainerHeadingAndCount(){
        SoftAssert softAssert = new SoftAssert();

        String actualHeaderTitle = containerFollowESPNHeader.getText();
        List<WebElement> listESPNSitesList = containerFollowESPNList.findElements(By.cssSelector(ESPN_FOLLOW_LIST_ITEMS));
        int actualESPNSitesListCount = listESPNSitesList.size();
        softAssert.assertEquals(actualHeaderTitle, ESPN_FOLLOW_HEADER_TITLE);
        softAssert.assertEquals(actualESPNSitesListCount, ESPN_FOLLOW_LIST_COUNT);
    }

    public void validateFollowESPNContainerListItemNames(){
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> listESPNSitesList = containerFollowESPNList.findElements(By.cssSelector(ESPN_FOLLOW_LIST_ITEMS));
        int i=0;
        for(WebElement element : listESPNSitesList){
            softAssert.assertEquals(element.getAttribute("innerHTML"), ESPN_FOLLOW_LIST_ITEM_NAMES[i], "LIST ITEM DOES NOT MATCH");
            i++;
        }
    }

}
