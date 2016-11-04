package greg.science.circulatory;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Manager {
    
    
    boolean gameStat = true;
    Game game = new Game();
    
    public Manager(){        
    }
    
    public void draw(Graphics g){
    	game.draw(g);
    }
    
    public void update(){
        
    }
    
    public void keyDown(KeyEvent e){
        
    }
    
    public void keyUp(KeyEvent e){
        
    }
    
    public void mouseUpdate(MouseEvent m){
        game.mouseUpdate(m);
    }
}
