package POM.locators;

public class HomeLoansLocators {
public static final String H0ME_LOAN ="nav.header-navigation__secondary--menu a[data-id='product-3']";//css
    public static final String DROP_DOWN ="//*[@id='product-3']";//xpath

    public static final String MORTGAGE_AND_H0ME_LOAN ="#product-3 > ul > li.header-navigation__dropdown--first-link";//css
    public static final  String VEDIO_PLAY_BUTTON = "//*[@id='Module7']/section//a[@role='button']";//XPATH

    public static final  String REFINANCE_RATES_TABS = "tabs__list--item-link-2";//ID
    public static final  String PURCHASE_RATES_TABS = "tabs__list--item-link-2";//ID

    public  static  final  String HOME_VALUE_ESTIMATOR = "//*[@id='Module5'] //a[contains(@href,'home-value-estimator')]";//XPATH
    public  static  final  String ESTIMATE_RATE_PAYMENTS = "//*[@id='Module4'] //a[contains(@href,'mortgage-calculator')]";//XPATH

    public static final  String IFRAME_MORTGAGE_CALCULATOR = "#Module2 > div > div > div > iframe";//CSS

    public static final  String DROP_DOWN_MENU_LOAN_TYPE = "//*[@aria-label='What type of loan are you looking for?']";//XPATH
    public static final  String TEXT_BOX_HOME_PRICE = " div.sb-material-wrapper  input[aria-label*='Home Price ']";//CSS
    public static final  String TEXT_BOX_DOWN_PAYMENT_PERCENTAGE = "div.sb-material-wrapper  input[aria-label*='Down payment percentage']";//CSS
    public static final  String TEXT_BOX_DOWN_PAYMENT_PRICE = "div.sb-material-wrapper  input[aria-label*='Down payment price']";//CSS
    public static final  String TEXT_BOX_PROPERTY_ZIP_CODE = "//*[@aria-label='Property ZIP code']";//XPATH
    public static final  String DROP_DOWN_MENU_CREDIT_SCORE = "//*[@aria-label='Credit score']";//XPATH
    public static final  String DROP_DOWN_MENU_IMPORTANT_THING_TO_CHOOSE_LOAN = "//*[@aria-label='Choose one']";//XPATH

    public static final  String ADVANCED_OPTION_OPEN_CLOSE = "openAdvanceBtn";//ID
    public static final  String ADVANCED_BOX = "div.sb-advance-block.sb-open";//CSS

    public static final  String CHECK_B0X_US_CITIZEN = "us_citizen";//ID
    public static final  String CHECK_B0X_FIRST_TIME_HOME_BUYER = "first_time_home_buyer";//ID
    public static final  String DROP_DOWN_MENU_TYPE_OF_PROPERTY = "#advanceFormContent select[aria-label='Type of property']";//CSS
    public static final  String DROP_DOWN_MENU_HOW_YOU_USE_PROPERTY = "#advanceFormContent  select[aria-label='How do you plan to use the home?']";//CSS
    public static final  String TEXT_BOX_ANNUAL_PROPERTY_TAX = "#advanceFormContent  input[aria-label='Annual property taxes']";//CSS
    public static final  String TEXT_BOX_MONTHLY_HOMEOWNER_INSURANCE = "#advanceFormContent  input[aria-label='Monthly homeowners insurance']";//css
    public static final  String MONTHLEY_HOME_OWNER_ASSOSIATE_FEES = "#advanceFormContent  input[aria-label='Monthly Home Owners Association fees']";//css

    //download
    public static final String NAV_BAR_BUY_OPTION = "#SubHeaderOriginal a[href*='mortgage-purchase']";//xpath
    public static final String CHOOSE_A_LOAN = "div.fpo-content > a[href*='choose-a-loan']";//xpath
    public static final String TERMS_AND_RATES = "div.module-bucket--tile__desc a[href*='terms-and-rates']";//xpath
    public static final String DOWN_PAYMENT = "div.col--control__body--tile-section--desc   a[href*='down-payment']";//CSS
    public static final String PRIVATE_MORTGAGE_INSURANCE = "div.col--control__body--tile-section--desc   a[href*='mortgage-insurance']";//CSS
    public static final String INVESTMENT_PDF = " a[href*='investment-primary-res.pdf']";//CSS

    public static final String ROOT1 = "viewer";//id
    public static final String ROOT2 = "toolbar";//id
    public static final String ROOT3 = "end";//id
    public static final String INVESTMENT_DOWNLOAD_BUTTON = "download";//id
    public static final String INVESTMENT_TAB = "viewer";

    public static final  String DOWNLOAD_BUTTON = "document.querySelector('pdf-viewer').shadowRoot.querySelector('viewer-toolbar').shadowRoot.querySelector('viewer-download-controls').shadowRoot.querySelector('cr-icon-button')";

}
