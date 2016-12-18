package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class LevelUpScreen implements Screen{
 	
	 public void displayOutput(AsciiPanel terminal) {
			
	        terminal.write("Time to level up", 1, 1);
	     
	        terminal.writeCenter("-- press [p] to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_P? new PlayScreen() : this;
	    }

}