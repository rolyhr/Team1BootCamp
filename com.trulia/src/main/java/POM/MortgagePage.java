package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class MortgagePage extends Base {

    public MortgagePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]//header//a[text() = 'Mortgage']")
    WebElement mortgageNavMenu;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[1]//div")
    WebElement subMenuMortgageOverview;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[2]//div")
    WebElement subMenuGetPreQualified;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[3]//div")
    WebElement subMenuMortgageRates;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[4]//div")
    WebElement subMenuRefinanceRates;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[5]//div")
    WebElement subMenuMortgageCalculator;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[6]//div")
    WebElement subMenuAffordabilityCalculator;

    @FindBy(xpath = "//*[@id='__next']//header//li[3]//li[7]//div")
    WebElement subMenuRefinanceCalculator;

    @FindBy(xpath = "//*[@id=\"main-content\"]//div[contains(text(), 'Looking for a')]")
    WebElement contentForMortgageOverviewPage;

    public boolean isContentForMortgageOverviewPagePresent(){return isElementPresent(contentForMortgageOverviewPage);}

    void clickOnSubMenuMortgageOverview(){clickOnElement(subMenuMortgageOverview);}

    public List<String> getListOfDropDownOfMortgageNavMenu(){
        return getStringListFromADiv(By.xpath("//*[@id=\"__next\"]//header//li[3]//ul//div"));}

    void mouseHoverOnMortgageNavMenu(){mouseHoverOnAnElement(mortgageNavMenu);}

    public void doNavigateToMortgageOverviewPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuMortgageOverview();
        waitForElementToBeVisible(contentForMortgageOverviewPage);
    }

    public void visibilityOfMortgageNavDropdownMenu(){
        waitForElementToBeVisible(mortgageNavMenu);
        mouseHoverOnMortgageNavMenu();
    }


}
