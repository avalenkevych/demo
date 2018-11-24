package automation.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.xpath;

public enum  Xpath implements Supplier<By> {

    LOGO("//span[@class='nav-sprite nav-logo-base']"), // Logo Amazon on homepage
    EMAIL("//input[@id='ap_email']"),
    PASSWORD("//input[@id='ap_password']"),
    USERNAME("//input[@id='ap_customer_name']"),
    PASSWORDCONFIRM("//input[@id='ap_password_check']"),
    REGISTRATION_BUTTON("//*[@id='continue']"),
    HEADING("//a[@id='nav-link-accountList']//span[@class='nav-line-1']"),
    USERNAMELINK("//*[@id='nav-link-accountList']/span[1]"), // element on homepage
    BTN_SIGNIN("//input[@id='signInSubmit']"),

    //Addresses fields
    ADDRESS_LINK("//div[@data-card-identifier='Addresses']//h2"),
    ADDRESS_ICON("//div[@id='ya-myab-plus-address-icon']"),
    UKR("//div[@class='a-popover-wrapper']/div/ul/li"),
    DROP_DOWN("//span[@data-action='a-dropdown-button']/span"),
    FULLNAME("//input[@id='address-ui-widgets-enterAddressFullName']"),
    STREET1("//input[@id='address-ui-widgets-enterAddressLine1']"),
    STREET2("//input[@id='address-ui-widgets-enterAddressLine2']"),
    CITY("//input[@id='address-ui-widgets-enterAddressCity']"),
    STATE("//input[@id='address-ui-widgets-enterAddressStateOrRegion']"),
    ZIPCODE("//input[@id='address-ui-widgets-enterAddressPostalCode']"),
    PHONE("//input[@id='address-ui-widgets-enterAddressPhoneNumber']");




    private final By by;
    Xpath(String id){
        this.by = xpath(id);
    }
    @Override
    public By get(){
        return by;
    }

    @Override
    public String toString(){
        return by.toString();
    }

}
