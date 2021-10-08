package testBase;

import POM.Flights;
import POM.Homepage;
import base.Base;

public class TestBase extends Base {

    public Flights flights;
    public Homepage getHomepage() {
        return new Homepage();
    }

    public Flights getFlights(){
        return  new Flights();
    }
}
