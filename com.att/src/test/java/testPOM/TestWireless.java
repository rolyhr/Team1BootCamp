package testPOM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestWireless extends TestBase {

    @Test(description = "TC001CK", enabled = false, priority = 2)
    public void testATTNavbarElemnts() throws IOException {
        String sheetName = "AttNavBar";
        String[] expectedCategories =getExcelFile(sheetName);
        getWireless().navigateToWireless();
        List<String> acutalCategories = getWireless().getListOfAttNavBarElements();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC002CK", enabled = false, priority = 3)
    public void testWirelessNavbarElemnts() throws IOException {
        String sheetName = "WirelssNavBar";
        String[] expectedCategories =getExcelFile(sheetName);
        getWireless().navigateToWireless();
        List<String> acutalCategories = getWireless().getListOfWirelessNavBarList();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC003CK", enabled = false, priority = 4)
    public void testAnyPhoneYourChoiceList() throws IOException {
        String sheetName = "PhoneChoice";
        String[] expectedCategories =getExcelFile(sheetName);
        getWireless().navigateToWireless();
        List<String> acutalCategories = getWireless().getListOfAnyPhoneYourChoiceList();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC004CK", enabled = false, priority = 5)
    public void testfHamburgerMenuList() throws IOException {
        String sheetName = "HamburgerMenu";
        String[] expectedCategories =getExcelFile(sheetName);
        getWireless().navigateToWireless();
        getWireless().clickOnhamburerMenu();
        List<String> acutalCategories = getWireless().getListOfHamburgerMenuList();
        acutalCategories.removeAll(Arrays.asList("", null));
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC005CK", enabled = true, priority = 6)
    public void testTableNumberOfRows() throws IOException {
//        String sheetName = "Table";
//        String[] expectedCategories =getExcelFile(sheetName);
        getWireless().navigateToWireless();
        int actual = getWireless().getNumberofRows();
        int expected = 7;
        Assert.assertEquals(actual,expected,"Table Row Number Did Not Match");
    }
//
//    @Test(description = "TC006CK", enabled = false, priority = 1)
//    public void testTableNumberOfColumns() throws IOException {
////        String sheetName = "Tabke";
////        String[] expectedCategories =getExcelFile(sheetName);
//        getWireless().navigateToWireless();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
//        int actual = getWireless().getNumberofColumns();
//        int expected = 4;
//        Assert.assertEquals(actual,expected,"Table Columns Number Did Not Match");
//    }
}
