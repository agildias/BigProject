package com.agildias.StepDefinition;

import com.agildias.PageObject.GroupChatPage;
import com.agildias.PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GroupChatStep {
    private WebDriver webDriver;

    public GroupChatStep() {
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("User Login first user input \"(.*)\" and \"(.*)\" for use group chat")
    public void loginCicle(String email,String pwd) throws InterruptedException {
        LoginPage login = new LoginPage(webDriver);
        login.clickLoginGoogle();
        login.inputGoogleEmail(email);
        login.clickBerikutnya();
        login.inputPasswordGoogle(pwd);
        login.clickNextButton();
        login.clickPaketSoalB();
    }

    @When("User Click GroupChat and input text message \"(.*)\"")
    public void sendTextMessage(String msg) throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickGroupChat();
        chat.titleGroup();
        chat.sendTextMessage(msg);
        chat.sendMessage();
    }

    @Then("message displayed")
    public void verifyMessage() throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        Assert.assertTrue(chat.isMessage());
    }

    @When("User Click GroupChat and input text long message \"(.*)\"")
    public void sendNumberMessage(String msg) throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickGroupChat();
        chat.titleGroup();
        chat.sendTextMessage(msg);
        chat.sendMessage();
    }

    @Then("Notification Succes Delete")
    public void succesDeletedMessage() throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickHiddenButton();
        Assert.assertTrue(chat.isSuccesDeleteMessage());
    }

    @When("User Click GroupChat and input image")
    public void uploadImage() throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickGroupChat();
        chat.clickAttachmen();
    }

    @Then("notification succes upload")
    public void successUpload(){
        GroupChatPage chat = new GroupChatPage(webDriver);
        Assert.assertTrue(chat.imageDisplayed());
    }

    @Then("succes upload and download until delete")
    public void downloadImage() throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickDownload();
        chat.windowsHandle();
        chat.deleteImage();
        Assert.assertTrue(chat.notifImageDelte());
    }

    @When("User Click GroupChat and input text message tag friend \"(.*)\"")
    public void inputTagFriend(String tag) throws InterruptedException {
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickGroupChat();
        chat.tagChat(tag);
        chat.sendMessage();

    }

    @Then("navigate to friend profile")
    public void navigateProfile(){
        GroupChatPage chat = new GroupChatPage(webDriver);
        chat.clickTagMessage();
        Assert.assertTrue(chat.verifyProfile());
    }
}
