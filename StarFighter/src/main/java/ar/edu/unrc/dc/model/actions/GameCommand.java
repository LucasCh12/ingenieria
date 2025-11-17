package ar.edu.unrc.dc.model.actions;

import ar.edu.unrc.dc.model.game.StarfighterGameEngine;

public interface GameCommand {
  void execute();
  String getTypeTurn();
  String commandIssued();
} 
  