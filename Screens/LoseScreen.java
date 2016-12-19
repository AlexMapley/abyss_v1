package Abyss.Screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class LoseScreen implements Screen {
	 public void displayOutput(AsciiPanel terminal) {
	        terminal.write("You died.", 1, 1);
	        terminal.write("Lol.", 1, 2);
	        terminal.writeCenter("-- Start a New Game Son --", 22);
	    }

	    public Screen respondToUserInput(KeyEvent key) {
	        //return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	    	return this;
	    }

}
