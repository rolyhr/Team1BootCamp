package testBase;

<<<<<<< HEAD
import POM.Cruise;
=======
import POM.CarsPage;
import POM.Homepage;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Cruise getHomepage() {
        return new Cruise();
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
