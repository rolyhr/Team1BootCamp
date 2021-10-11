package testBase;

import POM.Homepage;
import base.Base;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

//    public Shop getShop() {
//        return new Shop();
//    }
//
//    public static String systemPath = System.getProperty("user.dir");
//    public static String EXCEL_RELATIVE_PATH = "/src/test/resources/mercendesbenzTestData.xlsx";
//
//    public static String[] getExcelFile(String sheetName) throws IOException {
//        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
//        excelReader = new ExcelReader();
//        return  excelReader.fileReaderStringXSSF(EXCEL_FILE_PATH,sheetName);
//    }
//
//    public static String[][] getExcelFileArray(String sheetName) throws IOException {
//        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
//        excelReader = new ExcelReader();
//        return  excelReader.fileReaderArrayStringArraysXSSF(EXCEL_FILE_PATH,sheetName);
//    }
//
//    public static int[] getExcelFileArrayInteger(String sheetName) throws IOException {
//        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
//        excelReader = new ExcelReader();
//        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
//    }
//
//    public static int[] getExcelFileCellValue(String sheetName) throws IOException {
//        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
//        excelReader = new ExcelReader();
//        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
//    }
//
//    public void compareStringList(List<String> actual, String[]  expected){
//        boolean flag = false;
//
//        SoftAssert softAssert = new SoftAssert();
//        for (int i = 0; i< actual.size();i++){
//            softAssert.assertEquals(actual.get(i),expected[i],"FASHION MOST POPULAR CATEGORY DID NOT MATCH");
//        }
//        softAssert.assertAll();
//    }
}
