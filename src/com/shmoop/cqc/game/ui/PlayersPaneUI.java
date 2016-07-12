package com.shmoop.cqc.game.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class PlayersPaneUI extends GridPane {

	private List<PlayerUI> playersUI = new ArrayList<PlayerUI>();
	
	public void init(int playerCount) {
		
		/*
		 * Ensure to always start from a clean slate!
		 */
		
		this.getChildren().removeAll( this.getChildren() );
		this.playersUI.clear();
		
		/*
		 * Only process if count is above zero.
		 */
		
		if( playerCount > 0 ) {
			
			/*
			 * Determine the number of player panes to
			 * be displayed.
			 */
			
			PlayerUI[] players = new PlayerUI[ playerCount ];
			for(int a=0; a<players.length; a++) {
				players[a] = new PlayerUI( a+1 );
				players[a].init();
				this.add( players[a], 0, a );
				this.playersUI.add( players[a] );
				
			}//end of for loop
			
			/*
			 * Always start with player one!
			 */
			
			players[0].select( true );
			
			/*
			 * Final touches
			 */
			
			this.setPadding( new Insets(10, 10, 10, 10) );
			this.setVgap(5);
			this.setHgap(5);
			
		}//end of if statement
		
	}
}
