package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import pages.*;

import javax.inject.Inject;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
@TestExecutionListeners(listeners = {ScreenshotOnFailure.class, DependencyInjectionTestExecutionListener.class})

public class AutoTests {
    @Inject
    private WebDriver driver;
    @Inject
    private URL baseUrl;


    String username = "lorem";
    String email = "loremIpsum123491221@yopmail.com";
    String password = "qwerty123";
    String repassword = "qwerty123";

    @Before
    public void setUp(){

        //driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl + "/home");
    }

    @Test
    public void homePageElementscheck() throws Exception{
        MainPage homePage = new MainPage(driver);
        homePage.footerPresence();
        homePage.navigationPresence();

        assertTrue(homePage.getdLogoText().equals("Amazon"));


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
    public void  signInTest()  {

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
