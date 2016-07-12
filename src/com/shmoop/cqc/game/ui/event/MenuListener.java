package com.shmoop.cqc.game.ui.event;

public interface MenuListener {

	public void newGame();
	public void newLevel( Integer newGameLevel );
	public void newPlayerSetup( Integer newPlayerCount );

}
