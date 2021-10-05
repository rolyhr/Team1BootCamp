package testPOM;

import POM.ESPNHomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestESPNHomepage extends TestBase {

    ESPNHomepage espnHomepage;

    @Test (description = "TC001HP", priority = 1, enabled = false)
    public void testTopEventsDropdownListSize(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.topEventsDropdownList();
        espnHomepage.validateTopEventsDropdownListSizeAndLinks();
    }

    @Test (description = "TC002HP", priority = 2, enabled = false)
    public void testScrollHeader() throws Exception {
        espnHomepage = new ESPNHomepage();
        espnHomepage.scrollHeader();
        espnHomepage.validateScrollHeader();
    }

    @Test (description = "TC003HP", priority = 3, enabled = true)
    public void testNFLDropdownMenuLeftItemsCountAndText(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNFLDropdownMenuLeft();
        espnHomepage.validateNFLDropdownMenuLeftSize();
        espnHomepage.validateNFLDropdownMenuLeftItemsText();
    }

    @Test (description = "TC004HP", priority = 4, enabled = false)
    public void testNFLDropdownMenuLeftItems() {
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNFLDropdownMenuLeftLinks();
        espnHomepage.validateNFLDropdownMenuLeftLinks();
    }

    @Test (description = "TC005HP", priority = 5, enabled = false)
    public void testNFLDropdownMenuRightDivisions(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNFLDropdownMenuRightNFLDivisionNames();
        espnHomepage.validateNFLDropdownMenuRightNFLDivisionNames();
    }

    @Test (description = "TC006HP", priority = 6, enabled = false)
    public void testNFLDropdownMenuRightNFLTeams(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNFLDropdownMenuRightNFLTeams();
        espnHomepage.validateNFLDropdownMenuRightNFLTeamsCount();
        espnHomepage.validateNFLDropdownMenuRightNFLTeams();
    }

    @Test (description = "TC007HP", priority = 7, enabled = false)
    public void testNBADropdownMenuLeftItemsCountAndText(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNBADropdownMenuLeft();
        espnHomepage.validateNBADropdownMenuLeftSize();
        espnHomepage.validateNBADropdownMenuLeftItemsText();
    }

    @Test (description = "TC008HP", priority = 8, enabled = false)
    public void testNBADropdownMenuLeftItems(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNBADropdownMenuLeftLinks();
        espnHomepage.validateNBADropdownMenuLeftLinks();
    }

    @Test (description = "TC009HP", priority = 9, enabled = false)
    public void testNBADropdownMenuRightDivisions(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNBADropdownMenuRightNBADivisionNames();
        espnHomepage.validateNBADropdownMenuRightNBADivisionNames();
    }

    @Test (description = "TC010HP", priority = 10, enabled = false)
    public void testNBADropdownMenuRightNBATeams(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getNBADropdownMenuRightNBATeams();
        espnHomepage.validateNBADropdownMenuRightNBATeamsCount();
        espnHomepage.validateNBADropdownMenuRightNBATeams();
    }

    @Test (description = "TC011HP", priority = 11, enabled = false)
    public void testMLBDropdownMenuLeftItemsCountAndText(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getMLBDropdownMenuLeft();
        espnHomepage.validateMLBDropdownMenuLeftSize();
        espnHomepage.validateMLBDropdownMenuLeftItemsText();
    }

    @Test (description = "TC012HP", priority = 12, enabled = false)
    public void testMLBDropdownMenuLeftItems(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getMLBDropdownMenuLeftLinks();
        espnHomepage.validateMLBDropdownMenuLeftLinks();
    }

    @Test (description = "TC013HP", priority = 13, enabled = false)
    public void testMLBDropdownMenuRightDivisions(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getMLBDropdownMenuRightMLBDivisionNames();
        espnHomepage.validateMLBDropdownMenuRightMLBDivisionNames();
    }

    @Test (description = "TC014HP", priority = 14, enabled = false)
    public void testMLBDropdownMenuRightMLBTeams(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getMLBDropdownMenuRightMLBTeams();
        espnHomepage.validateMLBDropdownMenuRightMLBTeamsCount();
        espnHomepage.validateMLBDropdownMenuRightMLBTeams();
    }

    @Test (description = "TC015HP", priority = 15, enabled = false)
    public void testLogin(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.validateLogin();
    }

    @Test(description = "TC016HP", priority = 16, enabled = false)
    public void testESPNSitesContainerHeadingAndCount(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.validateESPNSitesContainerHeadingAndCount();
    }

    @Test(description = "TC017HP", priority = 17, enabled = false)
    public void testESPNSitesContainerListItemNames(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.validateESPNSitesContainerListItemNames();
    }

    @Test(description = "TC018HP", priority = 18, enabled = false)
    public void testFollowESPNContainerHeadingAndCount(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.validateFollowESPNContainerHeadingAndCount();
    }

    @Test(description = "TC019HP", priority = 19, enabled = false)
    public void testFollowESPNContainerListItemNames(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.validateFollowESPNContainerListItemNames();
    }

    @Test (description = "TC020HP", priority = 20, enabled = false)
    public void testHomepage(){
        espnHomepage = new ESPNHomepage();
        espnHomepage.getCurrentPageTitle();
        espnHomepage.validateCurrentPage();
    }

}
