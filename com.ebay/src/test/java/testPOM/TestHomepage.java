package testPOM;

import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {
    Homepage homepage;
    private String SearchPCDesktopAllInOnesLink;

    @Test(enabled = true)
    public void testDoSearch() throws Exception {
        homepage = getHomepage();

        homepage.doSearch("computer", "Computers/Tablets & Networking");
        String expTitle = "computer in Computers/Tablets & Networking | eBay";


        waitForElementToBeVisible(homepage.searchResultPageElement);
        scrollJS(1000);
        scrollJS(-500);
        scrollJS(6000);

    }
}



