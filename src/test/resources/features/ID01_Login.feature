
Feature: Cicle Login

Scenario: Login
  Given user navigate to login
  When user input "agild.0207@gmail.com" and "Agil12345678"
  Then user navigate to dashboard