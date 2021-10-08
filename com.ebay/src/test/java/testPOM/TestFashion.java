package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestFashion extends TestBase {
    @Test
    public void testNavigateToFashion() throws Exception {
        getFashion().navigateToFashion();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.ebay.com/b/Fashion/bn_7000259856";

        Assert.assertEquals(actualURL,expectedURL,"FAILED TO NAVIGATE FASHION PAGE");
    }
}
