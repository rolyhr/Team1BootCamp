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

    @Test (description = "TC004PD", priority = 4, enabled = false)
    public void testValidatePickYourPhoneMenuBarText() {
        pd = new PhonesAndDevices();
        pd.validatePickYourPhoneMenuBarText();
    }

    @Test (description = "TC005PD", priority = 5, enabled = false)
    public void testValidateBrandNameText() {
        pd = new PhonesAndDevices();
        pd.validateBrandNameText();
    }

    @Test (description = "TC006PD", priority = 6, enabled = false)
    public void testValidateDeviceConditionText() {
        pd = new PhonesAndDevices();
        pd.validateDeviceConditionText();
    }

    @Test (description = "TC007PD", priority = 7, enabled = false)
    public void testValidateOSText() {
        pd = new PhonesAndDevices();
        pd.validateOSText();
    }

    @Test (description = "TC008PD", priority = 8, enabled = false)
    public void testValidateFeaturedText() {
        pd = new PhonesAndDevices();
        pd.validateFeaturedText();
    }

    @Test (description = "TC009PD", priority = 9, enabled = false)
    public void testValidatePriceRangeText() {
        pd = new PhonesAndDevices();
        pd.validatePriceRangeText();
    }

    @Test (description = "TC010PD", priority = 10, enabled = false)
    public void testValidateColorText() {
        pd = new PhonesAndDevices();
        pd.validateColorText();
    }

    @Test (description = "TC011PD", priority = 11, enabled = false)
    public void testValidateSortByText() {
        pd = new PhonesAndDevices();
        pd.validateSortByText();
    }

    @Test (description = "TC013PD", priority = 13, enabled = false)
    public void testTopLeftMenuBarTextCount() {
        pd = new PhonesAndDevices();
        pd.topLeftMenuBarTextCount();
    }

    @Test (description = "TC014PD", priority = 14, enabled = false)
    public void testTopCenterMenuBarTextCount() {
        pd = new PhonesAndDevices();
        pd.topCenterMenuBarTextCount();
    }

    @Test (description = "TC015PD", priority = 15, enabled = false)
    public void testTopLeftHamburgerDDMenuListTestCount() {
        pd = new PhonesAndDevices();
        pd.topLeftHamburgerDDMenuListTestCount();
    }

    @Test (description = "TC016PD", priority = 16, enabled = true)
    public void testPickYourPhoneMenuBarTextCount() {
        pd = new PhonesAndDevices();
        pd.pickYourPhoneMenuBarTextCount();
    }

}
