package testPOM;

import POM.CBSSignUp;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCBSSignUp extends TestBase {

    CBSSignUp cbsSignUp;

    @Test (description = "TC001REG", priority = 1, enabled = true)
    public void testRegisterNewAccountWithAllValidData() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithAllValidData();
        String expectedResult = readFromExcel("REGAssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC002REG", priority = 2, enabled = true)
    public void testRegisterNewAccountWithAllInvalidData() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithAllInvalidData();
        String expectedResult = readFromExcel("REGAssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC003REG", priority = 3, enabled = true)
    public void testRegisterNewAccountWithInvalidEmailOnly() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithInvalidEmailOnly();
        String expectedResult = readFromExcel("REGAssertionResult", 2);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC004REG", priority = 4, enabled = true)
    public void testRegisterNewAccountWithDuplicateEmail() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithDuplicateEmail();
        String expectedResult = readFromExcel("REGAssertionResult", 3);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC005REG", priority = 5, enabled = true)
    public void testRegisterNewAccountWithInvalidPasswordOnly() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithInvalidPasswordOnly();
        String expectedResult = readFromExcel("REGAssertionResult", 4);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC006REG", priority = 6, enabled = true)
    public void testRegisterNewAccountWithInvalidPasswordSixCharOrLess() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithInvalidPasswordSixCharOrLess();
        String expectedResult = readFromExcel("REGAssertionResult", 5);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC007REG", priority = 7, enabled = true)
    public void testRegisterNewAccountWhenConfirmPasswordDoNotMatch() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWhenConfirmPasswordDoNotMatch();
        String expectedResult = readFromExcel("REGAssertionResult", 6);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    @Test (description = "TC008REG", priority = 8, enabled = true)
    public void testRegisterNewAccountWithTOSCheckboxUnchecked() {
        cbsSignUp = new CBSSignUp();
        String actualResult = cbsSignUp.registerNewAccountWithTOSCheckboxUnchecked();
        String expectedResult = readFromExcel("REGAssertionResult", 7);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }

    //registerNewAccountWithNewsletterCheckboxesUnchecked()

    //registerNewAccountWithNewsletterCheckboxesChecked()

    //isNewsletterCheckboxCheckedByDefault()

    @Test (description = "TC009REG", priority = 9, enabled = true)
    public void testIsNewsletterCheckboxCheckedByDefault() {
        cbsSignUp = new CBSSignUp();
        boolean actualResult = cbsSignUp.isNewsletterCheckboxCheckedByDefault();
        boolean expectedResult = Boolean.parseBoolean(readFromExcel("REGAssertionResult", 8));
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001REG");
    }
}
