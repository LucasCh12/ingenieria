Feature: Board Basic Behaviour
    
    Scenario: Valid Board Creation with state
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then the board dimensions should be 3x5
        And the board state should be:
            """
            _ _ _ _ _ 
            S _ _ _ _ 
            _ _ _ _ _
            """
        And the object count in board is 1
        And the position row: 1 column: 0 is ocuppied

    Scenario: Invalid board creation for row value bellow minimum
        Given a board configuration with -1 rows and 15 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then an IllegalArgumentException should be thrown with message "Rows must be between 3 and 10"

    Scenario: Invalid board creation for row value beyond maximum
        Given a board configuration with 11 rows and 15 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then an IllegalArgumentException should be thrown with message "Rows must be between 3 and 10"
    
    Scenario: Invalid board creation for column value bellow minimum
        Given a board configuration with 3 rows and -1 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then an IllegalArgumentException should be thrown with message "columns must be between 5 and 30"

    Scenario: Invalid board creation for column value beyond maximum
        Given a board configuration with 3 rows and 31 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then an IllegalArgumentException should be thrown with message "columns must be between 5 and 30"
        

    Scenario: Test position with valid row but negative column
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: 1 column: -1
        Then the result is false

    Scenario: Test position with valid row but column beyond maximum
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: 1 column: 5
        Then the result is false

    Scenario: Test position with negative row but valid column
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: -1 column: 2
        Then the result is false

    Scenario: Test position with row beyond maximum but valid column
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: 3 column: 2
        Then the result is false

    Scenario: Test position with negative row and column beyond maximum
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: -1 column: 6
        Then the result is false

    Scenario: Test position with row beyond maximum and negative column
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: 4 column: -1
        Then the result is false

    Scenario: Valid Board Creation with state and fog
        Given a board configuration with 10 rows and 30 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        Then the board dimensions should be 10x30
        And the board state should be:
        """
        _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        S _ _ _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        _ _ _ _ _ _ _ _ _ _ ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
        """
        And the object count in board is 1
        And the position row: 5 column: 0 is ocuppied

    Scenario: Ask if StarFighter is in invalid pos
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I ask if the StarFighter is in position row: -1 column: -1
        Then the result is false
    
    Scenario: Add a projectile off board
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I want to add a Projectile in position row: 5 column 7
        Then the board dimensions should be 3x5
        And the board state should be:
            """
            _ _ _ _ _ 
            S _ _ _ _ 
            _ _ _ _ _
            """
        
    Scenario: Add a projectile in a pos of another projectile
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I want to add a Projectile in position row: 0 column 0
        And I want to add a Projectile in position row: 0 column 0
        Then the board dimensions should be 3x5
        And the board state should be:
            """
            * _ _ _ _ 
            S _ _ _ _ 
            _ _ _ _ _
            """

   Scenario: Adding non-Projectile object in invalid position should throw exception
        Given a board configuration with 3 rows and 5 columns
        And a StarFighter with move speed 2 and vision 13 and projectile speed 2
        When I create the board
        And I try to add a non-Projectile object at position row: -1 column: 2
        Then an IllegalArgumentException should be thrown with message "Invalid object position"
    




    