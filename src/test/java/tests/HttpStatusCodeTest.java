package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pages.WebDriverConfig;
import pages.framework.HttpStatusCodeSupplier;
import javax.inject.Inject;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebDriverConfig.class)
public class HttpStatusCodeTest {
    @Inject private WebDriver driver;
    @Inject private HttpStatusCodeSupplier httpStatusCodeSupplier;
    @Inject private URL baseUrl;

    @Test
    public void notFound() throws Exception{
        driver.get(baseUrl + "/home");
        Thread.sleep(15000);
        assertEquals(200,httpStatusCodeSupplier.get());
    }
}
