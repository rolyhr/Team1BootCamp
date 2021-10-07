package testPOM;

import POM.CBSLogin;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCBSLogin extends TestBase {

    CBSLogin login;

    @Test (description = "TC001LI", priority = 1, enabled = true)
    public void testLoginFunctionalityWithValidData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithValidData();
        String expectedResult = readFromExcel("AssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001LI");
    }

    @Test (description = "TC002LI", priority = 2, enabled = true)
    public void testLoginFunctionalityWithInvalidData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidData();
        String expectedResult = readFromExcel("AssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002LI");
    }

    @Test (description = "TC003LI", priority = 3, enabled = true)
    public void testLoginFunctionalityWithNoData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithNoData();
        String expectedResult = readFromExcel("AssertionResult", 2);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC003LI");
    }

    @Test (description = "TC004LI", priority = 4, enabled = true)
    public void testLoginFunctionalityWithInvalidEmailOnly() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidEmailOnly();
        String expectedResult = readFromExcel("AssertionResult", 3);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC004LI");
    }

    @Test (description = "TC005LI", priority = 5, enabled = true)
    public void testLoginFunctionalityWithInvalidPasswordOnly() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidPasswordOnly();
        String expectedResult = readFromExcel("AssertionResult", 4);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC005LI");
    }

    @Test (description = "TC006LI", priority = 6, enabled = true)
    public void testIsForgotPasswordOptionAvailable() {
        login = new CBSLogin();
        boolean actualResult = login.isForgotPasswordOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 5));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC006LI");
    }

    @Test (description = "TC007LI", priority = 7, enabled = true)
    public void testIsSignUpOptionAvailable() {
        login = new CBSLogin();
        boolean actualResult = login.isSignUpOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 6));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC007LI");
    }

    @Test (description = "TC008LO", priority = 8, enabled = true)
    public void testIsLoggedOut() {
        login = new CBSLogin();
        boolean actualResult = login.isLoggedOut();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 7));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC008LI");
    }
}
