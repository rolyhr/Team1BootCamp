package loginLocators;

public class SignUpLocators {

    //REGISTRATION FORM LOCATORS
    public final static String HOME_PAGE_LOGIN_BUTTON = "#cbs-site-nav > div > div.site-nav-side > ul > li.nav-side-item.log-in-item > a";
    public final static String SIGN_UP_LINK = "#uRegContainer > div > div.help-links > div:nth-child(2) > a";
    public final static String EMAIL_INPUT = "#email";
    public final static String PASSWORD_INPUT = "#password";
    public final static String RE_ENTER_PASSWORD_INPUT = "#password2";
    public final static String FIRST_NAME_INPUT = "#firstname";
    public final static String LAST_NAME_INPUT = "#lastname";
    public final static String MONTH_INPUT = "#birthdate_month";
    public final static String DAY_INPUT = "#birthdate_day";
    public final static String YEAR_INPUT = "#birthdate_year";
    public final static String ZIP_CODE_INPUT = "#zip";
    public final static String NEWSLETTER_CHECKBOX1 = "#newsletter_cbssports";
    public final static String NEWSLETTER_CHECKBOX2 = "#newsletter_sportsline";
    public final static String TERMS_CHECKBOX = "#privacy_policy_optin";
    public final static String REGISTER_BUTTON = "#user_data > div.formLayout > div.mTop10 > input[type=submit]";

    //WARNINGS
    public final static String WARNING_REGISTRATION_SUCCESS = "#uRegContainer > div > div.registration-confirmation.thank-you > div:nth-child(1) > div > div:nth-child(2)";
    public final static String WARNING_EMAIL = "#row_email > div > div.fieldError";
    public final static String WARNING_PASSWORD = "#row_password > div > div.fieldError";
    public final static String WARNING_PASSWORD_NOT_MATCH = "#row_password2 > div > div.fieldError";
    public final static String WARNING_TOS = "#cell_privacy_policy_optin > div.fieldError";

}
