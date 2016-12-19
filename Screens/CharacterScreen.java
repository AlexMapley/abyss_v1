package Abyss.Screens;

import java.awt.event.KeyEvent;
import Abyss.PlayerAi;
import asciiPanel.AsciiPanel;

public class CharacterScreen implements Screen{
 	
	 public void displayOutput(AsciiPanel terminal) {
			
	        terminal.write("Health: " + PlayerAi.hp, 1, 1);
	        terminal.write("Mana: " + PlayerAi.mana, 1, 2);
	        terminal.write("Attack: " + PlayerAi.attack, 1, 4);
	        terminal.write("Defense: " + PlayerAi.defense, 1, 5);
	        terminal.write("Critical: " + PlayerAi.critical +"%", 1, 6);

	        
	        terminal.writeCenter("-- press [c] to return --", 22);
	    }

	 	
	    public Screen respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_C? new PlayScreen() : this;
	    }

}


