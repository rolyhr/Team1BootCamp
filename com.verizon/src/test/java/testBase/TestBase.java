package testBase;

import POM.AccessoriesHomePage;
import POM.HomePage;
import base.Base;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

public class TestBase extends Base {

    public HomePage getHomepage() {
        return new HomePage();
    }

    public AccessoriesHomePage getAccessoriesHomePage() {
        return new AccessoriesHomePage();
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
