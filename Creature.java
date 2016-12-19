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
    public Creature(World world, String name, char glyph, Color color, int maxHp, int maxMana ,int attack, int defense, double critical, int xp){
    	//Generics
    	this.name = name;
        this.world = world;
        this.glyph = glyph;
        this.color = color;
         
        //Stats
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.xp = xp;
        
        //Attributes
        this.attackValue = attack;
        this.defenseValue = defense;
        this.critical = critical;
    }
    
/* * * * * Attribute Setters * * * * * */
    public void setMaxHP(int maxHP) {
    	this.maxHp = maxHP;
    }
    public void setHP(int hp) {
    	this.hp = hp;
    }
    public void setMaxMana(int maxMana) {
    	this.maxMana = maxMana;
    }
    public void setMana(int mana) {
    	this.mana = mana;
    }
    public void setXp(int xp) {
    	this.xp = xp;
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
    
  
    
    //Ai injector
    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }
    
   
/* * * * * * * * * * * * * * * Creature abilities * * * * * * * * * * * * * * * * * */
    //Move
    public void moveBy(int mx, int my){
    	Creature other = world.creature(x+mx, y+my);
        if (other == null) {
        	//Move
            ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
        }
        else if (this.name() != "Mole"){			//Moles killing other Creatures causes some
        	//Creatures Attack Each Other				//concurrency issues...
            attack(other);									//We'll make them peaceful instead
        	other.attack(this);
        	PlayerAi.hp = this.hp;
        }
    }
    
    //Dig
    public void dig(int wx, int wy) {
        world.dig(wx, wy);
    }
    
    
    //Attack
    public void attack(Creature other){
    	
        int amount = Math.max(0, attackValue() - other.defenseValue());
        amount = (int)((Math.random() * amount) + (attackValue()/25));
        	//Critical modifier
        		double critField = Math.random();
        		double critChance = critField - (critical()/100);
        		if (critChance <= 0) {
        			amount = amount * 3;
        			notify("Critical Hit! 3x Damage!");
        		} 
        		
        //Do damage
        other.modifyHp(-amount);
   
        //Move Enemy
        Random rn = new Random();
		int x = rn.nextInt(2);
		int y = rn.nextInt(2);

        if (x == 0) {
        	x = x - 1;
        }
        if (y == 0) {
        	y = y -1;
        }
       other.moveBy(x, y);
      
        //Message
        notify("You attack the %s for %d damage.", other.name, amount);
        other.notify("The %s hits you for %d damage.", name, amount);
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
    
    private int maxMana;
    public int maxMana() { return maxMana; }

    private int mana;
    public int mana() { return mana; }
    
    private int xp;
    public int xp() { return xp; }
    
    private int attackValue;
    public int attackValue() { return attackValue; }

    private int defenseValue;
    public int defenseValue() { return defenseValue; }
    
    private double critical;
    public double critical() { return critical; }
 
}