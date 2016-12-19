package Abyss;

import javax.swing.JFrame;
import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Abyss.Screens.Screen;
import Abyss.Screens.StartScreen;

/*
 * I am now on tutorial #7
 */
public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;

    public ApplicationMain(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }
    
    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }
    
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
    

    public static void main(String[] args) {
    	//Starting Stats
    	PlayerAi.maxHp = 95;
    	PlayerAi.hp = 75;
    	PlayerAi.maxMana = 25;
    	PlayerAi.mana = 10;
    	PlayerAi.xp = 0;
    	PlayerAi.reqXp = 1;
    	
    	//Starting Attributes
    	PlayerAi.attack = 10;
    	PlayerAi.defense = 0;
    	PlayerAi.critical= 10.00;
    	
    	
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}


