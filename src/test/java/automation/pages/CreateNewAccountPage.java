package automation.pages;

import automation.RegistrationInformation;
import automation.framework.Browser;
import static automation.locators.Xpath.*;

public class CreateNewAccountPage {

    private final Browser driver;

    public CreateNewAccountPage(Browser driver){
        this.driver = driver;
    }

    public void setRegistrationForm(RegistrationInformation info){
        driver.setInputText(USERNAME, info.username);
        driver.setInputText(EMAIL, info.email);
        driver.setInputText(PASSWORD, info.password);
        driver.setInputText(PASSWORDCONFIRM, info.passwordConfirm);
    }

}
