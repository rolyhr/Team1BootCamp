package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentManager;
import reporting.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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
    private final String PROP_RELATIVE_PATH = "/src/main/resources/credentials.properties";
    private final String EXCEL_RELATIVE_PATH = "/src/test/resources/TestData.xlsx";
    private final String PROP_FILE_PATH = systemPath + PROP_RELATIVE_PATH;
    private final String EXCEL_FILE_PATH = systemPath + EXCEL_RELATIVE_PATH;

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
    }

    @AfterSuite (alwaysRun = true)
    private void afterSuiteTearDown() {
        driver.quit();
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

    //captureScreenshot() Method Needs To Be Debugged
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
            e.printStackTrace();
            System.out.println("UNABLE TO CLICK ON ELEMENT");
        }
    }

    public void sendKeysToElement(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (TimeoutException e) {
            element.sendKeys(value);
        }
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

    public void sendKeysToInput(WebElement element, String keys) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(keys);
    }

    public void dropdownSelectByVisibleText(WebElement element, String visibleText) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void clickJScript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    //SYNC Methods
    public void waitForElementToBeVisible(WebElement element) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementPresent(WebElement element){
        boolean flag = false;
        try{
            explicitWait.until(ExpectedConditions.visibilityOf(element));
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Can't locate the element");
        }
        return flag;
    }



}
