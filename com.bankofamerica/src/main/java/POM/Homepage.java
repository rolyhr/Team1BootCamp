package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage extends Base {

    public Homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#onlineId1")
    WebElement userIDInputField;

    @FindBy(css="#passcode1")
    WebElement userPasswordInputField;

    @FindBy(css="#signIn")
    WebElement signInButton;

    @FindBy(css = "body div.header div.ico-bg")
    WebElement warningForInvalidCredential;

    @FindBy(css = "#forgot-oid-pwd")
    WebElement forgetPasswordLink;

    @FindBy(xpath = "//input[@id ='acctNumber']")
    WebElement last6DigitInputField;

    @FindBy(xpath = "//input[@id ='ssNumber']")
    WebElement SSNInputField;

    @FindBy(xpath = "//button[@id = 'verifyCustomerAccount']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id = 'cancelCustomerAccount']")
    WebElement cancelButton;

    @FindBy(css = "#help-open-ssNumber")
    WebElement SSNHelpButton;

    @FindBy(css = "#helpLayer_ssNumber")
    WebElement contentForSSNHelper;

    @FindBy(css= "#help-close-ssNumber")
    WebElement closeButtonSSNHelperContent;

    @FindBy(xpath = "//div[@id = 'ah-acct-ssn-error-target']")
    WebElement unableToResetPasswordMessage;

    @FindBy(css = "#acctNumber_errorMessage")
    WebElement errorMessageForInvalid6DigitAccountNumber;

    @FindBy(css = "#ssNumber_errorMessage")
    WebElement errorMessageForInvalidSSN;

    @FindBy(xpath = "//*[@id=\"securityModalSpartaUILayer\"]/div")
    WebElement securityAndHelpWindow;

    @FindBy(xpath = "//div[@class='small-8 columns']//a")
    WebElement securityAndHelpLink;

    @FindBy(css = "#closeSecurityModal")
    WebElement securityAndHelpCloseButton;

    @FindBy(css = "#finCenterLocator")
    WebElement findATMLocation;

    @FindBy(css = "#skip-to-h1")
    WebElement locationPageHeader;

    @FindBy(css = "#q")
    WebElement zipCodeInputField;

    @FindBy(xpath = "//*[@id=\"search-button\"]")
    WebElement zipCodesearchButton;

    @FindBy(xpath = "//*[@id=\"lid664159\"]/div/a[2]")
    WebElement searchResult;

    @FindBy(xpath = "//div[@class = 'map-filter-scroll']//label")
    WebElement listOfFilterOptions;

    @FindBy(name = "Show_Filters")
    WebElement filterButton;

    @FindBy(name = "View_All_Filters")
    WebElement viewAllFiltersButton;

    @FindBy(xpath = "//button[text() = 'Apply filters']")
    WebElement applyFilterButton;

    @FindBy(xpath = "//*[@id=\"aria-map-list-header\"]/span[1]")
    WebElement filteredSearchResult;

    @FindBy(css = "#nav-search-query")
    WebElement helpSearchBar;

    @FindBy(xpath = "//*[@id=\"searchStub\"]//input[@title ='Search']")
    WebElement searchButton;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//a[1]")
    WebElement suggestedSearchOptionRoutingNumber;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//a[2]")
    WebElement suggestedSearchOptionBillingDispute;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//a[3]")
    WebElement suggestedSearchOptionErica;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//a[4]")
    WebElement suggestedSearchOptionBillPay;




    void clickOnOptionRoutingNumber(){clickOnElement(suggestedSearchOptionRoutingNumber);}

    void clickOnOptionBillingDispute(){clickOnElement(suggestedSearchOptionBillingDispute);}

    void clickOnOptionErica(){clickOnElement(suggestedSearchOptionErica);}

    void clickOnOptionBillPay(){clickOnElement(suggestedSearchOptionBillPay);}

    public List<String> getListOfNavigationBarMenu(){
        return getStringListFromADiv(By.xpath("//*[@id=\"navigationDesktop\"]/div[1]//span[@class = 'title']"));}

    public String getTextOfFilteredResult(){return filteredSearchResult.getText();}

    void clickOnApplyFilterButton(){clickOnElement(applyFilterButton);}

    void clickOnViewAllFiltersButton(){clickJScript(viewAllFiltersButton);}

    void clickOnFilterButton(){clickJScript(filterButton);}

    void selectFilterOption(String option){
        selectASubCategoryOfADropDownMenuByPassingTestData(By.xpath("//div[@class = 'map-filter-scroll']//label"), option);}

    public List<String> getAListOfStringOfFilterOptions(){
        doNavigateFinancialCenterAndATMLocationPage();
        clickOnFilterButton();
        return getStringListFromADiv(By.xpath("//div[@class = 'map-filter-scroll']//label"));}

    void clickOnSearchButton(){clickJScript(zipCodesearchButton);}

    void sendValuesToZipCodeInputField(String values){sendKeysToElement(zipCodeInputField,values);}

    void clickOnFindATMLocation(){clickJScript(findATMLocation);}

    void clickOnSecurityAndHelpLCloseButton(){clickOnElement(securityAndHelpCloseButton);}

    void clickOnSecurityAndHelpLink(){clickJScript(securityAndHelpLink);}

    void clickOnSSNHelperButton(){clickJScript(SSNHelpButton);}

    void clickOnSSNHelperContentCloseButton(){clickJScript(closeButtonSSNHelperContent);}

    void clickCancelButton(){clickJScript(cancelButton);}

    void clickContinueButton(){clickJScript(continueButton);}

    void sendSSN(String SSN){sendKeysToElement(SSNInputField, SSN);}

    void send6DigitCardNumber(String accountNumberLast6Digit){ sendKeysToElement(last6DigitInputField,accountNumberLast6Digit);}

    void clickOnForgetPasswordLink(){clickJScript(forgetPasswordLink);}

    void sendUserIDToUserIDInputField(String userID){sendKeysToInput(userIDInputField,userID);}

    void sendPasswordToPasswordInputField(String password){sendKeysToInput(userPasswordInputField,password);}

    void clickSignInButton(){clickOnElement(signInButton);}

    public boolean isContentForSSNHelperPresent(){return isElementPresent(contentForSSNHelper);}

    public boolean isErrorMessageForInvalidSSNPresent(){return isElementPresent(errorMessageForInvalidSSN);}

    public boolean isErrorMessageForInvalid6DigitAccountNumberPresent(){
        return isElementPresent(errorMessageForInvalid6DigitAccountNumber);}

    public boolean isWarningMessageForUnableToVerifyPresent(){ return  isElementPresent(unableToResetPasswordMessage);}

    public boolean isWarningForInvalidCredentialPresent(){return isElementPresent(warningForInvalidCredential);}




    public void doSearchForFinancialCenterLocationApplyingFilter(String zipCode, String option) throws InterruptedException {
        doNavigateFinancialCenterAndATMLocationPage();
        sendValuesToZipCodeInputField(zipCode);
        clickOnSearchButton();
        waitForElementToBeVisible(searchResult);
        clickOnFilterButton();
        selectFilterOption(option);
        clickOnApplyFilterButton();
        waitForElementToBeVisible(filteredSearchResult);
    }

    public void doSearchForFinancialCenterLocation(String values) throws InterruptedException {
        doNavigateFinancialCenterAndATMLocationPage();
        sendValuesToZipCodeInputField(values);
        clickOnSearchButton();
        //Thread.sleep(3000);
        waitForElementToBeVisible(searchResult);
    }

    public void doNavigateFinancialCenterAndATMLocationPage(){
        clickOnFindATMLocation();
        waitForElementToBeVisible(locationPageHeader);
    }

    public void doNavigateSecurityAndHelpLink(){
        clickOnSecurityAndHelpLink();
        waitForElementToBeVisible(securityAndHelpWindow);
        clickOnSecurityAndHelpLCloseButton();
    }

    public void doVerifyForgetPasswordCancelButton(String accountNumber, String SSN){
        clickOnForgetPasswordLink();
        waitForElementToBeVisible(last6DigitInputField);
        send6DigitCardNumber(accountNumber);
        sendSSN(SSN);
        clickOnSSNHelperButton();
        waitForElementToBeVisible(contentForSSNHelper);
        clickOnSSNHelperContentCloseButton();
        clickCancelButton();
        waitForElementToBeVisible(userIDInputField);
    }

    public void doVerifySSNHelperButton(){
        clickOnForgetPasswordLink();
        waitForElementToBeVisible(last6DigitInputField);
        clickOnSSNHelperButton();
        waitForElementToBeVisible(contentForSSNHelper);
    }

    public void doResetPasswordByProvidingInvalidSSNNumber(String accountNumber,String SSN){
        clickOnForgetPasswordLink();
        waitForElementToBeVisible(last6DigitInputField);
        send6DigitCardNumber(accountNumber);
        sendSSN(SSN);
        clickContinueButton();
    }

    public void doResetPasswordByProvidingInvalidAccountNumber(String accountNumber){
        clickOnForgetPasswordLink();
        waitForElementToBeVisible(last6DigitInputField);
        send6DigitCardNumber(accountNumber);
        clickOnElement(SSNInputField);
    }

    public void doResetPasswordByInvalidAccountInformation(String accountNumber, String SSN){
        clickOnForgetPasswordLink();
        waitForElementToBeVisible(last6DigitInputField);
        send6DigitCardNumber(accountNumber);
        sendSSN(SSN);
        clickContinueButton();
    }

    public void doSignIn(String userID, String password){
        waitForElementToBeVisible(userPasswordInputField);
        sendUserIDToUserIDInputField(userID);
        sendPasswordToPasswordInputField(password);
        clickSignInButton();
    }

}
