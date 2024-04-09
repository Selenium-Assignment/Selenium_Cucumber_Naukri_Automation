package testCase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Landing_page;

import static DriverSetup.Initializing_Driver.ldriver;

public class LoginFunctionalityTestCase {

    Landing_page lp = new Landing_page(ldriver);
    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        String url = "https://www.naukri.com/";
        ldriver.get(url);

    }

    @And("user proceeds to Login")
    public void user_proceeds_to_login() {
        lp.ClickOnloginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user provides {string} and {string}")
    public void userProvidesAnd(String email, String password) throws InterruptedException {

        lp.username(email);
        lp.password(password);
        Thread.sleep(2000);
    }

    @When("user  clicks on LoginButton")
    public void user_clicks_on_login_button() {

        lp.AccountLoginButton();
    }

    @Then("user is on Homepage")
    public void user_is_on_homepage() {
        System.out.println("homepage");

    }


}
