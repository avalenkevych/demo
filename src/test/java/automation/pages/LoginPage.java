package automation.pages;

import automation.LoginInformation;
import automation.framework.Browser;

import static automation.locators.Xpath.*;

public class LoginPage {

    private final Browser driver;

    public LoginPage(Browser driver) {
        this.driver = driver;
    }


    public void setLoginInformation(LoginInformation info) {
        driver.setInputText(EMAIL, info.email);
        driver.setInputText(PASSWORD, info.password);
    }

    public String getUserEmailEror() {
        return driver.getText(USER_EMAIL_ERROR);
    }

    public String getUserPasswordError() {
        return driver.getText(USER_PASSWORD_ERROR);
    }
}




