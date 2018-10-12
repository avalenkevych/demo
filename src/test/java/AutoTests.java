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
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\Testing\\Java\\Automation\\FirstProject\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void methodForMainPage(){
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        CreateNewAccountPage newUserPage = PageFactory.initElements(driver,CreateNewAccountPage.class);
        mainPage.hoverMouseAndGoToSignUpPage();
        newUserPage.registerNewUser("test","testgot123sdsdqwe12@email.com","123456","123456");



    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
