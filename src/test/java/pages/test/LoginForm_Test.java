package pages.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignInPage;
import pages.framework.Browser;
import pages.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URL;


@RunWith(WebDriverRunner.class)
public class LoginForm_Test {
    @Inject
    private Browser browser;
    @Inject private URL baseUrl;


    @Test
    public void checkLoginForm() throws InterruptedException{
        browser.get(baseUrl + "/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
        browser.manage().window().maximize();

        SignInPage loginForm = new SignInPage(browser);
        loginForm.login("loremIpsum123491221@yopmail.com","qwerty123");
        new WebDriverWait(browser,4)
                .until(ExpectedConditions.titleIs("Hello" + "lorem" ));

    }
}
