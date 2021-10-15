package testPOM.testPrepaidLoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import testPOM.TestPrepaidPage;

import java.io.IOException;

public class TestPrepaidLoginPage extends TestPrepaidPage {

    String[][] stringData;

    @Test(description = "TC_ATT_Prepaid_Login:001", priority = 1, enabled = false)
    public void testDoLoginWithValidData() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doLoginPrepaidAccount(stringData[0][0],stringData[0][1]);
        System.out.println("Login Successful");

    }

    @Test(description = "TC_ATT_Prepaid_Login:002", priority = 2, enabled = false)
    public void testDoLoginWithInValidData() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doLoginPrepaidAccount(stringData[0][0],stringData[0][1]);
        Assert.assertTrue(getPrepaidLoginPage().isErrorMessageForInvalidAccountPresent());

    }

    @Test(description = "TC_ATT_Prepaid_Login:003", priority = 3, enabled = false)
    public void testDoLoginWithInValidAccountNumber() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doLoginPrepaidAccount(stringData[1][0],stringData[0][1]);
        Assert.assertTrue(getPrepaidLoginPage().isErrorMessageForInvalidPhoneNumberPresent());

    }

    @Test(description = "TC_ATT_Prepaid_Login:004", priority = 4, enabled = false)
    public void testDoLoginWithInValidPassword() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doLoginPrepaidAccount(stringData[0][0],stringData[2][1]);
        Assert.assertTrue(getPrepaidLoginPage().isErrorMessageForInvalidPasswordPresent());

    }

    @Test(description = "TC_ATT_Prepaid_Login:005", priority = 5, enabled = false)
    public void testDoRequestPasswordWithoutClickAnyChekBox() throws IOException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithoutClickAnyChekBox(stringData[0][0]);
        Assert.assertTrue(getPrepaidLoginPage().isMessageForSelectingAtLeastOneOption());

    }

    @Test(description = "TC_ATT_Prepaid_Login:006", priority = 6, enabled = false)
    public void testDoRequestPasswordWithRequestPasswordOnlineCheckBox() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithRequestPasswordOnlineCheckBox(stringData[0][0]);
        Assert.assertTrue(getPrepaidLoginPage().isMessageForSelectingAtLeastOneOption());

    }

    @Test(description = "TC_ATT_Prepaid_Login:007", priority = 7, enabled = false)
    public void testDoRequestPasswordWithRequest4DigitPINCheckBox() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithRequest4DigitPINCheckBox(stringData[0][0]);
        Assert.assertTrue(getPrepaidLoginPage().isMessageForSelectingAtLeastOneOption());

    }

    @Test(description = "TC_ATT_Prepaid_Login:008", priority = 8, enabled = false)
    public void testDoRequestPasswordWithBothOptions() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithBothOptions(stringData[0][0]);
        Assert.assertTrue(getPrepaidLoginPage().isMessageForSelectingAtLeastOneOption());

    }

    @Test(description = "TC_ATT_Prepaid_Login:009", priority = 9, enabled = false)
    public void testDoRequestPasswordWithoutAccountNumberAndAnyOption() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithoutAccountNumberAndAnyOption();
        Assert.assertTrue(getPrepaidLoginPage().isMessageForAccountNumberPresent());

    }

    @Test(description = "TC_ATT_Prepaid_Login:010", priority = 10, enabled = true)
    public void testDoRequestPasswordWithoutAccountNumberAndBothOption() throws IOException, InterruptedException {

        stringData = getTestDataFromExcelFile("ATT_LoginData");
        getPrepaidLoginPage().doRequestPasswordWithoutAccountNumberAndBothOption();
        Assert.assertTrue(getPrepaidLoginPage().isMessageForAccountNumberPresent());

    }

}
