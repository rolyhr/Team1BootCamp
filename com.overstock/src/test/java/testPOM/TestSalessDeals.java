package testPOM;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestSalessDeals extends TestBase {
    @Test(description = "TC001SD", enabled = false, priority = 2)
    public void testOverStockNavbarElemnts() throws IOException, InterruptedException, AWTException {
       String sheetName = "SalesDeals";
       String[] expectedCategories =getExcelFile(sheetName);
        getSalesDeals().navigateToSalesAndDeals();
        List<String> acutalCategories = getSalesDeals().getListofSalesAndDealsNavBarElements();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC002CSD", enabled = false, priority = 2)
    public void testShopByDeppartmentList() throws IOException, InterruptedException, AWTException {
        String sheetName = "Dpartments";
        String[] expectedCategories =getExcelFile(sheetName);
        getSalesDeals().navigateToSalesAndDeals();
        List<String> acutalCategories = getSalesDeals().getShopByDeppartmentList();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC002CSD", enabled = false, priority = 2)
    public void testFilterCategoryList() throws IOException, InterruptedException, AWTException {
        String[] expectedCategories =getExcelFile("FilterCategory");
        getSalesDeals().navigateToLivingRoomProducts();
        List<String> acutalCategories = getSalesDeals().getFilterCategoryList();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC002CSD", enabled = false, priority = 2)
    public void testColorFilterCheckBoxList() throws IOException, InterruptedException, AWTException {
        String[] expectedCategories =getExcelFile("ColorList");
        getSalesDeals().navigateToLivingRoomProducts();
        getSalesDeals().clickOnLivingRoomColorFilter();
        List<String> acutalCategories = getSalesDeals().getFilterColorList();
        Assert.assertTrue(compareStringListContains(acutalCategories,expectedCategories),"COLOR FILTER LIST DID NOT MATCH");
    }

//    @Test(description = "TC002CSD", enabled = true, priority = 2)
//    public void testGetFilturedProductByColor() throws IOException, InterruptedException, AWTException {
//        String[] expectedCategories =getExcelFile("ColorList");
//        List<String> acutalCategories = getSalesDeals().getFilturedProductByColor();
//        compareStringList(acutalCategories,expectedCategories);
//    }

    @Test(description = "TC002CSD", enabled = true, priority = 2)
    public void testgetProductPriceList() throws IOException, AWTException, InterruptedException {
        String[] expectedCategories =getExcelFile("PriceList");
        getSalesDeals().navigateToLivingRoomProducts();
        List<String> acutalCategories = getSalesDeals().getProductPriceList();
        Assert.assertTrue(compareStringListContains(acutalCategories,expectedCategories),"Price LIST DID NOT MATCH");
    }
//
//    @Test(description = "TC004CK", enabled = true, priority = 5)
//    public void testfHamburgerMenuList() throws IOException {
//        String sheetName = "HamburgerMenu";
//        String[] expectedCategories =getExcelFile(sheetName);
//        getWireless().navigateToWireless();
//        getWireless().clickOnhamburerMenu();
//        List<String> acutalCategories = getWireless().getListOfHamburgerMenuList();
//        acutalCategories.removeAll(Arrays.asList("", null));
//        compareStringList(acutalCategories,expectedCategories);
//    }

}
