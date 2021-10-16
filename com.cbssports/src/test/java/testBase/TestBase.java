package testBase;

<<<<<<< HEAD
import POM.CBSLogin;
=======
import POM.Homepage;
import POM.SoccerPage;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
import base.Base;
import base.ExcelReader;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class TestBase extends Base {

    public CBSLogin getLogin() {
        return new CBSLogin();
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
