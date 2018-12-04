package automation.pages;

import automation.framework.Browser;

import static automation.locators.Xpath.ADD_TO_CART;
import static automation.locators.Xpath.PROCESS_TO_CHECKOUT_BTN;

public class SearchItemPage {
    private Browser driver;

    public SearchItemPage(Browser driver){
        this.driver = driver;
    }

    public void addToCart(){
        driver.await(ADD_TO_CART).click(ADD_TO_CART);
    }
    public void goToCheckout(){

        driver.await(PROCESS_TO_CHECKOUT_BTN).click();
    }
}
