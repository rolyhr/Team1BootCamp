package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//*[@id=\"global-nav\"]/ul/li[3]/a/span/span[1]")
    public WebElement mlb;


    public MLBHomePage navigateToMLBHomePage() {
        waitForElementToBeVisible(mlb);
        clickOnElement(mlb);
        return new MLBHomePage();
    }



}
