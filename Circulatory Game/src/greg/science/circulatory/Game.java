package greg.science.circulatory;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Organ> organs;
    int score = 0;
    int lives = 5;
    Random random;
    final int MAX_ORGANS = 9;
    boolean gameOver = false;
    FontMetrics fm;
    final int SCREEN_WIDTH = 640;
    
    public Game(){ 
    	organs = new ArrayList<Organ>();
    	random = new Random();
    }
    
    public void draw(Graphics g){
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("Arial", Font.BOLD, 30));
    	fm = g.getFontMetrics();
    	g.fillRect(0, 0, 1000, 1000);
    	g.setColor(Color.BLACK);
    	if(gameOver){
    		String go0 = "Game Over";
    		String go1 = "Score:";
    		String go2 = score + " points";
    		String go3 = "Press R to retry";
    		String go4 = "Press ESCAPE to quit to menu";
    		g.drawString(go0, SCREEN_WIDTH/2-fm.stringWidth(go0)/2, 50);
    		g.drawString(go1, SCREEN_WIDTH/2-fm.stringWidth(go1)/2, (int) (50+fm.getHeight()*1.25));
    		g.drawString(go2, SCREEN_WIDTH/2-fm.stringWidth(go2)/2, (int) (50+fm.getHeight()*2.5));
    		g.drawString(go3, SCREEN_WIDTH/2-fm.stringWidth(go3)/2, (int) (50+fm.getHeight()*3.75));
    		g.drawString(go4, SCREEN_WIDTH/2-fm.stringWidth(go4)/2, (int) (50+fm.getHeight()*5));
    	}
    	else{
	    	if(random.nextInt(150) < score+1 && organs.size() < MAX_ORGANS){    	
	    		organs.add(new Organ(1,1,200-(score+1)/2));
	    	}
	        for(int i = 0; i < organs.size(); i ++){
	            organs.get(i).draw(g);
	            if(organs.get(i).lifeTime == 0){
	            	organs.remove(i);
	    			lives --;
	            }
	        }
	        gameOver = lives <= 0;
	    	g.drawString(Integer.toString(score) + " | " + Integer.toString(lives), 5, 30);
	        System.out.println(score + "\t" + lives);
        }
    }
    
    public void mouseUpdate(MouseEvent e){
    	System.out.println(e.getButton()+"\n"+MouseEvent.BUTTON1+"\t"+MouseEvent.BUTTON2+"\t"+MouseEvent.BUTTON3);
        for(int i = 0; i < organs.size(); i ++){
        	Organ organ = organs.get(i);
//        	System.out.println(e.getX()+"\t"+e.getY ()+"\n"+
//        	organ.x +"\t"+ organ.y +"\n"+
//        	organ.rect.x + "\t" + organ.rect.y + "\t" + organ.rect.width + "\t" + organ.rect.height);
            if(organ.checkClick(e)){
//            	System.out.println("YES");
            	if(e.getButton() == MouseEvent.BUTTON1){
            		if(organ.type <= organ.MAX_GOOD_TYPE){
            			score ++;
            		}
            		else{
            			lives --;
            		}
            		organs.remove(i);
            		break;
            	}
            	else if(e.getButton() == MouseEvent.BUTTON3){
            		if(organ.type > organ.MAX_GOOD_TYPE){
            			score ++;
            		}
            		else{
            			lives --;
            		}
            		organs.remove(i);
            		break;
            	}
            }
        }
    }
}
