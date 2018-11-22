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
//@TestExecutionListeners(listeners = {ScreenshotOnFailure.class, DependencyInjectionTestExecutionListener.class})

public class HomePageTest {
    @Inject
    private WebDriver driver;
    @Inject
    private URL baseUrl;


    @Before
    public void setUp(){

        driver.manage().window().maximize();
        driver.get("/home");
    }

    @Test
    public void homePageElementscheck() throws Exception{
        MainPage homePage = new MainPage(driver);
        homePage.footerPresence();
        homePage.navigationPresence();

        assertTrue(homePage.getLogoText().equals("Amazon"));


    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
