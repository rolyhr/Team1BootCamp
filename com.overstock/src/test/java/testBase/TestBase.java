package testBase;

import POM.Homepage;
import base.Base;
import base.ExcelReader;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";


    public String[][] getString2DDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }

    public List<String> getExpectedList(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }

    public String[] getStringFromExelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringXSSF(path,sheetName);
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


//
//    private static String path = System.getProperty("user.dir") + "/src/test/resources/testData/productsTestData.xlsx";
//
//    @DataProvider(name="ProductsDataProvider")
//    public Object[][] productsDataProvider() throws IOException {
//        dataReader = new DataReader();
//        String sheetName = "products";
//
//        Object[][] testData = dataReader.fileReaderArrayStringArraysXSSF(path, sheetName);
//        return testData;
//    }
}
