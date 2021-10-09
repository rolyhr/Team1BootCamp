package testBase;

import POM.Homepage;
import POM.StaysPage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public StaysPage getStaysPage() {
        return new StaysPage();
    }

    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }



}
