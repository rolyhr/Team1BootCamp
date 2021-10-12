package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#gnav20-Shop-L1")
    public WebElement shopTab;

    @FindBy(css = "#gnav20-Shop-L2-4")
    public WebElement accessoriesTab;

    @FindBy(css = "#gnav20-Shop-L3-46")
    public WebElement shopAllAccessories;

    public AccessoriesHomePage navigateToAccessories(){
        clickOnElement(shopTab);
        clickOnElement(accessoriesTab);
        clickOnElement(shopAllAccessories);
        return new AccessoriesHomePage();
    }

    public AccessoriesHomePage navigateToAccessories2(){
        clickOnElement(shopTab);
        clickOnElement(accessoriesTab);
        return new AccessoriesHomePage();
    }
}
