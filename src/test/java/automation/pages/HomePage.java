package automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class HomePage  {

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

    @FindBy(xpath = "//*[@id='nav-link-accountList']/span[1]")
    private WebElement navigationItem;

    /*public HomePage(WebDriver driver) {
        super( driver);
    }

    public String getLogoText(){
        return logo.getText();

    }



    public void openSignInPage(){

        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).build().perform();
        signInBtn.click();

    }
    public void setSearchText(String text){
        this.searchField.sendKeys(text);
        this.searchField.sendKeys(Keys.ENTER);
    }
    public void goToUserPage(){
        this.navigationItem.click();
    }


*/

}
