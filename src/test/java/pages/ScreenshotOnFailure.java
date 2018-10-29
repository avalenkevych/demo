package pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class ScreenshotOnFailure extends AbstractTestExecutionListener {

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (Boolean.parseBoolean(System.getProperty("webdriver.screenshots.enabled", "true"))) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) testContext.getApplicationContext()
                    .getBean(WebDriver.class);
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File dir = new File("C:\\Work\\Testing\\Java\\Automation\\Demo\\screenshots\\");
            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
            Method method = testContext.getTestMethod();
            File file = new File(dir, String.format("%s#%s.png", method.getDeclaringClass().getName(), method.getName()));
            FileUtils.deleteQuietly(file);
            FileUtils.moveFile(screenshot, file);
            //LOGGER.info("saved screenshot as {}", file);
        }
    }

}