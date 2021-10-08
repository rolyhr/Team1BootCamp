package testBase;

import POM.Homepage;
import POM.RealStateAgents;
import base.Base;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }
    public RealStateAgents getRealStateAgents() {
        return new RealStateAgents();
    }

}
