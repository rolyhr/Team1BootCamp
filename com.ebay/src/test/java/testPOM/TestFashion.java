package testPOM;

import base.MySqlReader;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestFashion extends TestBase {

    @Test(description = "TC001FS",enabled = false,priority = 1)
    public void testVisibilityOfDropDownMenuAfterHoverFashion(){

        boolean actualResult = getFashion().hoverFashionFromNavBar();
        boolean expecteResult = true;
        Assert.assertTrue(actualResult,"UNABLE TO DISPLAY FASHION DROP-DOWN MENU FROM NAVIGATION BAR");
    }

    @Test(description = "TC002FS",enabled = false ,priority = 1)
    public void testFashionMostPopularCategoryList() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().hoverFashionFromNavBar();
        List<String> acutalCategories = getFashion().getFashionMostPopularCategory();
        String[] expectedCategories =getExcelFile("MostPopularCategories");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"FASHION MOST POPULAR CATEGORY DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC003FS",enabled = false ,priority = 2)
    public void testFashionMoreCategoryList() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().hoverFashionFromNavBar();
        List<String> acutalCategories = getFashion().getFashionMoreCategory();
        String[] expectedCategories =getExcelFile("MoreCategories");
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"FASHION MOST POPULAR CATEGORY DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC004FS",enabled = false ,priority = 3)
    public void testFashionShopByCategoryList() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().navigateToFashion();
        List<String> acutalCategories = getFashion().getFashionShopByCategory();
        String[] expectedCategories =getExcelFile("ShopByCategory");

        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"FASHION SHOP BY CATEGORY DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC005FS",enabled = false ,priority = 3)
    public void testsearchExistingFashionProduct() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().navigateToFashion();
        boolean flag =false;

        String[] testData = getExcelFile("ShopByCategory");
        String[] expectedResults=getExcelFile("Search");

        int actualResult =  getFashion().searchFashionProduct(testData[1]);
        if(actualResult >0){
            flag = true;
        }
        Assert.assertTrue(flag,"SEARCH EXISTING FASHION PRODUCT IS NOT WORKING PROPERLY");

    }

    @Test(description = "TC006FS",enabled = false ,priority = 3)
    public void testsearcNonExistingFashionProduct() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().navigateToFashion();
        boolean flag =false;

        String[] testData = getExcelFile("Search");
     //   String[] expectedResults=getExcelFile("Search");

        int actualResult =  getFashion().searchFashionProduct(testData[0]);
        if(actualResult == 0){
            flag = true;
        }
        Assert.assertTrue(flag,"SEARCH  NON-EXISTING FASHION PRODUCT IS NOT WORKING PROPERLY");
    }

    @Test(description = "TC007FS",enabled = false,priority = 3)
    public void testsearchExistingFashionProductWithKeyBoard() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().navigateToFashion();
        boolean flag =false;

        String[] testData = getExcelFile("ShopByCategory");
        String[] expectedResults=getExcelFile("Search");

        int actualResult =  getFashion().searchFashionProductWithKeyboard(testData[1]);
        if(actualResult >0){
            flag = true;
        }
        Assert.assertTrue(flag,"SEARCH EXISTING FASHION PRODUCT WITH KEYBOARD IS NOT WORKING PROPERLY");

    }

    @Test(description = "TC008FS",enabled = false ,priority = 3)
    public void testsearcNonExistingFashionProducWithKeyboard() throws IOException {

        String sheetName = "ebayTestData";
        getFashion().navigateToFashion();
        boolean flag =false;

        String[] testData = getExcelFile("Search");
        //   String[] expectedResults=getExcelFile("Search");

        int actualResult =  getFashion().searchFashionProduct(testData[0]);
        if(actualResult == 0){
            flag = true;
        }
        Assert.assertTrue(flag,"SEARCH  NON-EXISTING FASHION PRODUCT WITH KEYBOARD IS NOT WORKING PROPERLY");
    }


    @Test(description = "TC009FS",enabled = false ,priority = 3)
    public void testgetBreadcrumFashion() throws IOException {
        getFashion().navigateToFashion();
        String[] expectedCategories =getExcelFile("Breadcrum");
        List<String> acutalCategories = getFashion().getBreadcrumbList();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC0010FS",enabled = false ,priority = 3)
    public void testgetBreadcrumFashionWomenShoe() throws IOException {
        getFashion().navigateToFashion();
        String[] expectedCategories =getExcelFile("fashionshoeBreadcrumb");
        List<String> acutalCategories = getFashion().getBreadcrumFashionWomenShoe();
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC0011FS",enabled = false ,priority = 3)
    public void testListofBuyingformats() throws IOException {
        String[] expectedCategories =getExcelFile("BuyingFormatList");
        List<String> acutalCategories = getFashion().getBuyingformats();
        Assert.assertTrue(compareStringListContains(acutalCategories,expectedCategories));
    }

    @Test(description = "TC0012FS",enabled = false ,priority = 3)
    public void testSelectBuyingformats() throws IOException {
        String[] expectedCategories =getExcelFile("BuyingFormatList");
        getFashion().getBuyingformats();
        String acutalCategories =  getFashion().selectbuyingFormatContainerRadioButton(expectedCategories[2]);
        Assert.assertTrue(compareStringContains(acutalCategories,expectedCategories[2]));
    }

    @Test(description = "TC0011FS",enabled = false ,priority = 3)
    public void testListofConditionFilters() throws IOException {
        String[] expectedCategories =getExcelFile("Condtion");
        List<String> acutalCategories = getFashion().getConditonfilter();
        System.out.println(acutalCategories);
        Assert.assertTrue(compareStringListContains(acutalCategories,expectedCategories));
    }

    @Test(description = "TC0012FS",enabled = false ,priority = 3)
    public void testSelectConditionFilters() throws IOException {
        String[] expectedCategories =getExcelFile("Condtion");
        getFashion().getConditonfilter();
        String acutalCategories =  getFashion().selectCconditonFilterCheckBox(expectedCategories[2]);
        Assert.assertTrue(compareStringContains(acutalCategories,expectedCategories[2]));
    }

    @Test(description = "TC0013FS",enabled = false ,priority = 3)
    public void testListofShoeFilters() throws IOException {
        String[] expectedCategories =getExcelFile("shoeSize");
        List<String> acutalCategories = getFashion().getShoeSizefilter();
        Assert.assertTrue(compareStringListContainsNumbers(acutalCategories,expectedCategories));
    }
    @Test(description = "TC0014FS",enabled = false ,priority = 3)
    public void testSelectShoeFilters() throws IOException {
        String[] expectedCategories =getExcelFile("shoeSize");
        String acutalCategories =  getFashion().selectShoeSizeFilterCheckBox(expectedCategories[2].substring(0,1));
        Assert.assertTrue(compareStringContains(acutalCategories,expectedCategories[2].substring(0,1)));
    }

    @Test(description = "TC0015FS",enabled = false ,priority = 3)
    public void testListofBrandFilters() throws IOException {
        String[] expectedCategories =getExcelFile("Brand");
        List<String> acutalCategories = getFashion().getBrandfilter();
        System.out.println(acutalCategories);
        Assert.assertTrue(compareStringListContains(acutalCategories,expectedCategories));
    }
    @Test(description = "TC0016FS",enabled = false ,priority = 3)
    public void testSelectBrandFilters() throws IOException, SQLException, ClassNotFoundException {
        List<String> expectedCategories =  getAllDataFromMySQL("SELECT BrandName FROM test_schema_1.brand","BrandName");
        //String[] expectedCategories =getExcelFile("Brand");
        String acutalCategories =  getFashion().selectBrandCheckBox();
        System.out.println(acutalCategories);
        Assert.assertTrue(compareStringContains(acutalCategories, expectedCategories.get(2)));

    }

    @Test(description = "TC0017FS",enabled = true ,priority = 3)
    public void testDragAndDrop() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        getFashion().navigateToFashion();
        getFashion().dragAndDrop();

    }
//    @Test(description = "TC006FS",enabled = true ,priority = 3)
//    public void testModalWiindowShopWomenShoeByBrand() throws IOException {
//        getFashion().navigateToFashion();
//        getFashion().filterProductByShopByBradFreeInternationalShipping();
//    }


}
