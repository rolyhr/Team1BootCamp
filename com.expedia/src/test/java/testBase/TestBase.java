package testBase;

import POM.CarsPage;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public CarsPage getCarsPage() {
        return new CarsPage();
    }

    static String path = System.getProperty("user.dir") + "/src/test/resources/ExpediaData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }
}
