package greg.science.circulatory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    ArrayList<Organ> organs;
    int score = 0;
    int lives = 5;
    Random random;
    int maxOrgans = 10;
    
    public Game(){ 
    	organs = new ArrayList<Organ>();
    	random = new Random();
    }
    
    public void draw(Graphics g){
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("Arial", Font.BOLD, 30));
    	g.fillRect(0, 0, 1000, 1000);
    	if(random.nextInt(200) < score+1 && organs.size() < maxOrgans){    	
    		organs.add(new Organ(1,1,200-(score+1)/2));
    	}
        for(int i = 0; i < organs.size(); i ++){
            organs.get(i).draw(g);
            if(organs.get(i).lifeTime == 0){
            	organs.remove(i);
    			lives --;
            }
        }
    	g.setColor(Color.BLACK);
    	g.drawString(Integer.toString(score) + " | " + Integer.toString(lives), 5, 30);
        System.out.println(score + "\t" + lives);
    }
    
    public void mouseUpdate(MouseEvent e){
    	System.out.println(e.getButton()+"\n"+MouseEvent.BUTTON1+"\t"+MouseEvent.BUTTON2+"\t"+MouseEvent.BUTTON3);
        for(int i = 0; i < organs.size(); i ++){
        	Organ organ = organs.get(i);
//        	System.out.println(e.getX()+"\t"+e.getY()+"\n"+
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
