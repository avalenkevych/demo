import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AutoTests {

    static WebDriver driver;
    String email = "loremIpsum12349@yopmail.com";
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
    public void createNewAccountTest(){

        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        CreateNewAccountPage newUserPage = PageFactory.initElements(driver,CreateNewAccountPage.class);
        mainPage.openCreateNewUserPage();
        newUserPage.registerNewUser("testuser",email,password,"qwerty123");
        Assert.assertEquals("Hello, testuser", newUserPage.getUserNameText());


    }
    @Test
    public void signInTest(){
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        SignInPage signIn = PageFactory.initElements(driver, SignInPage.class);
        mainPage.openSignInPage();
        signIn.login(email,password);



    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
