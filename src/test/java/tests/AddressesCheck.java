package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddressPage;
import pages.CreateNewAccountPage;
import pages.MainPage;
import pages.SignInPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddressesCheck {

    static WebDriver driver;
    String email = "loremIpsum123491221@yopmail.com";
    String password = "qwerty123";

    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "C:\\Work\\Testing\\Java\\Automation\\FirstProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void AddNewAddress()  {
        MainPage homePage = new MainPage(driver);
        homePage.openSignInPage();
        SignInPage signIn = new SignInPage(driver);
        signIn.login(email,password);
        CreateNewAccountPage heading = new CreateNewAccountPage(driver);
        homePage.goToUserPage();
        heading.clickOnAddressLink();
        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickOnAddressIcon();
        addressPage.clickOnDropDown();
        addressPage.selectCountry();
        addressPage.waitInvisibilitiOfDropDown();
        addressPage.addNewAddress("QQQq123werty","qwer123ty123", "asd23asd","Chi2cago", "IL", "60504","123456789");
        addressPage.clickOnAddAddressBtn();
        Assert.assertEquals("Address saved", addressPage.getSuccessHeadingForAddressCreation());


    }


    @After
    public void tearDown(){
        driver.quit();
    }


}
