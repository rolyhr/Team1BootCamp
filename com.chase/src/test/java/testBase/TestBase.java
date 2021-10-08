package testBase;

import POM.HomeLoans;
import POM.Homepage;
import base.Base;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }
    public HomeLoans getHomeLoans() {
        return new HomeLoans();
    }

}
