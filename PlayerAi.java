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
    public static boolean dug = false;	//Keeps track of when the player digs
    public void onEnter(int x, int y, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
        } else if (tile.isDiggable()) {
            creature.dig(x, y);
            dug = true;
        }
    }
    
    //Receive Message
    public void onNotify(String message){
        messages.add(message);
    }
    
    public void onUpdate(){
    	
    }
    
/* * * * * Attributes * * * * * * * */
    
	//Status Attributes
    public static int maxHp;
	public static int hp;
	public static int maxMana;
	public static int mana;
	public static int stamina;
	public static int xp;
	public static int reqXp;
	public static int level = 1;
	
	//Passive Attributes
	public static int attack;
	public static int defense;
	public static double critical;
	public static double dodge;
	public static int insight;
	
	
}