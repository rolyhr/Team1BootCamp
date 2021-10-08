package testBase;

import POM.Experiences;
import POM.Homepage;
import base.Base;

public class TestBase extends Base {



    public Homepage getHomepage() {
        return new Homepage();
    }

    public Experiences getExperiences() {
        return new Experiences();
    }

}
