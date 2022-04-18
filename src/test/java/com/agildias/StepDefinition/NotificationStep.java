package com.agildias.StepDefinition;

import com.agildias.PageObject.LoginPage;
import com.agildias.PageObject.NotificationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NotificationStep {
    private WebDriver webDriver;

    public NotificationStep() {
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("User Login \"(.*)\" and \"(.*)\" for use group chat")
    public void loginToCicle(String email,String pwd) throws InterruptedException {
        LoginPage login = new LoginPage(webDriver);
        login.clickLoginGoogle();
        login.inputGoogleEmail(email);
        login.clickBerikutnya();
        login.inputPasswordGoogle(pwd);
        login.clickNextButton();
    }

    @When("User click notification Chat")
    public void clickChatNotif() throws InterruptedException {
        NotificationPage notif = new NotificationPage(webDriver);
        notif.clickChatNotif();
        notif.clickRecentChat();
    }

    @Then("navigate to privateChat")
    public void navigatePrivateChat(){
        NotificationPage notif = new NotificationPage(webDriver);
        Assert.assertTrue(notif.chat());
    }

    @When("User Click Notification Message")
    public void notifMessage() throws InterruptedException {
        NotificationPage notif = new NotificationPage(webDriver);
        notif.clickMessage();
        notif.clickNotifGrupChat();
    }

    @Then("navigate to GroupChat")
    public void navigateToGrupChat(){
        NotificationPage notif = new NotificationPage(webDriver);
        Assert.assertTrue(notif.checkGrupChat());
    }
}
