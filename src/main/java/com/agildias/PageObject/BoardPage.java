package com.agildias.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BoardPage {
    private static WebDriver driver;
    public BoardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[.='Board']")
    private WebElement board;

    @FindBy(xpath = "//a[.='Add List']")
    private WebElement addList;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputListName;

    @FindBy(xpath = "//div[@class='Button_container__1WNuB']")
    private WebElement createButton;

    @FindBy(xpath = "//div[@class='ListContainer_headerSection__title__text__36H_r']")
    private WebElement firstBoard;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement inputText;

    @FindBy(id = "notistack-snackbar")
    private WebElement notification;

    @FindBy(xpath = "//a[.='Add Card']")
    private WebElement addCard;

    @FindBy(xpath = "//a[@href='/cards/624fdddf3ddcc172ffb9d9c5']")
    private WebElement firstCard;

    @FindBy(xpath = "//div[@class='ManageDesc_editIcon__1I0bY']")
    private WebElement notes;

    @FindBy(xpath = "//div[@class='fr-element fr-view']")
    private WebElement inputNotes;

    @FindBy(xpath = "//button[@class='btn btn-success btn-sm']")
    private WebElement saveButton;



    public void clickBoard(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(board));
        board.click();
    }

    public void clickAddList(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(addList));
        addList.click();
    }

    public void inputTextListName(String input){
        inputListName.sendKeys(input);
    }

    public void clickCreate(){
        createButton.click();
    }

    public boolean verifyFirstBoard(){
        String boa = firstBoard.getText();
        System.out.println(boa);
        return firstBoard.isDisplayed();
    }
    public void clickFirstCardTitle(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(firstBoard));
        firstBoard.click();
    }

    public void inputTextTitle(String title) throws InterruptedException {
        Thread.sleep(2000);
        inputText.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        inputText.sendKeys(title);
        inputText.sendKeys(Keys.ENTER);
    }

    public boolean notificationMessage() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(notification));
        String msg = notification.getText();
        System.out.println(msg);
        return notification.isDisplayed();
    }

    public void clickAddCard(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(addCard));
        addCard.click();
    }

    public void inputTextCard(String card){
        inputText.sendKeys(card);
        inputText.sendKeys(Keys.ENTER);
    }
    public void clickFirstKanban()  {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(firstCard));
        firstCard.click();
    }
    public void clickNotes() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(notes));
        notes.click();
    }

    public void inputTextNotes(String note){
        inputNotes.sendKeys(note);
    }

    public void clickSaveButton(){
        saveButton.click();
    }

    public void deleteTextNotes(){
        inputNotes.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
    }

    public void commentButton() throws InterruptedException {
        Thread.sleep(5000);
       WebElement menu =driver.findElement(By.cssSelector("[data-rbd-draggable-id='624fdddf3ddcc172ffb9d9c5'] > #editCardMenu"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        Actions a = new Actions(driver);
        a.moveToElement(menu).click().build().perform();
       WebElement quick =driver.findElement(By.cssSelector(".EditCardMenu_menu__2xvBw:nth-child(2) > #editCardMenuButton__Move__text"));
        Thread.sleep(5000);
        Actions b = new Actions(driver);
        b.moveToElement(quick).click().build().perform();
       WebElement com =driver.findElement(By.cssSelector(".CreateCommentForm_formInitial__3AVVg"));
        Thread.sleep(3000);
        Actions c = new Actions(driver);
        c.moveToElement(com).click().build().perform();
        Thread.sleep(8000);
       driver.findElement(By.xpath("//input[@class='CreateCommentForm_formInitial__3AVVg form-control']")).click();
       driver.findElement(By.xpath("//div[@class='fr-element fr-view']")).sendKeys("Mencoba");
       Thread.sleep(3000);
       saveButton.click();

    }

    public void deleteCommentButton() throws InterruptedException {
        Thread.sleep(5000);
        WebElement menu =driver.findElement(By.cssSelector("[data-rbd-draggable-id='624fdddf3ddcc172ffb9d9c5'] > #editCardMenu"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(menu));
        Actions a = new Actions(driver);
        a.moveToElement(menu).click().build().perform();
        WebElement quick =driver.findElement(By.cssSelector(".EditCardMenu_menu__2xvBw:nth-child(2) > #editCardMenuButton__Move__text"));
        Thread.sleep(3000);
        Actions b = new Actions(driver);
        b.moveToElement(quick).click().build().perform();
        Thread.sleep(4000);
        WebElement lastcom = driver.findElement(By.xpath("//p[.='Delete'][last()]"));
        lastcom.click();
        WebElement delete = driver.findElement(By.xpath("//button[@class='btn btn-danger btn-block btn-sm']"));
        delete.click();
    }

    public void tagToggleMember() throws InterruptedException {
        Thread.sleep(5000);
        WebElement menu =driver.findElement(By.cssSelector("#editCardMenuIcon"));
        Thread.sleep(3000);
        Actions a = new Actions(driver);
        a.moveToElement(menu).click().build().perform();
        WebElement quick =driver.findElement(By.cssSelector("#editCardMenuButton__Member__icon"));
        Thread.sleep(3000);
        Actions b = new Actions(driver);
        b.moveToElement(quick).click().build().perform();
        WebElement member =driver.findElement(By.xpath("//p[.='Agil Dias Syahrizal']"));
        Thread.sleep(3000);
        Actions c = new Actions(driver);
        c.moveToElement(member).click().build().perform();
        Thread.sleep(2000);
    }

    public void moveCard() throws InterruptedException {
        Thread.sleep(3000);
        WebElement one = driver.findElement(By.xpath("//a[@href='/cards/625002b630d9d161b1ea2d79']"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(one));
        WebElement two = driver.findElement(By.id("listcard_content-1"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(one,two).perform();



    }
}
