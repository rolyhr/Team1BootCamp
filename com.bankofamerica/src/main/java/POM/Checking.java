package POM;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static POM.locators.ChekingLocators.*;

public class Checking extends Base {
    public Checking() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = CHECKING )
    public WebElement checking;

    @FindBy(id = MOBILE_BANKING)
    public WebElement mobileBanking;

    @FindBy(css = MOBILE_BANKING_NAVBAR_LIST)
    public List<WebElement> mobileBakingNavBarList;

    @FindBy(css = MOBILE_BANKING_SECURITY_PRIVACY_POLICY_ELEMENT_LIST)
    public List<WebElement> mobileBankingPrivacyPolicyElementList;

    @FindBy(css = MOBILE_BANKING_CARD_MANAGEMENT_ELEMENT_LIST)
    public List<WebElement> mobileBankingCradManagementElementList;

    @FindBy(css = MOBILE_BANKING_ACCOUNT_MANAGEMENT_ELEMENT_LIST)
    public List<WebElement> mobileBankingAccountManagementElementList;

    @FindBy(css = MOBILE_BANKING_DIGITAL_SERVICES_ELEMENT_LIST)
    public List<WebElement> mobileBankingDigitalServiceElementList;

    @FindBy(css = MOBILE_BANKING_PAYMENT_TRANSFER_ELEMENT_LIST)
    public List<WebElement> mobileBankingPaymentTransferElementList;


    @FindBy(css = PANEL_SLIDER_RIGH)
    public WebElement panelSliderRight;

    @FindBy(css = PANEL_SLIDER_LEFT )
    public WebElement panelSliderLeft;

    @FindBy(css =  SEARCH_SUB_CONTAINER)
    public WebElement searchSubContainer;

    @FindBy(css = SEARCH_RESULT)
    public WebElement searchResult;

    @FindBy(id = SEARCH_BOX)
    public WebElement searchBox;

    @FindBy(css = SEARCH_BUTTON )
    public WebElement searchButton;

    @FindBy(css = BREADCRUMB )
    public List<WebElement> breadCrumb;

    @FindBy(id = IMPORTANT_DISCLOSERS)
    public WebElement importanctDiscloserDropdown;

    @FindBy(css = CONTACTUS_ELEMNT_LIST)
    public WebElement contactUsElementList;


    public void clickOnChecking(){
        clickOnElement(checking);
    }

    public void clickOnCardManagement(){
        clickOnElement(mobileBakingNavBarList.get(1));
    }

    public void clickOnAccountdManagement(){
        clickOnElement(mobileBakingNavBarList.get(2));
    }

    public void clickOnDigitalServices(){
        clickOnElement(mobileBakingNavBarList.get(3));
    }

    public void clickOnPaymentTransfer(){
        clickOnElement(mobileBakingNavBarList.get(4));
    }

    public void navigateToMobileBanking(){
        clickOnChecking();
        clickOnElement(mobileBanking);
    }

    public List<String> getListofMobileBankingNavbarElemnts(){
        return getListOfStringElements(mobileBakingNavBarList);
    }

    public List<String> getListofMobileBankingSecurityandPrivacypolicyElements(){
        return getListOfStringElements(mobileBankingPrivacyPolicyElementList);
    }

    public List<String> getListofMobileBankingCradManagementElements(){
        return getListOfStringElements(mobileBankingCradManagementElementList);
    }

    public List<String> getListofMobileBankingAccountManagementElements(){
        return getListOfStringElements(mobileBankingAccountManagementElementList);
    }

    public List<String> getListofMobileBankingDigitalServiceElement(){
        return getListOfStringElements(mobileBankingDigitalServiceElementList);
    }
    public List<String> getListofMobileBankingPaymentTransferElements(){
        return getListOfStringElements(mobileBankingPaymentTransferElementList);
    }

    public List<String> getListofBreadcrumbelemnts(){
        return getListOfStringElements(breadCrumb);
    }
}
