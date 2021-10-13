package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestFootball extends TestBase {

    @Test(description = "TC001FS",enabled = false,priority = 1)
    public void testVisibilityOfDropDownMenuAfterHoverFootball(){
        boolean actualResult = getFootball().hoverOverFootball();
        boolean expecteResult = true;
        Assert.assertTrue(actualResult,"UNABLE TO DISPLAY FOOTBALL DROP-DOWN MENU FROM NAVIGATION BAR");
    }

    @Test(description = "TC002FS",enabled = false ,priority = 2)
    public void testFashionMostPopularCategoryList() throws IOException {
        String sheetName = "Categories";
        getFootball().hoverOverFootball();
        List<String> acutalCategories = getFootball().getListOfFootballDropDownMenuList();
        String[] expectedCategories =getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< acutalCategories.size();i++){
            softAssert.assertEquals(acutalCategories.get(i),expectedCategories[i],"FOOTBALL DROP-DOWN MENU CATEGORY DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC003FS",enabled = false,priority = 10)
    public void testESPNFantasyFootballInvalidLogin() throws InterruptedException, IOException {
        String sheetName = "LogIn";
        String[][] expectedCategories =getExcelFileArray(sheetName);
        getFootball().clickOnFootball();
        getFootball().navigateToESPNFantasyFootball();
        getFootball().loginEspnFantasy(expectedCategories[0][0],expectedCategories[0][1]);
        String actualResult = getFootball().errorLogin.getText();
        String expectedResult = "The credentials you entered are incorrect.\n" +
                "Reminder: Passwords are case sensitive.";
       Assert.assertEquals(actualResult,expectedResult,"LOGIN WITH INVALID CREDENTIALS IS NOT WORKING PROPERLY");

    }

    @Test(description = "TC004FS",enabled = false,priority = 9)
    public void testESPNFantasyFootbalLoginWithoutUsername() throws InterruptedException, IOException {
        String sheetName = "LogIn";
        String[][] expectedCategories =getExcelFileArray(sheetName);
        getFootball().clickOnFootball();
        getFootball().navigateToESPNFantasyFootball();
        getFootball().loginEspnFantasyWithoutUsername("",expectedCategories[0][1]);
     //   getFootball().clickLoginButtonESPNFootballFantasy();
        String actualResult = getFootball().loginErrorUsername.getText();
        String expectedResult = "Required";
        Assert.assertEquals(actualResult,expectedResult,"LOGIN ERROE MESSAGE IS NOT DISPLAYED FOR USERNAME");
    }

    @Test(description = "TC005FS",enabled = false,priority = 8)
    public void testESPNFantasyFootbalLoginWithoutPassword() throws InterruptedException, IOException {
        String sheetName = "LogIn";
        String[][] expectedCategories =getExcelFileArray(sheetName);
        getFootball().clickOnFootball();
        getFootball().navigateToESPNFantasyFootball();
        getFootball().loginEspnFantasyWithoutPassword(expectedCategories[0][0],"");
        //   getFootball().clickLoginButtonESPNFootballFantasy();
        String actualResult = getFootball().loginErrorPassword.getText();
        String expectedResult = "Required";
        Assert.assertEquals(actualResult,expectedResult,"LOGIN ERROR MESSAGE IS NOT DISPLAYED FOR PASSWORD");
    }

    @Test(description = "TC006FS",enabled = false,priority = 6)
    public void testFootballTablesNumberOfRow() throws InterruptedException, IOException {
        String sheetName = "Table";
        getFootball().navigateToFootballTable();
        int actualResult =   getFootball().numberOfRows();
       // int[] expectedResult = getExcelFileArrayInteger(sheetName);
       Assert.assertEquals(actualResult,20,"NUMBER OF ROWS FOR TABLES DID NOT MATCH");
    }

    @Test(description = "TC007FS",enabled = false,priority = 7)
    public void testFootbalTablesNumberOfColumns() throws IOException, InterruptedException {
        String sheetName = "Table";
        getFootball().navigateToFootballTable();
        int actualResult =   getFootball().numberOfColumns();
       // int[] expectedResult = getExcelFileArrayInteger(sheetName);
        Assert.assertEquals(actualResult,9,"NUMBER OF COLUMNS FOR TABLES DID NOT MATCH");
    }

    @Test(description = "TC008FS",enabled = false,priority = 3)
    public void testFootbalTablesTeamsTopListEnglishPremierleague() throws IOException, InterruptedException {
        String sheetName = "Table";
        getFootball().navigateToFootballTable();
        List<String> actualResult =   getFootball().accessEnglishPremierLeagueTableAttributes(20,1);
        String [] expectedResult = getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< actualResult.size();i++){
          softAssert.assertEquals(actualResult.get(i),expectedResult[i],"ENGLISH PREMIUM LEAGUE TOP LIST DID NOT MATCH");
        }
       softAssert.assertAll();
    }

    @Test(description = "TC009FS",enabled = false,priority = 4)
    public void testFootbalTablesColumnNames() throws IOException, InterruptedException {
        String sheetName = "TableColoumnNames";
        getFootball().navigateToFootballTable();
        List<String> actualResult =   getFootball().getListOfTableColoumns();
        String [] expectedResult = getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< actualResult.size();i++){
            softAssert.assertEquals(actualResult.get(i),expectedResult[i],"ENGLISH PREMIUM LEAGUE COLUMN NAMES DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC0010FS",enabled = false,priority = 5)
    public void testEnglishPremierLeagueTeamPosition() throws IOException, InterruptedException {
        String sheetName = "EnglishPremiumLeaguePosition";
        getFootball().navigateToFootballTable();
        List<String> actualResult =   getFootball().getListOfTeamPosition();
        String [] expectedResult = getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i< actualResult.size();i++){
            softAssert.assertEquals(actualResult.get(i),expectedResult[i],"POSITIONS FOR ENGLISH PREMIUM LEAGUE DID NOT MATCH");
        }
        softAssert.assertAll();
    }

    @Test(description = "TC0011FS",enabled = true,priority = 5)
    public void testSelectYearFilter() throws IOException, InterruptedException {
        String sheetName = "YearResult";
        List<String> actualResult =   getFootball().selectAYear();
        String [] expectedResult = getExcelFile(sheetName);
        SoftAssert softAssert = new SoftAssert();
        compareStringList(actualResult,expectedResult);
    }

//    @Test(description = "TC0010FS",enabled = true,priority = 5)
//    public void testTeamList() throws IOException, InterruptedException {
//       // String sheetName = "EnglishPremiumLeaguePosition";
//        getFootball().navigateToFootballTeam();
//        Thread.sleep(8000);
//        List<String> actualResult =   getFootball().getListOfTeamlist();
//     //   String [] expectedResult = getExcelFile(sheetName);
////        SoftAssert softAssert = new SoftAssert();
//        for (int i = 0; i< actualResult.size();i++){
//            System.out.println(actualResult.get(i));
//            //softAssert.assertEquals(actualResult.get(i),expectedResult[i],"POSITIONS FOR ENGLISH PREMIUM LEAGUE DID NOT MATCH");
//        }
////        softAssert.assertAll();
//    }

}
