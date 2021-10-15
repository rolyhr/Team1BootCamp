package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static truliaLocators.TruliaLocators.*;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Base {

    @FindBy (css = MAIN_MENUS)
    public WebElement mainMenus;

    public List<String> truliaMainMenu() {
        List<WebElement> webElementMM = driver.findElements(By.cssSelector(MAIN_MENUS));
        List<String> mainMenus = new ArrayList<>();
        for (WebElement mm : webElementMM) {
            mainMenus.add(mm.getText());
        }
        return mainMenus;
    }

}
