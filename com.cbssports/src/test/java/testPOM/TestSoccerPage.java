package testPOM;

import POM.SoccerPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.IOException;
import java.util.List;

public class TestSoccerPage extends TestBase {

    SoccerPage soccerPage;
    String[][] testData;

    @Test(description = "CaseID: 01",priority = 1, enabled = false)
    public void testNavigationBarMenuList() throws IOException {

        soccerPage = getSoccerPage();
        List<String> expectedList = getExpectedList("CBBSNavMenu");
        List<String> actualList = soccerPage.getNavigationBarMenuList();
        Assert.assertTrue(compareListsOfString(actualList,expectedList));
    }

    @Test(description = "CaseID: 02",priority = 2, enabled = false)
    public void testPlayButtonUnderWatchNavMenu() throws IOException {

        soccerPage = getSoccerPage();
        soccerPage.playWatchNow();
        Assert.assertTrue(soccerPage.isProviderPageVisible());
    }

    @Test(description = "CaseID: 03",priority = 3, enabled = false)
    public void testDoSignUpForNewsLetter() throws IOException {

        soccerPage = getSoccerPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        soccerPage.doSignUpForNewsLetter(testData[0][0]);
        Assert.assertTrue(soccerPage.isMessageForSuccessfulSignUpPresent());
    }

    @Test(description = "CaseID: 04",priority = 4, enabled = false)
    public void testDoSignUpForNewsLetterWithoutClickingOptInBox() throws IOException {

        soccerPage = getSoccerPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        soccerPage.doSignUpForNewsLetterWithoutClickingOptInBox(testData[0][0]);
        Assert.assertTrue(soccerPage.isMessageForUnsuccessfulSignUpPresent());
    }

    @Test(description = "CaseID: 05",priority = 5, enabled = false)
    public void testDoSignUpForNewsLetterWithoutEmail() throws IOException {

        soccerPage = getSoccerPage();
        soccerPage.doSignUpForNewsLetterWithoutEmail();
        Assert.assertTrue(soccerPage.isMessageForEmailRequiredPresent());
    }

    @Test(description = "CaseID: 06",priority = 6, enabled = false)
    public void testDoSignUpForNewsLetterWithoutEmailAndOptInBox(){
        soccerPage = getSoccerPage();
        soccerPage.doSignUpForNewsLetterWithoutEmailAndOptInBox();
        Assert.assertTrue(soccerPage.isMessageForEmailRequiredPresent());
    }

    @Test(description = "CaseID: 7",priority = 7, enabled = false)
    public void testDoSignUpForNewsLetterWithInvalidEmail() throws IOException {
        soccerPage = getSoccerPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        soccerPage.doSignUpForNewsLetter(testData[1][0]);
        Assert.assertTrue(soccerPage.isMessageForEmailRequiredPresent());
    }

    @Test(description = "CaseID: 8",priority = 8, enabled = true)
    public void testDoNotSellMyLink() throws IOException {
        soccerPage=getSoccerPage();
        soccerPage.openDoNotSellMyInfoIntoNewTab();
        String actualURL = soccerPage.getURLOfDoNotSellMyPersonalInfoPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        String expectedURL = testData[2][0];
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "CaseID: 9",priority = 9, enabled = false)
    public void testClickBackOnTopButtonATDoNotSellMyInfoTab() throws IOException {
        soccerPage=getSoccerPage();
        soccerPage.clickBackOnTopButtonATDoNotSellMyInfoTab();
        String actualURL = soccerPage.getURLOfDoNotSellMyPersonalInfoPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        String expectedURL = testData[3][0];
        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test(description = "CaseID: 10",priority = 10, enabled = true)
    public void testSelectLanguageFromComboBox() throws IOException {
        soccerPage=getSoccerPage();
        testData = getTestDataFromExcelFile("CBSSportsEmail");
        soccerPage.doSelectALanguageFromLanguageComboBox(testData[0][1]);
        String expectedFooter = testData[0][2];
        String actualFooter = soccerPage.changedLanguageForFooter();
        Assert.assertEquals(actualFooter,expectedFooter);
    }

}
