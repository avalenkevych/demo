package automation.pages;

import automation.AddressInformation;
import automation.framework.Browser;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static automation.locators.Xpath.*;

public class AddressPage {

    private final Browser driver;

    public AddressPage(Browser driver) {
        this.driver = driver;
    }

    public void setAddressInformation(AddressInformation info) {
        driver.setInputText(FULLNAME, info.fullname);
        driver.setInputText(STREET1, info.street1);
        driver.setInputText(STREET2, info.street2);
        driver.setInputText(CITY, info.city);
        driver.setInputText(STATE, info.state);
        driver.setInputText(ZIPCODE, info.zipcode);
        driver.setInputText(PHONE, info.phone);
        driver.click(ADD_ADDRESS_BUTTON);
    }

    public List<String> selectCountry() {

        List<WebElement> listOfCountries = driver.findElements(By.xpath("//div[@class='a-popover-wrapper']/div/ul/li"));
        for (int i = 0; i < listOfCountries.size(); i++) {
            if (listOfCountries.get(i).getText().equalsIgnoreCase("Ukraine")) {
                listOfCountries.get(i).click();
                break;
            }
        }
        return null;

        /*List<WebElement> countries = listOfCountries;
        countries.stream()
                .filter(country -> country.getText().equalsIgnoreCase("Ukraine"))
                .forEach(country -> country.click());

        return null;*/
    }

    public void waitInvisibilityOfDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='a-popover-wrapper']/div/ul/li"))));

    }

    public List<String> getErrorMessages() {

        List<WebElement> errorMessages = driver.findElements(By.xpath("//div[@class='a-alert-content']"));
        List<WebElement> errorMessages1 = errorMessages;
        List<String> errors = errorMessages1.stream()
                .map(l -> l.getText())
                .filter(l -> StringUtils.isNotBlank(l))
                .collect(Collectors.toList());
        errors.forEach(System.out::println);
        return errors;
    }

}





