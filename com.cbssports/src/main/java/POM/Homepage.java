package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"cbs-site-nav\"]/div/nav/ul/li[3]/a")
    public WebElement nfl;


    public NFLHomePage navigateToNFLHomePage() {
        waitForElementToBeVisible(nfl);
        clickOnElement(nfl);
        return new NFLHomePage();

    }
}
