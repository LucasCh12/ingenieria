package gameLife;

import java.util.Arrays;

public class GameLife {
    
    private Cell[][] matrix;

    private final Rules rules;

    private final Colors colors;

    public GameLife(int [][] matrix, Rules rules, Colors colors){
        Cell[][] aux = transformMatrix(matrix);
        this.matrix = aux;
        this.rules = rules;
        this.colors = colors;
    }

    public static int countNeighbors(int i, int j, Cell[][] matrix){
       int count = 0;

        for (int row = i - 1; row <= i + 1; row++) {
            for (int col = j - 1; col <= j + 1; col++) {
                if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) { 
                    Cell aux =  matrix[row][col];
                    if (aux.isAlive() && !(row == i && col == j)) {
                        count++;
                    }
                }
            }
        }
        return count; 
    }

    public Cell[][] getMatrix(){
        return matrix;
    }

    public void generateNextGen(){
        Cell[][] next = new Cell[matrix.length][matrix[0].length];

        for(int row = 0; row < matrix.length;row++){
            for(int col = 0; col < matrix[0].length;col++){
                Cell aux = matrix[row][col];
                int cantNeighbors = countNeighbors(row, col, matrix);
                if(aux.isAlive()){
                    if(!rules.survive(cantNeighbors)){
                        next[row][col] = new Cell(false); 
                    } else {
                        next[row][col] = new Cell(true); 
                    }
                } else {
                    if(rules.birth(cantNeighbors)){
                        next[row][col] = new Cell(true); 
                    } else {
                        next[row][col] = new Cell(false); 
                    }
                }
            }
        }
        this.matrix = next;
    }

    
    public boolean equalsMatrix(Cell[][] matrix1, Cell[][] matrix2) {
        return Arrays.deepEquals(matrix1, matrix2);
    }

    public String matrixToString(Cell[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int row = 0; row < matrix.length; row++) {
            sb.append("[");
            for (int col = 0; col < matrix[row].length; col++) {
                Cell aux = matrix[row][col];
                if(!aux.isAlive()){
                    sb.append("Death");
                }
                else{
                    sb.append("Live");
                }

                if (col < matrix[row].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (row < matrix.length - 1) {
                sb.append(",\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public String matrixToStringWithColors(Cell[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int row = 0; row < matrix.length; row++) {
            sb.append("[");
            for (int col = 0; col < matrix[row].length; col++) {
                Cell aux = matrix[row][col];
                if(!aux.isAlive()){
                    sb.append(colors.colorForDeathCell());
                }
                else{
                    sb.append(colors.colorForLiveCell());
                }

                if (col < matrix[row].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (row < matrix.length - 1) {
                sb.append(",\n");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final Cell[][] transformMatrix(int[][] matrix){
        Cell[][] out = new Cell[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length;row++){
            for(int col = 0; col < matrix[0].length; col++){
                out[row][col] = new Cell(matrix[row][col] == 1);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0,0,0,0,0,0},
            {0,0,1,1,0,0},
            {0,1,1,0,0,0},
            {0,0,1,0,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}
        };
        Colors colors = new ColorSchemaBlackWhiteGreenRed();
        Rules rules = new B36S23Rules();
        GameLife life = new GameLife(matrix, rules,colors);
        life.generateNextGen();
        Cell[][] aux = life.getMatrix();
        System.out.println(life.matrixToString(aux));
        System.out.println(life.matrixToStringWithColors(aux));
    }
    
}


