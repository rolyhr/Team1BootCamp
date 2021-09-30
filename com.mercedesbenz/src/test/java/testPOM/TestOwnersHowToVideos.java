package testPOM;

import POM.OwnersHowToVideos;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testBase.TestBase;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static ownersVideoLocators.OwnersVideoLocators.*;

public class TestOwnersHowToVideos extends TestBase {

    @Test
    public void testVideoElements() throws ScriptException, NoSuchMethodException, InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        OwnersHowToVideos ohtv = new OwnersHowToVideos();
        ohtv.navigateToVideo();
//        ohtv.play();

        js.executeScript("arguments[0].onplay;", ohtv.videoID);
        Thread.sleep(5000);
        js.executeScript("arguments[0].onpause;", ohtv.videoID);
        Thread.sleep(3000);
        js.executeScript("arguments[0].play;", ohtv.videoID);
        Thread.sleep(5000);

//        js.executeScript("document.getElementById('player').onplay", );
//        Thread.sleep(5000);
//        js.executeScript("document.getElementById('player').pause()");
//        Thread.sleep(3000);
//        js.executeScript("document.getElementById('player').play()");
//        Thread.sleep(5000);
    }
}
