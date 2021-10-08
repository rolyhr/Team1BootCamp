package testBase;

import POM.Fashion;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {


    public  Fashion fashion;

    public Homepage getHomepage() {
        return new Homepage();
    }

    public Fashion getFashion() {
        return new Fashion();
    }

    public static String[] getExcelFile(String sheetName) throws IOException {

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/ebayTestData.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        excelReader = new ExcelReader();

        return  excelReader.fileReaderStringXSSF(EXCEL_FILE_PATH,sheetName);
    }

}
