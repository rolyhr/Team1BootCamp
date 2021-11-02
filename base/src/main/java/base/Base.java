package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Base {

    /**
     * <p>This {@link Base} class is a member of the <a href="{@docRoot}/src/main/java/base/Base.java">
     * HR Framework</a>.
     *
     * @author  Roly Hr
     * @see     Collections
     * @see     ArrayList
     * @see     String
     * @see     Character
     * @version 1.0
     */

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
        explicitWait = new WebDriverWait(driver, 10);
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
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

    /**
     * <p>HELPER METHODS FOR SELENIUM</p>
     * @version 1.0
     */
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

    public void hoverOverElement(WebElement mainMenu, WebElement subMenu) {
        Actions actions = new Actions(driver);

        WebElement mm = explicitWait.until(ExpectedConditions.visibilityOf(mainMenu));
        actions.moveToElement(mm).build().perform();

        WebElement sm = explicitWait.until(ExpectedConditions.visibilityOf(subMenu));
        actions.moveToElement(sm).click().build().perform();
    }

    public void mouseHoverOnly(WebElement element) {
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
    }

    /*
     * This Method will click on link that opens new tab, then get the text of an element, close
     * the new tab and switch back to parent window.
     */
    public String switchTabGetPageNameCloseTab(WebElement newWindowLink,
                                               WebElement pageName,
                                               String pageTitle) {
        String name = "";
        String parentWindow = driver.getWindowHandle();
        clickOnElement(newWindowLink);
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            String title = driver.switchTo().window(tab).getTitle();
            if (title.equals(pageTitle)) {
                name = explicitWait.until(ExpectedConditions.visibilityOf(pageName)).getText();
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        return name;
    }

    public void switchToiFrame(WebElement element) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        driver.switchTo().frame(element);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }


    // ########################################################################################
    // Sami's Helper Methods


    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }

    public void typeOnInputField(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value);
        } catch (Exception ex) {
            driver.findElement(By.id(locator)).sendKeys(value);
        }

    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssNEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKeys(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }

    public static List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public static List<String> getTextFromWebElements(String locator, WebDriver driver1) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver1.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    public List<WebElement> getListOfWebElementsByTagName(WebElement element, String tagName) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = element.findElements(By.tagName(tagName));
        return list;
    }

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public String getTextByCss(String locator) {
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }

    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }

    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }

    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    public static void mouseHover(WebElement element) {
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

    //handling Alert
    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    //get Links
    public void getLinks(String locator) {
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //Synchronization
    public void waitUntilClickAble(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilSelectable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public void clearInput(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void keysInput(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //Handling New Tabs
    public static WebDriver handleNewTab(WebDriver driver1) {
        String oldTab = driver1.getWindowHandle();
        List<String> newTabs = new ArrayList<String>(driver1.getWindowHandles());
        newTabs.remove(oldTab);
        driver1.switchTo().window(newTabs.get(0));
        return driver1;
    }

    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        return driver1.findElement(By.cssSelector(locator)).isDisplayed();
    }

    public void typeOnInputBox(String locator, String value) {
        try {
            driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            System.out.println("ID locator didn't work");
        }
        try {
            driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex2) {
            System.out.println("Name locator didn't work");
        }
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex3) {
            System.out.println("CSS locator didn't work");
        }
    }


    // Custom-made Helper Methods for Amex.com
    public void brokenLink() throws IOException {
        //Step:1-->Get the list of all the links and images
        List<WebElement> linkslist = driver.findElements(By.tagName("a"));
        linkslist.addAll(driver.findElements(By.tagName("img")));

        System.out.println("Total number of links and images--------->>> " + linkslist.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();
        //Step:2-->Iterate linksList: exclude all links/images which does not have any href attribute
        for (int i = 0; i < linkslist.size(); i++) {
            //System.out.println(linkslist.get(i).getAttribute("href"));
            if (linkslist.get(i).getAttribute("href") != null && (!linkslist.get(i).getAttribute("href").contains("javascript") && (!linkslist.get(i).getAttribute("href").contains("mailto")))) {
                activeLinks.add(linkslist.get(i));
            }
        }
        System.out.println("Total number of active links and images-------->>> " + activeLinks.size());

        //Step:3--> Check the href url, with http connection api
        for (int j = 0; j < activeLinks.size(); j++) {

            HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();

            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href") + "--------->>> " + response);
        }
    }

    public void inputValueInTextBoxByWebElement(WebElement webElement, String value) {
        webElement.sendKeys(value + Keys.ENTER);
    }

    public void clearInputBox(WebElement webElement) {
        webElement.clear();
    }

    public String getTextByWebElement(WebElement webElement) {
        return webElement.getText();
    }

    public static void mouseHoverJScript(WebElement element) {
        try {
            if (isElementPresent(element)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript, element);
                System.out.println("Hover performed\n");
            } else {
                System.out.println("UNABLE TO HOVER OVER ELEMENT\n");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("ELEMENT WITH " + element
                    + " IS NOT ATTACHED TO THE PAGE DOCUMENT"
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("ELEMENT " + element + " WAS NOT FOUND IN DOM"
                    + e.getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR OCCURED WHILE HOVERING\n"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

    /**
     * Helper Methods To Use in Asserts
     *
     * @author Sami Sheikh
     */
    // Hover over dropdown and make sure it is visible (built-in page refresh)
    public void hoverOverDropdown(WebElement elementToHover) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elementToHover));

        try {
            Thread.sleep(1000);
            mouseHover(elementToHover);
            System.out.println("Hovered over dropdown\n");
        } catch (InterruptedException e) {
            try {
                driver.navigate().refresh();
                System.out.println("Couldn't hover over dropdown --- Refreshing page\n");

                wait.until(ExpectedConditions.visibilityOf(elementToHover));
                Thread.sleep(1000);

                mouseHoverJScript(elementToHover);
            } catch (Exception e1) {
                e.getMessage();
            }
        }
    }

    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
    public static boolean compareWebElementListToExpectedStringArray(By by, String path, String sheetName) throws IOException {
        List<WebElement> actualList = driver.findElements(by);
        String[] expectedList = excelReader.fileReaderStringXSSF(path, sheetName);

        String[] actual = new String[actualList.size()];

        for (int j = 0; j<actualList.size(); j++) {
            actual[j] = actualList.get(j).getText().replaceAll("&amp;", "&").replaceAll("’", "'").trim();
            actual[j].replaceAll("&amp;", "&").replaceAll("’", "'").trim();
//            escapeHtml4(actual[j]);
//            escapeHtml3(actual[j]);
        }

        int falseCount = 0;
        boolean flag = false;
        for (int i = 0; i < expectedList.length; i++) {
            if (actual[i].equalsIgnoreCase(expectedList[i])) {
                flag = true;
                System.out.println("ACTUAL STRING " + (i + 1) + ": " + actual[i]);
                System.out.println("EXPECTED STRING " + (i + 1) + ": " + expectedList[i] + "\n");
            } else {
                System.out.println("***FAILED AT INDEX " + (i + 1) + "***\nEXPECTED STRING: " + expectedList[i] +
                        "\nACTUAL STRING: " + actual[i] + "\n");
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }

    // Gets text from String[] and compares against expected String array from Excel workbook
    public static boolean compareTextListToExpectedStringArray(String[] actualArray, String path, String sheetName) throws IOException {
        String[] expectedList = excelReader.fileReaderStringXSSF(path, sheetName);

        int falseCount = 0;
        boolean flag = false;
        for (int i = 0; i < expectedList.length; i++) {
            if (actualArray[i].replaceAll("&amp;", "&").replaceAll("’", "'").trim().equalsIgnoreCase(expectedList[i])) {
                flag = true;
                System.out.println("ACTUAL " + (i + 1) + ": " + actualArray[i]);
                System.out.println("EXPECTED " + (i + 1) + ": " + expectedList[i] + "\n");
            } else {
                System.out.println("FAILED AT INDEX " + (i + 1) + "\nEXPECTED STRING: " + expectedList[i] + "\nACTUAL STRING: "
                        + actualArray[i]);
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }

    // Compares actual string against an expected string from Excel workbook
    public static boolean compareTextToExpectedString(String actual, String path, String sheetName) throws IOException {
        String[] expectedArray = excelReader.fileReaderStringXSSF(path, sheetName);
        String expected = expectedArray[0];

        boolean flag;
        if (actual.replaceAll("&amp;", "&").replaceAll("’", "'").trim().equalsIgnoreCase(expected)) {
            flag = true;
            System.out.println("ACTUAL STRING: " + actual + "\nEXPECTED STRING: " + expected);
        } else {
            flag = false;
            System.out.println("***DOES NOT MATCH***\nEXPECTED STRING: " + expected + "\nACTUAL STRING: " + actual);
        }
        return flag;
    }

    // Gets text from List<WebElements> and compares against expected String array from Excel workbook
    public static boolean compareAttributeListToExpectedStringArray(By by, String attribute, String path, String sheetName) throws IOException {
        List<WebElement> actualList = driver.findElements(by);
        String[] expectedList = excelReader.fileReaderStringXSSF(path, sheetName);

        String[] actual = new String[actualList.size()];

        for (int j = 0; j<actualList.size(); j++) {
            actual[j] = actualList.get(j).getAttribute(attribute).replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
            actual[j].replaceAll("&amp;", "&").replaceAll("’", "'").replaceAll("<br>", "\n").trim();
//            escapeHtml4(actual[j]);
//            escapeHtml3(actual[j]);
        }

        int falseCount = 0;
        boolean flag = false;
        for (int i = 0; i < expectedList.length; i++) {
            if (actual[i].equalsIgnoreCase(expectedList[i])) {
                flag = true;
                System.out.println("ACTUAL " + attribute.toUpperCase() + " " + (i + 1) + ": " + actual[i]);
                System.out.println("EXPECTED " + attribute.toUpperCase() + " " + (i + 1) + ": " + expectedList[i] + "\n");
            } else {
                System.out.println("FAILED AT INDEX " + (i+1) + "\nEXPECTED " + attribute.toUpperCase() + ": " + expectedList[i] +
                        "\nACTUAL " + attribute.toUpperCase() + ": " + actual[i] + "\n");
                falseCount++;
            }
        }
        if (falseCount > 0) {
            flag = false;
        }
        return flag;
    }

    public static boolean compareListSizeToExpectedCount(By by, String path, String sheetName) throws IOException {
        int[] expectedArray = excelReader.fileReaderIntegerXSSF(path, sheetName);
        int expected = expectedArray[0];

        List<WebElement> dropdownList = driver.findElements(by);
        int actual = dropdownList.size();
        System.out.println("Counted " + actual + " elements\n");

        boolean flag;
        if (actual == expected) {
            flag = true;
            System.out.println("ACTUAL COUNT: " + actual + "\nEXPECTED COUNT: " + expected);
        } else {
            flag = false;
            System.out.println("***SIZE DOES NOT MATCH***\nACTUAL COUNT: " + actual + "\nEXPECTED COUNT: " + expected + "\n");
        }
        return flag;
    }


    // Switches to newly opened tab, gets URL, closes new tab, switches back to parent tab
    public static String switchToTabAndGetURL() {
        java.util.Iterator<String> iter = driver.getWindowHandles().iterator();

        String parentWindow = iter.next();
        String childWindow = iter.next();

        driver.switchTo().window(childWindow);
        System.out.println("Switched to \"" + driver.getTitle() + "\" window");
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL + "\n");
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to \"" + driver.getTitle() + "\" window");
        System.out.println(driver.getCurrentUrl() + "\n");

        return actualURL;
    }

    // Switches to newly opened tab, gets URL and compares to expected URL in Excel workbook
    public static boolean switchToTabAndCompareURL(String path, String sheetName) throws IOException {
        java.util.Iterator<String> iter = driver.getWindowHandles().iterator();

        String parentWindow = iter.next();
        String childWindow = iter.next();

        driver.switchTo().window(childWindow);
        System.out.println("Switched to \"" + driver.getTitle() + "\" window");
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL + "\n");
        driver.close();

        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to \"" + driver.getTitle() + "\" window");
        System.out.println(driver.getCurrentUrl() + "\n");

        boolean flag = compareTextToExpectedString(actualURL, path, sheetName);

        return flag;
    }

    // Loops through list of dropdown elements, clicks on each link individually, grabs each page URL, inserts into String[],
    // closes child page & switches back to parent page
    //
    // Compares String[] to expected URLs in Excel workbook
    public static boolean clickLinksSwitchTabsCompareURLs(WebElement hoverElement, By by, String path, String sheetName) throws InterruptedException, IOException {
        Wait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        List<WebElement> list = driver.findElements(by);
        int listSize = list.size();
        String[] actualURLs = new String[listSize];

        int i = 0;
        for (WebElement element : list) {
            if (hoverElement.isEnabled()) {
                fluentWait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(Keys.CONTROL, Keys.ENTER);
                Thread.sleep(800);
                actualURLs[i] = switchToTabAndGetURL();
            } else if (!(hoverElement.isEnabled())){
                try {
                    mouseHoverJScript(hoverElement);
                } catch (Exception e){
                    mouseHover(hoverElement);
                }
                fluentWait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(Keys.CONTROL, Keys.ENTER);
                Thread.sleep(800);
                actualURLs[i] = switchToTabAndGetURL();
            }
            i++;
        }
        return compareTextListToExpectedStringArray(actualURLs, path, sheetName);
    }

}
