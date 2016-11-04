package greg.science.circulatory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Manager {
    
    
    boolean gameStat = false;
    boolean menuStat = true;
    Game game = new Game();
    Menu menu = new Menu();
    
    public Manager(){        
    }
    
    public void draw(Graphics g){
    	if(gameStat) game.draw(g);
    	else if(menuStat) menu.draw(g);
    }
    
    public void update(){
        
    }
    
    public void keyDown(KeyEvent e){
        
    }
    
    public void keyUp(KeyEvent e){
        if(game.gameOver){
        	if(e.getKeyCode() == KeyEvent.VK_R){
        		game = new Game(); 
        	}
        	if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
        		menuStat = true;
        		gameStat = false;
        		menu = new Menu();
        	}
        }
    }
    
    public void mouseUpdate(MouseEvent m){
        if(gameStat) game.mouseUpdate(m);
        else if(menuStat){
        	if(menu.play.click(m)){
        		menuStat = false;
        		gameStat = true;
        		game = new Game();
        	}
        }
    }
}
