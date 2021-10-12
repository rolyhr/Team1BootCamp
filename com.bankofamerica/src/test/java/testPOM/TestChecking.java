package testPOM;

import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestChecking extends TestBase {

    @Test(description = "TC001CK", enabled = false, priority = 1)
    public void testMobileBankingNavbarElemnts() throws IOException {
        String sheetName = "MobileBankingNavbarElemnts";
     //   getCheking().navigateToMobileBanking();
        List<String> acutalCategories = getCheking().getListofMobileBankingNavbarElemnts();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BANKING NAVIGATION BAR ELEMENTS LIST DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC002CK", enabled = false, priority = 1)
    public void testBreadcrumb() throws IOException {
        String sheetName = "BreadCrumb";
    //    getCheking().navigateToMobileBanking();
        List<String> acutalCategories = getCheking().getListofBreadcrumbelemnts();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"BREADCRUMB IS NOT DISPLAYING PROPERLY");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC003CK", enabled = false, priority = 1)
    public void testMobileBankingSecurityAndPrivacyPolicyElemntList() throws IOException {
        String sheetName = "SecurityAndPrivacy";
      //  getCheking().navigateToMobileBanking();
        List<String> acutalCategories = getCheking().getListofMobileBankingSecurityandPrivacypolicyElements();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BANKING SECURITY AND PRIVACY NAVBER ELEMENTS DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC004CK", enabled = false, priority = 1)
    public void testMobileBankingAccountManagementElemntList() throws IOException {
        String sheetName = "AccountManagement";
        //  getCheking().navigateToMobileBanking();
        getCheking().clickOnAccountdManagement();
        List<String> acutalCategories = getCheking().getListofMobileBankingAccountManagementElements();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BANKING Account MANAGEMENT ELEMENTS DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC005CK", enabled = false, priority = 1)
    public void testMobileBankingDigitalServiceElemEntList() throws IOException {
        String sheetName = "DigitalService";
        //  getCheking().navigateToMobileBanking();
        getCheking().clickOnDigitalServices();
        List<String> acutalCategories = getCheking().getListofMobileBankingDigitalServiceElement();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BANKING DIGITAL SERVICE ELEMENTS DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC006CK", enabled = false, priority = 1)
    public void testMobileBankingPaymentTransferElemntList() throws IOException {
        String sheetName = "PaymentTransfer";
        //  getCheking().navigateToMobileBanking();
        getCheking().clickOnPaymentTransfer();
        List<String> acutalCategories = getCheking().getListofMobileBankingPaymentTransferElements();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BANKING PAYMENT TRANSFER ELEMENTS DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC007CK", enabled = false, priority = 1)
    public void testMobileBankingCardManagementElemntList() throws IOException {
        String sheetName = "CardManagement";
        //  getCheking().navigateToMobileBanking();
        getCheking().clickOnCardManagement();
        List<String> acutalCategories = getCheking().getListofMobileBankingCradManagementElements();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BAKING CARD MANAGEMENT ELEMENTS DID NOT MATCH");
        }
        softAssert.assertAll();
    }

//    @Test(description = "TC007CK", enabled = true, priority = 1)
//    public void testgetListofMobileBankingContantUSElements() throws IOException {
//        String sheetName = "CardManagement";
//       // getCheking().navigateToMobileBanking();
//        List<String> acutalCategories = getCheking().getListofMobileBankingContantUSElements();
//        System.out.println(acutalCategories);
//        String[] expectedCategories =getExcelFile(sheetName);
////        SoftAssert softAssert = new SoftAssert();
////        for (int i = 0; i< acutalCategories.size();i++){
////            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"MOBILE BAKING CARD MANAGEMENT ELEMENTS DID NOT MATCH");
////        }
////        softAssert.assertAll();
//    }
//        @Test(description = "TC008CK", enabled = true, priority = 1)
//       public void testSEARCHsERVICE() throws IOException, InterruptedException {
//        String sheetName = "TestResult";
//        getCheking().navigateToMobileBanking();
//        String acutalCategories = getCheking().searchService("Card Managment");
//        String[][] expectedCategories =getExcelFileArray(sheetName);
//        System.out.println(acutalCategories);
//        //Assert.assertEquals(acutalCategories,expectedCategories[0][1]);
//    }

//    @Test(description = "TC008CK", enabled = false, priority = 1)
//    public void testScrollLeft() throws IOException, InterruptedException {
//        String sheetName = "TestResult";
//        //  getCheking().navigateToMobileBanking();
//        String acutalCategories = getCheking().scrollLeft();
//        String[][] expectedCategories =getExcelFileArray(sheetName);
//        Assert.assertEquals(acutalCategories,expectedCategories[0][1]);
//    }
//
//    @Test(description = "TC007CK", enabled = true, priority = 1)
//    public void testScrollRight() throws IOException, InterruptedException {
//        String sheetName = "TestResult";
//        //  getCheking().navigateToMobileBanking();
//        String acutalCategories = getCheking().scrollRight();
//        String[][] expectedCategories =getExcelFileArray(sheetName);
//      //  Assert.assertEquals(acutalCategories,expectedCategories[1][1]);
//    }

}
