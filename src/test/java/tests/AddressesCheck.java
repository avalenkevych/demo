package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressPage;
import pages.CreateNewAccountPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddressesCheck {

    static WebDriver driver;
    String email = "loremIpsum123491221@yopmail.com";
    String password = "qwerty123";

    @Before
    public void setUp(){

    }
    @Test
    public void AddNewAddress(){
        CreateNewAccountPage address = new CreateNewAccountPage(driver);
        AddressPage addressPage = new AddressPage(driver);
        address.clickOnAddressLink();

        List<WebElement> listOfCountries = driver.findElements(By.xpath("//div[@id='a-popover-3']//ul/li"));
        for (WebElement name: listOfCountries) {
            if(listOfCountries.equals("Ukraine")){
                name.click();
        }
        }
    }


}
