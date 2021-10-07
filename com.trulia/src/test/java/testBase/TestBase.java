package testBase;

import POM.Homepage;
import POM.MortgagePage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public MortgagePage getMortgagePage(){return new MortgagePage();}

    static String path = System.getProperty("user.dir") + "/src/test/resources/Trulia.xlsx";

    public String[][] getString2DDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }

    public List<String> getExpectedList(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }
}
