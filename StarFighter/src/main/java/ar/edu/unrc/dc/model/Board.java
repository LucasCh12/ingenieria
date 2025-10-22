package ar.edu.unrc.dc.model;

import java.util.ArrayList;
import java.util.List;

public class Board implements Observer {
    private int row;
    private int column;
    private List<BoardObject> boardObjects = new ArrayList<>();

    private static final int MIN_ROWS = 3;
    private static final int MAX_ROWS = 10;
    private static final int MIN_COLUMNS = 5;
    private static final int MAX_COLUMNS = 30;

    public Board(int row, int column){
        validateRow(row);
        validateColumn(column);
        this.row = row;
        this.column = column;
    }

    public int getRow(){ return this.row; }

    public void setRow(int row){ 
        validateRow(row);
        this.row = row; 
    }
    
    public String getSymbolAt(Position pos) {
        BoardObject obj = getObjectAt(pos);
        if (obj == null) return "_";
        if (obj instanceof StarFighter) return "S";
        if (obj instanceof Projectile) return "*";
        return "?";
    }

    public int getColumn(){ return this.column; }

    public void setColumn(int column){ 
        validateColumn(column);
        this.column = column; 
    }

    private void validateColumn(int column) {
        if (column < MIN_COLUMNS || column > MAX_COLUMNS) {
            throw new IllegalArgumentException("columns must be between 5 and 30");
        }
    }

    private void validateRow(int row) {
        if (row < MIN_ROWS || row > MAX_ROWS) {
            throw new IllegalArgumentException("Rows must be between 3 and 10");
        }
    }

     private void validateObjectPosition(BoardObject object) {
        Position position = object.getPosition();
        
        if (!isValidPosition(position)) {
            if (object instanceof Projectile) {
                return; // Proyectiles pueden estar fuera
            }
            throw new IllegalArgumentException("Invalid object position");
        }
    }

    public void addObjectToBoard(BoardObject object) {
        validateObjectPosition(object);
        
        // Solo agregar si la posición es válida y no está ocupada
        if (isValidPosition(object.getPosition()) && !isOccupied(object.getPosition())) {
            boardObjects.add(object); 
        }
        // Si es proyectil fuera del tablero, no se agrega (silent fail)
    }

    public boolean isOccupied(Position position) {
        // Solo verificar ocupación si la posición es válida
        if (!isValidPosition(position)) {
            return false; // Posiciones inválidas no están "ocupadas"
        }
        
        return boardObjects.stream().anyMatch(obj -> obj.isAt(position));
    }
    

    public int getObjectCount() { return boardObjects.size(); }

    public List<BoardObject> getObjects() { return new ArrayList<>(boardObjects); }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row >= 0 && row < this.row && column >= 0 && column < this.column;
    }

    public BoardObject getObjectAt(Position position) {
        for (BoardObject object : boardObjects) {
            if (object.isAt(position)) {
                return object;
            }
        }

        return null;
    }

    public BoardObject getProjectileAt(Position position) {
        for (BoardObject object : boardObjects) {
            if (object.isAt(position) && (object instanceof Projectile)) {
                return object;
            }
        }
        return null;
    }

    @Override
    public void update(StarfighterGameEngine engine){
        Board currentBoard = engine.getBoard();
        List<BoardObject> currentObjects = currentBoard.getObjects();
        this.boardObjects = new ArrayList<>(currentObjects);   
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; 
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return row == board.row && column == board.column;
    }

}

