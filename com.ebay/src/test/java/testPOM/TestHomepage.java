package testPOM;

import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {
    Homepage homepage;
    private String SearchPCDesktopAllInOnesLink;

    @Test(description = "Case ID: 01", priority = 1, enabled = false)
    public void testDoSearch() throws Exception {
        homepage = getHomepage();

        homepage.doSearch("computer", "Computers/Tablets & Networking");
        String expTitle = "computer in Computers/Tablets & Networking | eBay";


        waitForElementToBeVisible(homepage.searchResultPageElement);
        scrollJS(1000);


    }
}



