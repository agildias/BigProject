package com.agildias.PageObject;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulePage {
    private static WebDriver driver;
    public SchedulePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//h1[.='Schedule']")
    private WebElement schedule;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement createEventButton;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement inputTitleEvent;

    @FindBy(xpath = "//input[@id='date-picker-dialog-start']")
    private WebElement dateStart;

    @FindBy(xpath = "//input[@id='date-picker-dialog-end']")
    private  WebElement dateEnd;

    @FindBy(xpath = "//div[@class='CreateEventPage_plusButton__3LxsU']")
    private WebElement with;

    @FindBy(xpath = "//p[.='Agil Dias Syahrizal']")
    private WebElement invite;

    @FindBy(css = ".ManageSubscribersContainer_ManageSubscribersContainer__Header__1jlWK > .MuiSvgIcon-root")
    private WebElement closeModalInvite;

    @FindBy(xpath = "//span[.='Agil Dias Syahrizal']")
    private WebElement actualInvite;

    @FindBy(xpath = "//input[@name='switchItem']")
    private WebElement switchItem;

    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    private WebElement inputNote;

    @FindBy(xpath = "//div[.='Post Event']")
    private WebElement postButton;

    @FindBy(id = "notistack-snackbar")
    private WebElement notification;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div//h1[contains(.,'1 for all')][last()]")
    private WebElement inviteSchedule;


    public void clickSchedule() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(schedule));
        schedule.click();
    }

    public void clickCreateEvent() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(createEventButton));
        createEventButton.click();
    }

    public void inputTextTitle(String title) throws InterruptedException {
        inputTitleEvent.sendKeys(title);
        Thread.sleep(2000);
    }

    public void inputStartDate(String start){
        dateStart.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        dateStart.sendKeys(start);
    }

    public void inputEndDate(String end){
        dateEnd.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        dateEnd.sendKeys(end);
    }

    public void selectEveryDay(String day) {
        WebElement rep = driver.findElement(By.xpath("//div[@class='MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input']"));
        rep.click();
        WebElement a = driver.findElement(By.xpath("//li[@role='option']"));
        List<WebElement> options = driver.findElements(By.xpath("//li[@role='option']"));
        for (WebElement op : options) {
            if (op.getText().equals(day)) {
                op.click();
                break;
            }
        }
    }

    public void clickWith() throws InterruptedException {
        with.click();
        invite.click();
        String a = invite.getText();
        System.out.println(a);
        Thread.sleep(2000);
    }

    public boolean isExpectedInvite(){
        String a = invite.getText();
        System.out.println(a);
        return invite.isEnabled();
    }

    public void clickCloseInvite(){
        Actions w = new Actions(driver);
        w.moveToElement(closeModalInvite).click().perform();
//        closeModalInvite.click();
    }

    public boolean isActualInvite(){
        String b = actualInvite.getText();
        System.out.println(b);
        return actualInvite.isDisplayed();
    }

    public void clickSwitchPrivate(){
//        Select w = new Select(switchItem);
//        for (int i=0 ; i<2;i++){
            switchItem.click();
            switchItem.isSelected();
            System.out.println(switchItem.isSelected());
//        }
    }

    public void inputTextNote(String tell){
        inputNote.sendKeys(tell);
    }

    public void clickPostButton() throws InterruptedException {
        postButton.click();
        Thread.sleep(2000);
    }

    public boolean messageNotification() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver,30);
       wait.until(ExpectedConditions.visibilityOf(notification));
        String not = notification.getText();
        System.out.println(not);
        return notification.isDisplayed();
    }

    public boolean expectedInvitation(){
       String a = inputTitleEvent.getAttribute("value");
        System.out.println(a);
        return inputTitleEvent.isEnabled();
    }

    public boolean actualInvitation() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(inviteSchedule));
        String b = inviteSchedule.getText();
        System.out.println(b);
        return inviteSchedule.isEnabled();
    }

    public void clickInvitationSchedule(){
        inviteSchedule.click();
    }

    public void clickPrivate() {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(createEventButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement a = driver.findElement(By.xpath("//div//h1[contains(.,'IKI Lo')][last()]"));
        a.click();
    }

    public boolean titleInvitation(){
        WebElement iki = driver.findElement(By.xpath("//h1[contains(.,'IKI Lo')]"));
        String a = iki.getText();
        System.out.println(a);
        return iki.isDisplayed();
    }
}
