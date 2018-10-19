package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressPage extends PageObject {

    @FindBy(xpath="//h1[@class='a-spacing-medium']")
    private WebElement heading;

    @FindBy(xpath = "//div[@id='ya-myab-plus-address-icon']")
    private WebElement addressIcon;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    private WebElement streetAddressField1;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
    private WebElement streetAddressField2;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//span[@class='a-expander-prompt']")
    private WebElement expanderLink;

    @FindBy(xpath = "//span[@class='a-button-inner']/input[@type='submit']")
    private WebElement addAddressButton;

    @FindBy (xpath = "//div[@class='a-alert-content']")
    private WebElement errorMessages;



    public  AddressPage (WebDriver driver){
        super(driver);
    }
    public String getHeading(){
        return this.heading.getText();
    }
    public void clickOnAddressIcon(){
        this.addressIcon.click();
    }
    public void typeFullNameField(String fullNameField){
        this.fullNameField.sendKeys(fullNameField);
    }
    public void typeStreetAddressField1(String streetAddressField1){
        this.streetAddressField1.sendKeys(streetAddressField1);
    }
    public void typeStreetAddressField2(String streetAddressField2){
        this.streetAddressField2.sendKeys(streetAddressField2);
    }
    public void typeCityField(String cityField) {
        this.cityField.sendKeys(cityField);
    }

    public void typeStateField(String stateField) {
        this.stateField.sendKeys(stateField);
    }

    public void typeZipCodeField(String zipCodeField) {
        this.zipCodeField.sendKeys(zipCodeField);
    }

    public void typePhoneNumberField(String phoneNumberField) {
        this.phoneNumberField.sendKeys(phoneNumberField);
    }
    public void clickOnAddAddressBtn(){
        this.addAddressButton.click();
    }
    public void addNewAddress(String fullName, String street1, String street2, String city, String state, String zipcode, String phone ){
        this.typeFullNameField(fullName);
        this.typeStreetAddressField1(street1);
        this.typeStreetAddressField2(street2);
        this.typeCityField(city);
        this.typeStateField(state);
        this.typeZipCodeField(zipcode);
        this.typePhoneNumberField(phone);
    }



}
