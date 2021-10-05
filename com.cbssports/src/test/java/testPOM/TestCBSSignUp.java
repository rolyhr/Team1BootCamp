package testPOM;

import POM.CBSSignUp;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestCBSSignUp extends TestBase {

    CBSSignUp cbsSignUp;

    @Test (description = "TC001REG", priority = 1, enabled = false)
    public void testRegisterNewAccountWithAllValidData() {
        cbsSignUp = new CBSSignUp();
        String regSuccessMsg = cbsSignUp.registerNewAccountWithAllValidData();
        System.out.println(regSuccessMsg);
    }

    @Test (description = "TC002REG", priority = 2, enabled = false)
    public void testRegisterNewAccountWithAllInvalidData() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithAllInvalidData();
        System.out.println(warnings);
    }

    @Test (description = "TC003REG", priority = 3, enabled = false)
    public void testRegisterNewAccountWithInvalidEmailOnly() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithInvalidEmailOnly();
        System.out.println(warnings);
    }

    @Test (description = "TC004REG", priority = 4, enabled = false)
    public void testRegisterNewAccountWithDuplicateEmail() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithDuplicateEmail();
        System.out.println(warnings);
    }

    @Test (description = "TC005REG", priority = 5, enabled = false)
    public void testRegisterNewAccountWithInvalidPasswordOnly() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithInvalidPasswordOnly();
        System.out.println(warnings);
    }

    @Test (description = "TC006REG", priority = 6, enabled = false)
    public void testRegisterNewAccountWithInvalidPasswordSixCharOrLess() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithInvalidPasswordSixCharOrLess();
        System.out.println(warnings);
    }

    @Test (description = "TC007REG", priority = 7, enabled = false)
    public void testRegisterNewAccountWhenConfirmPasswordDoNotMatch() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWhenConfirmPasswordDoNotMatch();
        System.out.println(warnings);
    }

    @Test (description = "TC008REG", priority = 8, enabled = false)
    public void testRegisterNewAccountWithTOSCheckboxUnchecked() {
        cbsSignUp = new CBSSignUp();
        String warnings = cbsSignUp.registerNewAccountWithTOSCheckboxUnchecked();
        System.out.println(warnings);
    }

    //registerNewAccountWithNewsletterCheckboxesUnchecked()

    //registerNewAccountWithNewsletterCheckboxesChecked()

    //isNewsletterCheckboxCheckedByDefault()
    @Test (description = "TC009REG", priority = 9, enabled = true)
    public void testIsNewsletterCheckboxCheckedByDefault() {
        cbsSignUp = new CBSSignUp();
        boolean isChecked = cbsSignUp.isNewsletterCheckboxCheckedByDefault();
        System.out.println(isChecked);
    }
}
