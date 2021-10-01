package testPOM;

import POM.CarsPage;
import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCarsPage extends TestBase {

    Homepage homepage;
    CarsPage carsPage;

    @Test(description = "ID: 001",priority = 1, enabled = false)
    public void testPickUpDate() throws InterruptedException {
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        carsPage.doSelectPickupAndDropOffDate("20","March","2022","3","April","2022");
        Assert.assertTrue(carsPage.isSearchPageDropOffLocPresent());
    }

    @Test(description = "Case ID:002", priority = 2, enabled = true)
    public void testSearchForCarWithoutAnySelection(){
        homepage = new Homepage();
        carsPage = homepage.navigateToCarsPage();
        carsPage.doSearchWithoutAnySelection();
        Assert.assertTrue(carsPage.isErrorMsgForPickUpLocationPresent());
    }

}
