package testPOM;

import POM.CBSLogin;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.Set;

public class TestCBSLogin extends TestBase {

    CBSLogin login;

    @Test (description = "TC001LI", priority = 1, enabled = false)
    public void testLoginFunctionalityWithValidData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithValidData();
        String expectedResult = readFromExcel("AssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001LI");
    }

    @Test (description = "TC002LI", priority = 2, enabled = false)
    public void testLoginFunctionalityWithInvalidData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidData();
        String expectedResult = readFromExcel("AssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002LI");
    }

    @Test (description = "TC003LI", priority = 3, enabled = false)
    public void testLoginFunctionalityWithNoData() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithNoData();
        String expectedResult = readFromExcel("AssertionResult", 2);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC003LI");
    }

    @Test (description = "TC004LI", priority = 4, enabled = false)
    public void testLoginFunctionalityWithInvalidEmailOnly() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidEmailOnly();
        String expectedResult = readFromExcel("AssertionResult", 3);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC004LI");
    }

    @Test (description = "TC005LI", priority = 5, enabled = false)
    public void testLoginFunctionalityWithInvalidPasswordOnly() {
        login = new CBSLogin();
        String actualResult = login.loginFunctionalityWithInvalidPasswordOnly();
        String expectedResult = readFromExcel("AssertionResult", 4);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC005LI");
    }

    @Test (description = "TC006LI", priority = 6, enabled = false)
    public void testIsForgotPasswordOptionAvailable() {
        login = new CBSLogin();
        boolean actualResult = login.isForgotPasswordOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 5));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC006LI");
    }

    @Test (description = "TC007LI", priority = 7, enabled = false)
    public void testIsSignUpOptionAvailable() {
        login = new CBSLogin();
        boolean actualResult = login.isSignUpOptionAvailable();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 6));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC007LI");
    }

    @Test (description = "TC008LO", priority = 8, enabled = false)
    public void testIsLoggedOut() {
        login = new CBSLogin();
        boolean actualResult = login.isLoggedOut();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("AssertionResult", 7));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC008LI");
    }

    @Test (description = "SWITCH-TAB", enabled = false)
    public void testWindowSwitch() {
        login = new CBSLogin();
//        clickOnElement(login.instagramIcon);
//        clickOnElement(login.twitterIcon);
        String pageTitle = driver.getTitle();
        String pageName = login.switchTabGetPageNameCloseTab(login.instagramIcon, login.instagramPageName, pageTitle);
        System.out.println(pageName);
    }

    @Test (description = "FILE-UPLOAD", enabled = false)
    public void testFileUpload() throws InterruptedException {
        Thread.sleep(2000); //Delete all the Thread.sleep
        driver.findElement(By.cssSelector("#uploadfile_0")).sendKeys("C:\\Users\\hafiz\\Desktop\\file.txt");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#terms")).click();
    }

    @Test (description = "ALERT", enabled = true)
    public void testAlert() throws InterruptedException {
        Thread.sleep(3000); //Delete all the Thread.sleep
        driver.findElement(By.cssSelector("body > div > div.lft_wrap > div.top_bar > div:nth-child(2) > form > div.floatL.leftwidth > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > input.signinbtn")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
    }

}
