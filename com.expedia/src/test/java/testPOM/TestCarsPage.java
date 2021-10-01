package testPOM;

import POM.CarsPage;
import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;

public class TestCarsPage extends TestBase {

    Homepage homepage;
    CarsPage carsPage;
    String[][] testData;

    @Test(description = "ID: 001",priority = 1, enabled = false)
    public void testPickUpDate() throws InterruptedException {
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        carsPage.doSearchBySelectPickupAndDropOffDate("New York","20","March","2022","3","April","2022");
        Assert.assertTrue(carsPage.isSearchPageDropOffLocPresent());
    }

    @Test(description = "Case ID:002", priority = 2, enabled = false)
    public void testSearchForCarWithoutAnySelection(){
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        carsPage.doSearchWithoutAnySelection();
        Assert.assertTrue(carsPage.isErrorMsgForPickUpLocationPresent());
    }

    @Test(description = "Case ID:003", priority = 3, enabled = false)
    public void testSearchForCarBySelectingDropOffLocation(){
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        carsPage.doSearchBySelectDropOffLocation("New York","los","20","March","2022","3","April","2022");
        Assert.assertTrue(carsPage.isSearchResultTitlePresent());
    }

    @Test(description = "Case ID: 004", priority = 4, enabled = false)
    public void testAppDownloadByValidPhoneNumber() throws IOException, InterruptedException {
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        testData = getTestDataFromExcelFile("ExpediaAppData");
        carsPage.doDownloadAppByValidPhoneNumber(testData[0][0],testData[0][1]);
        Assert.assertTrue(carsPage.hasMessageAppearForValidSubmission());
    }

    @Test(description = "Case ID: 005", priority = 4, enabled = false)
    public void testAppDownloadByInvalidPhoneNumber() throws IOException, InterruptedException {
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        testData = getTestDataFromExcelFile("ExpediaAppData");
        carsPage.doDownloadAppByInvalidPhoneNumber(testData[0][0],testData[3][1]);
        Assert.assertTrue(carsPage.hasMessageAppearForInvalidSubmission());
    }

    @Test(description = "Case ID: 006", priority = 6, enabled = true)
    public void testAppDownloadForDifferentCountry() throws IOException, InterruptedException {
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        testData = getTestDataFromExcelFile("ExpediaAppData");
        carsPage.doDownLoadAppForDifferentCountry(testData[2][0],testData[2][1]);
        Assert.assertTrue(carsPage.hasMessageAppearForValidSubmission());
    }
}
