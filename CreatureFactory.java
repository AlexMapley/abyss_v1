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
        Creature player = new Creature(world, "Player", 'A', AsciiPanel.brightWhite, 0, 0, 0, 0, 0);
        player.setMaxHP(PlayerAi.MaxHP);
        player.setHP(PlayerAi.hp);
        player.setAtt(PlayerAi.attack);
        player.setDef(PlayerAi.defense);
        player.setCrit(PlayerAi.critical);
        
        
        world.addAtEmptyLocation(player);
        new PlayerAi(player, messages);
        return player;
    }
    
    //Fungus
    public Creature newFungus(){
        Creature fungus = new Creature(world, "Fungus", 'f', AsciiPanel.green, 25, 5, 0, 0, 1);
        world.addAtEmptyLocation(fungus);
        new FungusAi(fungus, null);
        return fungus;
    }
    
  //Goblin
    public Creature newGoblin(){
        Creature goblin = new Creature(world, "Goblin", 'G', AsciiPanel.brightGreen, 45, 10, 3, 0, 3);
        world.addAtEmptyLocation(goblin);
        new GoblinAi(goblin);
        return goblin;
    }
}
