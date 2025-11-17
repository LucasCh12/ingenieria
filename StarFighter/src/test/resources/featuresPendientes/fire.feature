Feature: Starfighter Fire

Scenario: Starfighter fires a projectile
  Given a game is initialized with a grid of 5 rows and 10 columns and m1=5 and m2=2
  When the starfighter fires
  Then a projectile should exist at row 3, column 1