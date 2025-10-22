package ar.edu.unrc.dc.model;

import java.util.Objects;

public class Position {
    private int row; 
    private int column; 

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() { return row; }

    public void setRow(int row) { this.row = row; }

    public int getColumn() { return column; }

    public void setColumn(int column) { this.column = column; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() { return Objects.hash(row, column); }

    @Override
    public String toString() { return "(" + row + "," + column + ")"; }
}
