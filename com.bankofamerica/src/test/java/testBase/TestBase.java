package testBase;

import POM.Homepage;
import POM.LocatorsPage;
import base.Base;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }
    public LocatorsPage getLocatorsPage(){return new LocatorsPage();}
}
