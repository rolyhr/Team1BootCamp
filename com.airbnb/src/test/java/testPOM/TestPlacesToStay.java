package testPOM;

import POM.PlacesToStay;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestPlacesToStay extends TestBase {

    PlacesToStay pts;

    @Test (description = "TC001PTS", priority = 1, enabled = false)
    public void testValidateFooterListTitleText() {
        pts = new PlacesToStay();
        pts.validateFooterListTitleText();
    }

    @Test (description = "TC002PTS", priority = 2, enabled = false)
    public void testValidateAboutListText() {
        pts = new PlacesToStay();
        pts.validateAboutListText();
    }

    @Test (description = "TC003PTS", priority = 3, enabled = false)
    public void testValidateCommunityListText() {
        pts = new PlacesToStay();
        pts.validateCommunityListText();
    }

    @Test (description = "TC004PTS", priority = 4, enabled = false)
    public void testValidateHostListText() {
        pts = new PlacesToStay();
        pts.validateHostListText();
    }

    @Test (description = "TC005PTS", priority = 5, enabled = false)
    public void testValidateSupportListText() {
        pts = new PlacesToStay();
        pts.validateSupportListText();
    }

    @Test (description = "TC006PTS", priority = 6, enabled = false)
    public void testValidateFutureGatewayTabsText() {
        pts = new PlacesToStay();
        pts.validateFutureGatewayTabsText();
    }

    @Test (description = "TC007PTS", priority = 7, enabled = false)
    public void testValidateTabsArtsAndCultureText() {
        pts = new PlacesToStay();
        pts.validateTabsArtsAndCultureText();
    }

    @Test (description = "TC008PTS", priority = 8, enabled = true)
    public void testValidateTabsOutdoorAdventureText() {
        pts = new PlacesToStay();
        pts.validateTabsOutdoorAdventureText();
    }

}
