package ar.edu.unrc.dc.utils;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public interface Observer {
    void update(StarfighterGameEngine subject);
}