package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class = \"uitk-tabs-container\"]//li[3]/a")
    WebElement carsButton;

    public CarsPage navigateToCarsPage(){
        clickJScript(carsButton);
        return new CarsPage();
    }

}
