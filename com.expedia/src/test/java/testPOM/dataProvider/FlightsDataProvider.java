package testPOM.dataProvider;

import org.testng.annotations.DataProvider;

public class FlightsDataProvider {
    @DataProvider(name = "SearchLocationDataProvider")
    public Object[][] getData(){
        Object[][] data = {
              //  {"New York","Washington "},{"Maryland","Washington"}};
        {"New York","Washington"}};
        return data;
    }
}
