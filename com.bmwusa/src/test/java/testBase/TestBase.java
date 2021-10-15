package testBase;

import POM.BMWLogin;
import base.Base;

public class TestBase extends Base {

    public BMWLogin getHomepage() {
        return new BMWLogin();
    }
}
