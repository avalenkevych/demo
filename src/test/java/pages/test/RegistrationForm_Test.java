package pages.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.framework.Browser;
import pages.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import static pages.locators.Xpath.*;

@RunWith(WebDriverRunner.class)
public class RegistrationForm_Test {
    @Inject
    private Browser driver;
    @Inject
    private URL baseUrl;

    @Before
    public void goToRegPage(){
        driver.manage().window().maximize();
        driver.get(baseUrl + "/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
    }

    @Test
    public void checkRegistration(){
        driver.setInputText(USERNAME, "qwerty1234@doe.co,");
        driver.setInputText(EMAIL, "qwerty1234@doe.com");
        driver.setInputText(PASSWORD, "secret");
        driver.setInputText(PASSWORDCONFIRM, "secret");
        driver.click(BUTTON);

        assertEquals("Hello"+ driver.getText(USERNAME),driver.getText(HEADING));





    }
}
