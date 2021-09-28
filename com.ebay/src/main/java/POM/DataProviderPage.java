package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataProviderPage extends Base {

    public DataProviderPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class=\"pagecontainer__top\"]//h1//span")
    WebElement electronicsPageHeader;

    //public String expectedHeader = electronicsPageHeader.getText();
}
