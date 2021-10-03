package bmwlocators;

public class LoginLocators {

    //LOGIN
    public static final String MY_BMW_LINK = "div.globalnav-container div.globalnav-primary-my-bmw > div.globalnav-primary-my-bmw__portal-holder > a";
    public static final String LOGIN_EMAIL_ADDRESS_INPUT = "#loginEmailAddressInput";
    public static final String LOGIN_PASSWORD_INPUT = "#loginPasswordInput";
    public static final String REMEMBER_ME_CHECKBOX = "#loginRememberMeCheckbox-input";
    public static final String LOGIN_BUTTON = "#loginBtn";
    public static final String FORGOT_YOUR_PASSWORD_LINK = "#forgotPasswordBtn";
    public static final String REGISTER_NOW_LINK = "#registerNowBtn";
    public static final String NEED_HELP_LINK = "#needHelpBtn";
    public static final String FAQ_TEXT_VALIDATION = "div.ngd-container div.main-app-title-container > app-title > h1";
    public static final String MY_BMW_TEXT_VALIDATION = "#navbar > div div.sub-head-title > div.title";
    public static final String LOGIN_PAGE_VALIDATION_MSG = "#loginTitle";

    //AFTER LOGGED IN
    public static final String AFTER_LOGIN_MY_BMW_LINK = "div.globalnav-container div.globalnav-primary-my-bmw--logged-in div > button";
    public static final String AFTER_LOGIN_UP_ARROW = "#navbar > div > app-sub-nav-header > div > div:nth-child(2) > a";
    public static final String LOGOUT_LINK = "div.globalnav-primary-my-bmw__profile-dropdown.globalnav-primary-my-bmw--dropdown-active > div > nav > a";
    //WARNINGS
    public static final String WARNING_INVALID_EMAIL = "#emailErrorMsg";
    public static final String WARNING_INVALID_PASSWORD = "#passwordRequiredMsg";
    public static final String WARNING_INVALID_EMAIL_PASSWORD = "#errorMessage";

}
