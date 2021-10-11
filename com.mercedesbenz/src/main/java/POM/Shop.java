package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static POM.locators.ShopLocators.*;

public class Shop extends Base {
    public Shop() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = SELECT_CLASS)
    public WebElement selectClass;

    @FindBy(css = SELECT_CLASS_LIST)
    public List<WebElement> selectClassList;

    @FindBy(css = SELECT_CLASS_RESULT)
    public WebElement selectClassResult;

    @FindBy(css = SELECT_MODEL)
    public WebElement selectModel;

    @FindBy(css = SELECT_MODEL_LIST)
    public List<WebElement> selectModelList;

    @FindBy(css = SELECT_MODEL_RESULT)
    public WebElement selectModelResult;

    public void clickOnSelectClass(){
        clickJScript(selectClass);
    }

    public List<String> getListofSelectClassList(){
        return getListOfStringElements(selectClassList);
    }

    public void selectClass(){
        clickOnSelectClass();
        clickOnElement(selectClassList.get(1));
    }

    public String getSelectClassResult(){
        return selectClassResult.getText();
    }

    public void clickOnSelectModel(){
        selectClass();
        clickOnElement(selectModel);
    }

    public void selectModel(){
        clickOnSelectModel();
        clickOnElement(selectModelList.get(1));
    }
    public List<String> getListofSelectModelList(){
        return getListOfStringElements(selectModelList);
    }

    public String getSelectModelResult(){
        return selectModelResult.getText();
    }
}
