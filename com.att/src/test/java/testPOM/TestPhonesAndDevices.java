package testPOM;

import POM.PhonesAndDevices;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestPhonesAndDevices extends TestBase {

    PhonesAndDevices pd;

    @Test (description = "TC001PD", priority = 1, enabled = false)
    public void testValidateTopLeftMenuBarText() {
        pd = new PhonesAndDevices();
        pd.validateTopLeftMenuBarText();
    }

    @Test (description = "TC002PD", priority = 2, enabled = false)
    public void testValidateTopCenterMenuBarText() {
        pd = new PhonesAndDevices();
        pd.validateTopCenterMenuBarText();
    }

    @Test (description = "TC003PD", priority = 3, enabled = false)
    public void testValidateTopLeftHamburgerDDMenuListTest() {
        pd = new PhonesAndDevices();
        pd.validateTopLeftHamburgerDDMenuListTest();
    }

    @Test (description = "TC004PD", priority = 4, enabled = true)
    public void testValidatePickYourPhoneMenuBarText() {
        pd = new PhonesAndDevices();
        pd.validatePickYourPhoneMenuBarText();
    }

}
