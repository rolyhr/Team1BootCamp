package testPOM;

import POM.Homepage;
import base.ExcelReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestHomepage extends TestBase {

    List<String> testData;

    String[][] stingValue;

    @DataProvider
    public static Object[][] ProductsDataProvider() {
        return new Object[][]{};
    }
//not complete
    @Test(enabled = false)
    public void testRegisterAccountWithValidData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
        String sheetName = "testRegister";

        excelReader= new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        Homepage homepage = new Homepage();
        homepage.registerAnAccount(testData[0][0], testData[0][1]);



        WebElement loggedInConfirmation = homepage.loggedInConfirmation();

        Assert.assertTrue(loggedInConfirmation.isDisplayed());

    }

//not complete
    @Test (enabled = false)
    public void testSignInWithValidData() throws IOException {

        String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
        String sheetName = "testRegister";

        excelReader = new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        Homepage homepage = new Homepage();
        homepage.signIn(testData[0][0], testData[0][1]);

        WebElement loggedInConfirmation = homepage.loggedInConfirmation();

        Assert.assertTrue(loggedInConfirmation.isDisplayed());

    }
//not complete
    @Test(dataProvider = "ProductsDataProvider",  enabled = false)
    public void testSearchForProductOnSearchBar(String products, String title) {
        getHomepage().searchForProductOnSearchBar(products);

        String actualResults = driver.getTitle().toString();
        String expectedResults = title;

        Assert.assertEquals(actualResults, expectedResults);


    }

//not complete
    @Test (enabled = false)
    public void testNavigateToYoutubeChannelOnAnotherTab() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
        String sheetName = "expected_conditions";

        getHomepage().navigateToYoutubeChannel();

        excelReader = new ExcelReader();
        String[][] testData = excelReader.fileReaderArrayStringArraysXSSF(path, sheetName);

        String actualResults = driver.getTitle().toString();
        String expectedResults = testData[0][0];

        Assert.assertEquals(actualResults, expectedResults);

    }


}
