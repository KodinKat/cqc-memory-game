package com.shmoop.cqc.game;

public class GameMgr {

	public final static int ONE_PLAYER = 1;
	public final static int TWO_PLAYER = 2;
	
	public final static int LEVEL_EASY = 1;
	public final static int LEVEL_MEDIUM = 2;
	public final static int LEVEL_YIKES = 3;
	
	private int playerCount = GameMgr.ONE_PLAYER;
	private int gameLevel = GameMgr.LEVEL_EASY;
	
	public void setPlayerCount(int playerCount){ this.playerCount = playerCount; }
	public void setGameLevel(int gameLevel){ this.gameLevel = gameLevel; }
	
	public int getPlayerCount(){ return this.playerCount; }
	public int getGameLevel(){ return this.gameLevel; }
	
}
