package test;

import automation.RegistrationInformation;
import automation.framework.Browser;
import automation.framework.WebDriverRunner;
import automation.pages.CreateNewAccountPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.net.URL;

import static automation.locators.Xpath.HEADING;
import static automation.locators.Xpath.REGISTRATION_BUTTON;
import static org.junit.Assert.assertEquals;

@RunWith(WebDriverRunner.class)
public class RegistrationForm_Test {
    @Inject
    private Browser driver;
    @Inject
    private URL baseUrl;


    private RegistrationInformation info = new RegistrationInformation(
            "testuser",
            "asdsadasd@yopmail.com",
            "qwerty12345",
            "qwerty12345"
            );

    @Before
    public void goToRegPage(){
        driver.manage().window().maximize();
        driver.get(baseUrl + "/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
    }


    @Test
    public void checkRegistration(){

        CreateNewAccountPage page = new CreateNewAccountPage(driver);
        page.setRegistrationForm(info);
        driver.click(REGISTRATION_BUTTON);

        assertEquals("Hello, testuser",driver.getText(HEADING));

    }
}
