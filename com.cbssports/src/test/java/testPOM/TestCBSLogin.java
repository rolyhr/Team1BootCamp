package testPOM;

import POM.CBSLogin;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCBSLogin extends TestBase {

    CBSLogin login;

    @Test (description = "TC001LI", priority = 1, enabled = false)
    public void testLoginFunctionalityWithValidData() {
        login = new CBSLogin();
        String warningMsg = login.loginFunctionalityWithValidData();
        System.out.println(warningMsg);
    }

    @Test (description = "TC002LI", priority = 2, enabled = false)
    public void testLoginFunctionalityWithInvalidData() {
        login = new CBSLogin();
        String warningMsg = login.loginFunctionalityWithInvalidData();
        System.out.println(warningMsg);
    }

    @Test (description = "TC003LI", priority = 3, enabled = false)
    public void testLoginFunctionalityWithNoData() {
        login = new CBSLogin();
        String warningMsg = login.loginFunctionalityWithNoData();
        System.out.println(warningMsg);
    }

    @Test (description = "TC004LI", priority = 4, enabled = false)
    public void testLoginFunctionalityWithInvalidEmailOnly() {
        login = new CBSLogin();
        String warningMsg = login.loginFunctionalityWithInvalidEmailOnly();
        System.out.println(warningMsg);
    }

    @Test (description = "TC005LI", priority = 5, enabled = false)
    public void testLoginFunctionalityWithInvalidPasswordOnly() {
        login = new CBSLogin();
        String warningMsg = login.loginFunctionalityWithInvalidPasswordOnly();
        System.out.println(warningMsg);
    }

    @Test (description = "TC006LI", priority = 6, enabled = false)
    public void testIsForgotPasswordOptionAvailable() {
        login = new CBSLogin();
        boolean isDisplayed = login.isForgotPasswordOptionAvailable();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC007LI", priority = 7, enabled = false)
    public void testIsSignUpOptionAvailable() {
        login = new CBSLogin();
        boolean isDisplayed = login.isSignUpOptionAvailable();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC008LO", priority = 8, enabled = true)
    public void testIsLoggedOut() {
        login = new CBSLogin();
        boolean isDisplayed = login.isLoggedOut();
        System.out.println(isDisplayed);
    }
}
