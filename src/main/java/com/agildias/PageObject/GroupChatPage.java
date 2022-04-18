package com.agildias.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class GroupChatPage {
    private static WebDriver driver;
    public GroupChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[.='Group Chat']")
    private WebElement groupChat;

    @FindBy(xpath = "//h1[.='Group Chat - Paket B']")
    private WebElement titleGroupChat;

    @FindBy(xpath = "//div[@class='fr-element fr-view']/p[1]")
    private WebElement typeMessage;

    @FindBy(xpath = "//button[@class='rounded-circle btn btn-warning btn-sm']")
    private WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class='fr-view'][last()]/p")
    private WebElement checkMessage;

//    @FindBy(css = "#group-chat-page > div > div > div:nth-child(1) > div > div.Message_bodySection__avu8p > div.Message_headerMessage__2REkT > div.Message_iconOption__3qihj > svg")
    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div//div[@class='Message_iconOption__3qihj'][last()]")
    private WebElement hiddenButton;

    @FindBy(xpath = "//p[.='Delete Message']")
    private WebElement deleteButton;

    @FindBy(xpath = "//div[@class='Button_container__1WNuB']")
    private WebElement deleteButton2;

    @FindBy(id = "notistack-snackbar")
    private WebElement notification;

    @FindBy(css = ".CreateGroupMessage_attachmentButton__i4UJs > .MuiSvgIcon-root")
    private WebElement attachButton;

//    @FindBy(xpath = "//input[@type='file']")
    @FindBy(xpath = "//div[@class='CreateGroupMessage_attachmentButton__i4UJs']/preceding-sibling::input")
    private WebElement inputImage;

    @FindBy(xpath = "//a[.='Download']")
    private WebElement download;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']/div//div[@class='AttachmentItem_iconOption__2qhwj'][last()]")
    private WebElement delImage;

    @FindBy(xpath = "//div[@class='AttachmentItem_main__title__1KAge'][last()]")
    private WebElement checkImageMessage;

    @FindBy(xpath = "//body/img")
    private WebElement verifyImage;

    @FindBy(xpath = "//span[@id='mentioned-user']/a[.='agild 0207'][last()]")
    private WebElement tagMessage;

    @FindBy(xpath = "//h1[.='agild 0207']")
    private WebElement profileFriend;


    public void clickGroupChat()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(groupChat));
        groupChat.click();
    }

    public boolean titleGroup(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(titleGroupChat));
        String paketB = titleGroupChat.getText();
        System.out.println(paketB);
        return titleGroupChat.isDisplayed();
    }

    public void sendTextMessage(String msg){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(typeMessage));
        typeMessage.sendKeys(msg);
    }

    public void sendMessage() throws InterruptedException {
        Thread.sleep(2000);
        sendMessageButton.click();

    }

    public boolean isMessage() throws InterruptedException {
        Thread.sleep(3000);
        String text = checkMessage.getText();
        System.out.println(text);
        return checkMessage.isDisplayed();
    }

    public void clickHiddenButton() throws InterruptedException {
        checkMessage.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(hiddenButton));
        Actions a = new Actions(driver);
        a.moveToElement(hiddenButton).click().build().perform();
        boolean isDelete = deleteButton.isDisplayed();
        System.out.println(isDelete);
        Thread.sleep(2000);
        deleteButton.click();
        deleteButton2.click();
    }

    public boolean isSuccesDeleteMessage(){
        String del = notification.getText();
        System.out.println(del);
        return notification.isDisplayed();
    }

    public void clickAttachmen() throws InterruptedException {
//        List<WebElement> inputs = driver.findElements(By.tagName("input"));
//
//        for (WebElement input : inputs) {
//            ((JavascriptExecutor) driver).executeScript(
//                    "arguments[0].removeAttribute('style','display: none;')", input);
//        }

        Thread.sleep(6000);
        String file= System.getProperty("user.dir")+"\\driver\\hulk.jpeg";
        inputImage.sendKeys(file);

    }
    public boolean imageDisplayed(){
        notification.isDisplayed();
        String hulk = notification.getText();
        System.out.println(hulk);
        return notification.isEnabled();
    }

    public void clickDownload() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(download));
        Thread.sleep(2000);
        download.click();
        Thread.sleep(3000);
    }


    public void windowsHandle(){
        ArrayList<String> tabs2 = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public void deleteImage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(delImage));
        checkImageMessage.click();
        Thread.sleep(3000);
        Actions a = new Actions(driver);
        a.moveToElement(delImage).click().build().perform();
        boolean isDelete = deleteButton.isDisplayed();
        System.out.println(isDelete);
        deleteButton.click();
        deleteButton2.click();
    }

    public boolean notifImageDelte() throws InterruptedException {
        Thread.sleep(5000);
        String del = notification.getText();
        System.out.println(del);
        return notification.isDisplayed();
    }

    public void tagChat(String tag){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(typeMessage));
        typeMessage.sendKeys(tag);
        typeMessage.sendKeys(Keys.ENTER);
    }

    public void clickTagMessage(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(tagMessage));
        tagMessage.click();
    }

    public boolean verifyProfile(){
        String pro = profileFriend.getText();
        System.out.println(pro);
        return profileFriend.isDisplayed();
    }
}
