package testPOM;

import POM.DataProviderPage;
import POM.ElectronicsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;

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

    @Test(description = "Case ID : 002", priority = 1, enabled = true)
    public void testDoShopBySubCategoryOfCameraAndPhoto() throws IOException {

        testData = getTestDataFromExcelFile("Ebay_Electronics");
        electronicsPages = getElectronicsPage();
        electronicsPages.doShopBySubCategoryOfCameraAndPhoto(testData[0][0]);
        String actualText = electronicsPages.textOfCameraAndHeaderPage.getText();
        String expectedTest = testData[0][1];
        Assert.assertEquals(actualText,expectedTest);

    }
}
