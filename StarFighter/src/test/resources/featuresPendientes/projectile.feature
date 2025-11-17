Feature: Projectile Behavior

Scenario: Projectile moves automatically each turn
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the starfighter fires
  When the player passes a turn
  Then the projectile should be at row 3, column 3

Scenario: Projectile fired from last column disappears
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the starfighter is positioned at row 3, column 9
  When the starfighter fires
  Then no projectile should exist on the grid

Scenario: Multiple projectiles move in correct order
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  And the starfighter fires
  And the player passes a turn
  And the starfighter fires
  When the player passes a turn
  Then the oldest projectile should be at row 3, column 5
  And the newest projectile should be at row 3, column 3

Scenario: Projectile moves off the grid and disappears
  Given a game is initialized with a grid of 5 rows and 5 columns and m1=5 and m2=3
  And the starfighter is positioned at row 3, column 3
  And the starfighter fires
  When the player passes a turn
  Then no projectile should exist on the grid