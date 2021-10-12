package testBase;

import POM.BuyHousesHomePage;
import POM.Homepage;
import base.Base;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }



    public BuyHousesHomePage getbuyHousesHomePage(){
        return new BuyHousesHomePage();
    }

    public boolean isElementPresent(WebElement element) {
        boolean flag = false;

        try {
            if (element.isDisplayed()) {
                flag = true;
            }
        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
