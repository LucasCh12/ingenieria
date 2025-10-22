Feature: Starfighter collisions

  Scenario: Starfighter collides with its own projectile
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=1
    And the starfighter fires
    When the starfighter moves 0 rows down and 1 columns right
    Then the game should be over and the position 3,1 should be marked with X

Feature: Projectile collisions during movement

  Scenario: Projectile hits the Starfighter in phase 1
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
    And the starfighter fires
    When the player passes a turn
    Then the game should be over and the starfighter position should be marked with X

  Scenario: Projectile moves before Starfighter action in same turn
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
    And the starfighter is positioned at row 3, column 1
    And the starfighter fires
    When the player passes a turn
    Then the game should be over and the position 3,3 should be marked with X

  Scenario: Starfighter collides while moving vertically through a projectile
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
    And a projectile is at row 4, column 0
    When the starfighter moves 2 rows down and 0 columns right
    Then the game should be over and the position 4,0 should be marked with X

  Scenario: Starfighter collides while moving horizontally through a projectile
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
    And a projectile is at row 3, column 2
    When the starfighter moves 0 rows down and 3 columns right
    Then the game should be over and the position 3,2 should be marked with X

  Scenario: Output shows projectile movement and collision before game over
    Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
    And the starfighter fires
    And the starfighter is positioned at row 3, column 1
    When the player passes a turn
    Then the output should contain "Command issued: pass (ok)"
    And the output should contain "A projectile moves and collides with the Starfighter"
    And the output should contain "Game over."
