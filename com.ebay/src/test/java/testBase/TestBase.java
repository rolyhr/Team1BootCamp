package testBase;

import POM.DataProviderPage;
import POM.ElectronicsPage;
import POM.Homepage;
import base.Base;
import base.ExcelReader;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public ElectronicsPage getElectronicsPage(){ return new ElectronicsPage();}

    public DataProviderPage getDataProviderPage(){ return new DataProviderPage();}



    static String path = System.getProperty("user.dir") + "/src/test/resources/EbayTestData.xlsx";
    public String[][] getTestDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderArrayStringArraysXSSF(path,sheetName);
    }

    public List<String> getTestDataAsList(String sheetName) throws IOException {
        excelReader = new ExcelReader();
        return excelReader.fileReaderStringListXSSF(path,sheetName);
    }

    public void pageUP(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
}
