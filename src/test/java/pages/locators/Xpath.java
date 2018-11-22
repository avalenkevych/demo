package pages.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.xpath;

public enum  Xpath implements Supplier<By> {

    LOGO("//span[@class='nav-sprite nav-logo-base']"),
    EMAIL("//input[@id='ap_email']"),
    PASSWORD("//input[@id='ap_password']"),
    USERNAME("//input[@id='ap_customer_name']"),
    PASSWORDCONFIRM("//input[@id='ap_password_check']"),
    BUTTON("//*[@id='continue']"),
    HEADING("//a[@id='nav-link-accountList']//span[@class='nav-line-1']");

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
