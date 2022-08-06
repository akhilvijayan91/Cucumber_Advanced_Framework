package stepdefinitions;

import Driver_SetUp.Driver;
import baseClass.driverInstance;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class MasterHooks extends driverInstance {

    static WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(MasterHooks.class);

    @Before
    public static void setup() {
        driver = Driver.getDriver();
    }

    @After
    public static void tearDownAndScreenshotOnFailure(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
                        .takeScreenshot(driver);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(screenshot.getImage(), "png", baos);
                byte[] bytes = baos.toByteArray();
                String imageBase64 = new String(Base64.getEncoder().encode(bytes));
                ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(imageBase64,"Refer attached screenShot.").build());
                driver.manage().deleteAllCookies();
                driver.quit();
            } else if (driver != null && !scenario.isFailed()) {

                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            LOGGER.error("Methods failed: tearDownAndScreenshotOnFailure, Exception: {}", e.getMessage());
        }

    }
}
