package POM;

import base.Base;
import org.openqa.selenium.support.PageFactory;
import static POM.locators.ShopLocators.*;

public class Shop extends Base {
    public Shop() {
        PageFactory.initElements(driver, this);
    }

}
