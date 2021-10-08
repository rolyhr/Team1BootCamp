package testBase;

import POM.Fashion;
import POM.Homepage;
import base.Base;

public class TestBase extends Base {


    public  Fashion fashion;

    public Homepage getHomepage() {
        return new Homepage();
    }

    public Fashion getFashion() {
        return new Fashion();
    }

}
