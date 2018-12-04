package automation.pages;

import automation.framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static automation.locators.Xpath.SEARCH_BTN;
import static automation.locators.Xpath.SEARCH_INPUT;


public class HomePage  {

   /* @FindBy(xpath = "//span[@class='nav-sprite nav-logo-base']")
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
    private WebElement navigationItem;*/


    private Browser browser;

    public HomePage(Browser browser){
        this.browser = browser;
    }
    public void searchItem(String text){

        browser.setInputText(SEARCH_INPUT, text);
        browser.click(SEARCH_BTN);
        browser.click(() ->By.partialLinkText(text));
    }





}
