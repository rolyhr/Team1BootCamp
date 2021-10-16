package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;

public class TestPrepaidPage extends TestBase {

    String[][] testData;



    @Test(description = "TC_ATT_Prepaid:001", priority = 1, enabled = false)
    public void testDoPrepaidPlansLink() throws IOException {

        testData = getPrepaidPage().getTestDataFromExcelFile();
        getPrepaidPage().doClickOnPrepaidPlansLink();
        String expected_url = testData[0][0];
        String actual_url = driver.getCurrentUrl();
        Assert.assertEquals(actual_url,expected_url);
    }

    @Test(description = "TC_ATT_Prepaid:002", priority = 2, enabled = false)
    public void testDoClickOnPhoneLink() throws IOException {

        testData = getPrepaidPage().getTestDataFromExcelFile();
        getPrepaidPage().doClickOnPhoneLink();
        String expected_url = testData[1][0];
        String actual_url = driver.getCurrentUrl();
        Assert.assertEquals(actual_url,expected_url);
    }

    @Test(description = "TC_ATT_Prepaid:003", priority = 3, enabled = false)
    public void testDoClickOnBringYourOwnLink() throws IOException {

        testData = getPrepaidPage().getTestDataFromExcelFile();
        getPrepaidPage().doClickOnBringYourOwnLink();
        String expected_url = testData[2][0];
        String actual_url = driver.getCurrentUrl();
        Assert.assertEquals(actual_url,expected_url);
    }
}
