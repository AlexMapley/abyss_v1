package Abyss.Screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {
	
	  public void displayOutput(AsciiPanel terminal) {
	        terminal.write("Key Bindings:", 1, 1);
	        terminal.write("Press 'c' for character screen:", 1, 2);
	        terminal.writeCenter("-- press [enter] to start --", 22);
	    }

	    public Screen respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	    }

}
