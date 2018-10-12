import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage {
    WebDriver driver;

    public CreateNewAccountPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//h1[@class='a-spacing-small']")
    private WebElement headingCreateAccount;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement passwordCheckField;

    @FindBy(xpath = "//*[@id='continue']")
    private WebElement createYourAmazonAccountButton;

    @FindBy(xpath = "//*[@id='hud-customer-name']/div/a")
    private WebElement customerName;

    private void typeUserName(String username){
        userNameField.sendKeys(username);
    }

    private void typeUserEmail(String email){
        emailField.sendKeys(email);
    }

    private void typeUserPass (String password){
        passwordField.sendKeys(password);
    }

    private void typeReEnterPass (String repassword){
        passwordCheckField.sendKeys(repassword);
    }

    private void clickOnCreateBitton(){
        createYourAmazonAccountButton.click();
    }


    public void registerNewUser (String username, String email, String password, String repassword){
        typeUserName(username);
        typeUserEmail(email);
        typeUserPass(password);
        typeReEnterPass(repassword);
        clickOnCreateBitton();

    }



}
