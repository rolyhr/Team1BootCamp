package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreditCardHomePage extends Base {
    public CreditCardHomePage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//*[@id=\"navCreditCardsContent\"]/div[2]//div/p")
    public WebElement creditInfo;

    @FindBy(xpath="//*[@id=\"navCreditCardsContent\"]/div[2]/div[1]//div[2]/ul/li")
    public List<WebElement> creditLinks;

    @FindBy(xpath="//*[@id=\"btnCompareCreditCards\"]")
    public WebElement btnCompareCreditCards;

    @FindBy(xpath="//*[@id=\"popularCards\"]/div/div//h2")
    public List<WebElement> cardNames;

    @FindBy(xpath="//*[@id=\"popularCards\"]//div[2]/h3")
    public List<WebElement> cardDescriptions;

    @FindBy(xpath="//*[@id=\"cardsForStudents\"]")
    public WebElement cardsForStudents;

    @FindBy(xpath="//*[@id=\"terms_and_conditions_4051863~3D~en_US\"]")
    public WebElement cardsForStudentsTC;

    @FindBy(xpath="//*[@id=\"termsAndConditions\"]/div[4]/div/div[1]/b")
    public List<WebElement> rowName;

    @FindBy(xpath="//*[@id=\"lifeServicesLink\"]")
    public WebElement lifeServices;

    @FindBy(xpath="//*[@id=\"powerOfAttorneyLarge\"]")
    public WebElement powerOfAttorneyLarge;

    @FindBy(xpath="//*[@id=\"commonQuestionsFaqPanel0\"]")
    public WebElement powerOfAttorneyCQ;

    @FindBy(xpath="//*[@id=\"tabsNav\"]//ul/li/a")
    public List<WebElement>  lifeServicesLabels;

    @FindBy(xpath="//*[@id=\"commonQuestionsFaqPanel0\"]//p[3]")
    public WebElement questionTwo;

    @FindBy(xpath="//*[@id=\"cashRewardsCards\"]")
    public WebElement cashRewardsCards;

    @FindBy(xpath="//*[@id=\"footer_cc_glossary\"]")
    public WebElement footer_cc_glossary;

    @FindBy(xpath="//*[contains(@id,\"A_id_\")]")
    public List<WebElement> glossaryA;

    @FindBy(xpath="//*[@id=\"footer-links-2\"]/ul/li/a")
    public List<WebElement> creditHREF;

    @FindBy(xpath="//*[@id=\"index-K\"]")
    public WebElement indexK;

    @FindBy(xpath="//*[@id=\"pointsRewardsCards\"]")
    public WebElement pointsRewardsCards;

    @FindBy(xpath="//*[@id=\"footer_cc_status\"]")
    public WebElement footer_cc_status;

    @FindBy(xpath="//*[@id=\"lastNameField\"]")
    public WebElement lastNameField;

    @FindBy(xpath="//*[@id=\"dateOfBirth\"]")
    public WebElement dateOfBirth;

    @FindBy(xpath="//*[@id=\"lastFourSSN\"]")
    public WebElement lastFourSSN;

    @FindBy(xpath="//*[@id=\"zipCode\"]")
    public WebElement zipCode;

    @FindBy(xpath="//*[@id=\"userInfo\"]/div[5]/div/button")
    public WebElement submitButton;

    @FindBy(xpath="//*[@id=\"appStatusErrorModule\"]//p[1]")
    public WebElement errorMessage;




}
