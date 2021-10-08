package testPOM;

import base.ExcelReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestExperiences extends TestBase {

    public String filePath(){

        String systemPath = System.getProperty("user.dir");
        String EXCEL_RELATIVE_PATH = "/src/test/resources/TestData.xlsx";
        String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

        return  EXCEL_FILE_PATH;
    }
    /********************************************* Test Search Experience  With Date and Location **********************************************************/
    @Test(description = "TC001SE",enabled = false,priority = 5)
    public void testSearchExperience() throws IOException, InterruptedException {

        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        List<String> searchResult = new ArrayList<>();
        getExperiences().switchToExperienceTab();

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0;i<expectedText.length;i++){
            searchResult = getExperiences().searchExperience(expectedText[i],"March 2022","June 2022","1","22");
            getExperiences().clickLittleSearchBox();
            getExperiences().clearSearchBarLocation();
            getExperiences().clearSearchBarDate();
            actualSearchResulLocation =  searchResult.get(0);
            System.out.println("actual:" + actualSearchResulLocation);
            System.out.println("Expected:"+ expectedText[i]);
            softAssert.assertEquals(actualSearchResulLocation,expectedText[i],"SEARCH EXPERIENCE WITH DATE AND LOCATION NOT WORKING PROPERLY");

        }
        softAssert.assertAll();

    }

    /********************************************* Test Search Experience Location **********************************************************/
    @Test(description = "TC002SE",enabled = false,priority = 5)
    public void testSearchExperienceWithLocation() throws IOException, InterruptedException {

        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        getExperiences().switchToExperienceTab();

        SoftAssert softAssert = new SoftAssert();
        for(int i = 0;i<expectedText.length;i++){
            actualSearchResulLocation = getExperiences().searchLocation(expectedText[i]);

            getExperiences().clickLittleSearchBox();
            getExperiences().clearSearchBarLocation();

            softAssert.assertEquals(actualSearchResulLocation,expectedText[i],"SEARCH EXPERIENCE WITH LOCATION NOT WORKING PROPERLY");
        }
        softAssert.assertAll();
    }

    /********************************************* Test Search Experience Date **********************************************************/
    @Test(description = "TC003SE",enabled = false,priority = 5)
    public void testSearchExperienceWithDate() throws IOException, InterruptedException {


        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        String searchResult ;
        getExperiences().switchToExperienceTab();
        searchResult = getExperiences().searchDate("March 2022","June 2022","1","22");
        getExperiences().clickLittleSearchBox();
        getExperiences().clearSearchBarDate();

//        SoftAssert softAssert = new SoftAssert();
//        for(int i = 0;i<expectedText.length;i++){
//            searchResult = getExperiences().searchDate("March 2022","June 2022","1","22");

//            getExperiences().clickLittleSearchBox();
//            getExperiences().clearSearchBarDate();
//            actualSearchResulLocation =  searchResult;
//            System.out.println("actual:" + actualSearchResulLocation);
//            System.out.println("Expected:"+ expectedText[i]);
//            softAssert.assertEquals(actualSearchResulLocation,expectedText[1],"SEARCH EXPERIENCE WITH DATE NOT WORKING PROPERLY");

//        }
//        softAssert.assertAll();

    }

    /********************************************* Test Category Name List In Get Explore Live Anywhere **********************************************************/


    @Test (description = "TC004PP",enabled = false,priority = 1)
    public void testCategoryNameInGetExploreLiveAnywhere() throws IOException {

        String excelFilePath = filePath();
        String sheetName = "AirBNB";

        getExperiences().switchToExperienceTab();
        List<String> acutalPlaces = getExperiences().getExploreLiveAnywhere();
        String[] expectedPlaces =excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i< acutalPlaces.size();i++){
            softAssert.assertEquals(acutalPlaces.get(i),expectedPlaces[i],"LIVE ANYWHERE CATEGORYY DID NOT MATCH");
        }
        softAssert.assertAll();
    }
    /********************************************* Test Category Name List Discover Things To do **********************************************************/

    @Test  (description = "TC005PP",enabled = false,priority = 6)
    public void testCategoryNameInDiscoverThingsTodo() throws IOException {

        String excelFilePath = filePath();
        String sheetName = "GetDicoverThingsToDO";

        getExperiences().switchToExperienceTab();

        List<String> acutalPlaces = getExperiences().getDicoverThingstodo();
        String[] expectedPlaces =excelReader.fileReaderStringXSSF(excelFilePath,sheetName);
        System.out.println(acutalPlaces.size());


        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i< acutalPlaces.size();i++){
            System.out.println(acutalPlaces.get(i));
            System.out.println(expectedPlaces[i]);
            softAssert.assertEquals(acutalPlaces.get(i),expectedPlaces[i],"LIVE ANYWHERE CATEGORYY DID NOT MATCH");
        }
        softAssert.assertAll();

    }

    /********************************************* Test Select Language From Drop-down Menu **********************************************************/

    @Test  (description = "TC006PP",enabled = false,priority = 6)
    public void testSelectLanguageFromCheckBox() throws IOException, InterruptedException {
        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        List<String> searchResult = new ArrayList<>();
        getExperiences().switchToExperienceTab();
        searchResult = getExperiences().searchExperience(expectedText[1],"March 2022","June 2022","1","22");

       getExperiences().selectLanguageFromCheckBox();

    }

    /********************************************* Test Select Number of Adult Guest  From Drop-down Menu **********************************************************/

    @Test  (description = "TC007PP",enabled = false,priority = 6)
    public void testSelectAddNumberOfAdultGuest() throws IOException, InterruptedException {
        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        List<String> searchResult = new ArrayList<>();
        getExperiences().switchToExperienceTab();
        searchResult = getExperiences().searchExperience(expectedText[1],"March 2022","June 2022","1","22");

        Assert.assertTrue( getExperiences().selectAddNumberOfAdultGuest(16),"Failed to click REMOVE ADULT GUEST");
       // getExperiences().clickOnSaveButton();

    }

    /********************************************* Test Select Number of Adult Guest  From Drop-down Menu **********************************************************/

    @Test  (description = "TC008PP",enabled = false,priority = 6)
    public void testSelectRemoveNumberOfAdultGuest() throws IOException, InterruptedException {
        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        List<String> searchResult = new ArrayList<>();
        getExperiences().switchToExperienceTab();
        searchResult = getExperiences().searchExperience(expectedText[1],"March 2022","June 2022","1","22");

        Assert.assertTrue( getExperiences().selectRemoveNumberOfAdultGuest(16),"Failed to click REMOVE ADULT GUEST");
   //     getExperiences().clickOnSaveButton();

    }

    /********************************************* Test Select T  From Drop-down Menu **********************************************************/

    @Test  (description = "TC008PP",enabled = false,priority = 6)
    public void testSelectTimeOfDay() throws IOException, InterruptedException {
        String sheetName = "AirBNBSearchExperience";
        String excelFilePath = filePath();
        String[] expectedText = excelReader.fileReaderStringXSSF(excelFilePath,sheetName);

        String actualSearchResulLocation;
        List<String> searchResult = new ArrayList<>();
        getExperiences().switchToExperienceTab();
        searchResult = getExperiences().searchExperience(expectedText[1],"March 2022","June 2022","1","22");

        getExperiences().clickOnTimeOfDayDropDown();
        getExperiences().selectCheckBoxMorning();
        getExperiences().selectCheckBoxAfternoon();
        getExperiences().selectCheckBoxEvening();
        getExperiences().clickOnSaveButton();
//        waitForElementToBeVisible(getExperiences().result);
//
//        String acutalResult = getExperiences().result.getText();
//        String expectedResult = "43 experiences";
//
//        Assert.assertEquals(acutalResult,expectedResult,"DID NOT RECEIVE THE EXPECTED RESULT FOR TIME OF DAY FILTER");

    }

    @Test(description = "TC009SE",enabled = true, priority = 5)
    public void testFileUploadCV(){

        String systemPath = System.getProperty("user.dir");
        String FILE_RELATIVE_PATH = "/src/test/resources/cvJT.docx";
        String FILE_PATH = systemPath + FILE_RELATIVE_PATH;

       String actualResult = getExperiences().uploadResume(FILE_PATH);
       String expectedResult = "cvJT.docx";
       String[] actualList = actualResult.split("\\\\");
       Assert.assertEquals(actualList[actualList.length-1],expectedResult,"UNABLE TO UPLOAD RESUME");
    }
}
