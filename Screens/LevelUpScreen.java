package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class LevelUpScreen implements Screen{
 	
	 
	 public void displayOutput(AsciiPanel terminal) {
		 	PlayerAi.level++;
		 	
		 
	        terminal.write("You've Reached Level " + PlayerAi.level, 1, 1);
	        
	        terminal.write("Press 1 to Follow the Thief Path", 1, 7);
	        terminal.write("Press 2 to Follow the Knight Path", 1, 9);
	        terminal.write("Press 3 to Follow the Assassin Path", 1, 11);
	     
	        terminal.writeCenter("-- press any key to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        if (key.getKeyCode() == KeyEvent.VK_1) {
	        	/* * * * * * * Rogue Path  * * * * * * */
	        	PlayerAi.attack +=2;
	        	PlayerAi.critical +=2;
	        	PlayerAi.defense +=1;
	        	PlayerAi.dodge +=1;
	        	
	        	//Level cap Increase
			 	PlayerAi.xp -= PlayerAi.reqXp;
			 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
			 	
				return new PlayScreen();
			
				}
	        if (key.getKeyCode() == KeyEvent.VK_2) {
	        	/* * * * * * * Knight Path  * * * * * * */
	        	PlayerAi.attack +=2;
	        	PlayerAi.critical +=1;
	        	PlayerAi.defense +=2;
	        	PlayerAi.dodge +=1;
	        	
	        	//Level cap Increase
	        	PlayerAi.xp -= PlayerAi.reqXp;
			 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
			 	
				return new PlayScreen();
			
				}
	        if (key.getKeyCode() == KeyEvent.VK_3) {
	        	/* * * * * * * Assassin * * * * * * */
	        	PlayerAi.attack +=1;
	        	PlayerAi.critical +=3;
	        	PlayerAi.defense +=0;
	        	PlayerAi.dodge +=2;
	        	
	        	//Level cap Increase
	        	PlayerAi.xp -= PlayerAi.reqXp;
			 	PlayerAi.reqXp = (int)((PlayerAi.reqXp + 1)*1.1);
			 	
				return new PlayScreen();
			
				}
	        else {
	        	return new PlayScreen();
	        }
	      }
	    
}