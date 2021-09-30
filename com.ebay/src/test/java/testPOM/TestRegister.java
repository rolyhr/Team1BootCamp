package testPOM;

import POM.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestRegister extends TestBase {

    @Test (description = "TC001REG", priority = 1, enabled = false)
    public void testCreateNewPersonalAccountWithValidData() {
        Register register = new Register();
        register.createNewPersonalAccountWithValidData();
        String actualValue = register.getText(register.registerDisplayNameAfterReg);
        String expectedValue = "John";
        Assert.assertEquals(actualValue, expectedValue, "Failed testCreateNewPersonalAccountWithValidData()");
    }

    @Test (description = "TC002REG", priority = 2, enabled = false)
    public void testCreateNewPersonalAccountNoData() {
        Register register = new Register();
        register.createNewPersonalAccountWithNoData();
        boolean actualValue = register.checkButtonStatus();
        System.out.println("Button Status: " + actualValue);
        Assert.assertFalse(actualValue, "Failed testCreateNewPersonalAccountNoData()");
    }

    @Test (description = "TC003REG", priority = 3, enabled = false)
    public void testCreateNewPersonalAccountExistingEmail() {
        Register register = new Register();
        register.createNewPersonalAccountWithExistingEmail();
        String actualResult = register.getText(register.registerEmailError);
        String expectedResult = "Your email address is already registered with eBay. Need help with your password";
        Assert.assertEquals(actualResult, expectedResult, "Failed testCreateNewPersonalAccountExistingEmail()");
    }

    @Test (description = "TC004REG", priority = 4, enabled = true)
    public void testCreateNewPersonalAccountInvalidEmail() {
        Register register = new Register();
        register.createNewPersonalAccountWithInvalidEmail();
        String actualResult = register.getText(register.registerEmailError);
        String expectedResult = "Email address is invalid. Please enter a valid email address.";
        Assert.assertEquals(actualResult, expectedResult, "Failed testCreateNewPersonalAccountExistingEmail()");
    }
}
