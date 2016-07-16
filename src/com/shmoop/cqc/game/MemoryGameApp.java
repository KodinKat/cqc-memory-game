package com.shmoop.cqc.game;

import com.shmoop.cqc.game.ui.MemoryGameUI;

public class MemoryGameApp {

	public static void main(String[] args) {
		
		MemoryGameUI memoryGameUI = new MemoryGameUI();
		MemoryGameUI.launch(memoryGameUI.getClass(), args);
		
	}

}
