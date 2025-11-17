Feature: Starfighter Movement

Scenario: Starfighter moves within allowed distance
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  When the starfighter moves 2 rows down and 3 columns right
  Then the starfighter should be positioned at row 5, column 4

Scenario: Starfighter cannot move beyond allowed distance
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=4 and m2=2
  When the starfighter tries to move 3 rows down and 3 columns right
  Then an error should be raised with message "Move exceeds maximum allowed distance"

Feature: Step-by-step movement collisions

Scenario: Starfighter collides with projectile during movement
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And a projectile is at row 4, column 1
  When the starfighter moves 2 rows down and 0 columns right
  Then the game should be over and the position 4,1 should be marked with X