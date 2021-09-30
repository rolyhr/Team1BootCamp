package testBase;

import POM.Mortgage;
import base.Base;

public class TestBase extends Base {

    public Mortgage getHomepage() {
        return new Mortgage();
    }
}
