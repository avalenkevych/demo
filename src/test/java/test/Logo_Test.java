package test;


import automation.pages.HomePage;
import org.junit.Before;
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

    @Before
    public void setUp(){
        browser.get(baseUrl + "/");
        browser.manage().window().maximize();
    }


    @Test
     public void checkAmazonLogo()  {
        assertEquals("Amazon", browser.await(LOGO).getText());


    }



}
