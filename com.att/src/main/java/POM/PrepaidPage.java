package POM;

import base.Base;
import base.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PrepaidPage extends Base {

    public PrepaidPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@data-test-id=\"linkHeading4\"]")
    WebElement prepaidAccountLink;

    @FindBy(xpath = "//a[@href=\"/prepaid/plans/\"]")
    WebElement prepaidPlanLink;

    @FindBy(xpath = "//a[@href=\"/buy/prepaid-phones/\"]")
    WebElement phoneLink;

    @FindBy(xpath = "//a//span[@data-test-id=\"linkHeading3\"]")
    WebElement bringYourOwnLink;

    @FindBy(xpath = "//button[@class=\"slick-arrow slick-next slick-disabled\"]")
    WebElement phoneSelectionRightArrowButton;



    public PrepaidPage navigateToPrepaidAccountPage(){
        clickOnElement(prepaidAccountLink);
        return new PrepaidPage();
    }
    public void clickOnPrepaidPlansLink(){
        clickOnElement(prepaidPlanLink);
    }
    public void clickOnPhoneLink(){
        clickOnElement(phoneLink);
    }
    public void clickOnBringYourOwnLink(){
        clickOnElement(bringYourOwnLink);
    }


    public void doClickOnPrepaidAccountLink(){
        navigateToPrepaidAccountPage();
    }

    public void doClickOnPrepaidPlansLink(){
        clickOnPrepaidPlansLink();
    }

    public void doClickOnPhoneLink(){clickOnPhoneLink();}

    public void doClickOnBringYourOwnLink(){clickOnBringYourOwnLink();}


    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile() throws IOException {
        excelReader = new ExcelReader();
        String sheetName = "ATT";
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
        return testData;
    }



}
