
Feature: Board

  Scenario: Create Card
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User navigate to Board
    Then succes Create Board "TestingBoard"

  Scenario: Negatif case Create Card Blank
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User navigate to Board
    Then get Board "" verify message

  Scenario: Change Card Title
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User navigate to Board
    Then Name card has change "Kanban Nih Bos"

  Scenario: Add Card
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Create Card and Input Card Name "Pertama"
    Then Card already made

  Scenario: Input Note Kanban
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Click Kanban
    Then succes save "something wrong"

  Scenario: Delete text note
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Click Edit Kanban
    Then succes in Delete text note

  Scenario: Quick Comment
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Click Board
    Then succes Comment and save

  Scenario: Delete Comment
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Click Board
    Then succes delete comment

  Scenario: Toggle Member
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User Click Board
    Then succes tag Toggle member

  Scenario: Drag and drop Card
    Given User Login with email "agild.0207@gmail.com" and password "Agil12345678"
    When User click board
    Then succes Drag and drop Card
