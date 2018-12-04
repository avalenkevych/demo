package automation.pages;

import automation.framework.Browser;

import static automation.locators.Xpath.DELIVER_TO_THIS_ADDRESS_BTN;

public class CheckoutPage {
    private Browser driver;

    public CheckoutPage(Browser driver){
        this.driver = driver;
    }

    public void deliverToThisAddress(){
        driver.await(DELIVER_TO_THIS_ADDRESS_BTN).click();
    }
}
