package testBase;

import POM.DataProviderPage;
import POM.ElectronicsPage;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public ElectronicsPage getElectronicsPage(){ return new ElectronicsPage();}

    public DataProviderPage getDataProviderPage(){ return new DataProviderPage();}



    static String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }
}
