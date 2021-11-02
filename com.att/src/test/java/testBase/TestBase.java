package testBase;

import POM.PhonesAndDevices;
import base.Base;

import java.util.List;

public class TestBase extends Base {

    public PhonesAndDevices getHomepage() {
        return new PhonesAndDevices();
    }

    public boolean doListsMatch(String parentElementLocator, String sheet){
        boolean flag = false;
        List<String> elementList = getListItemsByCss(parentElementLocator);

        for(int i = 0; i< elementList.size(); i++) {
            if (elementList.get(i).equals(readFromExcel(sheet, i))) {
                flag = true;
            } else {
                flag = false;
                System.out.println("EXPECTED: " + readFromExcel(sheet, i) + "\nACTUAL: " + elementList.get(i));
                break;
            }
        }
        return flag;
    }

}
