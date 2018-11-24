package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import automation.framework.Browser;
import automation.framework.WebDriverRunner;

import javax.inject.Inject;

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static automation.locators.Xpath.LOGO;

@RunWith(WebDriverRunner.class)
public class Logo_Test {

    @Inject
    private Browser browser;

    @Inject private URL baseUrl;


    @Test
     public void checkAmazonLogo() throws InterruptedException {
        browser.manage().window().maximize();
        browser.get(baseUrl + "/");
        String text = browser.await(LOGO).getText();
        assertEquals("Amazon", text);
    }


}
