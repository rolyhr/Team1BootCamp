package testPOM;

import POM.Homepage;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestHomepage extends TestBase {

    @Test
    public void test() {
        Homepage homepage = new Homepage();
        System.out.println(homepage.truliaMainMenu());
    }


}
