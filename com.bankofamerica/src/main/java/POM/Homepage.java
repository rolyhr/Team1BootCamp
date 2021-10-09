package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"navCreditCards\"]")
    public WebElement creditCard;

    public CreditCardHomePage navigateToCreditCard() {
        clickOnElement(creditCard);
        return new CreditCardHomePage();
    }
}
