Feature: Finish Game

Scenario: Abort ends the current game
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  When the player aborts the game
  Then the game should no longer be active

Feature: Commands after game over

Scenario: Cannot execute commands after game is over
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the player aborts the game
  When the starfighter tries to fire
  Then an error should be raised with message "Game is not active"

Scenario: Cannot start a new game while one is active
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  When the player tries to initialize another game with a grid of 6 rows and 10 columns and m1=4 and m2=2
  Then an error should be raised with message "Game already in progress"

Scenario: Cannot move after game is over
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the player aborts the game
  When the starfighter tries to move 1 row down and 0 columns right
  Then an error should be raised with message "Game is not active"

Scenario: Cannot pass after game is over
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the player aborts the game
  When the player tries to pass a turn
  Then an error should be raised with message "Game is not active"