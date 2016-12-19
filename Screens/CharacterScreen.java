package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class CharacterScreen implements Screen{
 	
	 public void displayOutput(AsciiPanel terminal) {
			
		 	terminal.write("Level: " + PlayerAi.level, 1, 1);
	        terminal.write("Health: " + PlayerAi.hp, 1, 2);
	        terminal.write("Mana: " + PlayerAi.mana, 1, 3);
	        terminal.write("Attack: " + PlayerAi.attack, 1, 5);
	        terminal.write("Defense: " + PlayerAi.defense, 1, 6);
	        terminal.write("Critical: " + PlayerAi.critical +"%", 1, 7);
	        terminal.write("Dodge: " + PlayerAi.dodge +"%", 1, 8);

	        
	        terminal.writeCenter("-- press [c] to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_C? new PlayScreen() : this;
	    }

}


