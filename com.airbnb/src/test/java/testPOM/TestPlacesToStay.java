package testPOM;

import POM.PlacesToStay;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestPlacesToStay extends TestBase {

    PlacesToStay pts;

    @Test (description = "TC001PTS", priority = 1, enabled = true)
    public void testCalendar() {
        pts = new PlacesToStay();
        pts.calendar();
    }
}
