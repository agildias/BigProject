
  Feature: Notification

    Scenario: Notification Chat
      Given User Login "agild.0207@gmail.com" and "Agil12345678" for use group chat
      When  User click notification Chat
      Then navigate to privateChat

    Scenario: All Notification
      Given User Login "agild.0207@gmail.com" and "Agil12345678" for use group chat
      When User Click Notification Message
      Then navigate to GroupChat