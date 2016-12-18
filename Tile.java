package Abyss;

import java.awt.Color;
import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)250, AsciiPanel.red),
    WALL((char)177, AsciiPanel.blue),
    BOUNDS('x', AsciiPanel.brightBlack),
	STAIRS_DOWN('>', AsciiPanel.white),
    STAIRS_UP('^', AsciiPanel.white);


    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

/* * * * * Tile Types * * * * * */
    
    //Ground
    public boolean isGround() {
        return this != WALL && this != BOUNDS;
    }
    
    
    
    
/* * * * * Tile Interactions* * * * * */
    //Can we dig it?
    
    public boolean isDiggable() {
        return this == Tile.WALL;
    }
}


