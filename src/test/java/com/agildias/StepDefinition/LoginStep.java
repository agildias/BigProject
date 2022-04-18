package com.agildias.StepDefinition;

import com.agildias.PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    private WebDriver webDriver;

    public LoginStep() {
        super();
        this.webDriver = Hook.webDriver;
    }


    @Given("user navigate to login")
    public void loginGoogle(){
        LoginPage login = new LoginPage(webDriver);
        login.clickLoginGoogle();
    }

    @When("user input \"(.*)\" and \"(.*)\"")
    public void inputEmailAndPassword(String email,String pwd) throws InterruptedException {
        LoginPage login = new LoginPage(webDriver);
        login.inputGoogleEmail(email);
        login.clickBerikutnya();
        login.inputPasswordGoogle(pwd);
        login.clickNextButton();
    }

    @Then("user navigate to dashboard")
    public void navigateToDashboard(){
        LoginPage login = new LoginPage(webDriver);
        login.isImage();
        login.clickPaketSoalB();
    }
}
