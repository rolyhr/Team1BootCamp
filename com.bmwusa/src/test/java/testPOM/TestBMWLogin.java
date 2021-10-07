package testPOM;

import POM.BMWLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestBMWLogin extends TestBase {

    BMWLogin login;

    @Test(description = "TC001LI", priority = 1, enabled = false)
    public void testLoginFunctionalityWithValidData() {
        login = new BMWLogin();
        String actualResult = login.loginFunctionalityWithValidData();
        String expectedResult = readFromExcel("AssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001LI");
    }

    @Test (description = "TC002LI", priority = 2, enabled = false)
    public void testLoginFunctionalityWithInvalidData() {
        login = new BMWLogin();
        String actualResult = login.loginFunctionalityWithInvalidData();
        String expectedResult = readFromExcel("AssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002LI");
    }

    @Test (description = "TC003LI", priority = 3, enabled = false)
    public void testLoginFunctionalityWithNoData() {
        login = new BMWLogin();
        boolean actualResult = login.loginFunctionalityWithNoData();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 2));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC003LI");
    }

    @Test (description = "TC004LI", priority = 4, enabled = false)
    public void testLoginFunctionalityWithInvalidEmailOnly() {
        login = new BMWLogin();
        boolean actualResult = login.loginFunctionalityWithInvalidEmailOnly();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 3));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC004LI");
    }

    @Test (description = "TC005LI", priority = 5, enabled = false)
    public void testLoginFunctionalityWithInvalidPasswordOnly() {
        login = new BMWLogin();
        String actualResult = login.loginFunctionalityWithInvalidPasswordOnly();
        String expectedResult = readFromExcel("AssertionResult", 4);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC005LI");
    }

    @Test (description = "TC006LI", priority = 6, enabled = false)
    public void testIsForgotPasswordOptionAvailable() {
        login = new BMWLogin();
        boolean actualResult = login.isForgotPasswordOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 5));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC006LI");
    }

    @Test (description = "TC007LI", priority = 7, enabled = true)
    public void testisRegisterNowOptionAvailable() {
        login = new BMWLogin();
        boolean actualResult = login.isRegisterNowOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 6));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC007LI");
    }

    @Test (description = "TC008LO", priority = 8, enabled = false)
    public void testIsLoggedOut() {
        login = new BMWLogin();
        boolean actualResult = login.isLoggedOut();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 7));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC008LI");
    }

}
