package com.shmoop.cqc.game.ui;

import javafx.stage.Screen;
import javafx.stage.Stage;

import com.shmoop.cqc.game.GameMgr;
import com.shmoop.cqc.game.ui.event.MenuListener;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MemoryGameUI extends Application implements MenuListener {

	private GameMgr gameMgr = new GameMgr();
	private MenuPaneUI menuPaneUI = null;
	private PlayersPaneUI playersPaneUI = null;
	private BorderPane mainPane = null;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//Window Title
		stage.setTitle("Shmoop | Crafting Quality Code (Short Course) | Memory Game ;)");
		
		//Position Window
		this.positionWindow( stage );
				
		//Init widgets
		this.initUI();
		
		//Set the scene and display
		Scene scene = new Scene(this.mainPane, stage.getWidth(), stage.getHeight());
		stage.setScene(scene);
		stage.show();
	}
	
	private void positionWindow(Stage stage) {
		
		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		double winWidth = (screen.getWidth() * 0.8); // 80% of screen width
		double winHeight = (screen.getHeight() * 0.7); // 70% of screen height
		double winX = ((screen.getWidth() / 2) - (winWidth / 2));
		double winY = ((screen.getHeight() / 2) - (winHeight / 2));
		
		stage.setX( winX );
		stage.setY( winY );
		stage.setWidth( winWidth );
		stage.setHeight( winHeight );
        
	}
	
	private void initUI() {
		
		//Helper variables
		int gameLevel = this.gameMgr.getGameLevel();
		int playerCount = this.gameMgr.getPlayerCount();
				
		//Build Menus Items
		this.menuPaneUI = new MenuPaneUI();
		this.menuPaneUI.init();
		
		this.menuPaneUI.addNewGameListener( this );
  		this.menuPaneUI.addNewPlayerSetupListener( this );
  		this.menuPaneUI.addNewLevelListener( this );
		
  		//Build Players UI Area
		this.playersPaneUI = new PlayersPaneUI();
		this.playersPaneUI.init( playerCount );
  			
		//Assign various child panes
		this.mainPane = new BorderPane();
		this.mainPane.setTop( this.menuPaneUI );
		this.mainPane.setLeft( this.playersPaneUI );
			
	}
	
	/*
	 * EVENTS
	 */
	
	public void newGame() {
		System.out.println("MemoryGameUI : New Game");
	}
	
	public void newLevel( Integer newGameLevel ) {
		this.gameMgr.setGameLevel( newGameLevel );
	}
	
	public void newPlayerSetup( Integer newPlayerCount ) {
		this.gameMgr.setPlayerCount( newPlayerCount );
	}
}
