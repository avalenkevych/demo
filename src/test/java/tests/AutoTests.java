package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoTests {

    static WebDriver driver;
    String username = "lorem";
    String email = "loremIpsum123491221@yopmail.com";
    String password = "qwerty123";
    String repassword = "qwerty123";



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\Testing\\Java\\Automation\\FirstProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void homePageElementscheck(){
        MainPage homePage = new MainPage(driver);
        homePage.footerPresence();
        homePage.navigationPresence();
        //Assert.assertEquals("Amazon", homePage.getdLogoText());
        //alternative variant
        assertTrue(homePage.getdLogoText().equals("Amazon"));

        /*List <WebElement> listbox = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option[contains(@value,'search-alias')]"));
        System.out.println(listbox.size());
        if (listbox.size()==50) System.out.println("Pass");
        else System.out.println("Fail");*/
    }

    @Test
    public void createNewAccountTest(){

        MainPage homePage = new MainPage(driver);
            homePage.openCreateNewUserPage();

        CreateNewAccountPage register = new CreateNewAccountPage(driver);
            register.newUser(username,email,password,repassword);
            Assert.assertEquals("Hello, "+ username, register.getUserNameText());
    }
    @Test
    public void  signInTest() throws InterruptedException {

        MainPage homePage = new MainPage(driver);
            homePage.openSignInPage();

        SignInPage signIn = new SignInPage(driver);
            signIn.login(email,password);

        CreateNewAccountPage heading = new CreateNewAccountPage(driver);
            Assert.assertEquals("Hello, "+ username, heading.getUserNameText());

    }



    @Test
    public void errorMessagesCheck(){
        MainPage homePage = new MainPage(driver);
            homePage.openSignInPage();

        SignInPage signIn = new SignInPage(driver);
            signIn.getErrorMessages();
            Assert.assertEquals("Enter your email or mobile phone number",signIn.getEmailError());
            Assert.assertEquals("Enter your password",signIn.getPassError());
    }

    @Test
    public void searchCheck(){

        MainPage homePage = new MainPage(driver);
            homePage.setSearchText("washing machine");

        SearchPage searchPage = new SearchPage(driver);
            searchPage.setCheckbox();
            searchPage.getCheckbox();
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
