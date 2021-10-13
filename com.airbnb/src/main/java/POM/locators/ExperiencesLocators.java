package POM.locators;

import org.openqa.selenium.support.PageFactory;

public class ExperiencesLocators {
    public static  final String EXPERIENCES_TAB = "search-block-tab-true-EXPERIENCES";//ID
    public static  final String LIVE_ANYWHERE = "#site-content > div > div > div:nth-child(2)  ul li span";//css #site-content > div:nth-child(3) div:nth-child(2)  ul li  span
    public static  final String DISCOVER_THINGS_TO_DO = "#site-content div:nth-child(5) ul li div._mm89b9  span";//css

    public static final String LOCATION = "div input[name='query']";//css
    public static final String DATE = " div._37ivfdq[role='button']";//css
    public  static final String SEARCH_BUTTON = "div._w64aej > button";//css


    public static final String DATE_PICKER_PANEL ="//div[@aria-label='Calendar']";//XPATH
    public static final String DATE_PICKER_FIRST_MONTH = "//section/div/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr/td/div/div/div";//XPATH
    public static final String DATE_PICKER_SECOND_MONTH = "//section/div/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr/td/div/div/div";//XPATH
    public static final String DATE_SELECTED = "div._p4vcro6";//CSS
    public static final String DATE_START_MONTH = "div._14676s3 > div._1foj6yps  div:nth-child(2)  h2";//CSS
    public static final String DATE_END_MONTH = "div._14676s3 > div._1foj6yps  div:nth-child(3)  h2";//CSS
    public static final String PREVIOUS_MONTH = "//button[@aria-label='Previous']"; //XPATH
    public static final String NEXT_MONTH = "//button[@aria-label='Next']";//XPATH


    public static final String SEARCH_RESULT_LOCATION = "div._gy80z6f > div > button:nth-child(2) > div";//CSS
    public static final String SEARCH_RESULT_DATE = " div._gy80z6f > div > button:nth-child(4) > div._1g5ss3l";//CSS

    public static  final  String LITTLE_SEARCH_BOX = "button:nth-child(4) > div._i8zuk7[data-testid='little-search-icon']";//css
    public  static  final String CROSS_BUTTON_LOCATION = "div._1x4oe4n > div > button";//CSS
    public  static  final String CROSS_BUTTON_DATE = "div._1ccj0azg > div > button";//css

    public  static  final  String HOST_LANGUAGE = "button._1aov7ci[aria-label='Language offered']";//css
    public  static  final  String CHECK_BOX_LANGUAGE_NAME = "//input[@name='English']";//XPATH
    public  static  final  String DROP_DOWN_MENU = "//div[@role='menu']";//XPATH
    public  static  final  String SAVE_BUTTON = "//*[@id='filter-panel-save-button']";//XPATH


    public  static  final  String GUEST = "button[aria-label*='Guests']";//css
    public  static  final  String SELECT_ADULT_INCREASE= "#filterItem-guest_picker-stepper-adults-0 > button:nth-child(3)";//CSS
    public  static  final  String SELECT_ADULT_DECREASE = "#filterItem-guest_picker-stepper-adults-0 > button:nth-child(1)";//CSS

    public  static  final  String TIME_OF_DAY = "button[aria-label*='Time of day']";//css
    public  static  final  String CHECKBOX_MORNING= "filterItem-experience_time_of_day-checkbox-experience_time_of_day-morning-row-checkbox";//ID
    public  static  final  String CHECKBOX_AFTERNOON = "filterItem-experience_time_of_day-checkbox-experience_time_of_day-afternoon-row-checkbox";//ID
    public  static  final  String CHECKBOX_EVENING = "filterItem-experience_time_of_day-checkbox-experience_time_of_day-evening-row-checkbox";//ID
    public  static  final  String RESULT = "//*[@id='site-content']/div[1]/div/div/div/div/div/section/h1";//Css

    public  static  final  String FOOTER_CAREERS = "a[href*='careers']";//CSS
    public  static  final  String BUTTON_EXPLORE_JOBS = "#main a[href*='jobs'] ";//CSS
    public  static  final  String TECHNICAL_ACCOUNTING_JOBS = "div.col-xs-12.col-md-6.col-md-offset-6.jobs-board__positions-wrapper > div > ul > li:nth-child(1)  > a";//CSS
    public  static  final  String BUTTON_APPLY_NOW = "div.page-positions__btn-wrap > button";//CSS
    public  static  final  String BUTTON_ATTACH_RESUME = "#main_fields > div:nth-child(11) > div > div.link-container > a:nth-child(1)";//CSS
    public  static  final  String FILE_UPLOAD_RESUME = "resume_file";//CSS
    public static final String IFRAME_APPLY_NOW = "grnhse_iframe";

}
