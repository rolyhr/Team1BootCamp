package testBase;

import POM.Homepage;
import POM.PrepaidPage;
import POM.prepaidLoginPage.PrepaidLoginPage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public PrepaidPage getPrepaidPage() { return new PrepaidPage();}

    public PrepaidLoginPage getPrepaidLoginPage() {return new PrepaidLoginPage();}

    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
        return testData;
    }

}
