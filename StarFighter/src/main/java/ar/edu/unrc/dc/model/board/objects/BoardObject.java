package ar.edu.unrc.dc.model.board.objects;

import ar.edu.unrc.dc.model.board.Position;

public interface BoardObject {
    Position getPosition();
    public boolean isAt(Position position);
}
