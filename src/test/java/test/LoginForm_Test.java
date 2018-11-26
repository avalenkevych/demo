package test;


import automation.LoginInformation;
import automation.pages.LoginPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import automation.framework.Browser;
import automation.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static automation.locators.Xpath.BTN_SIGNIN;



@RunWith(WebDriverRunner.class)
public class LoginForm_Test {
    @Inject
    private Browser driver;
    @Inject private URL baseUrl;

    private LoginInformation info = new LoginInformation(
            "loremIpsum123491221@yopmail.com",
            "qwerty123");
    @Before
    public void goToLoginPage(){
        driver.get(baseUrl + "/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
        driver.manage().window().maximize();
    }

    @Test
    public void checkLoginForm(){
        LoginPage page = new LoginPage(driver);
        page.setLoginInformation(info);
        driver.click(BTN_SIGNIN);

    }

    @Test
    public void checkLoginFormErrorMessages(){
        LoginPage page = new LoginPage(driver);
        driver.click(BTN_SIGNIN);
        assertEquals("Enter your email or mobile phone number", page.getUserEmailEror());
        assertEquals("Enter your password", page.getUserPasswordError());
    }
}
