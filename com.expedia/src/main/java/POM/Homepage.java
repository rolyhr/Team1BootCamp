package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"wizardMainRegionV2\"]//div[2]//ul/li[1]/a")
    WebElement staysButton;

    public StaysPage navigateToStaysPage(){
        clickJScript(staysButton);
        return new StaysPage();
    }


}
