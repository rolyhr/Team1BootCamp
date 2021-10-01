package testBase;

import POM.CarsPage;
import POM.Homepage;
import base.Base;

public class TestBase extends Base {

    public Homepage getHomepage() {
        return new Homepage();
    }

    public CarsPage getCarsPage() {
        return new CarsPage();
    }
}
