package automation.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.Supplier;


public class Browser extends DelegatingWebDriver {

    public Browser(WebDriver driver) {
        super(driver);
    }

    public void setInputText(Supplier<By> by, Object value) {
        Element element = await(by);
        element.clear();
        element.sendKeys(value.toString());
    }
    public String getInputText(Supplier<By> by){
        return await(by).getAttribute("value");
    }


    public String getText(Supplier<By>by){
        final Element text = await(by);
        return  text.getText();
    }
    public void setRadio(Supplier<By> by, Object value){


    }

}
