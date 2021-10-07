package POM;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static ownersVideoLocators.OwnersVideoLocators.*;

public class OwnersHowToVideos extends Base {

    public OwnersHowToVideos() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = VIDEO_OWNERS_SUPPORT_LINK)
    public WebElement videoOwnersSupportLink;

    @FindBy (css = VIDEO_VIEW_VIDEO_BUTTON)
    public WebElement videoViewVideoButton;

    @FindBy (css = VIDEO_APPLE_CARPLAY)
    public WebElement videoAppleCarplay;

    @FindBy (css = VIDEO_IFRAME)
    public WebElement videoIframe;

    @FindBy (css = VIDEO_ID)
    public WebElement videoID;

    @FindBy (css = PLAY_BUTTON)
    public WebElement playButton;

    public void navigateToVideo() {
        clickOnElement(videoOwnersSupportLink);
        clickOnElement(videoViewVideoButton);
        clickOnElement(videoAppleCarplay);
        WebElement video = explicitWait.until(ExpectedConditions.visibilityOf(videoIframe));
        String videoSrc = video.getAttribute("src");
        driver.navigate().to(videoSrc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void play() throws ScriptException, NoSuchMethodException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        String titleValue = (String) js.executeScript("function getAttributeValue() {\n" +
//                                                        "    const btn = document.querySelector('#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button');\n" +
//                                                        "    if (btn) {\n" +
//                                                        "            return btn.getAttribute('title');\n" +
//                                                        "    }\n" +
//                                                        "}" +
//                                                        "getAttributeValue();");
        String titleValue = driver.findElement(By.cssSelector(PLAY_BUTTON)).getAttribute("title");
        if (titleValue.equals("Play (k)")){
            driver.findElement(By.cssSelector(PLAY_BUTTON)).click();
        }
    }

//    public static void main(String[] args) throws ScriptException, NoSuchMethodException, ParseException {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//
//        String script1 = "function hello(name) {print ('Hello, ' + name);}";
//        engine.eval(script1);
//        Invocable inv = (Invocable) engine;
//        inv.invokeFunction("hello", "Roly");
//
//        String cssSelector = "#movie_player > div.ytp-chrome-bottom > div.ytp-chrome-controls > div.ytp-left-controls > button";
//        String titleValue = "function getAttributeValue(value) {\n" +
//                                "var btn = document.querySelector(value);\n" +
//                                    "if (btn) {\n" +
//                                        "return btn.getAttribute('title');\n" +
//                                    "}\n" +
//                            "}";
//        engine.eval(titleValue);
//        inv.invokeFunction("getAttributeValue", cssSelector);
//    }

}
