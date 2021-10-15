package testBase;

import POM.Homepage;
import POM.SoccerPage;
import base.Base;
import base.ExcelReader;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public SoccerPage getSoccerPage(){ return new SoccerPage();}



    static String path = System.getProperty("user.dir") + "/src/test/resources/CBSSportsTestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }
    public List<String> getExpectedList(String sheetName) throws IOException {
        excelReader =new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }

    //Helper Method


}
