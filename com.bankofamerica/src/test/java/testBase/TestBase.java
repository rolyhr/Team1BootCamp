package testBase;

import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    static String path = System.getProperty("user.dir") + "/src/test/resources/BankOfAmerica.xlsx";

    public String[][] getString2DDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }

    public List<String> getExpectedList(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }
}
