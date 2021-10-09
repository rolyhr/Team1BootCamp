package testBase;

import POM.AccessoriesPage;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }
    public AccessoriesPage getAccessoriesPage(){
        return new AccessoriesPage();
    }

    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
        return testData;
    }
}
