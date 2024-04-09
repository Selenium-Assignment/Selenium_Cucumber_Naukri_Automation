package testCase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.Landing_page;

import static DriverSetup.Initializing_Driver.ldriver;

public class profileUpdateFunctionality {

    HomePage hp = new HomePage(ldriver);
    Landing_page lp = new Landing_page(ldriver);


    @Given("User is on landing Page")
    public void userIsOnLandingPage() throws InterruptedException {
        String url = "https://www.naukri.com/";
        ldriver.get(url);
        Thread.sleep(2000);

    }

    @And("User provides {string} and {string} and logsIn")
    public void userProvidesAndAndLogsIn(String email, String password) throws InterruptedException {
        lp.ClickOnloginButton();
        Thread.sleep(5000);
        lp.username(email);
        lp.password(password);
        Thread.sleep(6000);
        lp.AccountLoginButton();
        Thread.sleep(2000);
    }

    @Then("User moves to profile Section")
    public void userMovesToProfileSection() throws InterruptedException {
        Thread.sleep(5000);
        hp.accountHolderProfile();

        Thread.sleep(5000);
    }

    @And("user updates the profile")
    public void userUpdatesTheProfile() throws InterruptedException {

       //************************************* updating Resume_headline_Section ****************************************

        Thread.sleep(2000);

        hp.editresumeHeadlineSection();
        String updatedtext = " Technical business analyst in making, handy with data analysis, business requirement analysis, process design and standardization, and documentation. I am hero";
        hp.resumeHeadlineTxt(updatedtext);
        hp.saveButtonResumeHeadlineText();
        Thread.sleep(5000);

        //****************** updating Key_Skill_Section *********************

        hp.UpdateKeySkill();


    }

    @Then("User verifies profile is successfully updated")
    public void userVerifiesProfileIsSuccessfullyUpdated() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(hp.updadationSuccessfulMgs());


    }
}


