package testPOM;

import POM.DataProviderPage;
import POM.ElectronicsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestElectronicsPage extends TestBase {

    ElectronicsPage electronicsPages;
    DataProviderPage dataProviderPage;
    String[][] testData;


    @Test(description = "Case ID : 001", priority = 1, enabled = false)
    public void testDoNavigateToElectronicsPage() throws IOException {
        testData = getTestDataFromExcelFile("Ebay");
        electronicsPages = getElectronicsPage();
        electronicsPages.doNavigateToElectronicsPage();
        Assert.assertEquals(electronicsPages.getTextOfElectronicsPageHeader(),testData[0][0]);

    }

    @Test(description = "Case ID : 002", priority = 2, enabled = false)
    public void testDoShopBySubCategoryAllOfCameraAndPhoto() throws IOException {

        testData = getTestDataFromExcelFile("Ebay_Electronics");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategoryOfCameraAndPhoto(testData[0][0]);
        String actualText = electronicsPages.headerOfCameraPage.getText();
        String expectedTest = testData[0][1];
        Assert.assertEquals(actualText,expectedTest);

    }

    @Test(description = "Case ID : 003", priority = 3, enabled = false)
    public void testDoShopBySubCategoryCameraAndDroneOfCameraAndPhoto() throws IOException {

        testData = getTestDataFromExcelFile("Ebay_Electronics");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategoryOfCameraAndPhoto(testData[1][0]);
        String actualText = electronicsPages.headerOfCameraPage.getText();
        String expectedTest = testData[1][1];
        Assert.assertEquals(actualText,expectedTest);

    }

    @Test(description = "Case ID : 004", priority = 4, enabled = false)
    public void testDoShopBySubCategoryDSLRCameraOfCameraAndPhoto() throws IOException {

        testData = getTestDataFromExcelFile("Ebay_Electronics");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategoryOfCameraAndPhoto(testData[2][0]);
        String actualText = electronicsPages.headerOfCameraPage.getText();
        String expectedTest = testData[2][1];
        Assert.assertEquals(actualText,expectedTest);

    }

    @Test(description = "Case ID : 005", priority = 5, enabled = false)
    public void testDoShopBySubCategoryCellPhoneAndSmartWatch() throws IOException, InterruptedException {

        testData = getTestDataFromExcelFile("CellPhone");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategoryOfCellPhonesAndSmartWatches(testData[0][0]);
        String actualText = electronicsPages.getTextOfHeaderOfCellPhonesAndSmartWatch();
        String expectedTest = testData[0][1];
        Assert.assertEquals(actualText, expectedTest);
    }

    @Test(description = "Case ID : 006", priority = 6, enabled = false)
    public void testDoShopBySubCategorySamsungPhone() throws IOException, InterruptedException {

        testData = getTestDataFromExcelFile("CellPhone");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategorySamsungPhoneOfCellPhonesAndSmartWatch(testData[1][0]);
        String actualText = electronicsPages.getTextOfHeaderOfSamsungPhone();
        String expectedTest = testData[1][1];
        Assert.assertEquals(actualText, expectedTest);
    }

    @Test(description = "Case ID : 007", priority = 7, enabled = false)
    public void testCategoryNameInShopByCategorySection() throws Exception {

        electronicsPages = getElectronicsPage();
        electronicsPages.doNavigateToElectronicsPage();
        List<String> expectedCategoryName = getTestDataAsList("ShopByCategory");
        List<String> actualCategoryName = electronicsPages.getListOfShopByCategoryName();
        Assert.assertTrue(compareListsOfString(actualCategoryName,expectedCategoryName));
    }

    @Test(description = "Case ID : 008", priority = 8, enabled = false)
    public void testEbayRefurbishedNameInRefurbishedSection() throws Exception {

        electronicsPages = getElectronicsPage();
        electronicsPages.doNavigateToElectronicsPage();
        List<String> expectedCategoryName = getTestDataAsList("EbayRefurbished");
        List<String> actualCategoryName = electronicsPages.getListOfEbayRefurbishedName();
        Assert.assertTrue(compareListsOfString(actualCategoryName,expectedCategoryName));
    }

    @Test(description = "Case ID : 009", priority = 9, enabled = true)
    public void testMostPopularNameInPopularSection() throws Exception {

        electronicsPages = getElectronicsPage();
        electronicsPages.doNavigateToElectronicsPage();
        List<String> expectedCategoryName = getTestDataAsList("PopularCategory");
        List<String> actualCategoryName = electronicsPages.getListOfMostPopularName();
        Assert.assertTrue(compareListsOfString(actualCategoryName,expectedCategoryName));
    }

}
