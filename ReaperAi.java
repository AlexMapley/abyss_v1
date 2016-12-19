package Abyss;

import java.util.Random;

public class ReaperAi extends CreatureAi {
	
    public ReaperAi(Creature creature) {
        super(creature);
    }

    //Movement
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        }
    }
    
    public void onUpdate(){
    	
    	//Moves whenever anything dies
    	Random rn = new Random();
		int x = rn.nextInt(2);
		int y = rn.nextInt(2);

        if (x == 0) {
        	x--;
        }
        if (y == 0) {
        	y--;
        }
        creature.moveBy(x,y);
    }
}
