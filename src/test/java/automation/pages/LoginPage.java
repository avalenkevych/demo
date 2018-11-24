package automation.pages;

import automation.LoginInformation;
import automation.framework.Browser;

import static automation.locators.Xpath.EMAIL;
import static automation.locators.Xpath.PASSWORD;

public class LoginPage {

    private final Browser driver;

    public LoginPage(Browser driver){
        this.driver = driver;
    }

    public void setLoginInformation(LoginInformation info){
        driver.setInputText(EMAIL,info.email);
        driver.setInputText(PASSWORD,info.password);
    }


   /* @FindBy (xpath = "//input[@id='ap_email']")
    private WebElement userEmail;

    @FindBy (xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement userPassword;

    @FindBy (xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='auth-email-missing-alert']//div[@class='a-alert-content']")
    private WebElement emailError;

    @FindBy (xpath = "//div[@id='auth-password-missing-alert']//div[@class='a-alert-content']")
    private WebElement passError;





    public String getEmailError(){
        return emailError.getText();
    }
    public String getPassError(){
        return passError.getText();
    }
    public void getErrorMessages(){
        signInButton.click();
    }*/

}
