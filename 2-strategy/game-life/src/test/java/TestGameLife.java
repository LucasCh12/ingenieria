
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import gameLife.B36S23Rules;
import gameLife.Cell;
import gameLife.Colors;
import gameLife.ConwayRules;
import gameLife.GameLife;
import gameLife.GreenRedColorsCells;
import gameLife.Rules;


public class TestGameLife {
    
    @Test
    public void testConwayRulesBirthAndSurvive(){

        int[][] matrix = {
            {0, 0, 0, 0, 0, 0, 0,0},
            {0, 0, 0, 0, 1, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 0, 0, 0, 0,0},
        };

        int [][] next = {
            {0, 0, 0, 0, 0, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 0, 0, 0, 0,0},
        };

        Colors colors = new GreenRedColorsCells();
        Rules rules = new ConwayRules();
        GameLife life = new GameLife(matrix,rules,colors);
        life.generateNextGen();
        Cell[][] next1 = life.transformMatrix(next);
        assertTrue(life.equalsMatrix(life.getMatrix(), next1));
    }

    @Test
    public void testConwayRulesDieBirthSurvive(){
        int[][] matrix = {
            {0, 0, 0, 1, 0, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 0, 0, 0, 0,0},
        };

        int[][] next = {
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 1, 0, 0, 0, 0,0},
            {0, 0, 0, 1, 1, 0, 0,0},
            {0, 0, 0, 0, 0, 0, 0,0},
        };
        Colors colors = new GreenRedColorsCells();
        Rules rules = new ConwayRules();
        GameLife life = new GameLife(matrix,rules,colors);
        life.generateNextGen();
        Cell[][] next1 = life.transformMatrix(next);
        assertTrue(life.equalsMatrix(life.getMatrix(), next1));
    }

    @Test
    public void testB36S23Replicator() {
        int[][] matrix = {
            {0,0,0,0,0,0},
            {0,0,1,1,0,0},
            {0,1,1,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };

        int[][] next = {
            {0,0,0,0,0,0},
            {0,1,1,1,0,0},
            {0,1,0,0,0,0},
            {0,1,1,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };
        Colors colors = new GreenRedColorsCells();
        Rules rules = new B36S23Rules();
        GameLife life = new GameLife(matrix,rules,colors);      
        life.generateNextGen();
        Cell[][] next1 = life.transformMatrix(next);
        assertTrue(life.equalsMatrix(life.getMatrix(), next1));
    }

}


