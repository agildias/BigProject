
Feature: Group Chat

  Scenario: Send message text
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input text message "Mencoba Lagi Dong"
    Then message displayed

  Scenario: Negatif case send long message text
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input text long message "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
    Then message displayed

  Scenario: Delete message
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input text message "Mencoba Lagi Dong"
    Then Notification Succes Delete

  Scenario: Upload image
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input image
    Then notification succes upload

  Scenario: Download image
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input image
    Then succes upload and download until delete

  Scenario: Tag Friend
    Given User Login first user input "agild.0207@gmail.com" and "Agil12345678" for use group chat
    When User Click GroupChat and input text message tag friend "@ag"
    Then navigate to friend profile

