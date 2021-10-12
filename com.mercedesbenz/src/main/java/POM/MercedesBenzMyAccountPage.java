package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MercedesBenzMyAccountPage extends Base {

    public MercedesBenzMyAccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[1]/header/nav/ul/li[5]/div/div/ul/li[2]/section/div/div/div[2]/button")
    public WebElement registerTab;

    @FindBy(xpath="//*[@id=\"registrationPage\"]/div[1]")
    public WebElement createAUserAccount;

    @FindBy(xpath="//*[@id=\"username\"]")
    public WebElement inputEmailAddress;

    @FindBy(xpath="//*[@id=\"firstname\"]")
    public WebElement inputFirstName;

    @FindBy(xpath="//*[@id=\"lastname\"]")
    public WebElement inputLastName;

    @FindBy(xpath="//*[@id=\"56-button\"]/span")
    public WebElement selectLanguageDropDownMenu;

    @FindBy(xpath="//*[@id=\"56-button\"]")
    public WebElement selectLanguageEnglishUS;

    @FindBy(xpath="//*[@id=\"59-button\"]/span")
    public WebElement selectCountryDropDownMenu;

    @FindBy(xpath="//*[@id=\"59-button\"]")
    public WebElement selectCountryUSA;

    @FindBy(xpath="//*[@id=\"password\"]")
    public WebElement inputPassword;

    @FindBy(xpath="//*[@id=\"toas\"]/div[1]/div")
    public WebElement checkBox;

    @FindBy(xpath="//*[@id=\"continue\"]")
    public WebElement createUserAccount;

    @FindBy(xpath="//div[1]/header/nav/ul/li[5]/div/div/ul/li[2]/section/div/div/div[1]/button")
    public WebElement loginButton;

    @FindBy(xpath="//*[@id=\"loginPage\"]/div[1]")
    public WebElement loginPage;

    @FindBy(xpath="//*[@id=\"username\"]")
    public WebElement inputUserName;

    @FindBy(xpath="//*[@id=\"continue\"]")
    public WebElement continueTab;








}
