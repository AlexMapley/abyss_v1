package Abyss;

import java.awt.Color;
import java.util.Random;

public class Creature {
    private World world;

    public int x;
    public int y;

    private char glyph;
    public char glyph() { return glyph; }
    private Color color;
	
    public Color color() { return color; }

    //Constructor
    public Creature(World world, String name, char glyph, Color color, int maxHp, int attack, int defense, double critical, int xp){
    	this.name = name;
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attackValue = attack;
        this.defenseValue = defense;
        this.critical = critical;
        this.xp = xp;
    }
    
/* * * * * Attribute Setters * * * * * */
    public void setMaxHP(int MaxHP) {
    	this.maxHp = MaxHP;
    }
    public void setHP(int hp) {
    	this.hp = hp;
    }
    public void setAtt(int att) {
    	this.attackValue = att;
    }
    public void setDef(int def) {
    	this.defenseValue = def;
    }
    public void setCrit(double crit) {
    	this.critical = crit;
    }
    public void setXp(int xp) {
    	this.xp = xp;
    }
  
    
    //Ai injector
    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
    
   
/* * * * * * * * * * * * * * * Creature abilities * * * * * * * * * * * * * * * * * */
    //Move
    public void moveBy(int mx, int my){
    	Creature other = world.creature(x+mx, y+my);
        if (other == null)
        	//Move
            ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        else
        	//Attack
            attack(other);
    }
    
    //Dig
    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }
    
  
    //Attack
    public void attack(Creature other){
        int amount = Math.max(0, attackValue() - other.defenseValue());
        amount = (int)(Math.random() * amount) + 1;
        	//Critical modifier
        		int attz = attackValue();
        		int chance = (int)(100/critical());
        		Random rn = new Random();
        		int target = rn.nextInt(chance);
        		if (target == 7) {
        			amount = amount * 3;
        			notify("Critical Hit! 3x Damage!");
        		} 
        		
        //Do damage
        other.modifyHp(-amount);
   
        //Move Enemy
		int x = rn.nextInt(2);
		int y = rn.nextInt(2);

        if (x == 0) {
        	x = x - 1;
        }
        if (y == 0) {
        	y = y -1;
        }
       other.moveBy(x, y);
        
        
        
        notify("You attack the '%s' for %d damage.", other.name, amount);
        other.notify("The '%s' attacks you for %d damage.", glyph, amount);
    }
    
    //Remove 
    public void modifyHp(int amount) {
        hp += amount;
    
        if (hp < 1)
         world.remove(this);
    }
    
    //Update
    public void update(){   
        ai.onUpdate();  
    }
    
    //Notify
    public void notify(String message, Object ... params){
        ai.onNotify(String.format(message, params));
    }

 
/* * * * * * * * * * * * * * * * Attributes * * * * * * * * * * * * * * * * * * * * * */
    private String name;
    public String name() { return name; }
    
    private int maxHp;
    public int maxHp() { return maxHp; }

    private int hp;
    public int hp() { return hp; }

    private int attackValue;
    public int attackValue() { return attackValue; }

    private int defenseValue;
    public int defenseValue() { return defenseValue; }
    
    private double critical;
    public double critical() { return critical; }
    
    private int xp;
    public int xp() { return xp; }
 
}