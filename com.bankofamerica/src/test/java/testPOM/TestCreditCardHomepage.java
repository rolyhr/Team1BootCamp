package testPOM;

import POM.CreditCardHomePage;
import POM.Homepage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.ArrayList;

public class TestCreditCardHomepage extends TestBase {

    @Test(description = "Tc001", priority=1,enabled = false)
    public void testCreditLinks(){
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        oneDList(credit.creditLinks);
    }


    @Test(description = "Tc002", priority=2,enabled = false)
    public void testVeryfycreditCardsButton(){
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        clickOnElement(credit.btnCompareCreditCards);
        oneDList(credit.cardNames);
        oneDList(credit.cardDescriptions);

    }

    @Test(description = "Tc003", priority=3,enabled = false)
    public void verifyCreditCardForStudents(){
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        clickOnElement(credit.cardsForStudents);
        clickOnElement(credit.cardsForStudentsTC);
        ArrayList<String> windows2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows2.get(1));
        oneDList(credit.rowName);
        driver.close();
        driver.switchTo().window(windows2.get(0));
    }

    @Test(description = "Tc004", priority=4,enabled = false)
    public void verifyCreditCardToSetPowerOfAttorny() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        clickJScript(credit.lifeServices);
        clickOnElement(credit.powerOfAttorneyLarge);
        scrollJS(1000);
        clickOnElement(credit.powerOfAttorneyCQ);
        waitForElementToBeVisible(credit.questionTwo);
        String actualText = credit.questionTwo.getText();
        String expectedText = "Is there a fee to add a power of attorney agent to my account?";
        Assert.assertEquals(actualText, expectedText);
        oneDhref(credit.lifeServicesLabels);
    }

    @Test(description = "Tc005", priority=5,enabled = false)
    public void verifyCreditCardForCashRewards() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        clickOnElement(credit.cashRewardsCards);
        clickOnElement(credit.footer_cc_glossary);
        oneDList(credit.glossaryA);
        clickOnElement(credit.indexK);
        oneDhref(credit.creditHREF);
    }

    @Test(description = "Tc006", priority=6, enabled = false)
    public void verifyCreditCardTest6() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();
        clickOnElement(credit.pointsRewardsCards);
        clickOnElement(credit.footer_cc_status);
        clickOnElement(credit.lastNameField);
        sendKeysToInput(credit.lastNameField, "John");
        clickOnElement(credit.dateOfBirth);
        sendKeysToInput(credit.dateOfBirth, "01/03/1979");
        clickOnElement(credit.lastFourSSN);
        sendKeysToInput(credit.lastFourSSN, "1234");
        clickOnElement(credit.zipCode);
        sendKeysToInput(credit.zipCode, "12345");
        clickOnElement(credit.submitButton);
        waitForElementToBeVisible(credit.errorMessage);
        String actualText = credit.errorMessage.getText();
        String expectedText = "The information you entered does not match our records";
        Assert.assertEquals(actualText, expectedText);
    }


    @Test(description = "Tc007", priority=7,enabled = false)
    public void verifyCreditCardTest7() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();


    }

    @Test(description = "Tc008", priority=8,enabled = false)
    public void verifyCreditCardTest8() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();

    }


    @Test(description = "Tc009", priority=9,enabled = false)
    public void verifyCreditCardTest9() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();

    }

    @Test(description = "Tc0010", priority=10,enabled = false)
    public void verifyCreditCardTest10() {
        Homepage homepage = getHomepage();
        CreditCardHomePage credit = homepage.navigateToCreditCard();

    }




}
