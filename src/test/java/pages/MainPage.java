package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.Key;


public class MainPage extends PageObject {

    @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")
    private WebElement logo;

    @FindBy(xpath = "//div[@id='navFooter']")
    private WebElement footer;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()='Start here.']")
    private WebElement startHereButton;

    @FindBy(xpath = "(//span[@class='nav-action-inner' and text()='Sign in'])[1]")
    private WebElement signInBtn;

    @FindBy(xpath = "//div[@id='nav-xshop-container']")
    private WebElement navigationBar;







    public MainPage(WebDriver driver) {
        super( driver);
    }

    public String getdLogoText(){
        return logo.getText();

    }
    //this shit need to do
    public Boolean footerPresence(){
        return footer.isDisplayed();
    }
    public Boolean navigationPresence(){
        return navigationBar.isDisplayed();
    }

    public SignInPage openCreateNewUserPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).build().perform();
        startHereButton.click();
        return new pages.SignInPage(driver);
    }
    public void openSignInPage(){
        //signInBtn.isDisplayed();
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).build().perform();
        signInBtn.click();

    }
    public void setSearchText(String text){
        this.searchField.sendKeys(text);
        this.searchField.sendKeys(Keys.ENTER);
    }




}
