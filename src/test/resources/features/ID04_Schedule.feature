
Feature: Schedule

 Scenario: Create Event Private
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedule and click create even
    And User create event Every day "Breakfast" "2022/04/11" "2022/04/11" "Every day"
   Then get post event "Mencoba"

  Scenario:  Negatif case Blank on Date Event Private
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedule and click create even
    And User create event dont repeat "Breakfast" "" "" "Don't repeat"
    Then get post event "Booking"

  Scenario:  Negatif case Blank Title on Date Event Private
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedule and click create even
    And User create event every week "" "" "" "Every week"
    Then get post event "Booking"

  Scenario: Create Event Public
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedule and click create even
    And User create event Every year "Makan Makan" "2022/04/15" "2023/04/17" "Every year"
    Then get note post "Makan Bayar sendiri"

  Scenario: Verify Invitation Public
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedule and click create even
    And User create event public Dont repeat "1 for all" "2022/04/11" "2022/04/11" "Don't repeat"
    Then get verify invitation "Alamak"

  Scenario: Verify Invitation Private
    Given User Login Schedule "agild.0207@gmail.com" and password "Agil12345678" for use schedule
    When User click schedulepage
    Then navigate private invitation