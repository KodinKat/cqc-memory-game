package com.shmoop.cqc.game.ui;

import java.util.ArrayList;
import java.util.List;

import com.shmoop.cqc.game.GameMgr;
import com.shmoop.cqc.game.ui.event.MenuListener;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

public class MenuPaneUI extends FlowPane {

	private List<MenuListener> newGameListeners = new ArrayList<MenuListener>();
	private List<MenuListener> newLevelListeners = new ArrayList<MenuListener>();
	private List<MenuListener> newPlayerSetupListeners = new ArrayList<MenuListener>();
	
	public void init() {
		
		/*
		 * Main Menu Bar
		 */
		
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle( "-fx-background-color: DAE6F3;" );
		
		/*
		 * Game Menu Item
		 */
		
		Menu menuGame = new Menu("Game");
		
		/*
		 * New Game Item and Event Listener
		 */
		
		MenuItem itemNew = new MenuItem("New");
		itemNew.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				newGameEvent();
			}
		});
		
		/*
		 * Player Count Sub Menu and Toggle Listener
		 */
		
		Menu subItemMenuPlayers = new Menu("Players");
		final ToggleGroup subMenuPlayersGroup = new ToggleGroup();
		RadioMenuItem onePlayer = new RadioMenuItem("1 Player Game");
		onePlayer.setUserData( new Integer( GameMgr.ONE_PLAYER ) );
		onePlayer.setToggleGroup( subMenuPlayersGroup );
		RadioMenuItem twoPlayer = new RadioMenuItem("2 Player Game");
		twoPlayer.setUserData( new Integer( GameMgr.TWO_PLAYER ) );
		twoPlayer.setToggleGroup( subMenuPlayersGroup );
		subMenuPlayersGroup.selectToggle(onePlayer);
		subItemMenuPlayers.getItems().addAll( onePlayer, twoPlayer );
		
		subMenuPlayersGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) {
	    			if (subMenuPlayersGroup.getSelectedToggle() != null) {
	    				newPlayerSetupEvent( (Integer) subMenuPlayersGroup.getSelectedToggle().getUserData() );
	    			}
		    	}
		});
		
		
		/*
		 * Game Level Sub Menu and Toggle Listener
		 */
		
		Menu subItemMenuLevel = new Menu("Level");
		final ToggleGroup subMenuLevelGroup = new ToggleGroup();
		RadioMenuItem levelEasy = new RadioMenuItem("Easy");
		levelEasy.setUserData( new Integer( GameMgr.LEVEL_EASY ) );
		levelEasy.setToggleGroup( subMenuLevelGroup );
		RadioMenuItem levelMedium = new RadioMenuItem("Medium");
		levelMedium.setUserData( new Integer( GameMgr.LEVEL_MEDIUM ) );
		levelMedium.setToggleGroup( subMenuLevelGroup );
		RadioMenuItem levelYikes = new RadioMenuItem("Yikes");
		levelYikes.setUserData( new Integer( GameMgr.LEVEL_YIKES ) );
		levelYikes.setToggleGroup( subMenuLevelGroup );
		subMenuLevelGroup.selectToggle(levelEasy);
		subItemMenuLevel.getItems().addAll( levelEasy, levelMedium, levelYikes );
		
		subMenuLevelGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) {
					if (subMenuLevelGroup.getSelectedToggle() != null) {
						newLevelEvent( (Integer) subMenuLevelGroup.getSelectedToggle().getUserData() );
					}
	        	}
		});
		
		
		/*
		 * Exit Menu Item - Terminate Application
		 */
		
		MenuItem itemExit = new MenuItem("Exit");
		itemExit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				System.exit(0);
			}
		});
		
		/*
		 * Assign Items to Game Menu
		 */
		
		menuGame.getItems().addAll(itemNew, new SeparatorMenuItem(), subItemMenuPlayers, subItemMenuLevel, new SeparatorMenuItem(), itemExit);
		
		
		/*
		 * Assign Game Menu to Menu bar
		 */
		
		menuBar.getMenus().addAll( menuGame );
		
		/*
		 * Assign Menu Bar to pane
		 */
		
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setStyle( "-fx-background-color: DAE6F3;  -fx-border-color: black;" );
		this.setHgap(5);
		this.setVgap(5);
		this.getChildren().addAll( menuBar );
	
	}
	
	/*
	 * ADD TO LISTENERS
	 */
	
	public void addNewGameListener(MenuListener listener) {
		this.newGameListeners.add( listener );
	}
	
	public void addNewLevelListener(MenuListener listener) {
		this.newLevelListeners.add( listener );
	}
	
	public void addNewPlayerSetupListener(MenuListener listener) {
		this.newPlayerSetupListeners.add( listener );
	}
	
	/*
	 * EVENT TRIGGERS
	 */
	
	private void newGameEvent() {
		for (MenuListener listener : this.newGameListeners) {
			listener.newGame();
		}
	}
	
	private void newLevelEvent( Integer gameLevel ) {
		for (MenuListener listener : this.newLevelListeners) {
			listener.newLevel( gameLevel );
		}
	}

	private void newPlayerSetupEvent( Integer playerCount ) {
		for (MenuListener listener : this.newPlayerSetupListeners) {
			listener.newPlayerSetup( playerCount );
		}
	}
}

