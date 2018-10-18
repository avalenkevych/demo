package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject{

    public SearchPage (WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//input[@name='s-ref-checkbox-Whirlpool']")
    private WebElement checkbox;


    public void setCheckbox(){
        this.checkbox.click();
    }
    public Boolean getCheckbox(){
        return this.checkbox.isSelected();
    }





}
