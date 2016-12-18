package Abyss.Screens;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import Abyss.Creature;
import Abyss.CreatureFactory;
import Abyss.PlayerAi;
import Abyss.World;
import Abyss.WorldBuilder;
import asciiPanel.AsciiPanel;

public class PlayScreen implements Screen {
	
	 //Creates Our world
	 private World world;
	 private int screenWidth;
	 private int screenHeight;
	 private Creature player;
	 
	 private void createWorld(){
		 world = new WorldBuilder(90, 31)
			 .makeCaves()
             .build();
	   }
	 
	 //Message List
	 private List<String> messages;
	 
	 //PlayScreen Constructor
	 public PlayScreen(){
		 screenWidth = 80;
		 screenHeight = 21;
		 messages = new ArrayList<String>();
		 createWorld();
		 
		 CreatureFactory creatureFactory = new CreatureFactory(world);
		 createCreatures(creatureFactory);
	  }
	 
	 
	 private void createCreatures(CreatureFactory creatureFactory){
		 	//Make the Player
		    player = creatureFactory.newPlayer(messages);
		  
		    //Make some Goblins
		    for (int i = 0; i < 9; i++){
		        creatureFactory.newGoblin();
		    }
		    //Make some Fungi
		    for (int i = 0; i < 24; i++){
		        creatureFactory.newFungus();
		    }
		}
	 
	 
/* * * * * * Output Display * * * * * * */
	 public void displayOutput(AsciiPanel terminal) {
		 
	        //Terminal Labels
	        terminal.writeCenter("Exp " + PlayerAi.xp + " / " + PlayerAi.reqXp, 22);
	        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 23);
	        String stats = String.format(" %3d/%3d hp", player.hp(), player.maxHp());
	        terminal.write(stats, 1, 23);
	        
	        int left = getScrollX();
	        int top = getScrollY();
	        displayTiles(terminal, left, top);
	        terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
	        
	        //Ready to level up?
	        if (PlayerAi.xp >= PlayerAi.reqXp ) {
	     		terminal.write("Time To Level!", 1, 20);
	     		terminal.write("Press p", 1, 21);
	     	}
	        
	        displayMessages(terminal, messages);
	    }
	 
	    public Screen respondToUserInput(KeyEvent key) {
	        switch (key.getKeyCode()){
	        case KeyEvent.VK_ESCAPE: return new LoseScreen();
	        case KeyEvent.VK_C: return new CharacterScreen();
	        case KeyEvent.VK_ENTER: return new WinScreen();
	        case KeyEvent.VK_P: return new LevelUpScreen();
	        
	        //Key bindings
	        case KeyEvent.VK_LEFT:
	        case KeyEvent.VK_A: player.moveBy(-1, 0); break;
	        case KeyEvent.VK_RIGHT:
	        case KeyEvent.VK_D: player.moveBy( 1, 0); break;
	        case KeyEvent.VK_UP:
	        case KeyEvent.VK_W: player.moveBy( 0,-1); break;
	        case KeyEvent.VK_DOWN:
	        case KeyEvent.VK_S: player.moveBy( 0, 1); break;
	        }
	        
	        //Moving up or down a level
	        switch (key.getKeyChar()){
	        	case '<': player.moveBy( 0, 0); break;
	        	case '>': player.moveBy( 0, 0); break;
	        }
	        
	    
	        return this;
	    }
	 
	 //Displays Tiles
	 private void displayTiles(AsciiPanel terminal, int left, int top) {
	        for (int x = 0; x < screenWidth; x++){
	            for (int y = 0; y < screenHeight; y++){
	                int wx = x + left;
	                int wy = y + top;

	                Creature creature = world.creature(wx, wy);
	                if (creature != null)
	                    terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
	                else
	                    terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
	            }
	        }
	    }
	 
	 //Display Messages
	 private void displayMessages(AsciiPanel terminal, List<String> messages) {
		    int top = screenHeight - messages.size();
		    for (int i = 0; i < messages.size(); i++){
		        terminal.writeCenter(messages.get(i), top + i);
		    }
		    messages.clear();
		}

	 
	 
	 //Scrolling Methods
	 public int getScrollX() {
		    return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
		}
	 public int getScrollY() {
		    return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
		}
	


}
