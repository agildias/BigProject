package com.agildias.StepDefinition;

import com.agildias.PageObject.LoginPage;
import com.agildias.PageObject.SchedulePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ScheduleStep {
    private WebDriver webDriver;

    public ScheduleStep() {
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("User Login Schedule \"(.*)\" and password \"(.*)\" for use schedule")
    public void LoginSchedule(String email, String pwd) throws InterruptedException {
        LoginPage login = new LoginPage(webDriver);
        login.clickLoginGoogle();
        login.inputGoogleEmail(email);
        login.clickBerikutnya();
        login.inputPasswordGoogle(pwd);
        login.clickNextButton();
        login.clickPaketSoalB();
    }

    @When("User click schedule and click create even")
    public void navigateToSchedule() throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.clickSchedule();
        schedule.clickCreateEvent();
    }

    @And("User create event Every day \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void createEventEveryDay(String title,String start,String end,String day) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextTitle(title);
        schedule.inputStartDate(start);
        schedule.inputEndDate(end);
        schedule.selectEveryDay(day);
        schedule.clickWith();
        Assert.assertEquals(schedule.isExpectedInvite(),schedule.isActualInvite());
        schedule.clickCloseInvite();
    }

    @Then("get post event \"(.*)\"")
    public void postEvent(String tell) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.clickSwitchPrivate();
        schedule.inputTextNote(tell);
        schedule.clickPostButton();
        Assert.assertTrue(schedule.messageNotification());
    }

    @And("User create event dont repeat \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void createEventDontRepeat(String title,String start,String end,String day) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextTitle(title);
        schedule.inputStartDate(start);
        schedule.inputEndDate(end);
        schedule.selectEveryDay(day);
        schedule.clickWith();
        Assert.assertEquals(schedule.isExpectedInvite(),schedule.isActualInvite());
        schedule.clickCloseInvite();
    }

    @Then("User input note until post event \"(.*)\"")
    public void clickPostEvent(String tell) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.clickSwitchPrivate();
        schedule.inputTextNote(tell);
        schedule.clickPostButton();
        Assert.assertTrue(schedule.messageNotification());
    }

    @And("User create event every week \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void createEventEveryWeek(String title,String start,String end,String day) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextTitle(title);
        schedule.inputStartDate(start);
        schedule.inputEndDate(end);
        schedule.selectEveryDay(day);
        schedule.clickWith();
        Assert.assertEquals(schedule.isExpectedInvite(),schedule.isActualInvite());
        schedule.clickCloseInvite();
    }

    @And("User create event Every year \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void createEventEveryYear(String title,String start,String end,String day) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextTitle(title);
        schedule.inputStartDate(start);
        schedule.inputEndDate(end);
        schedule.selectEveryDay(day);
        schedule.clickWith();
        Assert.assertEquals(schedule.isExpectedInvite(), schedule.isActualInvite());
        schedule.clickCloseInvite();
    }

    @Then("get note post \"(.*)\"")
    public void clickPostEventButton(String tell) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextNote(tell);
        schedule.clickPostButton();
        Assert.assertTrue(schedule.messageNotification());
    }

    @And("User create event public Dont repeat \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"")
    public void createEventPublicDontRepeat(String title,String start,String end,String day) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextTitle(title);
        schedule.inputStartDate(start);
        schedule.inputEndDate(end);
        schedule.selectEveryDay(day);
        schedule.clickWith();
        Assert.assertEquals(schedule.isExpectedInvite(), schedule.isActualInvite());
        schedule.clickCloseInvite();
    }

    @Then("get verify invitation \"(.*)\"")
    public void verifyInvitation(String tell) throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.inputTextNote(tell);
        schedule.clickPostButton();
        Assert.assertEquals(schedule.expectedInvitation(),schedule.actualInvitation());
        schedule.clickInvitationSchedule();
    }

    @When("User click schedulepage")
    public void schedulePage() throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.clickSchedule();
    }

    @Then("navigate private invitation")
    public void clickPrivateInvitation() throws InterruptedException {
        SchedulePage schedule = new SchedulePage(webDriver);
        schedule.clickPrivate();
        Assert.assertTrue(schedule.titleInvitation());
    }

}
