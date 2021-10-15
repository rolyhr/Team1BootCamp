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

    @FindBy(xpath = "//*[@id=\"searchStub\"]/div/div/form")
    WebElement suggestionForSearchTopic;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//li[1]//a")
    WebElement suggestedSearchOptionRoutingNumber;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//li[2]//a")
    WebElement suggestedSearchOptionBillingDispute;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//li[3]//a")
    WebElement suggestedSearchOptionErica;

    @FindBy(xpath = "//*[@class = 'suggestions nav-search-suggestions']//li[4]//a")
    WebElement suggestedSearchOptionBillPay;

    @FindBy(xpath = "//div[@class = 'main']//a[@role ='button']")
    WebElement routingNumberButton;

    @FindBy(xpath = "//*[@id=\"searchStub\"]//h3/span")
    WebElement searchResultForErica;

    @FindBy(xpath = "//*[@id=\"searchStub\"]//h3/span")
    WebElement searchResultForBillPay;

    @FindBy(xpath = "//*[@id=\"searchStub\"]//h3/span")
    WebElement searchResultForBillingDispute;

    @FindBy(xpath = "//*[@id=\"searchStub\"]//p[1]/span[@class = 'query']")
    WebElement searchResultForSearchTerm;

    @FindBy(xpath = "//*[@id=\"searchStub\"]/div/div/form/div[2]/ul/li[1]/a")
    WebElement suggestionTerm1stOption;

    @FindBy(xpath = "//*[@id=\"apptScheduler\"]")
    WebElement scheduleAppointmentLink;

    @FindBy(xpath = "//*[@id='btn-manage-rebook-appointment']")
    WebElement manageAppointmentButton;

    @FindBy(css = "#inputFieldEmailAddress")
    WebElement manageAppointmentEmailInputField;

    @FindBy(css = "#inputFieldConfirmationCode")
    WebElement manageAppointmentConfirmationCodeInputField;

    @FindBy(css = "#triggerFindEmailAddress")
    WebElement manageAppointmentEmailFindButton;

    @FindBy(css = "#triggerFindConfirmationCode")
    WebElement manageAppointmentConfirmationFindButton;

    @FindBy(xpath = "//*[@id=\"sendEmailModalClose\"]")
    WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id=\"sendEmailModalCancel\"]")
    WebElement cancelEmailButton;

    @FindBy(xpath = "//*[@id=\"sentEmailNotSent\"]/h4")
    WebElement confirmationOfNoAppointment;

    public boolean isManageAppointmentButtonPresent(){ return isElementPresent(manageAppointmentButton);}

    public boolean isConfirmationOfAppointmentPresent(){return isElementPresent(confirmationOfNoAppointment);}

    void clickOnCancelEmailButton(){clickOnElement(cancelEmailButton);}

    void clickOnSendEmailButton(){clickOnElement(sendEmailButton);}

    void clickOnManageAppointmentConfirmationFindButton(){clickOnElement(manageAppointmentConfirmationFindButton);}

    void clickOnManageAppointmentEmailFindButton(){clickOnElement(manageAppointmentEmailFindButton);}

    void sendConfirmationToConfirmationInputFieldForManageAppointment(String confirmationCode){sendKeysToElement(manageAppointmentConfirmationCodeInputField,confirmationCode);}

    void sendEmailToEmailInputFieldForManageAppointment(String email){sendKeysToElement(manageAppointmentEmailInputField,email);}

    void clickManageAppointmentButton(){clickOnElement(manageAppointmentButton);}

    void clickOnScheduleAppointmentLintLink(){clickOnElement(scheduleAppointmentLink);}

    void mouseOverOnSuggestionTermAndSelect(){mouseHoverOnAnElementAndClick(suggestionTerm1stOption);}

    void clickOnSearchButton(){clickOnElement(searchButton);}

    public boolean isSearchResultForSearchTermPresent(){return  isElementPresent(searchResultForSearchTerm);}

    void sendSearchTermIntoSearchBar(String searchTerm){sendKeysToElement(helpSearchBar,searchTerm);}

    public boolean isSearchResultForBillingDisputePresent(){return  isElementPresent(searchResultForBillingDispute);}

    public boolean isSearchResultForBillPayPresent(){return  isElementPresent(searchResultForBillPay);}

    public boolean isSearchResultForEricaPresent(){return  isElementPresent(searchResultForErica);}

    public boolean isSearchResultForRoutingNumberPresent(){return isElementPresent(routingNumberButton);}

    void waitForSuggestionTopicToBePopulated(){waitForElementToBeVisible(suggestionForSearchTopic);}

    void selectOptionRoutingNumber(){clickOnElement(suggestedSearchOptionRoutingNumber);}

    void selectOnOptionBillingDispute(){clickOnElement(suggestedSearchOptionBillingDispute);}

    void selectOptionErica(){clickOnElement(suggestedSearchOptionErica);}

    void selectOptionBillPay(){clickOnElement(suggestedSearchOptionBillPay);}

    void clickOnSearchBar(){clickOnElement(helpSearchBar);}

    public List<String> getListOfNavigationBarMenu(){
        return getStringListFromADiv(By.xpath("//*[@id=\"navigationDesktop\"]/div[1]//span[@class = 'title']"));}

    public String getTextOfFilteredResult(){return filteredSearchResult.getText();}

    void clickOnApplyFilterButton(){clickOnElement(applyFilterButton);}

    void clickOnFilterButton(){clickJScript(filterButton);}

    void selectFilterOption(String option){
        selectASubCategoryOfADropDownMenuByPassingTestData(By.xpath("//div[@class = 'map-filter-scroll']//label"), option);}

    public List<String> getAListOfStringOfFilterOptions(){
        doNavigateFinancialCenterAndATMLocationPage();
        clickOnFilterButton();
        return getStringListFromADiv(By.xpath("//div[@class = 'map-filter-scroll']//label"));}

    void clickOnZIPCodeSearchButton(){clickJScript(zipCodesearchButton);}

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



    public void doManageAppointmentBySendingConfirmationCodeAndCancel(String confirmationCode){
        clickOnScheduleAppointmentLintLink();
        clickManageAppointmentButton();
        sendConfirmationToConfirmationInputFieldForManageAppointment(confirmationCode);
        clickOnManageAppointmentConfirmationFindButton();
        clickOnCancelEmailButton();
    }

    public void doManageAppointmentBySendingConfirmationCode(String confirmationCode){
        clickOnScheduleAppointmentLintLink();
        clickManageAppointmentButton();
        sendConfirmationToConfirmationInputFieldForManageAppointment(confirmationCode);
        clickOnManageAppointmentConfirmationFindButton();
        clickOnSendEmailButton();
    }

    public void doManageAppointmentBySendingEmail(String email){
        clickOnScheduleAppointmentLintLink();
        clickManageAppointmentButton();
        sendEmailToEmailInputFieldForManageAppointment(email);
        clickOnManageAppointmentEmailFindButton();
        clickOnSendEmailButton();
    }

    public void doSearchBySendingSearchTermAndSelectSuggestedTerm(String value){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        sendSearchTermIntoSearchBar(value);
        waitForSuggestionTopicToBePopulated();
        mouseOverOnSuggestionTermAndSelect();
        waitForElementToBeVisible(searchResultForSearchTerm);
    }

    public void doSearchBySendingSearchTerm(String value){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        sendSearchTermIntoSearchBar(value);
        clickOnSearchButton();
        waitForElementToBeVisible(searchResultForSearchTerm);
    }

    public void doSearchForBillPay(){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        clickOnSearchBar();
        waitForSuggestionTopicToBePopulated();
        selectOptionBillPay();
        waitForElementToBeVisible(searchResultForBillPay);
    }

    public void doSearchForBillingDispute(){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        clickOnSearchBar();
        waitForSuggestionTopicToBePopulated();
        selectOnOptionBillingDispute();
        waitForElementToBeVisible(searchResultForBillingDispute);
    }

    public void doSearchForErica(){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        clickOnSearchBar();
        waitForSuggestionTopicToBePopulated();
        selectOptionErica();
        waitForElementToBeVisible(searchResultForErica);
    }

    public void doSearchForRoutingNumber(){
        waitForElementToBeVisibleForStaleElement(helpSearchBar);
        clickOnSearchBar();
        waitForSuggestionTopicToBePopulated();
        selectOptionRoutingNumber();
        waitForElementToBeVisible(routingNumberButton);
    }

    public void doSearchForFinancialCenterLocationApplyingFilter(String zipCode, String option) throws InterruptedException {
        doNavigateFinancialCenterAndATMLocationPage();
        sendValuesToZipCodeInputField(zipCode);
        clickOnZIPCodeSearchButton();
        waitForElementToBeVisible(searchResult);
        clickOnFilterButton();
        selectFilterOption(option);
        clickOnApplyFilterButton();
        waitForElementToBeVisible(filteredSearchResult);
    }

    public void doSearchForFinancialCenterLocation(String values) throws InterruptedException {
        doNavigateFinancialCenterAndATMLocationPage();
        sendValuesToZipCodeInputField(values);
        clickOnZIPCodeSearchButton();
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
