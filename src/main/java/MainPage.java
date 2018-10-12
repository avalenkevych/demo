import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class MainPage {
    private WebDriver driver;

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


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //this shit need to do
    public MainPage findLogo(){
        logo.getText();
        return new MainPage(driver);
    }
    //this shit need to do
    public MainPage footer(){
        footer.isDisplayed();
        return new MainPage(driver);
    }

    public SignInPage hoverMouseAndGoToSignUpPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).build().perform();
        startHereButton.click();
        return new SignInPage(driver);
    }



}
