package testPOM;

import POM.Footer;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestFooter extends TestBase {

    Footer footer;

    @Test (description = "TC001VZ", priority = 1, enabled = false)
    public void testValidateFooterTitleText() {
        footer = new Footer();
        footer.validateFooterTitleText();
    }

    @Test (description = "TC002VZ", priority = 2, enabled = false)
    public void testValidateShopListText() {
        footer = new Footer();
        footer.validateShopListText();
    }

    @Test (description = "TC003VZ", priority = 3, enabled = false)
    public void testValidateTopDeviceBrandListText() {
        footer = new Footer();
        footer.validateTopDeviceBrandListText();
    }

    @Test (description = "TC004VZ", priority = 4, enabled = false)
    public void testValidateSupportListText() {
        footer = new Footer();
        footer.validateSupportListText();
    }

    @Test (description = "TC005VZ", priority = 5, enabled = false)
    public void testValidateAboutVerizonListText() {
        footer = new Footer();
        footer.validateAboutVerizonListText();
    }

    @Test (description = "TC006VZ", priority = 6, enabled = false)
    public void testValidateMostPopularListText() {
        footer = new Footer();
        footer.validateMostPopularListText();
    }

    @Test (description = "TC007VZ", priority = 7, enabled = false)
    public void testValidateTopAccessoriesBrandsListText() {
        footer = new Footer();
        footer.validateTopAccessoriesBrandsListText();
    }

    @Test (description = "TC008VZ", priority = 8, enabled = false)
    public void testValidateImportantConsumerInfoListText() {
        footer = new Footer();
        footer.validateImportantConsumerInfoListText();
    }

    @Test (description = "TC009VZ", priority = 9, enabled = false)
    public void testValidateFollowVerizonListText() {
        footer = new Footer();
        footer.validateFollowVerizonListText();
    }

    @Test (description = "TC010VZ", priority = 10, enabled = true)
    public void testValidateFollowVerizonFiosListText() {
        footer = new Footer();
        footer.validateFollowVerizonFiosListText();
    }

    @Test (description = "TC011VZ", priority = 11, enabled = false)
    public void testFooterTitlesTextCount() {
        footer = new Footer();
        footer.footerTitlesTextCount();
    }

    @Test (description = "TC012VZ", priority = 12, enabled = false)
    public void testShopListTextCount() {
        footer = new Footer();
        footer.shopListTextCount();
    }

    @Test (description = "TC013VZ", priority = 13, enabled = false)
    public void testTopDeviceBrandsListTextCount() {
        footer = new Footer();
        footer.topDeviceBrandsListTextCount();
    }

    @Test (description = "TC014VZ", priority = 14, enabled = false)
    public void testSupportListTextCount() {
        footer = new Footer();
        footer.supportListTextCount();
    }

    @Test (description = "TC015VZ", priority = 15, enabled = false)
    public void testAboutVerizonListTextCount() {
        footer = new Footer();
        footer.aboutVerizonListTextCount();
    }

    @Test (description = "TC016VZ", priority = 16, enabled = false)
    public void testMostPopularListTextCount() {
        footer = new Footer();
        footer.mostPopularListTextCount();
    }

    @Test (description = "TC017VZ", priority = 17, enabled = false)
    public void testTopAccessoriesBrandListTextCount() {
        footer = new Footer();
        footer.topAccessoriesBrandListTextCount();
    }

    @Test (description = "TC018VZ", priority = 18, enabled = false)
    public void testImportantConsumerInfoListTextCount() {
        footer = new Footer();
        footer.importantConsumerInfoListTextCount();
    }

    @Test (description = "TC019VZ", priority = 19, enabled = false)
    public void testFollowVerizonListTextCount() {
        footer = new Footer();
        footer.followVerizonListTextCount();
    }

    @Test (description = "TC020VZ", priority = 20, enabled = false)
    public void testFollowVerizonFiosListTextCount() {
        footer = new Footer();
        footer.followVerizonFiosListTextCount();
    }

}
