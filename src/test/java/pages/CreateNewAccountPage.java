package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage extends PageObject {
    //WebDriver driver;


    public CreateNewAccountPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//a[@id='nav-link-accountList']//span[@class='nav-line-1']")
    private WebElement headingForUsername;

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

    @FindBy(xpath = "//div[@data-card-identifier='Addresses']//h2")
    private WebElement addressLink;



    private void typeUserName(String username){
        this.userNameField.sendKeys(username);
    }

    private void typeUserEmail(String email){
        this.emailField.sendKeys(email);
    }

    private void typeUserPass (String password){
        this.passwordField.sendKeys(password);
    }

    private void typeReEnterPass (String repassword){
        this.passwordCheckField.sendKeys(repassword);
    }

    private void clickOnCreateButton(){
        this.createYourAmazonAccountButton.click();
    }


    public void newUser (String username, String email, String password, String repassword){
        this.typeUserName(username);
        this.typeUserEmail(email);
        this.typeUserPass(password);
        this.typeReEnterPass(repassword);
        this.clickOnCreateButton();

    }

    public String getUserNameText(){
        return this.headingForUsername.getText();
    }

    public AddressPage clickOnAddressLink(){
        this.addressLink.click();
        return new AddressPage(driver);
    }



}
