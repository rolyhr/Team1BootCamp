package testBase;

import POM.FantasyPage;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public FantasyPage getFantasyPage(){return new FantasyPage();}

    static String path = System.getProperty("user.dir") + "/src/test/resources/espnFantasy.xlsx";

    public String[][] getString2DDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }

    public List<String> getExpectedList(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }
}
