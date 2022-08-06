package Driver_SetUp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.utilityFecthProperty;

import java.io.IOException;
import java.util.Objects;

public final class Driver {
    private static WebDriver driver;
    private static ThreadLocal<WebDriver> dr=new ThreadLocal<>();
    private Driver()
    {}

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static void unload()
    {
        dr.remove();
    }

    public static void initDriver() throws IOException {
        if (Objects.isNull(getDriver())) {
            String browsername = utilityFecthProperty.fetchPropertyValue("browser");
            switch (browsername) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    setDriver(driver);
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    setDriver(driver);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    setDriver(driver);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    setDriver(driver);
                    break;
                case "deco":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    setDriver(driver);
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    setDriver(driver);
                    break;
            }
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}
