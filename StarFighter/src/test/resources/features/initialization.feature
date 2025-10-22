Feature: Starfighter game initialization.

  Scenario: Starfighter correctly positioned at the start of game, when grid has odd rows and columns
    Given the application has been started
    When the game is initialized with a grid of 5 rows and 5 columns
    Then the starfighter should be positioned at row 3, column 0


  Scenario: Cannot start a game with too few rows
    Given the application has been started
    When the game is initialized with a grid of 2 rows and 10 columns
    Then an error should be raised with message "Rows must be between 3 and 10"


  Scenario: Cannot start a game with too many columns
    Given the application has been started
    When the game is initialized with a grid of 5 rows and 50 columns
    Then an error should be raised with message "Columns must be between 5 and 30"

  Scenario: Cannot start a game with invalid m1
    Given the application has been started
    When the game is initialized with a grid of 5 rows and 10 columns and m1=50 and m2=2
    Then an error should be raised with message "m1 must be between 1 and 40"

  Scenario: Cannot start a game with invalid m2
    Given the application has been started
    When the game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=10
    Then an error should be raised with message "m2 must be between 1 and 5"
