package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static POM.locators.ExperiencesLocators.*;

public class Experiences extends Base {
    public  Experiences(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = EXPERIENCES_TAB)
    public WebElement experienceTab;

    @FindBy(css = LIVE_ANYWHERE)
    public List<WebElement> liveAnywhere;

    @FindBy(css = DISCOVER_THINGS_TO_DO)
    public List<WebElement> discoverThingsTodo;

    @FindBy(css  = LOCATION)
    public WebElement location;

    @FindBy(css = DATE)
    public WebElement date;

    @FindBy(css = SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy(xpath = DATE_PICKER_PANEL)
    public WebElement datePickerPanel;

    @FindBy(xpath = DATE_PICKER_FIRST_MONTH)
    public  List<WebElement> datePickerfirstMonth;

    @FindBy(css = DATE_SELECTED)
    public WebElement dateSelected;

    @FindBy(xpath = PREVIOUS_MONTH)
    public WebElement previousMonth;

    @FindBy(xpath = NEXT_MONTH)
    public WebElement nextMonth;

    @FindBy(css = DATE_START_MONTH)
    public WebElement dateStartMonth;

    @FindBy(css = DATE_END_MONTH)
    public WebElement dateEndMonth;

    @FindBy(css = SEARCH_RESULT_DATE)
    public WebElement searchResultDate;

    @FindBy(css = SEARCH_RESULT_LOCATION)
    public WebElement searchResultLocation;

    @FindBy(css = LITTLE_SEARCH_BOX)
    public WebElement littleSearchBox;

    @FindBy(css = CROSS_BUTTON_LOCATION)
    public WebElement crossButtonLocation;

    @FindBy(css = CROSS_BUTTON_DATE)
    public WebElement crossButtonDate;
/************************************************/
    @FindBy(css = HOST_LANGUAGE)
    public WebElement hostLanguage;

    @FindBy(xpath = CHECK_BOX_LANGUAGE_NAME)
    public WebElement checkBoxLanguageName;

    @FindBy(xpath = DROP_DOWN_MENU)
    public WebElement dropDownMenu;

    @FindBy(xpath = SAVE_BUTTON)
    public WebElement saveButton;
    /************************************************/
    @FindBy(css = GUEST)
    public WebElement guest;

    @FindBy(css = SELECT_ADULT_INCREASE)
    public WebElement selectAdultIncrease;

    @FindBy(css = SELECT_ADULT_DECREASE)
    public WebElement selectAdultDecrease;

    @FindBy(css = TIME_OF_DAY)
    public WebElement timeOfTheDay;

    @FindBy(id = CHECKBOX_MORNING)
    public WebElement optionCheckBoxMorning;

    @FindBy(id = CHECKBOX_EVENING)
    public WebElement optionCheckBoxEvening;

    @FindBy(id = CHECKBOX_AFTERNOON)
    public WebElement  optionCheckBoxAfternoon;

    @FindBy(xpath = RESULT)
    public WebElement  result;
    /************************************************/
    @FindBy(css = FOOTER_CAREERS)
    public WebElement  footerCareers ;

    @FindBy(css = BUTTON_EXPLORE_JOBS)
    public WebElement  buttonExploreJobs ;

    @FindBy(css = TECHNICAL_ACCOUNTING_JOBS)
    public WebElement  technicalAccountingJobs;

    @FindBy(css = BUTTON_APPLY_NOW)
    public WebElement  buttonApplyNow;

    @FindBy(css = BUTTON_ATTACH_RESUME)
    public WebElement  buttonAttachResume;

    @FindBy(id = FILE_UPLOAD_RESUME)
    public WebElement  fileUploadResume;

    @FindBy(id = IFRAME_APPLY_NOW)
    public WebElement  iframeApplyNow;
    /************************************************/

    public void selectLanguageFromCheckBox(){
       clickOnElement(hostLanguage);
       waitForElementToBeVisible(dropDownMenu);
       clickOnElement(checkBoxLanguageName);
       clickOnElement(saveButton);
    }


    /*********************************************************/
    public void switchToExperienceTab(){
        clickJScript(experienceTab);
    }

    /*********************************************************/
    public List<String> getExploreLiveAnywhere(){
       return getListOfStringElements(liveAnywhere);
    }

    /*********************************************************/
    public List<String> getDicoverThingstodo(){
        return getListOfStringElements(discoverThingsTodo);
    }


    /*********************************************************/

    public String searchLocation(String searchLocation){
        location.sendKeys(searchLocation);
        clickJScript(searchButton);
        waitForElementToBeVisible(searchResultLocation);
        return searchResultLocation.getText();
    }

    /*********************************************************/
    public String searchDate(String startMonth, String endMonth, String startDate, String endDate){
        clickJScript(date);
        waitForElementToBeVisible(datePickerPanel);
        selectMonthByNextPrevious(dateStartMonth,nextMonth,startMonth);
        List<WebElement> datesFirst = getListOfWebElements(By.xpath(DATE_PICKER_FIRST_MONTH));
        selectDate( datesFirst ,dateStartMonth,startDate);
        List<WebElement> datesSecond= getListOfWebElements(By.xpath(DATE_PICKER_SECOND_MONTH));
        selectDate( datesSecond ,dateEndMonth,endDate);
        clickOnElement(searchButton);
        waitForElementToBeVisible(searchResultDate);

        return  searchResultDate.getText();
    }


    /*********************************************************/
    public List<String> searchExperience(String searchLocation,String startMonth, String endMonth, String startDate, String endDate) throws InterruptedException {

        location.sendKeys(searchLocation);
        clickJScript(date);

        waitForElementToBeVisible(datePickerPanel);
        selectMonthByNextPrevious(dateStartMonth,nextMonth,startMonth);

        List<WebElement> datesFirst = getListOfWebElements(By.xpath(DATE_PICKER_FIRST_MONTH));
        selectDate( datesFirst ,dateStartMonth,startDate);
        List<WebElement> datesSecond= getListOfWebElements(By.xpath(DATE_PICKER_SECOND_MONTH));
        selectDate( datesSecond ,dateEndMonth,endDate);

        clickJScript(searchButton);

        waitForElementToBeVisible(searchResultDate);

        List<String> searchResultList = new ArrayList<>();

        searchResultList.add(searchResultLocation.getText());
        searchResultList.add(searchResultDate.getText());

        return searchResultList;
    }
    /************************************************/

    public void clickLittleSearchBox() {
        clickJScript(littleSearchBox);
    }
    /************************************************/

    public void clearSearchBarLocation()  {
        fluentWait.until(ExpectedConditions.visibilityOf(location));
        clickOnElement(location);
        crossButtonLocation.click();
    }
    /************************************************/

    public void clearSearchBarDate()  {
        fluentWait.until(ExpectedConditions.visibilityOf(date));
        clickJScript(date);
        crossButtonDate.click();
    }

    /************************************************/

    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }


    /************************************************/

    public boolean selectAddNumberOfAdultGuest(int num) {
        clickOnElement(guest);
        waitForElementToBeVisible(dropDownMenu);
        boolean flag = clickMultipleTimeOnAddElement(selectAdultIncrease,num);
        return flag;
    }
    /************************************************/

    public boolean selectRemoveNumberOfAdultGuest(int num){
        selectAddNumberOfAdultGuest(num);
        int i = num-1;

        boolean flag = clickMultipleTimeOnRemoveElement(selectAdultDecrease,num);
//        boolean flag = false;
//        while (i>0){
//               clickOnElement(selectAdultDecrease);
//               flag = selectAdultIncrease.isEnabled();
//               i--;
//        }
        return flag;
    }

    /************************************************/

    public void clickOnTimeOfDayDropDown(){
        clickOnElement(timeOfTheDay);
        waitForElementToBeVisible(dropDownMenu);
    }

    public void selectCheckBoxMorning(){
        clickOnElement(optionCheckBoxMorning);
    }

    public void selectCheckBoxAfternoon(){
        clickOnElement(optionCheckBoxAfternoon);

    }

    public void selectCheckBoxEvening(){
        clickOnElement(optionCheckBoxEvening);

    }
    /************************************************/

    public void navigateToApplyJobsPage() {
        clickOnElement(footerCareers);
        clickOnElement(buttonExploreJobs);
        clickOnElement(technicalAccountingJobs);
        clickOnElement(buttonApplyNow);
    }

    public String uploadResume(String filePath){
        navigateToApplyJobsPage();
        switchToIframe(iframeApplyNow);
        waitForElementToBeVisible(buttonAttachResume);
        clickOnElement(buttonAttachResume);
        waitForElementToBeVisible(fileUploadResume);
        fileUploadResume.sendKeys(filePath);
        return fileUploadResume.getAttribute("value");
    }

}
