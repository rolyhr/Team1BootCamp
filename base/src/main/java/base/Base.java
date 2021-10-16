package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
<<<<<<< HEAD
=======
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095

public class Base {

    public static WebDriver driver;
    public static Wait<WebDriver> fluentWait;
    public static WebDriverWait explicitWait;
    public static ExtentReports extent;
    public static ExcelReader excelReader;
    public static MySqlReader mySqlReader;
    private Properties properties;
    public Statement statement = null;
    public ResultSet resultSet = null;

    public final String systemPath = System.getProperty("user.dir");
    public final String PROP_RELATIVE_PATH = "\\src\\main\\resources\\credentials.properties";
    public final String EXCEL_RELATIVE_PATH = "\\src\\test\\resources\\TestData.xlsx";
    public final String PROP_FILE_PATH = systemPath + PROP_RELATIVE_PATH;
    public final String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteExtentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeSuite(alwaysRun = true)
    public void utilSetup() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(PROP_FILE_PATH);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            excelReader = new ExcelReader();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            mySqlReader = new MySqlReader();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public static void beforeEachMethodExtentInit(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();
        ExtentTestManager.startTest(methodName);
        ExtentTestManager.getTest().assignCategory(className);
        System.out.println("\n\t***" + methodName + "***\n");
    }

    @Parameters({"browser", "url"})
    @BeforeMethod (alwaysRun = true)
    public void driverSetup(@Optional("chrome") String browser, String url) {
        driver = initDriver(browser);

        explicitWait = new WebDriverWait(driver, 20);
        fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(StaleElementReferenceException.class);
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void extentFlush(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED: " + result.getName());
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
            captureScreenshot(driver, result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED: " + result.getName());
        }

        ExtentTestManager.endTest();
        extent.flush();
    }

    @AfterMethod
    public void driverClose() {
        driver.close();
        driver.quit();
    }

    @AfterSuite (alwaysRun = true)
    private void afterSuiteTearDown() {
        extent.close();
    }

    public WebDriver initDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
        return driver;
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    private static void captureScreenshot(WebDriver driver, String testName) {
        String fileName = testName + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File newScreenshotFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "main" + File.separator + "java" + File.separator + "reporting" + File.separator + fileName);
        try {
            FileHandler.copy(screenshot, newScreenshotFile);
            System.out.println("SCREENSHOT TAKEN");
        } catch (Exception e) {
            System.out.println("ERROR TAKING SCREENSHOT: " + e.getMessage());
        }
    }

    //HELPER METHODS FOR SELENIUM
    public void clickOnElement(WebElement element) {
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            clickJScript(element);
        }
    }

    public void clickJScript(WebElement element) { //helper method for clickOnElement()
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void sendKeysToElement(WebElement element, String value) {
        try {
            explicitWait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
        } catch (TimeoutException e) {
            explicitWait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(value);
        }
    }

    public boolean isButtonEnabled(WebElement element) {
        WebElement button = fluentWait.until(ExpectedConditions.visibilityOf(element));
        return button.isEnabled();
    }

    public void waitForElementToContainText(WebElement element, String text) {
        try {
            explicitWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hoverOverSubElement(WebElement mainMenu, WebElement subMenu) {
        Actions actions = new Actions(driver);

        WebElement mm = explicitWait.until(ExpectedConditions.visibilityOf(mainMenu));
        actions.moveToElement(mm).build().perform();

        WebElement sm = explicitWait.until(ExpectedConditions.visibilityOf(subMenu));
        actions.moveToElement(sm).click().build().perform();
    }
<<<<<<< HEAD

    public void mouseHover(WebElement element) {
        try {
            Actions hover = new Actions(driver);
            hover.moveToElement(element).perform();
        } catch (Exception ex) {
            driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            Actions hover = new Actions(driver);

            wait.until(ExpectedConditions.visibilityOf(element));
            hover.moveToElement(element).perform();
        }
    }

    public String readFromExcel(String sheetName, int index) {
=======
    //
    public String getStringFromExelSheet(String sheetName, int index) {
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
        String[] excelData = new String[index];
        try {
            excelData = excelReader.fileReaderStringXSSF(EXCEL_FILE_PATH, sheetName);
        } catch (IOException e) {
            System.out.println("UNABLE TO READ FROM EXCEL FILE!");
        }
        return Arrays.toString(new String[]{excelData[index]})
                     .replace("[", "")
                     .replace("]", "");
    }

    public String readFromExcel2D(String sheetName, int index1, int index2) {
        String[][] excelData = new String[index1][index2];
        try {
            excelData = excelReader.fileReaderArrayStringArraysXSSF(EXCEL_FILE_PATH, sheetName);
        } catch (IOException e) {
            System.out.println("UNABLE TO READ FROM EXCEL FILE!");
        }
        return Arrays.toString(new String[]{excelData[index1][index2]})
                .replace("[", "")
                .replace("]", "");
    }

    public String getDataFromMySQL(String query, String columnLabel) throws SQLException, IOException, ClassNotFoundException {
        mySqlReader = new MySqlReader();
        MySqlReader.loadProperties();
        statement = MySqlReader.connectToSqlDatabase().createStatement();
        resultSet = statement.executeQuery(query);
        resultSet.next();
        return resultSet.getString(columnLabel);
    }

    public WebElement safeFindElement(By by) {
        return driver.findElement(by);
    }

    public void dropdownSelectByVisibleText(WebElement element, String visibleText) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    //SYNC Method
    public void waitForElementToBeVisible(WebElement element) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

<<<<<<< HEAD
    //GET CURRENT DATE - FORMAT: September 12, 2020
    public String getDate() {
        String[] dateArray = new String[6];
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            Date todayWithZeroTime = formatter.parse(formatter.format(today));
            dateArray = todayWithZeroTime.toString().split(" ");
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return dateArray[1].trim() + " " + dateArray[2].trim() + ", " + dateArray[5].trim();
    }

    public void pickCalendarDate(WebElement monthYearElement, WebElement monPickerBtn, String month, int day) {
        while (true) {
            String extractMonthYear = explicitWait.until(ExpectedConditions.visibilityOf(monthYearElement)).getText().toLowerCase();
            String[] array = extractMonthYear.split(" ");
            String extractedMonth = array[0].trim();
            if (extractedMonth.equals(month.toLowerCase())) {
                break;
            } else {
                explicitWait.until(ExpectedConditions.elementToBeClickable(monPickerBtn)).click();
            }
        }
        WebElement exactDay = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(getCustomLocator(day))));
        exactDay.click();
    }


    //NEED TO MODIFY THIS getDay() HELPER METHOD BASED ON THE PROJECT REQUIREMENT
    //HELPER METHOD FOR pickCalendarDay()
    public String getCustomLocator(int day) {
        String locator = "";
        return locator;
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getListOfWebElementsByXpath(WebElement element, String locator) {
        return element.findElements(By.xpath(locator));
    } //DELETE THIS METHOD

    public static List<WebElement> getListOfWebElementsByCss(WebElement element, String locator) {
        return element.findElements(By.cssSelector(locator));
    } //DELETE THIS METHOD

    public void scrollToElementJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<String> getListItemsByCss(String cssSelector) {
        List<WebElement> menuItems = driver.findElements(By.cssSelector(cssSelector));
        List<String> element = new ArrayList<>();
        for (WebElement menuItem : menuItems) {
            element.add(menuItem.getText());
        }
        return element;
    }

    public List<String> getListItemsByXpath(String xpath) {
        List<WebElement> menuItems = driver.findElements(By.cssSelector(xpath));
        List<String> element = new ArrayList<>();
        for (WebElement menuItem : menuItems) {
            element.add(menuItem.getText());
        }
        return element;
=======
    //Synchronization method for Stale Element error.
    public void waitForElementToBeVisibleForStaleElement(WebElement element){
        boolean staleElement = true;

        while(staleElement){
            try{
                explicitWait.until(ExpectedConditions.visibilityOf(element));
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    //Helper Method: Check if an element is existed.
    public boolean isElementPresent(WebElement element){
        boolean flag = false;
        try{
            //explicitWait.until(ExpectedConditions.visibilityOf(element));
            fluentWait.until(ExpectedConditions.visibilityOf(element));
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't locate the element");
        }
        return flag;
    }

    public List<WebElement> getListOfADropDownMenu(By by){

        try {
            explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }catch(Exception e){
            e.printStackTrace();
        }
        return driver.findElements(by);
    }

    //Helper Method: Create a list of WebElements of a drop_down menu and test an element of
    //that list by truth of source then select that element.
    public void selectASubCategoryOfADropDownMenuByPassingTestData(By by, String category) {
        List<WebElement> listOfADropDownMenu = getListOfADropDownMenu(by);
        List<String > listOfTextOfSubCategory = new ArrayList<>();

        for(WebElement e : listOfADropDownMenu){
            listOfTextOfSubCategory.add(e.getText());
        }
        for(int i = 0; i < listOfTextOfSubCategory.size(); i++) {
            try {
                if (category.equalsIgnoreCase(listOfTextOfSubCategory.get(i))) {
                    listOfADropDownMenu.get(i).click();
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Unable to find the element");
            }
        }
    }

    //Helper Method:
    public boolean compareListsOfString(List<String> actual, List<String> expected) {
        boolean flag;

        int length = actual.size();
        int count = 0;

        for (int i = 0; i < length; i++) {
            String actualString = actual.get(i);
            String expString = expected.get(i);

            if (!actualString.trim().equalsIgnoreCase(expString)) {
                count++;
                System.out.println("***MISMATCH***");
                System.out.println("ACTUAL: " + actualString);
                System.out.println("EXPECTED: " + expString);
            }
        }
        if (count > 0) {
            flag = false;
        } else {
            flag = true;
        }
        return flag;
    }

    //Create List of String from a Div or Category
    public List<String> getStringListFromADiv(By by) {
        List<String> list = new ArrayList<>();
        List<WebElement> webElementList = driver.findElements(by);

        for (int i = 0; i < webElementList.size(); i++){
            list.add(i, webElementList.get(i).getText());
        }
        return list;
    }

    /* Synchronization method */
    public void pageScroll(int pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }

    //Helper Method
    public void mouseHoverOnAnElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    //Helper Method
    public void mouseHoverOnAnElementAndClick(WebElement element){
        Actions action = new Actions(driver);

        try {
            action.moveToElement(element).click().build().perform();
        }catch(NoSuchElementException e){
            System.out.println("Element Couldn't Found");
        }
    }

    //Helper Method
    public void switchToANewTabAndCloseParentTab(){

        String parentTab = driver.getWindowHandle();

        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> all = driver.getWindowHandles();

        for(String winHandle : driver.getWindowHandles())
        {
            if(winHandle.equals(parentTab))
            {
                //Condition satisfied. Switching to the parent tab and closing it
                driver.switchTo().window(winHandle);
                driver.close();
            }
        }
        all.remove(parentTab);

        for(String winHandle : all) {
            driver.switchTo().window(winHandle);
        }
    }
    //Helper Method
    public void sendKeysToElementAndClearDefaultValue(WebElement element, String value){
        try {
            String s = Keys.chord(Keys.COMMAND, "a");
            element.click();
            element.sendKeys(s);
            element.sendKeys(Keys.DELETE);
            //element.clear();
            element.sendKeys(value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKeysToElementThatHasDefaultValue(WebElement element, String attValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', arguments[1]);",element, attValue);
    }

    //Helper method
    public void switchToiFrame(String ID){
        driver.switchTo().frame(ID);
    }

    public void switchToiFrame(WebElement webElement){
        driver.switchTo().frame(webElement);
    }

    public void dropdownSelectByVisibleTextHasDefaultValueSelected(WebElement element, String visibleText) {
        //explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
>>>>>>> 02591dc3b88a0272a76144e9d5109a19c585a095
    }

}
