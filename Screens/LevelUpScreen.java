package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class LevelUpScreen implements Screen{
 	
	 public void displayOutput(AsciiPanel terminal) {
			
		 	
		 
	        terminal.write("Time to level up", 1, 1);
	        
	        terminal.write("Press 1 to Follow the Rogue Path", 1, 7);
	        terminal.write("Press 2 to Follow the Knight Path", 1, 9);
	     
	        terminal.writeCenter("-- press any key to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        if (key.getKeyCode() == KeyEvent.VK_1) {
	        	PlayerAi.attack +=3;
	        	PlayerAi.critical +=3;
	        	PlayerAi.defense++;
	        	
	        	//Level cap Increase
			 	PlayerAi.xp -= PlayerAi.reqXp;
			 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
			 	
				return new PlayScreen();
			
				}
	        if (key.getKeyCode() == KeyEvent.VK_2) {
	        	PlayerAi.attack +=4;
	        	PlayerAi.critical +=1;
	        	PlayerAi.defense+=2;
	        	
	        	//Level cap Increase
			 	PlayerAi.xp = 0;
			 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
			 	
				return new PlayScreen();
			
				}
	        else {
	        	return new PlayScreen();
	        }
	      }
	    
}