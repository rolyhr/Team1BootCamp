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

    @Test (description = "TC008PTS", priority = 8, enabled = false)
    public void testValidateTabsOutdoorAdventureText() {
        pts = new PlacesToStay();
        pts.validateTabsOutdoorAdventureText();
    }

    @Test (description = "TC009PTS", priority = 9, enabled = false)
    public void testFooterListTitleTextCount() {
        pts = new PlacesToStay();
        pts.footerListTitleTextCount();
    }

    @Test (description = "TC010PTS", priority = 10, enabled = false)
    public void testAboutListTextCount() {
        pts = new PlacesToStay();
        pts.aboutListTextCount();
    }

    @Test (description = "TC011PTS", priority = 11, enabled = false)
    public void testCommunityListTextCount() {
        pts = new PlacesToStay();
        pts.communityListTextCount();
    }

    @Test (description = "TC012PTS", priority = 12, enabled = false)
    public void testHostListTextCount() {
        pts = new PlacesToStay();
        pts.hostListTextCount();
    }

    @Test (description = "TC013PTS", priority = 13, enabled = false)
    public void testSupportListTextCount() {
        pts = new PlacesToStay();
        pts.supportListTextCount();
    }

    @Test (description = "TC014PTS", priority = 14, enabled = false)
    public void testFutureGatewayTabsListTextCount() {
        pts = new PlacesToStay();
        pts.futureGatewayTabsListTextCount();
    }

    @Test (description = "TC015PTS", priority = 15, enabled = false)
    public void testTabsArtsAndCultureTextCount() {
        pts = new PlacesToStay();
        pts.tabsArtsAndCultureTextCount();
    }

    @Test (description = "TC016PTS", priority = 16, enabled = true)
    public void testTabsOutdoorAdventureListTextCount() {
        pts = new PlacesToStay();
        pts.tabsOutdoorAdventureListTextCount();
    }

}
