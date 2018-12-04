package test;

import automation.LoginInformation;
import automation.framework.Browser;
import automation.framework.WebDriverRunner;
import automation.pages.HomePage;
import automation.pages.LoginPage;
import automation.pages.SearchItemPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.net.URL;

import static automation.locators.Xpath.*;

@RunWith(WebDriverRunner.class)
public class Checkout_Test {

    @Inject
    private Browser driver;
    @Inject
    private URL baseUrl;

    private LoginInformation info = new LoginInformation(
            "loremIpsum123491221@yopmail.com",
            "qwerty123");

    @Before
    public void setUp() {
        driver.get(baseUrl + "/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
        driver.manage().window().maximize();

        LoginPage page = new LoginPage(driver);
        page.setLoginInformation(info);
        driver.click(BTN_SIGNIN);

        HomePage homePage = new HomePage(driver);
        homePage.searchItem("Selenium WebDriver");

        SearchItemPage searchItemPage = new SearchItemPage(driver);
        searchItemPage.addToCart();
        searchItemPage.goToCheckout();

    }

    @Test
    public void successfulCheckout(){
        driver.await(DELIVER_TO_THIS_ADDRESS_BTN).click();
        driver.setRadio(RADIO_BTN,"radio");
        driver.await(CONTINUE_BTN).click();

    }


}
