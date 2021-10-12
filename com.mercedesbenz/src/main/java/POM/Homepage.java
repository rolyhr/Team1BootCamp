package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[1]/header/nav/div[2]/ul[2]/li[2]/button")
    public WebElement myAccountTab;


    public MercedesBenzMyAccountPage navigateToMercedesBenzPageMyAccount(){
        clickOnElement(myAccountTab);
        return new MercedesBenzMyAccountPage();
    }



}
