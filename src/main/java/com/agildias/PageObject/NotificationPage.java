package com.agildias.PageObject;

import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.XMLFormatter;

public class NotificationPage {
    private static WebDriver driver;

    public NotificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".NavHeader_navIconSection__2A2RJ > div:nth-of-type(1)")
    private WebElement chatNotification;

    @FindBy(xpath = "//p[.='Agil Dias Syahrizal']")
    private WebElement recentChat;

    @FindBy(xpath = "//div[@class='PrivateChatPage_headerSection__bodySection__memberName__bigvk']/p[.='Agil Dias Syahrizal']")
    private WebElement privateChat;

    @FindBy(css = ".NavHeader_navIconSection__2A2RJ > div:nth-of-type(2)")
    private WebElement message;

    @FindBy(xpath = "//h1[.='Card RE: Pertamax']")
    private WebElement notifGrupChat;

    @FindBy(xpath = "//div[@class='modal-title h4']/h1[contains(.,'Pertamax')]")
    private WebElement verifyGrup;

    public void clickChatNotif() throws InterruptedException {
        Thread.sleep(3000);
        chatNotification.click();
    }

    public void clickRecentChat() throws InterruptedException {
        Thread.sleep(8000);
        recentChat.click();

    }

    public boolean chat(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(privateChat));
        String a = privateChat.getText();
        System.out.println(a);
        return privateChat.isEnabled();
    }

    public void clickMessage()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(message));
        message.click();
    }

    public void clickNotifGrupChat() throws InterruptedException {
        Thread.sleep(8000);
        notifGrupChat.click();

    }

    public boolean checkGrupChat(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-title h4']/h1[contains(.,'Pertamax')]")));
        String a = verifyGrup.getText();
        System.out.println(a);
        return verifyGrup.isEnabled();
    }
}
