package ar.edu.unrc.dc.model.board;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unrc.dc.model.board.objects.BoardObject;
import ar.edu.unrc.dc.model.board.objects.entities.Entity;
import ar.edu.unrc.dc.model.board.objects.entities.StatsEntities;
import ar.edu.unrc.dc.model.board.objects.projectiles.Projectile;
import ar.edu.unrc.dc.model.game.StarfighterGameEngine;
import ar.edu.unrc.dc.utils.Observer;

public class Board implements Observer {
    private Entity starFighter;
    private int row;
    private int column;
    private List<BoardObject> boardObjects = new ArrayList<>();

    private static final int MIN_ROWS = 3;
    private static final int MAX_ROWS = 10;
    private static final int MIN_COLUMNS = 5;
    private static final int MAX_COLUMNS = 30;

    public Board(int row, int column, Entity starFighter) {
        validateRow(row);
        validateColumn(column);
        this.row = row;
        this.column = column;
        this.starFighter = starFighter;
        addObjectToBoard(starFighter);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        validateRow(row);
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        validateColumn(column);
        this.column = column;
    }

    private void validateColumn(int column) {
        if (column < MIN_COLUMNS || column > MAX_COLUMNS) {
            throw new IllegalArgumentException(
                "columns must be between 5 and 30"
            );
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
        if (
            isValidPosition(object.getPosition()) &&
            !isOccupied(object.getPosition())
        ) {
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

    public int getObjectCount() {
        return boardObjects.size();
    }

    public List<BoardObject> getObjects() {
        return new ArrayList<>(boardObjects);
    }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return (
            row >= 0 && row < this.row && column >= 0 && column < this.column
        );
    }

    public List<Projectile> getProjectiles(){
        List<Projectile> projectiles = new ArrayList<>();
        for (BoardObject object : boardObjects) {
            if (object instanceof Projectile){
                projectiles.add((Projectile)(object));
            }
        }
        return projectiles;
    }

    public BoardObject getObjectAt(Position position) {
        for (BoardObject object : boardObjects) {
            if (object.isAt(position)) {
                return object;
            }
        }

        return null;
    }

    public boolean isOutOfVision(Position pos) {
        StatsEntities stats = starFighter.getStatsEntities();
        return getManhathanDistance(pos) > stats.getVision();
    }

    public int getManhathanDistance(Position pos) {
        Position starFighterPosition = starFighter.getPosition();
        return Math.abs(pos.getRow() - starFighterPosition.getRow()) + Math.abs(pos.getColumn() - starFighterPosition.getColumn());
    }

    @Override
    public void update(StarfighterGameEngine engine) {
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

    @Override
    public String toString() {
        int rows = this.getRow();
        int cols = this.getColumn();
        String result = "";

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Position pos = new Position(row, col);
                if (isOutOfVision(pos)) {
                    result += "? ";
                } else {
                    BoardObject obj = this.getObjectAt(pos);
                    if (obj == null) {
                        result += "_ ";
                    } else {
                        result += obj.toString() + " ";
                    }
                }
            }
            result += "\n";
        }
        return result;
    }
}
