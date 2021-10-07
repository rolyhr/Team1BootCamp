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

    @FindBy(xpath = "//*[@id=\"long-form\"]/div//h1[contains(text(), 'Talk')]")
    WebElement contentForPreQualifiedPage;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]//h1/div")
    WebElement contentForMortgageRatePage;

    @FindBy(xpath = "//*[@id=\"main-content\"]//div[2]//h1/div")
    WebElement contentForRefinanceCalculatorPage;

    @FindBy(xpath = "//*[@id=\"main-content\"]//div[2]//h1/div")
    WebElement contentForMortgageCalculatorPage;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/div/main//h1/div")
    WebElement contentForAffordabilityCalculatorPage;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]//h1/div")
    WebElement contentForRefinanceRatesPage;

    public boolean isContentForRefinanceRatesPage(){ return isElementPresent(contentForRefinanceRatesPage);}

    public boolean isContentForAffordabilityCalculatorPage(){return isElementPresent(contentForAffordabilityCalculatorPage);}

    public boolean isContentForMortgageCalculatorPagePresent(){return isElementPresent(contentForMortgageCalculatorPage);}

    public boolean isContentForRefinanceCalculatorPagePresent(){return isElementPresent(contentForRefinanceCalculatorPage);}

    public boolean isContentForMortgageRatePagePresent(){return isElementPresent(contentForMortgageRatePage);}

    public boolean isContentForPreQualifiedPagePresent(){return isElementPresent(contentForPreQualifiedPage);}

    public boolean isContentForMortgageOverviewPagePresent(){return isElementPresent(contentForMortgageOverviewPage);}


    void clickOnSubMenuRefinanceCalculator(){clickOnElement(subMenuRefinanceCalculator);}

    void clickOnSubMenuAffordabilityCalculator(){clickOnElement(subMenuAffordabilityCalculator);}

    void clickOnsSubMenuMortgageCalculator(){clickOnElement(subMenuMortgageCalculator);}

    void clickOnSubMenuRefinanceRates(){clickOnElement(subMenuRefinanceRates);}

    void clickOnSubMenuMortgageRates(){clickOnElement(subMenuMortgageRates);}

    void clickOnSubMenuGetPreQualified(){clickOnElement(subMenuGetPreQualified);}

    void clickOnSubMenuMortgageOverview(){clickOnElement(subMenuMortgageOverview);}

    public List<String> getListOfDropDownOfMortgageNavMenu(){
        return getStringListFromADiv(By.xpath("//*[@id=\"__next\"]//header//li[3]//ul//div"));}

    void mouseHoverOnMortgageNavMenu(){mouseHoverOnAnElement(mortgageNavMenu);}


    public void doNavigateToRefinanceCalculatorPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuRefinanceCalculator();
        waitForElementToBeVisible(contentForRefinanceCalculatorPage);
    }

    public void doNavigateToAffordabilityCalculatorPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuAffordabilityCalculator();
        waitForElementToBeVisible(contentForAffordabilityCalculatorPage);
    }

    public void doNavigateToMortgageCalculatorPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnsSubMenuMortgageCalculator();
        waitForElementToBeVisible(contentForRefinanceCalculatorPage);
    }

    public void doNavigateToRefinanceRatesPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuRefinanceRates();
        waitForElementToBeVisible(contentForRefinanceRatesPage);
    }

    public void doNavigateToMortgageRatesPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuMortgageRates();
        waitForElementToBeVisible(contentForMortgageRatePage);
    }

    public void doNavigateToGetPreQualifiedPage(){
        visibilityOfMortgageNavDropdownMenu();
        clickOnSubMenuGetPreQualified();
        waitForElementToBeVisible(contentForPreQualifiedPage);
    }

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
