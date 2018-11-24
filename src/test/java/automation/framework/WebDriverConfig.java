package automation.framework;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import automation.pages.ScreenshotOnFailure;

import java.net.*;

@Configuration
public class WebDriverConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DesiredCapabilities desiredCapabilities(@Value("${webdriver.capabilities.browserName:chrome}")String browserName)
    {
        return new DesiredCapabilities(browserName,"", Platform.ANY);
    }

    @Bean(destroyMethod = "quit")
    public WebDriver webDriver(DesiredCapabilities desiredCapabilities) throws IllegalAccessException {
        switch (desiredCapabilities.getBrowserName()){
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Work\\Testing\\Java\\Automation\\FirstProject\\drivers\\chromedriver.exe");
                return new ChromeDriver(desiredCapabilities);
            default:
                throw new IllegalAccessException("unknown browser" + desiredCapabilities.getBrowserName());

        }
    }

    @Bean
    public URL baseUrl(@Value("${webdriver.baseUrl:https://amazon.com}") URL value){
        return value;
    }

    @Bean
    public ScreenshotOnFailure screenshotOnFailure() {
        return new ScreenshotOnFailure();
    }
    @Bean
    public Browser browser(WebDriver driver) {
        return new Browser(driver);
    }



}