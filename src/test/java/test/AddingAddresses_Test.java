package test;

import automation.AddressInformation;
import org.junit.*;
import org.junit.runner.RunWith;
import automation.pages.AddressPage;
import automation.framework.Browser;
import automation.framework.WebDriverRunner;

import javax.inject.Inject;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static automation.locators.Xpath.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(WebDriverRunner.class)
public class AddingAddresses_Test {
    @Inject
    private Browser driver;
    @Inject
    private URL baseUrl;

    private AddressInformation info = new AddressInformation(
            "asdqwe",
            "wqeqwe1",
            "asdsad2",
            "Kiev",
            "qwewqe",
            "12345",
            "123456789");

    @Before
    public void goToUserProfilePage(){
        driver.get(baseUrl + "/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_custrec_signin&switch_account=");
        driver.manage().window().maximize();
        driver.setInputText(EMAIL, "loremIpsum123491221@yopmail.com");
        driver.setInputText(PASSWORD,"qwerty123");
        driver.click(BTN_SIGNIN);
    }

    @Test
    public void checkAddingNewAddress() {
        AddressPage page = new AddressPage(driver);
        driver.get(baseUrl + "/a/addresses/add?ref=ya_address_book_add_button");
        driver.click(DROP_DOWN);
        page.selectCountry();
        page.waitInvisibilityOfDropDown();
        page.setAddressInformation(info);
        assertEquals("Address saved", driver.getText(ADDRESS_SUCCESS_HEADING));
    }

    @Test
    public void checkAddressErrorMessages(){
        AddressPage page = new AddressPage(driver);
        driver.get(baseUrl + "/a/addresses/add?ref=ya_address_book_add_button");
        driver.click(ADD_ADDRESS_BUTTON);
        List<String> expected = Arrays.asList("Please enter a name.",
                "Please enter an address","Please enter a city name.",
                "Please enter a state, region, or province",
                "Please enter a ZIP or postal code",
                "Please enter a phone number so we can call if there are any issues with delivery.") ;
        assertThat(page.getErrorMessages(),is(expected));
    }

}
