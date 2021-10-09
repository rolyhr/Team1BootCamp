package testPOM;

import POM.Homepage;
import POM.StaysPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;

public class TestStaysPage extends TestBase {

    Homepage homepage;
    StaysPage staysPage;
    String [][] testData;

    @Test(description = "TCCID001",priority = 1,enabled = true)
    public void testCheckInDate() throws IOException, InterruptedException {
        homepage=new Homepage();
        staysPage= homepage.navigateToStaysPage();
        testData=getTestDataFromExcelFile("Expedia");
        //staysPage.doSearchBySelectCheckInAndCheckOutDate(testData[0][0], testData[0][1], testData[0][2], testData[0][3], testData[0][4], testData[0][5], testData[0][6]);
        //Assert.assertTrue(staysPage.isSearchResultTitlePresent());
    }

    @Test(description = "TCCID002",priority = 2,enabled = true)
    public void testSearchForHotelWithoutAnySelection(){
        homepage = new Homepage();
        staysPage= homepage.navigateToStaysPage();
        staysPage.doSearchWithoutAnySelection();
        Assert.assertFalse(staysPage.isSearchResultTitlePresent());
    }

    @Test(description = "TCCID003",priority = 3,enabled = true)
    public void testDoSearchBySelectGoingToLocation(){
        homepage = new Homepage();
        staysPage= homepage.navigateToStaysPage();
        staysPage.doSearchBySelectGoingToLocation("New York","25","October","2021","25","November","2021");
        Assert.assertTrue(staysPage.isSearchResultTitlePresent());
    }


}
