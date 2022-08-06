package Pages;

import Driver_SetUp.Driver;
import baseClass.driverInstance;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.utilityFecthProperty;

import java.io.IOException;

public class loginPage
{
    //private static final Logger log = LogManager.getLogger(loginPage.class.getName());



    public void enterUserName(String username) throws IOException, InterruptedException {
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_username_fld"))).sendKeys(username);
        //extentReportUtility.loger.log(Status.INFO,"Succesfully entered Username: "+username);
        ExtentCucumberAdapter.addTestStepLog("Sucessfully entered username: "+username);
    }
    public void enterpassword(String password) throws IOException
    {
        Driver.getDriver().findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_password_fld"))).sendKeys(password);
        //extentReportUtility.loger.log(Status.INFO,"Succesfully entered Password: "+password);
    }
    public void tosignin() throws IOException
    {
        Driver.getDriver().findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_signin_btn"))).click();
        //extentReportUtility.loger.log(Status.INFO,"Succesfully signed in");
    }
}
