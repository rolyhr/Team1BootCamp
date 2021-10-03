package testPOM;

import POM.BMWLogin;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestBMWLogin extends TestBase {

    BMWLogin login;

    @Test(description = "TC001LI", priority = 1, enabled = false)
    public void testLoginFunctionalityWithValidData() {
        login = new BMWLogin();
        String warningMsg = login.loginFunctionalityWithValidData();
        System.out.println(warningMsg);
    }

    @Test (description = "TC002LI", priority = 2, enabled = false)
    public void testLoginFunctionalityWithInvalidData() {
        login = new BMWLogin();
        String warningMsg = login.loginFunctionalityWithInvalidData();
        System.out.println(warningMsg);
    }

    @Test (description = "TC003LI", priority = 3, enabled = false)
    public void testLoginFunctionalityWithNoData() {
        login = new BMWLogin();
        boolean isDisplayed = login.loginFunctionalityWithNoData();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC004LI", priority = 4, enabled = false)
    public void testLoginFunctionalityWithInvalidEmailOnly() {
        login = new BMWLogin();
        boolean isDisplayed = login.loginFunctionalityWithInvalidEmailOnly();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC005LI", priority = 5, enabled = false)
    public void testLoginFunctionalityWithInvalidPasswordOnly() {
        login = new BMWLogin();
        String warningMsg = login.loginFunctionalityWithInvalidPasswordOnly();
        System.out.println(warningMsg);
    }

    @Test (description = "TC006LI", priority = 6, enabled = false)
    public void testIsForgotPasswordOptionAvailable() {
        login = new BMWLogin();
        boolean isDisplayed = login.isForgotPasswordOptionAvailable();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC007LI", priority = 7, enabled = false)
    public void testisRegisterNowOptionAvailable() {
        login = new BMWLogin();
        boolean isDisplayed = login.isRegisterNowOptionAvailable();
        System.out.println(isDisplayed);
    }

    @Test (description = "TC008LO", priority = 8, enabled = true)
    public void testIsLoggedOut() {
        login = new BMWLogin();
        boolean isDisplayed = login.isLoggedOut();
        System.out.println(isDisplayed);
    }

}
