package testPOM;

import POM.Homepage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class TestHomepage extends TestBase {

    @Test
    public void testDownloadFile() throws InterruptedException {
        Homepage homepage = new Homepage();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        Set<String> tabs = driver.getWindowHandles();
        System.out.println(tabs.size());
        String parentTab = driver.getWindowHandle();

        tabs.add((String) js.executeScript("document.querySelector('#jsEnabled > section.footnotes-block > section > div > div.col-12.everyday-toggle > p:nth-child(2) > a').click();"));
        tabs.add((String) js.executeScript("document.querySelector('#jsEnabled > section.footnotes-block > section > div > div.col-12.everyday-toggle > p:nth-child(2) > a').click();"));
        tabs.add((String) js.executeScript("document.querySelector('#jsEnabled > section.footnotes-block > section > div > div.col-12.everyday-toggle > p:nth-child(2) > a').click();"));
        tabs.add((String) js.executeScript("document.querySelector('#jsEnabled > section.footnotes-block > section > div > div.col-12.everyday-toggle > p:nth-child(2) > a').click();"));
        System.out.println(tabs.size());
        System.out.println(tabs);
//        WebElement downloadElement = (WebElement)js.executeScript("document.querySelector('pdf-viewer').shadowRoot.querySelector('viewer-toolbar').shadowRoot.querySelector('div#toolbar div#end viewer-download-controls#downloads').shadowRoot.querySelector('cr-icon-button#download');");
//        downloadElement.click();
    }
}
