package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
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
    public void testFashionMorerCategoryList() throws IOException {

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

//    @Test(description = "TC006FS",enabled = true ,priority = 3)
//    public void testModalWiindowShopWomenShoeByBrand() throws IOException {
//        getFashion().navigateToFashion();
//        getFashion().filterProductByShopByBradFreeInternationalShipping();
//    }
}
