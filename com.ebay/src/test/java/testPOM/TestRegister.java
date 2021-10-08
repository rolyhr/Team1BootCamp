package testPOM;

import POM.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestRegister extends TestBase {

    @Test (description = "TC001REG", priority = 1, enabled = true)
    public void testCreateNewPersonalAccountWithValidData() {
        Register register = new Register();
        register.createNewPersonalAccountWithValidData();
        String actualValue = register.createNewPersonalAccountWithValidData();
        String expectedValue = readFromExcel("REGExpected", 0);
        Assert.assertEquals(actualValue, expectedValue, "Failed, TC001REG");
    }

    @Test (description = "TC002REG", priority = 2, enabled = true)
    public void testCreateNewPersonalAccountNoData() {
        Register register = new Register();
        boolean actualValue = register.createNewPersonalAccountWithNoData();
        boolean expectedValue = Boolean.parseBoolean(readFromExcel("REGExpected", 1));
        Assert.assertEquals(actualValue, expectedValue, "Failed, TC002REG");
    }

    @Test (description = "TC003REG", priority = 3, enabled = true)
    public void testCreateNewPersonalAccountExistingEmail() {
        Register register = new Register();
        String actualValue = register.createNewPersonalAccountWithExistingEmail();
        String expectedValue = readFromExcel("REGExpected", 2);
        Assert.assertEquals(actualValue, expectedValue, "Failed, TC003REG");
    }

    @Test (description = "TC004REG", priority = 4, enabled = true)
    public void testCreateNewPersonalAccountInvalidEmail() {
        Register register = new Register();
        String actualResult = register.createNewPersonalAccountWithInvalidEmail();
        String expectedResult = readFromExcel("REGExpected", 3);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC004REG");
    }

    @Test (description = "TC005REG", priority = 5, enabled = true)
    public void testCreateNewPersonalAccountWithInvalidPasswordLess6Char() {
        Register register = new Register();
        String actualResult = register.createNewPersonalAccountWithInvalidPasswordLess6Char();
        String expectedResult = readFromExcel("REGExpected", 4);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC005REG");
    }

    @Test (description = "TC006REG", priority = 6, enabled = true)
    public void testCreateNewPersonalAccountWithInvalidPasswordNoSymbol() {
        Register register = new Register();
        String actualResult = register.createNewPersonalAccountWithInvalidPasswordNoSymbol();
        String expectedResult = readFromExcel("REGExpected", 5);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC006REG");
    }

    @Test (description = "TC007REG", priority = 7, enabled = true)
    public void testCreateNewPersonalAccountWithInvalidPasswordNoLetter() {
        Register register = new Register();
        String actualResult = register.createNewPersonalAccountWithInvalidPasswordNoLetter();
        String expectedResult = readFromExcel("REGExpected", 6);
        Assert.assertEquals(actualResult, expectedResult, "Failed, TC007REG");
    }

}
