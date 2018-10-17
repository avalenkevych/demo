package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject {

    @FindBy (xpath = "//input[@id='ap_email']")
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



    public SignInPage (WebDriver driver){
        super(driver);
    }

    public void login(String email , String password){
       userEmail.sendKeys(email);
      // continueButton.click();
       userPassword.sendKeys(password);
       signInButton.click();
    }

    public String getEmailError(){
        return emailError.getText();
    }
    public String getPassError(){
        return passError.getText();
    }
    public void getErrorMessages(){
        signInButton.click();
    }

}
