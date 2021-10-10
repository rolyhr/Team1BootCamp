package testBase;

import POM.Checking;
import POM.Homepage;
import base.Base;
import base.ExcelReader;

import java.io.IOException;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }
    public Checking getCheking() {
        return new Checking();
    }

    public static String[] getExcelFile(String sheetName) throws IOException {

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/BankOfAmerica.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        excelReader = new ExcelReader();

        return  excelReader.fileReaderStringXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static String[][] getExcelFileArray(String sheetName) throws IOException {

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/BankOfAmerica.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        excelReader = new ExcelReader();

        return  excelReader.fileReaderArrayStringArraysXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static int[] getExcelFileArrayInteger(String sheetName) throws IOException {

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/BankOfAmerica.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        excelReader = new ExcelReader();

        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static int[] getExcelFileCellValue(String sheetName) throws IOException {

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/BankOfAmerica.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        excelReader = new ExcelReader();

        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
    }
}
