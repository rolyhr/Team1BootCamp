package testPOM;

import POM.OwnersHowToVideos;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static ownersVideoLocators.OwnersVideoLocators.*;

public class TestOwnersHowToVideos extends TestBase {

    @Test (description = "TC001VP", priority = 1, enabled = false)
    public void testPlayButton() {
        OwnersHowToVideos ohtv = new OwnersHowToVideos();
        String actualResult = ohtv.playButton();
        String expectedResult = readFromExcel("AssertionResult", 0);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC001VP");
    }

    @Test (description = "TC002VP", priority = 1, enabled = false)
    public void testPauseButton() {
        OwnersHowToVideos ohtv = new OwnersHowToVideos();
        String actualResult = ohtv.pauseButton();
        String expectedResult = readFromExcel("AssertionResult", 1);
        Assert.assertEquals(actualResult, expectedResult, "FAILED, TC002VP");
    }
}
