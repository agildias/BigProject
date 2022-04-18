package com.agildias.StepDefinition;

import com.agildias.PageObject.BoardPage;
import com.agildias.PageObject.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BoardStep {
    private WebDriver webDriver;

    public BoardStep() {
        super();
        this.webDriver = Hook.webDriver;
    }

    @Given("User Login with email \"(.*)\" and password \"(.*)\"")
    public void loginUsers(String email,String pwd) throws InterruptedException {
        LoginPage login = new LoginPage(webDriver);
        login.clickLoginGoogle();
        login.inputGoogleEmail(email);
        login.clickBerikutnya();
        login.inputPasswordGoogle(pwd);
        login.clickNextButton();
        login.clickPaketSoalB();
    }

    @When("User navigate to Board")
    public void navigateTOBoard(){
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
    }

    @Then("succes Create Board \"(.*)\"")
    public void createBoard(String input){
        BoardPage board = new BoardPage(webDriver);
        board.clickAddList();
        board.inputTextListName(input);
        board.clickCreate();
        Assert.assertTrue(board.verifyFirstBoard());
    }

    @Then("get Board \"(.*)\" verify message")
    public void createBlankBoard(String input) throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickAddList();
        board.inputTextListName(input);
        board.clickCreate();
        Assert.assertTrue(board.notificationMessage());

    }

    @Then("Name card has change \"(.*)\"")
    public void changeCardTitle(String title) throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickFirstCardTitle();
        board.inputTextTitle(title);
        Assert.assertTrue(board.notificationMessage());
    }

    @When("User Create Card and Input Card Name \"(.*)\"")
    public void createFirstKanban(String input){
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
        board.clickAddCard();
        board.inputTextCard(input);
    }

    @Then("Card already made")
    public void verifyKanban() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        Assert.assertTrue(board.notificationMessage());
    }

    @When("User Click Kanban")
    public void navigateToKanban() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
        board.clickFirstKanban();
    }

    @Then("succes save \"(.*)\"")
    public void inputNoteMessage(String note) throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickNotes();
        board.inputTextNotes(note);
        board.clickSaveButton();
        Assert.assertTrue(board.notificationMessage());
    }

    @When("User Click Edit Kanban")
    public void clickEditKanbanBoard() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
        board.clickFirstKanban();
    }

    @Then("succes in Delete text note")
    public void inputEmoticonNotes() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.clickNotes();
        board.deleteTextNotes();
        board.clickSaveButton();
        Assert.assertTrue(board.notificationMessage());
    }

    @When("User Click Board")
    public void clickEditMenu()  {
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
    }

    @Then("succes Comment and save")
    public void quickComment() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.commentButton();
        Assert.assertTrue(board.notificationMessage());
    }

    @Then("succes delete comment")
    public void deleteComment() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.deleteCommentButton();
        Assert.assertTrue(board.notificationMessage());
    }

    @Then("succes tag Toggle member")
    public void changeMember() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.tagToggleMember();
        Assert.assertTrue(board.notificationMessage());
    }

    @When("User click board")
    public void createSecondCard(){
        BoardPage board = new BoardPage(webDriver);
        board.clickBoard();
    }

    @Then("succes Drag and drop Card")
    public void dragAndDropCard() throws InterruptedException {
        BoardPage board = new BoardPage(webDriver);
        board.moveCard();
    }
}
