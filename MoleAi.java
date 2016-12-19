package Abyss;

import java.util.Random;

public class MoleAi extends CreatureAi {
	
    public MoleAi(Creature creature) {
        super(creature);
    }

    //Movement
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        } else if (tile.isDiggable()) {
            creature.dig(x, y);
        }
    }
    
    public void onUpdate(){
    	
    	//Moles always moving
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
