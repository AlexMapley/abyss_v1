package Abyss;

import java.util.List;

import asciiPanel.AsciiPanel;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }
    
/* * * * * * Creatures for Assembly * * * * * */
    
    //Player
    public Creature newPlayer(List<String> messages){
        Creature player = new Creature(world, "Player", 'A', AsciiPanel.brightWhite, 0, 0, 0, 0, 0, 0, 0);
        
        //Set Player Stats
        player.setMaxHP(PlayerAi.maxHp);
        player.setHP(PlayerAi.hp);
        player.setMaxMana(PlayerAi.maxMana);
        player.setMana(PlayerAi.mana);
        player.setAtt(PlayerAi.attack);
        player.setDef(PlayerAi.defense);
        player.setCrit(PlayerAi.critical);
        player.setDodge(PlayerAi.dodge);
        
        //Add Player to World
        world.addAtEmptyLocation(player);
        new PlayerAi(player, messages);
        return player;
    }
    
    /** (hp, mana, attack, defense, crit, dodge, xp) **/
    
    //Fungus
    public Creature newFungus(){
        Creature fungus = new Creature(world, "Fungus", 'f', AsciiPanel.green, 20, 0, 5, 3, 0, 0, 1);
        world.addAtEmptyLocation(fungus);
        new FungusAi(fungus, null);
        return fungus;
    }
    
    //Goblin
    public Creature newGoblin(){
        Creature goblin = new Creature(world, "Goblin", 'G', AsciiPanel.brightGreen, 45, 5, 10, 3, 0, 2, 3);
        world.addAtEmptyLocation(goblin);
        new GoblinAi(goblin);
        return goblin;
    }
    
    //Mole
    public Creature newMole(){
        Creature mole = new Creature(world, "Mole", 'M', AsciiPanel.brightCyan, 95, 12, 15, 12, 5, 10, 12);
        world.addAtEmptyLocation(mole);
        new MoleAi(mole);
        return mole;
    }
    //Reaper
    public Creature newReaper(){
        Creature Reaper = new Creature(world, "Reaper", 'R', AsciiPanel.brightRed, 1000, 999, 100, 100, 10, 5, 100000);
        world.addAtEmptyLocation(Reaper);
        new MoleAi(Reaper);
        return Reaper;
    }
}
