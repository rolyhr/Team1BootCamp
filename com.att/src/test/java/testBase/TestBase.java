package testBase;

<<<<<<< HEAD
import POM.PhonesAndDevices;
import base.Base;
import org.openqa.selenium.WebElement;

import java.util.List;

import static attLocators.ATTLocators.TOP_LEFT_MENU_BAR;
=======
import POM.Homepage;
import POM.PrepaidPage;
import POM.prepaidLoginPage.PrepaidLoginPage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095

public class TestBase extends Base {

    public PhonesAndDevices getHomepage() {
        return new PhonesAndDevices();
    }

<<<<<<< HEAD
    public boolean doListsMatch(String parentElementLocator, String sheet){
        boolean flag = false;

        List<String> elementList = getListItemsByCss(parentElementLocator);

        for(int i = 0; i< elementList.size(); i++) {

            if (elementList.get(i).equals(readFromExcel(sheet, i))) {
                flag = true;
            } else {
                flag = false;
                System.out.println("EXPECTED: " + readFromExcel(sheet, i) + "\nACTUAL: " + elementList.get(i));
                break;
            }
        }

        return flag;
=======
    public PrepaidPage getPrepaidPage() { return new PrepaidPage();}

    public PrepaidLoginPage getPrepaidLoginPage() {return new PrepaidLoginPage();}

    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
        return testData;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
    }

}
