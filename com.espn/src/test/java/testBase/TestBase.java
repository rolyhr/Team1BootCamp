package testBase;

<<<<<<< HEAD
import POM.ESPNHomepage;
=======
import POM.FantasyPage;
import POM.Homepage;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
import base.Base;
import base.ExcelReader;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public ESPNHomepage getHomepage() {
        return new ESPNHomepage();
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

    public String[] getStringFromExelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringXSSF(path,sheetName);
    }
}
