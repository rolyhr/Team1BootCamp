package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static POM.locators.FashionLocators.*;

public class Fashion extends Base {
    public Fashion() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = FASHION_NAV)
    public WebElement navigateToFashion;

    public void navigateToFashion() {
       clickOnElement(navigateToFashion);

    }
}