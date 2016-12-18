package Abyss;

import java.util.List;

public class PlayerAi extends CreatureAi {

	
    public PlayerAi(Creature creature, List<String> messages) {
    	super(creature);
    	this.messages = messages;
    }
    
    //Messages
    private List<String> messages;
    
    
    
    
/* * * * * Abilties * * * * *  * * */
    
    //Movement
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        } else if (tile.isDiggable()) {
            creature.dig(x, y);
        }
    }
    
    //Receive Message
    public void onNotify(String message){
        messages.add(message);
    }
    
    
/* * * * * Attributes * * * * * * * */
    
	//Status Attributes
    public static int MaxHP;
	public static int hp;
	public static int mana;
	public static int stamina;
	public static int xp;
	public static int reqXp;
	
	//Passive Attributes
	public static int attack;
	public static int defense;
	public static double critical;
	public static int cunning;
	public static int endurance;
	public static int luck;
	public static int insight;

}
