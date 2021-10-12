package testBase;

import POM.Fashion;
import POM.Homepage;
import base.Base;
import base.ExcelReader;
import base.MySqlReader;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class TestBase extends Base {


    public  Fashion fashion;

    public Homepage getHomepage() {
        return new Homepage();
    }

    public Fashion getFashion() {
        return new Fashion();
    }



    public static String systemPath = System.getProperty("user.dir");
    public static String EXCEL_RELATIVE_PATH = "/src/test/resources/ebayTestData.xlsx";

    public static String[] getExcelFile(String sheetName) throws IOException {
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
        excelReader = new ExcelReader();
        return  excelReader.fileReaderStringXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static String[][] getExcelFileArray(String sheetName) throws IOException {
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
        excelReader = new ExcelReader();
        return  excelReader.fileReaderArrayStringArraysXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static int[] getExcelFileArrayInteger(String sheetName) throws IOException {
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
        excelReader = new ExcelReader();
        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public static int[] getExcelFileCellValue(String sheetName) throws IOException {
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;
        excelReader = new ExcelReader();
        return  excelReader.fileReaderIntegerXSSF(EXCEL_FILE_PATH,sheetName);
    }

    public void compareStringList(List<String> actual, String[]  expected){
        boolean flag = false;

        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< actual.size();i++){
            System.out.println(actual.get(i));
            softAssert.assertEquals(actual.get(i),expected[i],"FASHION MOST POPULAR CATEGORY DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    public boolean compareStringListContains(List<String> actual, String[]  expected){
        int flagCount = 0;
        boolean flag;
        System.out.println(actual.size());
        System.out.println(expected.length);
        for (int i = 0; i< actual.size();i++){
           System.out.println(actual.get(i));
            if(!actual.get(i).contains(expected[i])){
                flagCount += 1 ;
//                System.out.println("Actual:"+  actual.get(i));
//                System.out.println("Expected:"+expected[i]);
//                System.out.println("*****");
            }
        }

        if(flagCount== 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean compareStringListContainsNumbers(List<String> actual, String[]  expected){
        int flagCount = 0;
        boolean flag;
        System.out.println(actual.size());
        System.out.println(expected.length);
        for (int i = 0; i< actual.size();i++){
            //  System.out.println(actual.get(i));
            if(!actual.get(i).contains(expected[i].substring(0,1))){
                flagCount += 1 ;
                System.out.println("Actual:"+  actual.get(i));
                System.out.println("Expected:"+expected[i]);
                System.out.println("*****");
            }
        }

        if(flagCount== 0) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    public boolean compareStringContains(String actual, String  expected){
        boolean flag = false;
            if(actual.contains(expected)) {
                flag = true;
            }
        return flag;
    }
}
