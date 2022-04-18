package com.agildias.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div/p[.='Login with Google Account']")
    private WebElement loginAccount;

    @FindBy(id = "identifierId")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//span[.='Berikutnya']")
    private WebElement berikutButton;

    @FindBy(xpath = "//div[@id='view_container']//span[.='Berikutnya']")
    private WebElement nextButton;

    @FindBy(xpath = "//h1[.='Paket soal B']")
    private WebElement verifyPaket;

    @FindBy(xpath = "//h1[.='Paket B']")
    private WebElement paketSoalB;

    public void clickLoginGoogle(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(loginAccount));
        loginAccount.click();
    }

    public void inputGoogleEmail(String email){
//        WebElement a = driver.findElement(By.xpath("//div[.='agil dias']"));
//        a.click();
        inputEmail.sendKeys(email);
    }

    public void clickBerikutnya(){
        berikutButton.click();
    }
    public void inputPasswordGoogle(String pwd){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        inputPassword.sendKeys(pwd);
    }
    public void clickNextButton() throws InterruptedException {
        Thread.sleep(2000);
        nextButton.click();
    }

    public boolean isImage(){
        verifyPaket.isDisplayed();
        String img = verifyPaket.getText();
        System.out.println(img);
        return verifyPaket.isEnabled();
    }

    public void clickPaketSoalB(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(paketSoalB));
        paketSoalB.click();
    }
}
