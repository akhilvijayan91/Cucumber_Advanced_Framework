package stepdefinitions;

import Pages.loginPage;
import baseClass.driverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

import java.io.IOException;

import static Driver_SetUp.Driver.initDriver;
import static Driver_SetUp.Driver.quitDriver;
import static Pages.CommonMethods.getTitle;

public class LoginVerification extends driverInstance {


    @Given("user is on the Orange HRM Login Page")
    public void userIsOnTheOrangeHRMLoginPage() throws IOException {
        InitiateDriverInstance();
    }

    @When("the user login to Orange HRM  application with {string} and {string}")
    public void theUserLoginToOrangeHRMApplicationWithAnd(String username, String password) throws IOException, InterruptedException {
        loginPage lp=new loginPage();
        lp.enterUserName(username);
        lp.enterpassword(password);
        lp.tosignin();
    }

    @Then("the user should login sucessfully to Orange HRM application")
    public void theUserShouldLoginSucessfullyToOrangeHRMApplication() {
        Assertions.assertThat(getTitle()).containsIgnoringCase("viewEmployeeList");
        quitDriver();

    }
}
