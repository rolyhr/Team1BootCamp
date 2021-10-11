package testPOM;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TestShop extends TestBase {
    @Test(description = "TC001PE", enabled = false, priority = 2)
    public void testListofSelectClass() throws IOException{
        getShop().clickOnSelectClass();
        List<String> acutalCategories =  getShop().getListofSelectClassList();
        String[] expectedCategories =getExcelFile("class");
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC002PE", enabled = false, priority = 2)
    public void testListofSelectModel() throws IOException,AWTException {
        getShop().clickOnSelectModel();
        List<String> acutalCategories =  getShop().getListofSelectModelList();
        String[] expectedCategories =getExcelFile("model");
        compareStringList(acutalCategories,expectedCategories);
    }

    @Test(description = "TC003PE", enabled = true, priority = 2)
    public void testSelectClass() throws IOException{
        getShop().selectClass();
        String actualResult  =  getShop().getSelectClassResult();
        String[] expectedResults =getExcelFile("class");
        Assert.assertEquals(actualResult,expectedResults[1]);
    }

    @Test(description = "TC004PE", enabled = false, priority = 2)
    public void testSelectModel() throws IOException{
        getShop().selectModel();
        String actualResult  =  getShop().getSelectModelResult();
        String[] expectedResults =getExcelFile("model");
        Assert.assertEquals(actualResult,expectedResults[1]);
    }
}
