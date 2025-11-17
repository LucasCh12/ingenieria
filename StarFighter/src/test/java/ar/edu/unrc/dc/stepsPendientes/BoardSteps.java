package ar.edu.unrc.dc.stepsPendientes;

import ar.edu.unrc.dc.model.board.Board;
import ar.edu.unrc.dc.model.board.Position;
import ar.edu.unrc.dc.model.board.objects.entities.fighters.StarFighter;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;

public class BoardSteps {
    private Board board;
    private int row;
    private int column;
    private int starFighterMoveSpeed;
    private int starFighterVision;
    private int projectileSpeed;
    private StarFighter starFighter;
    private Position starFighterPosition;
    private Exception exception;
    boolean result;
    Projectile projectile;
    /*
    private String normalizeBoardString(String boardString) {
        return boardString.trim() 
                     .replaceAll(" \\n", "\n") 
                     .replaceAll(" +", " "); 
    }

    @Given("a board configuration with {int} rows and {int} columns")
    public void a_board_configuration_with_rows_and_columns(Integer int1, Integer int2) {
        row = int1;
        column = int2;
        starFighterPosition = new Position((row)/2, 0);
    }

    @And("a StarFighter with move speed {int} and vision {int} and projectile speed {int}")
    public void a_star_fighter_with_move_speed_and_vision_and_projectile_speed(Integer int1, Integer int2, Integer int3) {
        starFighterMoveSpeed = int1;
        starFighterVision = int2;
        projectileSpeed = int3;
        starFighter = new StarFighter(starFighterPosition, starFighterMoveSpeed, projectileSpeed, starFighterVision);
    }

    @When("I create the board")
    public void i_create_the_board() {
        try {
            board = new Board(row, column, starFighter);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("the board dimensions should be 3x5")
    public void the_board_dimensions_should_be_3x5() {
        assertEquals(3,board.getRow());
        assertEquals(5,board.getColumn());
    }

    @Then("the board dimensions should be 10x30")
    public void the_board_dimensions_should_be_10x30() {
        assertEquals(10,board.getRow());
        assertEquals(30,board.getColumn());
    }

    @And("the board state should be:")
    public void the_board_state_should_be(String docString) {
        String expected = normalizeBoardString(docString);
        String actual = normalizeBoardString(board.toString());
    
        assertEquals(expected, actual);
    }

    @Then("the object count in board is {int}")
    public void the_object_count_in_board_is(Integer int1) {
        assertEquals(board.getObjectCount(), int1);    
    }

    @Then("an IllegalArgumentException should be thrown with message {string}")
    public void an_illegal_argument_exception_should_be_thrown_with_message(String expectedMessage) {
        assertTrue(exception instanceof IllegalArgumentException, 
                   "Expected IllegalArgumentException but got: " + exception.getClass());
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Then("the position row: {int} column: {int} is ocuppied")
    public void the_position_row_column_is_ocuppied(Integer int1, Integer int2) {
        assertTrue(board.isOccupied(starFighterPosition));
        assertEquals(starFighterPosition.getRow(), int1);
        assertEquals(starFighterPosition.getColumn(), int2);
    }

    @And("I ask if the StarFighter is in position row: {int} column: {int}")
    public void i_ask_if_the_star_fighter_is_in_position_row_column(Integer int1, Integer int2) {
        Position auxPosition = new Position(int1, int2);
        result = board.isOccupied(auxPosition);
    }

    @Then("the result is false")
    public void the_result_is_false() {
        assertFalse(result);
    }

    @When("I want to add a Projectile in position row: {int} column {int}")
    public void i_want_to_add_a_projectile_in_position_row_column(Integer int1, Integer int2) {
        Position auxPosition = new Position(int1, int2);
        projectile = new Projectile(auxPosition, projectileSpeed);
        board.addObjectToBoard(projectile);        
    }

    @When("I try to add a non-Projectile object at position row: {int} column: {int}")
    public void i_try_to_add_a_non_projectile_object_at_position_row_column(Integer row, Integer col) {
        Position invalidPosition = new Position(row, col);
        StarFighter invalidStarFighter = new StarFighter(invalidPosition, 2, 2, 13);
        try {
            board.addObjectToBoard(invalidStarFighter);
        } catch (Exception e) {
            this.exception = e;
        }
    }
    
    */
}
