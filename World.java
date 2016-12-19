package Abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class World {
	private Tile[][] tiles;
    private int width;
    public int width() { return width; }

    private int height;
    public int height() { return height; }
    

    public World(Tile[][] tiles){
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }
    
    public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }
    
    public char glyph(int x, int y){
        return tile(x, y).glyph();
    }
    
    public Color color(int x, int y){
        return tile(x, y).color();
    }

    
/* * * * * * Creatures * * * * * * */
	private ArrayList<Creature> creatures = new ArrayList<Creature>();
	
	//Get Creature locations
	public Creature creature(int x, int y){
	    for (Creature c : creatures){
	        if (c.x == x && c.y == y)
	            return c;
	    }
	    return null;
	}

	
/* * * * * * Actions * * * * * * * */
	
	//Spawn
	public void addAtEmptyLocation(Creature creature){
		int x;
		int y;
		
		do {
			x = (int)(Math.random() * width);
	        y = (int)(Math.random() * height);
	    }
		while (!tile(x,y).isGround()  || creature(x,y) != null);
		
		creature.x = x;
		creature.y = y;
		
		//Add Creature to list
		creatures.add(creature);
	}

	//Dig
	public void dig(int x, int y) {
    if (tile(x,y).isDiggable())
        tiles[x][y] = Tile.FLOOR;
    
    	//Mole Movement
    	update("Mole");
	}
	
	//Remove
	public void remove(Creature other) {
	    creatures.remove(other);
	    
	    //Exp reward
	    PlayerAi.xp += other.xp();
	    
	    //Reaper Moves
	    update("Reaper");
	}
	
	//Update
	public void update(String type){
	    for (Creature creature : creatures){
	    	if (creature.name() == type) {
	    		creature.update();
	    	}
	    }
	}
}
