package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

import static POM.locators.HomeLoansLocators.*;

public class HomeLoans extends Base {
    public  HomeLoans(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = H0ME_LOAN)
    public WebElement homeLoan;

    @FindBy(css = MORTGAGE_AND_H0ME_LOAN)
    public WebElement mortgageAndHomeLoans;

    @FindBy(xpath = VEDIO_PLAY_BUTTON)
    public WebElement videoPlayButton;

    @FindBy(xpath = DROP_DOWN)
    public WebElement dropDownMenu;

    @FindBy(id = REFINANCE_RATES_TABS)
    public WebElement refinanceRateTabs;

    @FindBy(id = PURCHASE_RATES_TABS)
    public WebElement purchaseRatesTabs;

    @FindBy(xpath = HOME_VALUE_ESTIMATOR)
    public  WebElement homeValueEstimator;

    @FindBy(xpath = ESTIMATE_RATE_PAYMENTS)
    public  WebElement estimateRatesPayments;

    //Iframe
    @FindBy(css = IFRAME_MORTGAGE_CALCULATOR)
    public  WebElement iframeMortgageCalculatorIframe;

    @FindBy (id = ADVANCED_OPTION_OPEN_CLOSE)
    public WebElement advancedOptionOpenClose;

    @FindBy (css = ADVANCED_BOX)
    public WebElement advancedBox;

    @FindBy (id = CHECK_B0X_US_CITIZEN)
    public  WebElement checkBoxUSCitizen;

    @FindBy (id = CHECK_B0X_FIRST_TIME_HOME_BUYER)
    public  WebElement checkBoxFirstTimeHomeBuyer;


    //PDF DOWNLOAD
    @FindBy(css = NAV_BAR_BUY_OPTION)
    public  WebElement navBarBuyOption ;

    @FindBy(css = CHOOSE_A_LOAN)
    public  WebElement chooseALoan ;

    @FindBy(css = TERMS_AND_RATES)
    public  WebElement termsAndRates ;

    @FindBy(css = DOWN_PAYMENT)
    public  WebElement downPayment ;

    @FindBy(css = PRIVATE_MORTGAGE_INSURANCE)
    public  WebElement  privateMortgageInsurance;

    @FindBy(css = INVESTMENT_PDF)
    public  WebElement invertmentPdf ;


//    @FindBy(css = ROOT1)
//    public  WebElement  root1;
//
//    @FindBy(id = ROOT2)
//    public  WebElement  root2;
//
//    @FindBy(id = ROOT3)
//    public  WebElement  root3;

    @FindBy(id = INVESTMENT_DOWNLOAD_BUTTON)
    public  WebElement  investmentDownload;

    public void clickOnHomeLoans(){
        clickOnElement(homeLoan);
    }

    public void clickOnMortGageandHomeLoans(){
        clickOnElement(mortgageAndHomeLoans);
    }

    public void navigateToMortgageAndHomeLoans(){
        clickOnHomeLoans();
        waitForElementToBeVisible(dropDownMenu);
        clickOnMortGageandHomeLoans();
    }

    public void clickOnVideoPlayButton(){
        waitForElementToBeVisible(videoPlayButton);
        clickOnElement(videoPlayButton);
    }

    public void clickOnpurchaseRatesTabs(){
        clickOnElement(purchaseRatesTabs);
    }

    public String clickOnrefinanceRateTabs(){
        clickOnElement(refinanceRateTabs);
        return  refinanceRateTabs.getAttribute("aria-selected");

    }


    public void navigateToHomeValueEstimator(){
        clickOnElement(homeValueEstimator);

    }

    public void navigateToRatesANDpayments(){
        clickOnElement(estimateRatesPayments);
    }

    public void switchTIframeMortgageCalculator(){
        waitForElementToBeVisible(iframeMortgageCalculatorIframe);
        switchToIframe(iframeMortgageCalculatorIframe);
    }

    public void expandMortgageCalculatorAdvanced(){
        clickOnElement(advancedOptionOpenClose);
        waitForElementToBeVisible(advancedBox);
    }


    public String selectUSCitizen(){
       clickOnElement(checkBoxUSCitizen);
        return  checkBoxUSCitizen.getAttribute("aria-checked");
    }

    public String selectFirstTimeHomeBuyer() {
        clickOnElement(checkBoxFirstTimeHomeBuyer);
        return checkBoxFirstTimeHomeBuyer.getAttribute("aria-checked");
    }

    public String selectMultipleCheckBoxTellUSMoreAboutYou() {
        selectUSCitizen();
        selectFirstTimeHomeBuyer();

        String usCheckBox =  checkBoxUSCitizen.getAttribute("aria-checked");
        String firstTimeBuyer =  checkBoxFirstTimeHomeBuyer.getAttribute("aria-checked");

        if(usCheckBox.equals("true")  && (firstTimeBuyer.equals("true"))){
            return "true";
        }else{
            return "false";
        }
    }
    public WebElement getShadowRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }
    public void navigateToPrivateMortgageInsurancePDF() throws InterruptedException {
        clickOnElement(navBarBuyOption);
        clickOnElement(chooseALoan);
        clickOnElement(termsAndRates);
        clickOnElement(downPayment);
        clickOnElement(privateMortgageInsurance);
        clickOnElement(invertmentPdf);
        Thread.sleep(8000);
        Set<String> tabs = driver.getWindowHandles();
        System.out.println(tabs.size());
        String parentTab = driver.getWindowHandle();

        for (String child : tabs) {
            if (!parentTab.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                System.out.println("switch to child");
                WebElement root1 = driver.findElement(By.id(ROOT1));
                Thread.sleep(4000);
            }
        }
        System.out.println(driver.getCurrentUrl());

//        WebElement root1 = driver.findElement(By.id("viewer"));
//        WebElement shadowRoot1 = getShadowRootElement(root1);


        //   driver.switchTo().window(ROOT1);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement download = (WebElement) js.executeScript("return ");
//        waitForElementToBeVisible(download);

//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        WebElement resetPwdLink =  (WebElement) jse.executeScript(
//                "return document.querySelector('#viewer').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#downloads').shadowRoot.querySelector('#download').shadowRoot.querySelector('#icon > iron-icon')");
//
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", resetPwdLink);
      //  clickOnElement(download);


//        WebElement root1 = driver.findElement(By.id(ROOT1));
//        WebElement shadow_root1 = expand_shadow_element(root1);
//
//        WebElement root2 = shadow_root1.findElement(By.id(ROOT2));
//        WebElement shadow_root2 = expand_shadow_element(root2);
//
//        WebElement root3 = shadow_root2.findElement(By.id(ROOT3));
//        WebElement shadow_root3 = expand_shadow_element(root3);
////
////        WebElement root4 = shadow_root3.investmentDownload;
////        WebElement shadow_root4 = expand_shadow_element(root4);
////
////        WebElement search_term = shadow_root4.findElement(By.id(INVESTMENT_DOWNLOAD_BUTTON));
////        String js = "arguments[0].setAttribute('value','pdf')";
////        ((JavascriptExecutor) driver).executeScript(js, search_term);
//
//        WebElement search_button = shadow_root3.findElement(By.id(INVESTMENT_DOWNLOAD_BUTTON));
//        search_button.click();
//
//        System.out.println("Search Button Clicked");
//    }
//
//    public static WebElement expand_shadow_element(WebElement element)
//    {
//        WebElement shadow_root = (WebElement)((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
//        return shadow_root;
//    }

    }
    }
