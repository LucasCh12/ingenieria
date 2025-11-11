Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given Today is Sunday
    When I ask the system whether it's Friday
    Then The answer should be false 

  Scenario: Friday finally it's Friday
    Given Today is Friday
    When I ask the system whether it's Friday
    Then The answer should be true

  Scenario: Monday isn't Wednesday
    Given Today is Monday
    When I ask the system whether it's Wednesday
    Then The answer should be false