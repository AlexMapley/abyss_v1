package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class LevelUpScreen implements Screen{
 	
	 public void displayOutput(AsciiPanel terminal) {
			//Level cap Increase
		 	PlayerAi.xp = 0;
		 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
		 	
		 
	        terminal.write("Time to level up", 1, 1);
	        
	        terminal.write("Press 1 to level up Attack", 1, 7);
	        terminal.write("Press 2 to level up Critical", 1, 9);
	     
	        terminal.writeCenter("-- press [p] to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        if (key.getKeyCode() == KeyEvent.VK_1) {
	        	PlayerAi.attack +=3;
				return new PlayScreen();
			
				}
	        if (key.getKeyCode() == KeyEvent.VK_2) {
	        	PlayerAi.critical +=5;
				return new PlayScreen();
			
				}
			return null;
	      }
	    
}
