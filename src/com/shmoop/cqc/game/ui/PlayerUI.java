package com.shmoop.cqc.game.ui;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PlayerUI extends GridPane {

	private int id = -1;
	private Text playerTxt = null;
	private Text playerScoreTxt = null;
	
	public PlayerUI( int id ) {
		this.id = id;
	}
	
	public void init() {
		 
		Text playerLbl = new Text("Player:");
		this.add(playerLbl, 0, 0);
		 
		this.playerTxt = new Text( ""+this.id );
		this.add(playerTxt, 1, 0);
		 
		Text playerScoreLbl = new Text("Score:");
		this.add(playerScoreLbl, 0, 1);
		 
		this.playerScoreTxt = new Text("0");
		this.add(playerScoreTxt, 1, 1);
		
		/*
		 * Final touches
		 */
		
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setMinWidth( 200 );
		this.setVgap(5);
		this.setHgap(5);
		
		this.setStyle("-fx-background-color: #DAE6F3; -fx-border-color: black;");
		
	}
	
	public void select( boolean select ) {
		if( select ) {
			this.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: black;");
		}else{
			this.setStyle("-fx-background-color: #DAE6F3; -fx-border-color: black;");
		}
	}
	
}
