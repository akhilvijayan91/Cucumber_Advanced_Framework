package baseClass;

import Driver_SetUp.Driver;

import com.aventstack.extentreports.service.ExtentService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.FrameworkConfig;
import utilities.utilityFecthProperty;

import java.io.IOException;

import static Driver_SetUp.Driver.initDriver;
import static Driver_SetUp.Driver.quitDriver;

public class driverInstance {
    public String className;

    FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

    public void InitiateDriverInstance() throws IOException {
        initDriver();
        className = this.getClass().getSimpleName();
        Driver.getDriver().get(config.url());


      /*  public void InitiateDriverInstance () {
            initDriver();
            className = this.getClass().getSimpleName();
            Driver.getDriver().get(utilityFecthProperty.fetchPropertyValue("url"));

            Driver.getDriver().manage().window().maximize();


        }

        public void closeInstance (ITestResult Result) throws IOException {
            quitDriver();
        }*/
    }
}
