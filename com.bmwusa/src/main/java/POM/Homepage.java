package POM;

import base.Base;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    public Homepage() {
        PageFactory.initElements(driver, this);
    }




}
