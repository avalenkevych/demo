package pages.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.framework.Browser;
import pages.framework.Element;
import pages.framework.WebDriverRunner;

import javax.inject.Inject;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static pages.locators.Xpath.LOGO;

@RunWith(WebDriverRunner.class)
public class framework_test1 {

    @Inject
    private Browser browser;

    @Inject private URL baseUrl;


    @Test
     public void explicitWait() throws InterruptedException {
        browser.manage().window().maximize();
        browser.get(baseUrl + "/");
        String text = browser.await(LOGO).getText();
        assertEquals("Amazon", text);
    }


}
