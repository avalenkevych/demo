package pages.framework;

import org.openqa.selenium.WebDriver;

import java.net.URI;

public class BaseUrlDriver extends DelegatingWebDriver {

    private final URI baseUrl;

    BaseUrlDriver(WebDriver driver, URI baseUrl) {
        super(driver);
        this.baseUrl = baseUrl;
    }

    @Override
    public void get(String url) {
        super.get(!url.contains("://") ? baseUrl + url : url);
    }
}
