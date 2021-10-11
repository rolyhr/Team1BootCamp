package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.awt.*;
import java.io.IOException;

public class TestRealEstateAgents extends TestBase {
    @Test(description = "TC001RA", enabled = false, priority = 2)
    public void testSearchrealestateAgentsButton() throws IOException, InterruptedException, AWTException {
        String[] testData =getExcelFile("AgeantSearch");
        getRealStateAgents().searchrealestateAgentsWithButton(testData[0]);
        String actualResult = getRealStateAgents().getrealestateAgentsSearchContainerResult();
        Assert.assertEquals(actualResult,"Did You Mean","SEARCH AGENT DID NOT WORK PROPERLY");
    }

    @Test(description = "TC002RA", enabled = false, priority = 2)
    public void searchrealestateAgentsKeyBorad() throws IOException, InterruptedException, AWTException {
        String[] testData =getExcelFile("AgeantSearch");
        getRealStateAgents().searchrealestateAgentsWithKeyBorad(testData[0]);
        String actualResult = getRealStateAgents().getrealestateAgentsSearchContainerResult();
        Assert.assertEquals(actualResult,"Did You Mean","SEARCH AGENT DID NOT WORK PROPERLY");
    }

    @Test(description = "TC003RA", enabled = false, priority = 2)
    public void testsearchHomeWithInvalidEmail() throws IOException, InterruptedException, AWTException {
        String[] city =getExcelFile("HomeSearch");
        String[][] phoneEmail =getExcelFileArray("Email");
        String[] expectedResult =getExcelFile("ErrorMesage");

        getRealStateAgents().writeEmail(city[0],phoneEmail[1][0]);
        String actualResult = getRealStateAgents().getErrorMessageEmail();

        Assert.assertEquals(actualResult,expectedResult[0],"SEARCH HOME WITH INVALID EMAIL DID NOT WORK PROPERLY");
    }

    @Test(description = "TC004RA", enabled = false, priority = 2)
    public void testsearchHomeWithInvalidPhone() throws IOException, InterruptedException, AWTException {
        String[] city =getExcelFile("HomeSearch");
        String[][] phoneEmail =getExcelFileArray("Email");
        String[] expectedResult =getExcelFile("ErrorMesage");

        getRealStateAgents().writePhone(city[0],phoneEmail[0][1]);
        String actualResult = getRealStateAgents().getErrorMessagePhone();
        Assert.assertEquals(actualResult,expectedResult[1],"SEARCH HOME WITH INVALID PHONE DID NOT WORK PROPERLY");
    }

    @Test(description = "TC005RA", enabled = true, priority = 2)
    public void testsearchHomeWithoutPhoneEmail() throws IOException, InterruptedException, AWTException {
        String[] testData =getExcelFile("HomeSearch");
        String[] expectedResult =getExcelFile("ErrorMesage");
        getRealStateAgents().writePhone(testData[0],"");
        getRealStateAgents().sendValueHomeEmail("");
        String actualResult = getRealStateAgents().getErrorMessagePhone();
        Assert.assertEquals(actualResult,expectedResult[2],"REQUIRED TEXT  WITHOUT EMAIL AND PHONE DID NOT WORK PROPERLY");
    }


}
